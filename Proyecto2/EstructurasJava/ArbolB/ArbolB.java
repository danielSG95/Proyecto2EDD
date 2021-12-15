/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolB;

import Interfaces.AdminObject;
import Interfaces.Comparador;
import Modelo.Estudiante;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Robert0
 */
public class ArbolB <T> {
    private final String ruta = "src/Imagenes/";   
    protected int orden;
    protected Pagina raiz;
    
    private int index_nodo_encontrado;
    private T mediana;//para que es esto? :v 
    private Pagina nd;

    public ArbolB() {
        orden = 5;
        raiz = null;
        index_nodo_encontrado = -1;
        mediana = null;
    }
    
    public boolean arbolVacio()
    {
        return raiz == null;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public Pagina getRaiz() {
        return raiz;
    }

    public void setRaiz(Pagina raiz) {
        this.raiz = raiz;
    }

    public int getIndex_nodo_encontrado() {
        return index_nodo_encontrado;
    }

    public void setIndex_nodo_encontrado(int index_nodo_encontrado) {
        this.index_nodo_encontrado = index_nodo_encontrado;
    }

    public T getMediana() {
        return mediana;
    }

    public void setMediana(T mediana) {
        this.mediana = mediana;
    }

    public Pagina getNd() {
        return nd;
    }

    public void setNd(Pagina nd) {
        this.nd = nd;
    }
       
    
    private boolean buscarNodo(Pagina actual, T estudiante)
    {
        int index = 0;
        Comparador dato = (Comparador)estudiante;
        boolean encontrado = false;
        if(dato.esMenor(actual.getClave(1)))
        {
            index = 0;
            encontrado = false;
        }       
        else
        {
            index = actual.getCuenta();
            while(dato.esMenor(actual.getClave(index)))
            {
                index--;
            }
            encontrado = dato.esIgual(actual.getClave(index));
        }
        index_nodo_encontrado = index;
        return encontrado;       
    }
    
    private Pagina buscar(Pagina act, T estudiante)
    {
        if(act == null)
            return null;
        else
        {
            boolean esta = buscarNodo(act, estudiante);
            if(esta)
                return act;
            else
                return buscar(act.getRama(index_nodo_encontrado), estudiante);
        }            
    }
    
    public void insertar(T estudiante)
    {
        raiz = insertar(raiz, estudiante);
        System.out.println("");
    }
    
    private Pagina insertar(Pagina raiz, T estudiante)
    {
        boolean subeArriba;
        T lMediana = null;
        Pagina nd = null;
        subeArriba = empujar(raiz, estudiante);
        if(subeArriba)
        {
            Pagina p;
            p = new Pagina();
            lMediana = mediana;
            nd = this.nd;
            p.setCuenta(1);
            p.setClave(1, lMediana);
            p.setRama(0, raiz);
            p.setRama(1, nd);
            raiz = p;
        }
        mediana = null;
        this.nd = null;
        index_nodo_encontrado = -1;
        return raiz;
    }
    
    private boolean empujar(Pagina actual, T valor)
    {
        boolean subeArriba = false;
        if(actual == null)
        {
            subeArriba = true;
            this.mediana = valor;
            this.nd = null;
        }
        else
        {
            boolean esta = buscarNodo(actual,valor);
            if(esta)
            {
                subeArriba = false;
                System.out.println("Clave duplicada");
                return false;
            }
            subeArriba = empujar(actual.getRama(index_nodo_encontrado), valor);
            if(subeArriba)
            {
                if(!actual.nodoLleno())
                {
                    meterPagina(actual, index_nodo_encontrado);
                    subeArriba = false;
                }
                else
                {
                    dividirNodo(actual, index_nodo_encontrado);
                }
            }
        }
        return subeArriba;
    }

    private void meterPagina(Pagina actual, int index) {
        for (int i = actual.getCuenta(); i > index; i--) {
            actual.setClave(i + 1, actual.getClave(i));
            actual.setRama(i + 1, actual.getRama(i));
        }
        actual.setClave(index + 1, mediana);
        actual.setRama(index + 1, nd);
        actual.setCuenta(actual.getCuenta() + 1);
    }

    private void dividirNodo(Pagina actual, int index) {
        int i, posMda, k;
        Pagina nuevaPag;
        k = index;
        posMda = (k<orden/2)? orden/2:(orden/2)+1;
        nuevaPag = new Pagina();
        for(i = posMda+1; i<orden; i++)
        {
            nuevaPag.setClave(i - posMda, actual.getClave(i));
            nuevaPag.setRama(i - posMda, actual.getRama(i));
            actual.setClave(i, null);
            actual.setRama(i, null);
        }
        nuevaPag.setCuenta((orden -1) - posMda);
        actual.setCuenta(posMda);
        if(k <= orden / 2)
            meterPagina(actual, index);
        else
        {
            index = k - posMda;
            meterPagina(nuevaPag, index);
        }
        mediana = (T) actual.getClave(actual.getCuenta());//no es seguro
        actual.setClave(actual.getCuenta(), null);//se quita la mediana del actual
        nuevaPag.setRama(0, actual.getRama(actual.getCuenta()));
        actual.setCuenta(actual.getCuenta() - 1);
        nd = nuevaPag;        
    }
    
    public void recorridoInorden()
    {
        System.out.println("RECORRIDO INORDEN");                
        recorridoInorden(raiz);
    }
    
    private void recorridoInorden(Pagina raiz)
    {
        AdminObject dato;
        if(raiz!= null)
        {            
            recorridoInorden(raiz.getRama(0));            
            for(int k = 1; k <=  raiz.getCuenta(); k++)
            {                
                System.out.printf("Rama numero %d ",k);
                dato = (AdminObject)raiz.getClave(k);
                System.out.println(dato.escribirObjetoConsole(dato));
                recorridoInorden(raiz.getRama(k));
            }
        }
    }
    
    public void graficar(String nombre)
    {
         try {
            try (BufferedWriter dotcode = new BufferedWriter(new FileWriter(new File(nombre+".dot")))) {
                dotcode.write(generarDotB());
                dotcode.close();
            }
            
            Runtime rt = Runtime.getRuntime();
            rt.exec("dot -Tpng "+nombre+".dot -o "+ruta+nombre+".png");
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
    
    private String generarDotB()
    {
        StringBuffer buffer = new StringBuffer();
        buffer.append("digraph arbolB{\n");
        buffer.append("node[shape=record];\n");
        buffer.append(escribirPagina(raiz));
        buffer.append(enlazarPaginas(raiz));
        buffer.append("}");
        return buffer.toString();
    }
    
    private String escribirPagina(Pagina raiz)
    {
        StringBuffer buffer = new StringBuffer();
        AdminObject dato;
        boolean flag = false;
        if(raiz == null)
            return "";
        buffer.append("pagina").append(raiz.hashCode()).append("[label=\"");
        for(int i = 1; i <= raiz.getCuenta(); i++)
        {
            dato = (AdminObject)raiz.getClave(i);
            if(flag)
                buffer.append(" | ");
            buffer.append("<p").append(dato.hashCode()).append(">");
            buffer.append(dato.escribirObjeto(dato));
            flag = true;
        }
        buffer.append("\"];\n");
        int i = 0;
        while(i <= raiz.getCuenta())
        {        
            if(raiz.getRama(i) != null)
                buffer.append(escribirPagina(raiz.getRama(i)));
            i++;
        }                        
        return buffer.toString();
    }
    
    private String enlazarPaginas(Pagina raiz)
    {
        StringBuffer buffer = new StringBuffer();
        int contador = 0;        
        while(contador < orden)
        {            
            if(raiz.getRama(contador) != null)
            {
                buffer.append("pagina").append(raiz.hashCode());   
                buffer.append(" -> ");
                buffer.append("pagina").append(raiz.getRama(contador).hashCode());
                buffer.append("[label=\"rama").append(contador).append("\"];").append("\n");
            }
            contador++;
        }
        return buffer.toString();
    }     
}
