/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server.dao;

import com.server.Idao.AdminObject;
import com.server.Idao.Comparador;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Robert0
 * @param <T>
 */
public class arbolAvl<T> {

    private static final String RUTADOT = "/home/da9ni5el/ReportesProyecto/DotFiles/";
    private static final String RUTAIMG = "/home/da9ni5el/ReportesProyecto/Imagenes/";
    private NodoAvl<T> raiz;

    public arbolAvl() {
        raiz = null;
    }

    public String getRuta() {
        return RUTAIMG;
    }

    public void insertar(T valor) throws Exception {
        Comparador dato = (Comparador) valor;
        Flag flag = new Flag(false);
        raiz = insertar(raiz, dato, flag);
    }

    private NodoAvl insertar(NodoAvl raiz, Comparador dato, Flag f) throws Exception {
        NodoAvl n1;                
        if (raiz == null) {
            raiz = new NodoAvl(dato);
            f.setFlag(true);
        } else if (dato.esMenor(raiz.getDato()) ) {
            NodoAvl izdo;
            izdo = insertar(raiz.getIzdo(), dato, f);
            raiz.setIzdo(izdo);
            if (f.getFlag()) {
                switch (raiz.getFe()) {
                    case 1:
                        raiz.setFe(0);
                        f.setFlag(false);
                        break;
                    case 0:
                        raiz.setFe(-1);
                        break;
                    case -1:
                        n1 = raiz.getIzdo();
                        if (n1.getFe() == -1) {
                            raiz = rotacionIIE(raiz, n1);
                        } else {
                            raiz = rotacionIDE(raiz, n1);
                        }
                        f.setFlag(false);
                }
            }
        } else if (dato.esMayor(raiz.getDato()) ) {
            NodoAvl dcho;
            dcho = insertar(raiz.getDcho(), dato, f);
            raiz.setDcho(dcho);
            if (f.getFlag()) {
                switch (raiz.getFe()) {
                    case 1:
                        n1 = raiz.getDcho();
                        if (n1.getFe() == +1) {
                            raiz = rotacionDDE(raiz, n1);
                        } else {
                            raiz = rotacionDIE(raiz, n1);
                        }
                        f.setFlag(false);
                        break;
                    case 0:
                        raiz.setFe(+1);
                        break;
                    case -1:
                        raiz.setFe(0);
                        f.setFlag(false);
                }
            }
        } else {
            /*Se escribe esta parte para poder escribir el Log de Administrador*/
            AdminObject u = (AdminObject)dato;
            new LogFile().escribirArchivo("ERROR", "Arbol_Avl", "Clave duplicada: " + u.devolverClave());      
//            throw new Exception("No puede existir dos nodos repetidos");
            return raiz;
        }
        return raiz;
    }

    private NodoAvl rotacionIIE(NodoAvl n, NodoAvl n1) {
        n.setIzdo(n1.getDcho());
        n1.setDcho(n);
        // actualización de los factores de equilibrio
        if (n1.fe == -1) // se cumple en la inserción
        {
            n.setFe(0);
            n1.setFe(0);
        } else {
            n.setFe(-1);
            n1.setFe(1);
        }
        return n1;
    }

    private NodoAvl rotacionDDE(NodoAvl n, NodoAvl n1) {
        n.setDcho(n1.getIzdo());
        n1.setIzdo(n);

        if (n1.getFe() == +1) {
            n.setFe(0);
            n1.setFe(0);
        } else {
            n.setFe(+1);
            n1.setFe(-1);
        }
        return n1;
    }

    private NodoAvl rotacionIDE(NodoAvl n, NodoAvl n1) {
        NodoAvl n2;
        n2 = n1.getDcho();
        n.setIzdo(n2.getDcho());
        n2.setDcho(n);
        n1.setDcho(n2.getIzdo());
        n2.setIzdo(n1);
        if (n2.getFe() == +1) {
            n1.setFe(-1);
        } else {
            n1.setFe(0);
        }
        if (n2.getFe() == -1) {
            n.setFe(1);
        } else {
            n.setFe(0);
        }
        n2.setFe(0);
        return n2;
    }

