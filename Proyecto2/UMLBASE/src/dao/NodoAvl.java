/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server.dao;

/**
 *
 * @author Robert0
 * @param <T>
 */
public class NodoAvl <T> {
    protected int fe;
    protected T dato;
    NodoAvl izdo;
    NodoAvl dcho;
    
    //Requerimientos propios del proyecto
    ListaSimple<Object> direcciones;
    Cola<Object> lista_pedidos;
    Cola<Object> carrito_compra;
    
    
    public NodoAvl() {
        this.izdo = null;
        this.dcho = null;
        this.fe = 0;
        this.dato = null;
        
        direcciones = null;
        lista_pedidos = null;
        carrito_compra = null;
    }
    
    public NodoAvl(T valor)
    {
        this.dato = valor;
        this.izdo = null;
        this.dcho = null;
        this.fe = 0;
        
        direcciones = null;
        lista_pedidos = null;
        carrito_compra = null;
    }

    public ListaSimple<Object> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(ListaSimple<Object> direcciones) {
        this.direcciones = direcciones;
    }

    public Cola<Object> getLista_pedidos() {
        return lista_pedidos;
    }

    public void setLista_pedidos(Cola<Object> lista_pedidos) {
        this.lista_pedidos = lista_pedidos;
    }

    public Cola<Object> getCarrito_compra() {
        return carrito_compra;
    }

    public void setCarrito_compra(Cola<Object> carrito_compra) {
        this.carrito_compra = carrito_compra;
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
