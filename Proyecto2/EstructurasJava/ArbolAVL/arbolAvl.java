/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolAVL;

import Interfaces.AdminObject;
import Interfaces.Comparador;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Robert0
 */
public class arbolAvl <T> {
    private final String ruta = "src/Imagenes/";
    private boolean sw;
    private NodoAvl raiz;
    
    public arbolAvl() {
        sw = false;
        raiz = null;
    }

    public String getRuta() {
        return ruta;
    }
            
    public void insertar(T valor)
    {
        Comparador dato = (Comparador)valor;
        raiz = insertar(raiz, dato);
    }
    
    private NodoAvl insertar(NodoAvl raiz, Comparador dato)
    {        
        if(raiz == null)
        {
            raiz = new NodoAvl(dato);
            sw = true;
        }
        else if(dato.esMenor(raiz.getDato()))
        {
            NodoAvl izdo; 
            izdo = insertar(raiz.getIzdo(), dato);
            raiz.setIzdo(izdo);
            if(sw)
                raiz = actualizarIzq(raiz);
        }
        else if(dato.esMayor(raiz.getDato()))
        {
            NodoAvl dcho;
            dcho = insertar(raiz.getDcho(),dato);
            raiz.setDcho(dcho);
            if(sw)
                raiz = actualizarDcho(raiz);
        }
        else
            sw = false;
        return raiz;
    }
    
    private NodoAvl actualizarIzq(NodoAvl raiz)
    {
        switch(raiz.getFe())
        {
            case 1:
                raiz.setFe(0);
                this.sw = true;
                break;
            case 0:
                raiz.setFe(-1);                
                break;
            case -1:
                if(raiz.getIzdo().getFe() == -1)
                    raiz = rotacionII(raiz);
                else
                    raiz = rotacionID(raiz);
                sw = false;
                break;
        }
        return raiz;
    }
    
    private NodoAvl actualizarDcho(NodoAvl raiz)
    {
        switch(raiz.getFe())
        {
            case -1:
                raiz.setFe(0);
                this.sw = false;
                break;
            case 0:
                raiz.setFe(1);
                break;
            case 1:
                if(raiz.getDcho().getFe() == 1)
                    raiz = rotacionDD(raiz);
                else
                    raiz = rotacionDI(raiz);
                sw = false;
                break;
        }
        return raiz;
    }

    private NodoAvl rotacionII(NodoAvl raiz) {
        NodoAvl temporal = raiz.getIzdo();
        raiz.setIzdo(temporal.getDcho());
        temporal.setDcho(raiz);
        temporal.setFe(0);
        raiz.setFe(0);
        raiz = temporal;
        //retorno aqui
        return raiz;
    }

    private NodoAvl rotacionID(NodoAvl raiz) {
        NodoAvl aux1, aux2;
        aux1 = raiz.getIzdo();
        aux2 = aux1.getDcho();
        aux1.setDcho(aux2.getIzdo());
        aux2.setIzdo(aux1);
        raiz.setIzdo(aux2.getDcho());
        aux2.setDcho(raiz);
        if(aux2.getFe() == 1)
            aux1.setFe(-1);
        else
            aux1.setFe(0);
        
        if(aux2.getFe() == -1)
            raiz.setFe(1);
        else
            raiz.setFe(0);
        aux2.setFe(0);
        raiz = aux2;
        //retorno aqui
        return raiz;
    }

    private NodoAvl rotacionDD(NodoAvl raiz) {
        NodoAvl aux = raiz.getDcho();
        raiz.setDcho(aux.getIzdo());
        aux.setIzdo(raiz);
        aux.setFe(0);
        raiz.setFe(0);
        raiz = aux;
        //retorno aqui
        return raiz;
    }

    private NodoAvl rotacionDI(NodoAvl raiz) {
        NodoAvl aux1, aux2;
        aux1 = raiz.getDcho();
        aux2 = aux1.getIzdo();
        aux1.setIzdo(aux2.getDcho());
        aux2.setDcho(aux1);
        raiz.setDcho(aux2.getIzdo());
        aux2.setIzdo(raiz);
        if(aux2.getFe() == 1)
            raiz.setFe(-1);
        else
            raiz.setFe(0);
        if(aux2.getFe() == -1)
            aux1.setFe(1);
        else
            aux1.setFe(0);
        aux2.setFe(0);
        raiz = aux2;
        //retorno aqui
        return raiz;
    }
    
    public void inorden()
    {
        System.out.println("\tRecorrido Inorden");
        recorridoInorden(raiz);
    }
    
    private void recorridoInorden(NodoAvl raiz)
    {
        if(raiz == null)
            return;
        AdminObject dato;
        recorridoInorden(raiz.getIzdo());
        dato = (AdminObject)raiz.getDato();
        System.out.println(dato.escribirObjetoConsole(dato));
        recorridoInorden(raiz.getDcho());
    }
    
