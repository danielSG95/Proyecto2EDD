package com.server.modelo;

import com.server.Idao.AdminObject;
import com.server.Idao.Comparador;

public class Producto implements Comparador, AdminObject {

    String codigoProducto;
    String nombre;
    String marca;
    float precio;
    String pathImagen;

    public Producto(String codigo) {
        this.codigoProducto = codigo;
    }

    public Producto(String codigoProducto, String nombre, String marca, float precio, String pathImagen) {
        super();
        this.codigoProducto = codigoProducto;
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.pathImagen = pathImagen;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getPathImagen() {
        return pathImagen;
    }

    public void setPathImagen(String pathImagen) {
        this.pathImagen = pathImagen;
    }

    @Override
    public String escribirObjetoConsole() {
        // TODO Auto-generated method stub		
        return "Codigo: " + codigoProducto;
    }

    @Override
    public void modificarObjeto(Object q) {
        Producto p = (Producto) q;
        codigoProducto = p.codigoProducto;
        marca = p.marca;
        nombre = p.nombre;
        pathImagen = p.pathImagen;
        precio = p.precio;

    }

    @Override
    public String escribirObjeto() {
        return "Codigo: " + codigoProducto + " \\nNombre: " + nombre
                + "\\nPrecio:" + precio + "\\nCantidad: ";
    }

    @Override
    public String devolverClave() {
        return String.valueOf(codigoProducto);
        /*Modificacion*/
    }

    @Override
    public boolean esIgual(Object q) {
        String clave = q.toString();
        return clave.equals(codigoProducto);
    }

    @Override
    public boolean esMayor(Object q) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean esMenor(Object q) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean mayorIgual(Object q) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean menorIgual(Object q) {
        // TODO Auto-generated method stub
        return false;
    }

}
