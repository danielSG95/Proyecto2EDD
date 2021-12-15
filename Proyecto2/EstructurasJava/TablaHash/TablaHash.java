/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TablaHash;

import Interfaces.AdminObject;
import ListaSimple.ListaSimple;
import ListaSimple.NodoSimple;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Robert0
 */
public class TablaHash <T> {
    private final int nprimos[]={23,37,79,131,181,239,293,359,421};//agregar mas si es necesario
    private final String ruta = "src/Imagenes/";
    private int tamPrimos;
    
    protected int final_;
    protected int numElementos;
    protected double factorCarga;
    protected ListaSimple elementos[];

    public TablaHash() {
        tamPrimos = 0;
        elementos =  new ListaSimple[nprimos[tamPrimos]];//se inicia en 23
        final_ = 23;
        numElementos = 0; 
        factorCarga = 0.0;
    }

    public String getRuta() {
        return ruta;
    }
            
    private int funcionPlegamiento(String clave, int m)
    {
        String clave_ = claveToAscii(clave);
        char ch[] = clave_.toCharArray();
        int i, suma;
        for(suma =0, i=0; i< ch.length; i++)
            suma+= ch[i];
        return suma%m;
    }
        
    private String claveToAscii(String clave)
    {
        char ch[] = clave.toCharArray();
        String buffer = "";
        int temporal = 0;
        for(int i = 0; i< ch.length; i++)
        {
            temporal+= (int)ch[i];//se van sumando todos los valores ascii de la cadena
        }
        buffer = String.valueOf(temporal);//el entero resultante se parsea a String
        return buffer;
    }
    
    protected void darAlta(T valor)
    {
        AdminObject dato = (AdminObject)valor;
        int posicion = funcionPlegamiento(dato.devolverClave(), final_);
        if(elementos[posicion] == null)
        {
            elementos[posicion] = new ListaSimple();
        }
        elementos[posicion].insertar(valor);
        numElementos++;
        factorCarga = (double)numElementos/final_;
        if(factorCarga > 0.8)//se hace un rehashing
        {
            rehashing();
        }
    }
    
    private void rehashing()
    {
        ListaSimple temporal [] = elementos;//copiando el array a un array temporal. 
//        int tam_temporal = elementos.length;
        if(tamPrimos < nprimos.length)
            tamPrimos++;
        else
            System.out.println("No se puede asignar un nuevo valor a la tabla hash. Alcanzado su limite de tamanio");
        final_ = final_*2;
        elementos = new ListaSimple[final_];
        factorCarga = (int)numElementos/final_;
        for(int i=0; i< elementos.length; i++)
        {
            if(temporal[i]!= null)
            {
                darAlta((T) temporal[i]);
            }
        } 
    }
    
    protected boolean darBaja(T valor)
    {
        AdminObject dato = (AdminObject)valor;
        int posicion = funcionPlegamiento(dato.devolverClave(), final_);
        if(elementos[posicion].elminar(valor)!= null)
        {
            numElementos--;
            System.out.println("Elemento de la tabla Hash eliminado");
            return true;
        }
        else
        {
            System.out.println("Ha ocurrido un error al eliminar el elemento");
            return false;
        }
    }
    
    protected Object buscarElemento(T buscado)
    {
        AdminObject dato = (AdminObject)buscado;
        int posicion = funcionPlegamiento(dato.devolverClave(), final_);
        if(elementos[posicion] != null)
        {
            NodoSimple temporal = elementos[posicion].buscar(buscado);
            if(temporal != null)
                return  temporal.getDato();
        }
        return null;
    }
    
    public boolean insertar(T valor)
    {
        try {
            darAlta(valor);
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
    public Object buscar(T valor)
    {
        return buscarElemento(valor);
    }
    
    public boolean eliminar(T valor)
    {
        return darBaja(valor);
    }
    
    private String generarGrafo()
    {
        StringBuffer buffer = new StringBuffer();
        AdminObject dato; 
        buffer.append("digraph Tabla{\nnode[shape=record];\n");
        boolean flag = false;
        buffer.append("vector[label=\"");
        for(int i = 0; i < final_; i++)
        {
            if(elementos[i] != null)
            {
                if(flag)
                    buffer.append(" | ");
                buffer.append("<sector").append(i).append("> posicion: ").append(i);
                flag = true;
            }
        }
        buffer.append("\"];\n");
        
        for(int i = 0; i < final_; i++)
        {
            if(elementos[i] != null)
            {
                NodoSimple pivote = elementos[i].getPrimero();
                if(pivote != null)
                {
                    buffer.append("vector:sector").append(i).append(" -> ");
                    buffer.append("nodo").append(pivote.hashCode()).append("\n");
                }
                while(pivote != null)
                {
                    dato = (AdminObject)pivote.getDato();
                    buffer.append("nodo").append(pivote.hashCode()).append("[label=\"").append(dato.escribirObjeto(dato));
                    buffer.append("\"];\n");
                    if(pivote.getSiguiente() != null)
                    {
                        dato = (AdminObject)pivote.getSiguiente().getDato();
                    buffer.append("nodo").append(pivote.getSiguiente().hashCode()).append("[label=\"").append(dato.escribirObjeto(dato));
                    buffer.append("\"];\n");
                    
                    buffer.append("nodo").append(pivote.hashCode()).append(" -> ");
                    buffer.append("nodo").append(pivote.getSiguiente().hashCode()).append("\n");
                    }
                    pivote = pivote.getSiguiente();
                }
            }
        }
        buffer.append("}");
        
        return buffer.toString();         
    }
    
    public void graficar(String nombre)
    {
        try {
            try (BufferedWriter dotcode = new BufferedWriter(new FileWriter(new File(nombre+".dot")))) {
                dotcode.write(generarGrafo());
                dotcode.close();
            }
            
            Runtime rt = Runtime.getRuntime();
            rt.exec("dot -Tpng "+nombre+".dot -o "+ruta+nombre+".png");
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}