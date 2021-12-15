/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server.dao;

/**
 *
 * @author da9ni5el
 * @param <T>
 */
public class NodoSimple <T>{
    protected T dato;  //asumira el rol de puntero a producto
    protected int numerico; // asumira el rol de cantidad para las colas de carro y lista de compras
    protected NodoSimple<T> siguiente;
    protected NodoSimple<T> anterior;
    
    public NodoSimple(T dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }
    
    public NodoSimple(T dato, int cantidad) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
        this.numerico = cantidad;
    }

    public int getNumerico() {
        return numerico;
    }

    public void setNumerico(int numerico) {
        this.numerico = numerico;
    }
    
    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public NodoSimple<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoSimple<T> siguiente) {
        this.siguiente = siguiente;
    }

    public NodoSimple<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoSimple<T> anterior) {
        this.anterior = anterior;
    }
    
}
