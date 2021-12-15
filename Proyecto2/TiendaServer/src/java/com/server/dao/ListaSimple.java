/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server.dao;

import com.server.Idao.Comparador;
import com.server.Idao.AdminObject;
import com.server.modelo.Detalle;
import com.server.modelo.Producto;
import com.server.modelo.Venta;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author da9ni5el
 * @param <T>
 *
 */
public class ListaSimple<T> {

    private static final String RUTADOT = "/home/da9ni5el/ReportesProyecto/DotFiles/";
    private static final String RUTAIMG = "/home/da9ni5el/ReportesProyecto/Imagenes/";

    protected NodoSimple<T> primero;
    protected NodoSimple<T> ultimo;

    public ListaSimple() {
        this.primero = null;
        this.ultimo = null;
    }

    public NodoSimple getPrimero() {
        return this.primero;
    }

    public NodoSimple getUltimo() {
        return this.ultimo;
    }

    protected boolean esVacio() {
        return primero == null;
    }

    public void insertar(T dato) {
        NodoSimple<T> nuevo = new NodoSimple<>(dato);
        insertar(nuevo);
    }

    public void insertar(T dato, int cantidad) {
        NodoSimple<T> nuevo = new NodoSimple<>(dato, cantidad);
        insertar(nuevo);
    }

    protected void insertar(NodoSimple<T> nuevo) {
        if (esVacio()) {
            primero = ultimo = nuevo;
        } else {
            ultimo.setSiguiente(nuevo);
            ultimo = nuevo;
        }

    }

    public NodoSimple<T> buscar(T valor) {
        Comparador dato = (Comparador) valor;
        return buscar(primero, dato);
    }

    protected NodoSimple<T> buscar(NodoSimple<T> primero, Comparador dato) {
        NodoSimple<T> pivote = primero;
        while (pivote != null) {
            if (dato.esIgual(pivote.getDato())) {
                return pivote;
            }
            pivote = pivote.getSiguiente();
        }
        return null;
    }

    public T elminar(T valor) {
        Comparador dato = (Comparador) valor;
        return eliminar(dato);
    }

    protected T eliminar(Comparador dato) {
        if (esVacio()) {
            System.out.println("EDD vacia");
            return null;
        }
        NodoSimple<T> pivote = primero;
        NodoSimple<T> auxiliar = null;
        T objeto = null;
        while (pivote != null) {
            if (dato.esIgual(pivote.getDato())) {
                if (pivote == ultimo) {
                    this.ultimo = auxiliar;
                    continue;
                } else if (pivote == primero) {
                    this.primero = primero.getSiguiente();
                } else {
                    auxiliar.setSiguiente(pivote.getSiguiente());
                }
                objeto = pivote.getDato();
                pivote = null;
                return objeto;
            }
            auxiliar = pivote;
            pivote = pivote.getSiguiente();
        }
        return null;
    }

    /*Se implementa un ordenamiento burbuja por fechas*/
    public ListaSimple ordenar(ListaSimple list) {
        System.out.println("\tOrdenando Lista");
        NodoSimple pivote = list.primero;
        NodoSimple auxiliar; 
        T temporal;
        while (pivote.getSiguiente() != null) {
            auxiliar = pivote.getSiguiente();
            while (auxiliar != null) {

                if (pivote.getNumerico() > auxiliar.getNumerico()) {
                    temporal = (T) pivote.getDato();
                    pivote.setDato(auxiliar.getDato());
                    auxiliar.setDato(temporal);
                }
                auxiliar = auxiliar.getSiguiente();
            }
            pivote = pivote.getSiguiente();
        }
        return list;
    }

    public T modificar(T valorNuevo) {
        AdminObject dato = (AdminObject) valorNuevo;
        return modificar(primero, dato);
    }