    private NodoAvl rotacionDIE(NodoAvl n, NodoAvl n1) {
        NodoAvl n2;
        n2 = n1.getIzdo();
        n.setDcho(n2.getIzdo()); /*Aqui se genera la excepcion*/
        n2.setIzdo(n);
        n1.setIzdo(n2.getDcho()); /*Aqui se genera la excepcion*/
        n2.setDcho(n1);
        if (n2.getFe() == +1) {
            n.setFe(-1);
        } else {
            n.setFe(0);
        }
        if (n2.getFe() == -1) {
            n1.setFe(1);
        } else {
            n1.setFe(0);
        }
        n2.setFe(0);
        return n2;
    }

    
    public T buscarElemento(T buscado) {
        Comparador dato;
        dato = (Comparador) buscado;
        NodoAvl temporal = localizar(raiz, dato);
        if(temporal != null) {
            return (T)temporal.getDato();
        }
        return null;
    }
    
    public NodoAvl buscarNodo(T buscado) {
        Comparador dato;
        dato = (Comparador) buscado;
        return localizar(raiz, dato);        
    }

    protected NodoAvl<T> localizar(NodoAvl<T> raizSub, Comparador buscado) {
        if (raizSub == null) {
            return null;
        } else if (buscado.esIgual(raizSub.getDato()) ) {
            return raizSub;
        } else if (buscado.esMenor(raizSub.getDato())) {
            return localizar(raizSub.izdo, buscado);
        } else {
            return localizar(raizSub.dcho, buscado);
        }
    }
    
    protected boolean modificarElemento(T nuevo) {
        NodoAvl<T> buscado = buscarNodo(nuevo);
        if(buscado != null) {
            AdminObject dato = (AdminObject)buscado.getDato();
            dato.modificarObjeto(nuevo); /*Aqui se hace la modificacino de datos*/            
            return true;
        }
        return false;
    }
    
