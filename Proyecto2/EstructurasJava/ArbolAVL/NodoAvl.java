/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolAVL;

/**
 *
 * @author Robert0
 */
public class NodoAvl <T> {
    protected int fe;
    protected T dato;
    NodoAvl izdo;
    NodoAvl dcho;
    public NodoAvl() {
        this.izdo = null;
        this.dcho = null;
        this.fe = 0;
        this.dato = null;
    }
    
    public NodoAvl(T valor)
    {
        this.dato = valor;
        this.izdo = null;
        this.dcho = null;
        this.fe = 0;
    }

    public int getFe() {
        return fe;
    }

    public void setFe(int fe) {
        this.fe = fe;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public NodoAvl getIzdo() {
        return izdo;
    }

    public void setIzdo(NodoAvl izdo) {
        this.izdo = izdo;
    }

    public NodoAvl getDcho() {
        return dcho;
    }

    public void setDcho(NodoAvl dcho) {
        this.dcho = dcho;
    }                
}