    protected T modificar(NodoSimple<T> primero, AdminObject dato) {
        NodoSimple<T> buscado = buscar((T) dato);
        if (buscado != null) {
            dato.modificarObjeto(buscado.getDato());
            return buscado.getDato();
        }
        return null;
    }

    public boolean graficar(String nombre) {
        try {
            try (BufferedWriter dotcode = new BufferedWriter(new FileWriter(new File(RUTADOT + nombre + ".dot")))) {
                dotcode.write("digraph G{\ngraph[overlap=true];\nnode[shape=box, fontname=Helvetica];\n");
                dotcode.write("edge[color = black];\n");
                dotcode.write(toDot());
                dotcode.write("}");
                dotcode.close();
            }

            Runtime rt = Runtime.getRuntime();
            rt.exec("dot -Tpng " + RUTADOT + nombre + ".dot -o " + RUTAIMG + nombre + ".png");
//            rt.exec("ristretto " + RUTAIMG + nombre + ".png");
            /*Eseta linea podria elminarse*/
            return true;
        } catch (IOException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    protected String toDot() {
        NodoSimple<T> pivote = primero;
        AdminObject dato;
        String buffer = "";
        while (pivote != null) {
            dato = (AdminObject) pivote.getDato();
            buffer += "nodo" + pivote.hashCode() + "[label=\"" + dato.escribirObjeto() + pivote.getNumerico() + "\"];\n";
            if (pivote.getSiguiente() != null) {
                dato = (AdminObject) pivote.getSiguiente().getDato();
                buffer += "nodo" + pivote.getSiguiente().hashCode() + "[label=\"" + dato.escribirObjeto() + pivote.getNumerico() + "\"];\n";

                buffer += "nodo" + pivote.hashCode() + "-> nodo" + pivote.getSiguiente().hashCode() + "\n";
            }
            pivote = pivote.getSiguiente();
        }
        return buffer;
    }

    protected String conectarProductoHash() {
        StringBuffer buffer = new StringBuffer();
        NodoSimple pivote = primero;
        while (pivote != null) {

            if (pivote.getDato() != null) {
                Producto p = (Producto)pivote.getDato();
                buffer.append("nodo").append(pivote.hashCode());
                buffer.append("->nodo").append(p.hashCode()).append("TH").append("\n");
            }

            pivote = pivote.getSiguiente();
        }

        return buffer.toString();
    }
    
    protected String conectarProductoBHash() {
        StringBuffer buffer = new StringBuffer();
        NodoSimple pivote = primero;
        while (pivote != null) {

            if (pivote.getDato() != null) {
                Detalle d = (Detalle)pivote.getDato();
                Producto p = (Producto)d.getProducto();
                buffer.append("nodo").append(pivote.hashCode());
                buffer.append("->nodo").append(p.hashCode()).append("TH").append("\n");
            }

            pivote = pivote.getSiguiente();
        }

        return buffer.toString();
    }

    protected void recorrer() {
        NodoSimple pivote = primero;
        while (pivote != null) {
            AdminObject dato = (AdminObject) pivote.getDato();
            System.out.println(dato.escribirObjetoConsole());
            pivote = pivote.getSiguiente();
        }
    }
    
    
        /*EXCLUSIVO PARA EL REPORTE DE BUSQUEDA POR RANGO DE FECHAS*/
    
    protected boolean usuarioEsta(String username) {        
        NodoSimple pivote = primero;
        while(pivote != null) {
            Venta v = (Venta)pivote.getDato();
            if(v.getUsuario().getNickname().equals(username)) {
                pivote.setNumerico((pivote.getNumerico()+1));
                return true;
            }                
            pivote = pivote.getSiguiente();
        }
        return false;
    }

    private static void generarReporteRangoFecha(java.lang.String fechas) {
        com.server.servicio.Servicio_Service service = new com.server.servicio.Servicio_Service();
        com.server.servicio.Servicio port = service.getServicioPort();
        port.generarReporteRangoFecha(fechas);
    }
}
