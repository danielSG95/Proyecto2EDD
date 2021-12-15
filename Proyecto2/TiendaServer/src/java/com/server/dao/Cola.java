package com.server.dao;

import com.server.Idao.Comparador;

public class Cola<T> extends ListaSimple<T> {

    public Cola() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void insertar(T dato, int cantidad) {
        // TODO Auto-generated method stub
        super.insertar(dato, cantidad);
    }

    @Override
    public T elminar(T valor) {
        return super.elminar(valor); //To change body of generated methods, choose Tools | Templates.
    }

    protected T deQueque() { //desencolar
        if (primero == null) {
            System.out.println("Lista Vacia");
            return null;
        }

        NodoSimple<T> pivote = primero;
        T auxiliarDato = pivote.getDato();

        primero = primero.getSiguiente();
        pivote = null;
        return auxiliarDato;
    }

    @Override
    public T modificar(T valorNuevo) {
        // TODO Auto-generated method stub
        return super.modificar(valorNuevo);
    }

}
