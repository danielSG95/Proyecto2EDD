/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server.dao;

import com.server.Idao.AdminObject;
import com.server.Idao.Comparador;
import com.server.modelo.Producto;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Robert0
 */
public class TablaHash {

    private static final String RUTADOT = "/home/da9ni5el/ReportesProyecto/DotFiles/";
    private static final String RUTAIMG = "/home/da9ni5el/ReportesProyecto/Imagenes/";

    protected int TAM;
    protected int numElementos;
    protected double factorCarga;
    protected Object elementos[];

    public TablaHash() {
        TAM = 10; //tamanio de la tabla
        elementos = new Object[TAM];//se inicia en 10
        numElementos = 0;
        factorCarga = 0.0;
    }

    private int funcionPlegamiento(String clave, int m, boolean tipoOperacion) {
        char ch[] = claveToAscii(clave);
        int i, suma, dir;
        for (suma = 0, i = 0; i < ch.length; i++) {
            suma += ch[i];
        }
        dir = suma % m;
        return exploracionCuadratica(dir, clave, tipoOperacion);
    }

    private int exploracionCuadratica(int dir, String clave, boolean esBuscar) {
        int i = 0;
        /*Se sucito una colicion y es necesario reportarla*/
        if (elementos[dir] != null) {
            new LogFile().escribirArchivo("WARN", "Tabla_Hash", "Ha ocurrido una colision en la posicion: " + dir);
        }

        while (elementos[dir] != null) {
            Comparador dato = (Comparador) elementos[dir];
            if (!dato.esIgual(clave)) {
                i++;
                dir = dir + i * i;
                dir = dir % TAM;
            } else {
                if (esBuscar) {
                    return dir;
                    /*Se retonra la posicion de busqueda*/
                }
                /*Se agrega al log que se encuentra un producto repetido*/
                new LogFile().escribirArchivo("ERROR", "Tabla_Hash", "Producto Repetido: " + clave);
                break;
            }
        }
        return dir;
    }

    private char[] claveToAscii(String clave) {
        char ch[] = clave.toCharArray();
        String buffer = "";
        int temporal = 0;
        for (int i = 0; i < ch.length; i++) {
            temporal += (int) ch[i];//se van sumando todos los valores ascii de la cadena
        }
        buffer = String.valueOf(temporal);//el entero resultante se parsea a String
        return buffer.toCharArray();
    }

    protected void darAlta(Object valor) {
        AdminObject dato = (AdminObject) valor;
        int posicion = funcionPlegamiento(dato.devolverClave(), TAM, false);
        elementos[posicion] = valor;
        numElementos++;
        factorCarga = (double) numElementos / TAM;
        if (factorCarga >= 0.8)//se hace un rehashing
        {
            System.out.println("Haciendo Rehashing");
            rehashing();
        }
    }

    private void rehashing() {
        try {
            Object temporal[] = elementos;//copiando el array a un array temporal. 
            TAM = TAM * 2;
            elementos = new Object[TAM];
            numElementos = 0;
            for (Object temporal1 : temporal) {
                if (temporal1 != null) {
                    darAlta(temporal1);
                }
            }
        } catch (Exception e) {
            System.out.println("ReHash Erro:" + e.toString());
        }

        System.out.println("ReHash finalizado");
    }

    protected boolean darBaja(Object valor) {
        AdminObject dato = (AdminObject) valor;
        int posicion = funcionPlegamiento(dato.devolverClave(), TAM, true);
        elementos[posicion] = null;
        numElementos--;
        return true;
    }

    protected Object buscarElemento(Object buscado) {
//        AdminObject dato = (AdminObject) buscado;
        int posicion = funcionPlegamiento(buscado.toString(), TAM, true);
        if (elementos[posicion] != null) {
            Comparador compare = (Comparador) elementos[posicion];
            if (compare.esIgual(buscado)) {
                return elementos[posicion];
            }
        }
        return null;
    }
        
    public boolean insertar(Object valor) {
        try {
            darAlta(valor);
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public Object buscar(Object valor) {
        return buscarElemento(valor);
    }

    public boolean eliminar(Object valor) {
        return darBaja(valor);
    }

    protected boolean modificarElemento(Object nuevo) {
        //Accion de ultima hora
        Producto p = (Producto)nuevo;
        Object buscado = buscarElemento(p.getCodigoProducto());
        if (buscado != null) {
            AdminObject dato = (AdminObject) buscado;
            dato.modificarObjeto(nuevo);
            return true;
        }
        return false;
    }

    public boolean modificar(Object nuevo) {
        return modificarElemento(nuevo);
    }

    public String toDot() {
        StringBuffer buffer = new StringBuffer();
        AdminObject dato;
        boolean flag = false;
        buffer.append("vector[height=5 label=\"");
        for (int i = 0; i < TAM; i++) {
            if (flag) {
                buffer.append(" | ");
            }
            buffer.append("<sector").append(i).append("> posicion: ").append(i);
            flag = true;
        }
        buffer.append("\"];\n");

        for (int i = 0; i < TAM; i++) {
            if (elementos[i] != null) {
                Object pivote = elementos[i];
                if (pivote != null) {
                    buffer.append("vector:sector").append(i).append(" -> ");
                    buffer.append("nodo").append(pivote.hashCode()).append("TH").append("\n");
                }
                dato = (AdminObject) pivote;
                buffer.append("nodo").append(pivote.hashCode()).append("TH").append("[label=\"").append(dato.escribirObjeto());
                buffer.append("\"];\n");
            }
        }
        return buffer.toString();
    }

    private String generarGrafo() {
        StringBuffer buffer = new StringBuffer();
        AdminObject dato;
        buffer.append("digraph Tabla{\nnode[shape=record];\n");
        buffer.append("graph[rankdir=LR, ordering=out];\n");
        buffer.append(toDot());
        buffer.append("}");
        return buffer.toString();
    }

    public boolean graficar(String nombre) {
        try {
            try (BufferedWriter dotcode = new BufferedWriter(new FileWriter(new File(RUTADOT + nombre + ".dot")))) {
                dotcode.write(generarGrafo());
                dotcode.close();
            }

            Runtime rt = Runtime.getRuntime();
            rt.exec("dot -Tpng " + RUTADOT + nombre + ".dot -o " + RUTAIMG + nombre + ".png");
            rt.exec("ristretto " + RUTAIMG + nombre + ".png");/*Esta linea podria eliminarse*/
            return true;
        } catch (IOException e) {
            System.out.println(e.toString());
            return false;
        }
    }
}