    //=======================METODOS PARA GRAFICAR==================================
    public boolean graficar(String nombre) {
        try {
            try (BufferedWriter dotcode = new BufferedWriter(new FileWriter(new File(RUTADOT + nombre + ".dot")))) {
                dotcode.write(generarDot());
                dotcode.close();
            }

            Runtime rt = Runtime.getRuntime();
            rt.exec("dot -Tpng " + RUTADOT + nombre + ".dot -o " + RUTAIMG + nombre + ".png");
            rt.exec("ristretto  " + RUTAIMG + nombre + ".png");/*Este metodo podria eliminarse*/
            return true;
        } catch (IOException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    private String generarDot() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("digraph avl{\n");
        buffer.append("graph[overlap=true];\n");
        buffer.append("node[shape= oval];\n");
        buffer.append(toDot());
        buffer.append("}");
        return buffer.toString();
    }
    
    public String toDot() {
        return toDot(raiz);
    }

    private String toDot(NodoAvl raiz) {
        StringBuffer buffer = new StringBuffer();
        AdminObject dato;
        if (raiz == null) {
            return null;
        }

        dato = (AdminObject) raiz.getDato();
        buffer.append("nodo").append(raiz.getDato().hashCode()).append("[label=\"Fe:").append(raiz.getFe()).append("\\n");
        buffer.append(dato.escribirObjeto()).append("\"];\n");
                
        buffer.append(escribirClusterDirecciones(raiz));
        buffer.append(escribirClusterCarrito(raiz));
        buffer.append(escribirClusterProductos(raiz));        

        if (raiz.getIzdo() != null) {

            dato = (AdminObject) raiz.getIzdo().getDato();
            buffer.append("nodo").append(raiz.getIzdo().getDato().hashCode()).append("[label=\"Fe:").append(raiz.getIzdo().getFe()).append("\\n");
            buffer.append(dato.escribirObjeto()).append("\"];\n");
            

            buffer.append("nodo").append(raiz.getDato().hashCode()).append(" -> nodo").append(raiz.getIzdo().getDato().hashCode());
            buffer.append("[label=\"izdo\"];\n");

            buffer.append(toDot(raiz.getIzdo()));
        }
        if (raiz.getDcho() != null) {

            dato = (AdminObject) raiz.getDcho().getDato();
            buffer.append("nodo").append(raiz.getDcho().getDato().hashCode()).append("[label=\"Fe:").append(raiz.getDcho().getFe()).append("\\n");
            buffer.append(dato.escribirObjeto()).append("\"];\n");
            

            buffer.append("nodo").append(raiz.getDato().hashCode()).append(" -> nodo").append(raiz.getDcho().getDato().hashCode());
            buffer.append("[label=\"dcho\"];\n");

            buffer.append(toDot(raiz.getDcho()));
        }
        return buffer.toString();
    }

    
    private String escribirClusterCarrito(NodoAvl raiz) {
        StringBuffer buffer = new StringBuffer();
        if(raiz.getCarrito_compra() == null) 
            return "";
        String dotCarrito = raiz.getCarrito_compra().toDot();
        if(!dotCarrito.isEmpty()) {
            
            buffer.append("subgraph clusterCarrito").append(raiz.hashCode()).append("{\n");
            buffer.append("node[shape=box];\n");
            buffer.append(dotCarrito);
            buffer.append("\n label=\"Carrito_Compra\"");
            buffer.append("\n}\n");
            buffer.append("nodo").append(raiz.getDato().hashCode());
            buffer.append("->nodo").append(raiz.getCarrito_compra().getPrimero().hashCode());
            buffer.append("\n");
        }
        return buffer.toString();
    }
    
    
    private String escribirClusterProductos(NodoAvl raiz) {
        StringBuffer buffer = new StringBuffer();
        if(raiz.getLista_pedidos() == null)
            return "";
        String dotCarrito = raiz.getLista_pedidos().toDot();
        if(!dotCarrito.isEmpty()) {
            
            buffer.append("subgraph clusterPedidos").append(raiz.hashCode()).append("{\n");
            buffer.append("node[shape=box];\n");
            buffer.append(dotCarrito);
            buffer.append("\n label=\"Lista_Pedidos\"");
            buffer.append("\n}\n");
            buffer.append("nodo").append(raiz.getDato().hashCode());
            buffer.append("->nodo").append(raiz.getLista_pedidos().getPrimero().hashCode());
            buffer.append("\n");
        }
        return buffer.toString();
    }
    
    private String escribirClusterDirecciones(NodoAvl raiz) {
        StringBuffer buffer = new StringBuffer();
        if(raiz.getDirecciones() == null)
            return "";
        String dotCarrito = raiz.getDirecciones().toDot();
        if(!dotCarrito.isEmpty()) {            
            buffer.append("subgraph clusterDirecciones").append(raiz.hashCode()).append("{\n");
            buffer.append("node[shape=box];\n");
            buffer.append(dotCarrito);
            buffer.append("\n label=\"Direcciones\"");
            buffer.append("\n}\n");
            buffer.append("nodo").append(raiz.getDato().hashCode());
            buffer.append("->nodo").append(raiz.getDirecciones().getPrimero().hashCode());
            buffer.append("\n");
        }
        return buffer.toString();
    }
    
    
    protected String conectarProductoHash() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(recorrerConectandoHash(raiz));
        return buffer.toString();
    }   
    