    public void graficar(String nombre)
    {
        try {
            try (BufferedWriter dotcode = new BufferedWriter(new FileWriter(new File(nombre+".dot")))) {
                dotcode.write(generarDot());
                dotcode.close();
            }
            
            Runtime rt = Runtime.getRuntime();
            rt.exec("dot -Tpng "+nombre+".dot -o "+ruta+nombre+".png");
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
    
    private String generarDot()
    {
        StringBuffer buffer = new StringBuffer();
        buffer.append("digraph avl{\n");
        buffer.append("graph[overlap=true];\n");
        buffer.append(toDot(raiz));
        buffer.append("}");
        return buffer.toString();
    }
    
    private String toDot(NodoAvl raiz)
    {
        StringBuffer buffer = new StringBuffer();
        AdminObject dato;
        if(raiz == null)
            return null;
        if(raiz.getIzdo() != null)
        {
            dato = (AdminObject)raiz.getDato();
            buffer.append("nodo").append(raiz.hashCode()).append("[label=\"Fe:").append(raiz.getFe()).append("\\n");
            buffer.append(dato.escribirObjeto(dato)).append("\"];\n");
            
            dato = (AdminObject)raiz.getIzdo().getDato();
            buffer.append("nodo").append(raiz.getIzdo().hashCode()).append("[label=\"Fe:").append(raiz.getIzdo().getFe()).append("\\n");
            buffer.append(dato.escribirObjeto(dato)).append("\"];\n");
            
            buffer.append("nodo").append(raiz.hashCode()).append(" -> nodo").append(raiz.getIzdo().hashCode());
            buffer.append("[label=\"izdo\"];\n");
            
            buffer.append(toDot(raiz.getIzdo()));
        }
        if(raiz.getDcho() != null)
        {
            dato = (AdminObject)raiz.getDato();
            buffer.append("nodo").append(raiz.hashCode()).append("[label=\"Fe:").append(raiz.getFe()).append("\\n");
            buffer.append(dato.escribirObjeto(dato)).append("\"];\n");
            
            dato = (AdminObject)raiz.getDcho().getDato();
            buffer.append("nodo").append(raiz.getDcho().hashCode()).append("[label=\"Fe:").append(raiz.getDcho().getFe()).append("\\n");
            buffer.append(dato.escribirObjeto(dato)).append("\"];\n");
            
            buffer.append("nodo").append(raiz.hashCode()).append(" -> nodo").append(raiz.getDcho().hashCode());
            buffer.append("[label=\"dcho\"];\n");
            
            buffer.append(toDot(raiz.getDcho()));
        }
        return buffer.toString();
    }
    
    public boolean borrarAvl(T valor)
    {        
        Comparador dato = (Comparador)valor;
        borrar(raiz, dato);
        return true;//no siempre es valido esto.
    }
    
    //HACER METODO DE ELIMINAR
    private NodoAvl borrar(NodoAvl raiz, Comparador dato)
    {
        if(raiz == null)
            sw = false;
        else if(dato.esIgual(raiz.getDato()))
            raiz = eliminar(raiz);
        else if(dato.esMenor(raiz.getDato()))
        {
            NodoAvl izdo; 
            izdo = borrar(raiz.getIzdo(), dato);
            raiz.setIzdo(izdo);
            if(sw)
                actualizarBI(raiz);
        }
        else if(dato.esMayor(raiz.getDato()))
        {
            NodoAvl dcho;
            dcho = borrar(raiz.getDcho(), dato);
            raiz.setDcho(dcho);
            if(sw)
                raiz = actualizarBD(raiz);
        }        
        return raiz;
    } 
        
    private NodoAvl eliminar(NodoAvl raiz) {
        NodoAvl auxiliar = null;
        T dato_temp;
        if(raiz.getIzdo() == null)
        {
            auxiliar = raiz;
            raiz = raiz.getDcho();
            auxiliar = null;
            this.sw = true;
        }
        else if(raiz.getDcho() == null)
        {
            auxiliar = raiz;
            raiz = raiz.getIzdo();
            auxiliar = null;
            this.sw = true;
        }
        else
        {
            dato_temp = menor(raiz.getDcho());
            raiz.setDato(dato_temp);
            borrar(raiz.getDcho(), (Comparador) dato_temp);
            if(sw)
            {
                raiz.setDcho(null);
                raiz = actualizarBD(raiz);
            }                
            
        }
        return raiz;
    }

    private T menor(NodoAvl dcho) {
        if(dcho.getIzdo() == null)
            return (T) dcho.getDato();
        else
            return menor(dcho.getIzdo());
    }

    
    private NodoAvl actualizarBI(NodoAvl raiz) {
        switch(raiz.getFe())
        {
            case -1:
                raiz.setFe(0);
                sw = false;
                break;
            case 0:
                raiz.setFe(1);
                sw = false;
                break;
            case 1:
                NodoAvl temporal = raiz.getDcho();
                switch(temporal.getFe())
                {
                    case 1:
                        raiz = rotacionDD(raiz);
                        break;
                    case -1:
                        raiz = rotacionDI(raiz);
                        break;
                    case 0:
                        raiz = rotacionDD2(raiz);
                        break;
                }
                sw = false;
                break;
        }
        return raiz;
    }

    private NodoAvl actualizarBD(NodoAvl raiz) {
        switch(raiz.getFe())
        {
            case 1:
                raiz.setFe(0);
                break;
            case 0:
                raiz.setFe(-1);
                sw = false;
                break;
            case -1:
                NodoAvl temporal = raiz.getIzdo();
                switch(temporal.getFe())
                {
                    case -1:
                        raiz = rotacionII(raiz);
                        break;
                    case 1:
                        raiz = rotacionID(raiz);
                        break;
                    case 0:
                        raiz = rotacionII2(raiz);
                }
                sw = false;
                break; 
        }        
        return raiz;
    }
    
    private NodoAvl rotacionDD2(NodoAvl raiz) {
        NodoAvl temporal = raiz.getDcho();
        raiz.setDcho(temporal.getIzdo());
        temporal.setIzdo(raiz);
        temporal.setFe(-1);
        raiz.setFe(1);
        raiz = temporal;
        return raiz;
    }

    private NodoAvl rotacionII2(NodoAvl raiz) {
        NodoAvl temporal = raiz.getIzdo();
        raiz.setIzdo(temporal.getDcho());
        temporal.setDcho(raiz);
        temporal.setFe(1);
        raiz.setFe(-1);
        raiz = temporal;
        return raiz;
    }
    
    

}