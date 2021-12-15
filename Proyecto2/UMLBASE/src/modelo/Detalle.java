/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server.modelo;

import com.server.Idao.*;
/**
 *
 * @author da9ni5el
 */
public class Detalle implements AdminObject {
    private int cantidad;
    private float precio;
    private Producto producto;

    public Detalle(int cantidad, float precio, Producto producto) {
        this.cantidad = cantidad;
        this.precio = precio;
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String escribirObjetoConsole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificarObjeto(Object q) {
        throw new UnsupportedOperationException("Not supported yet"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String escribirObjeto() {
        StringBuffer buffer = new StringBuffer();
        
        buffer.append(producto.escribirObjeto());
//        buffer.append(cantidad);
    
        return buffer.toString();
    }
    
    @Override
    public String devolverClave() {
        return null;
    }
           
}