    protected String recorrerConectandoHash(NodoAvl raiz) {
        StringBuffer buffer = new StringBuffer();
        if(raiz == null)
            return "";
        if(raiz.getCarrito_compra() != null) {
            buffer.append(raiz.getCarrito_compra().conectarProductoHash());
        }
        if(raiz.getLista_pedidos() != null) {
            buffer.append(raiz.getLista_pedidos().conectarProductoHash());
        }        
        buffer.append(recorrerConectandoHash(raiz.getIzdo()));
        buffer.append(recorrerConectandoHash(raiz.getDcho()));
        return buffer.toString();
    }
    
//========================BORRAR AVL=============================  
    public void eliminar(T valor) throws Exception {
        Comparador dato = (Comparador) valor;
        Flag flag = new Flag(false);
        raiz = borrarAvl(raiz, dato, flag);
    }

    private NodoAvl borrarAvl(NodoAvl raiz, Comparador dato, Flag flag) throws Exception {
        // TODO Auto-generated method stub
        if (raiz == null) {
            throw new Exception("Nodo no encontrado");
        } else if (dato.esMenor(raiz.getDato())) {
            NodoAvl izdo;
            izdo = borrarAvl(raiz.getIzdo(), dato, flag);
            raiz.setIzdo(izdo);
            if (flag.getFlag()) {
                raiz = equilibrar1(raiz, flag);
            }
        } else if (dato.esMayor(raiz.getDato()) ) {
            NodoAvl dcho;
            dcho = borrarAvl(raiz.getDcho(), dato, flag);
            raiz.setDcho(dcho);
            if (flag.getFlag()) {
                raiz = equilibrar2(raiz, flag);
            }
        } else {
            NodoAvl q;
            q = raiz;
            if (q.getIzdo() == null) {
                raiz = q.getDcho();
                flag.setFlag(true);
            } else if (q.getDcho() == null) {
                raiz = q.getIzdo();
                flag.setFlag(true);
            } else {
                NodoAvl izdo;
                izdo = reemplazar(raiz, raiz.getIzdo(), flag);
                raiz.setIzdo(izdo);
                if (flag.getFlag()) {
                    raiz = equilibrar1(raiz, flag);
                }
            }
            q = null;
        }
        return raiz;
    }

    private NodoAvl reemplazar(NodoAvl n, NodoAvl act, Flag f) {

        if (act.getDcho() != null) {
            NodoAvl d;
            d = reemplazar(n, act.getDcho(), f);
            act.setDcho(d);
            if (f.getFlag()) {
                act = equilibrar2(act, f);
            }
        } else {
            n.setDato(act.getDato());
            n = act;
            act = act.getIzdo();
            n = null;
            f.setFlag(true);
        }
        return act;
    }

    private NodoAvl equilibrar1(NodoAvl n, Flag cambiarA) {
        NodoAvl n1;
        switch (n.getFe()) {
            case -1:
                n.setFe(0);
                break;
            case 0:
                n.setFe(1);
                cambiarA.setFlag(false);
                break;
            case +1:
                n1 = n.getDcho();
                if (n1.getFe() >= 0) {
                    if (n1.getFe() == 0) {
                        cambiarA.setFlag(false);
                    }
                    n = rotacionDDE(n, n1);
                } else {
                    n = rotacionDIE(n, n1);
                }
                break;
        }
        return n;
    }

    private NodoAvl equilibrar2(NodoAvl n, Flag cambiarA) {
        NodoAvl n1;
        switch (n.getFe()) {
            case -1://rotacion izquierda
                n1 = n.getIzdo();
                if (n1.getFe() <= 0) {
                    if (n1.getFe() == 0) {
                        cambiarA.setFlag(false);
                    }
                    n = rotacionIIE(n, n1);
                } else {
                    n = rotacionIDE(n, n1);
                }
                break;
            case 0:
                n.setFe(-1);
                cambiarA.setFlag(false);
                break;
            case +1:
                n.setFe(0);
                break;
        }
        return n;
    } 
}

class Flag {

    boolean sw;

    public Flag(boolean v) {
        // TODO Auto-generated constructor stub
        this.sw = v;
    }

    public void setFlag(boolean e) {
        this.sw = e;
    }

    public boolean getFlag() {
        return sw;
    }
}
