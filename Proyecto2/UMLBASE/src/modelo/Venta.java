/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server.modelo;

import com.server.dao.ListaSimple;
import java.time.LocalDate;
 

        /*  FACTURAS    */

import com.server.Idao.*;
/**
 *
 * @author da9ni5el
 */

public class Venta implements AdminObject, Comparador{
    private String numeroFactura;
    private LocalDate fecha;
    private double total;
    Usuario usuario;
    ListaSimple<Detalle> detalle;

    public Venta(String numeroFactura, LocalDate fecha, double total, Usuario usuario, ListaSimple<Detalle> detalle) {
        this.numeroFactura = numeroFactura;
        this.fecha = fecha;
        this.total = total;
        this.usuario = usuario;
        this.detalle = detalle;
    }
    
    public Venta(String numeroFactura, LocalDate fecha, double total, Usuario usuario) {
        this.numeroFactura = numeroFactura;
        this.fecha = fecha;
        this.total = total;
        this.usuario = usuario;        
    }
    
    public Venta(String n) {
        this.numeroFactura = n;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ListaSimple<Detalle> getDetalle() {
        return detalle;
    }

    public void setDetalle(ListaSimple<Detalle> detalle) {
        this.detalle = detalle;
    }

    
    
    @Override
    public String escribirObjetoConsole() {
        return "No Factura: " + numeroFactura + " Usuario: " + usuario  + " Fecha: " + fecha;
    }

    @Override
    public void modificarObjeto(Object q) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String escribirObjeto() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("No Factura: ").append(numeroFactura).append("\\n");
        buffer.append("Fecha: ").append(fecha).append("\\n");
        buffer.append("total: ").append(total).append("\\n");
        buffer.append("Usuario: ").append(usuario.getNickname());
        return buffer.toString();
    }

    @Override
    public String devolverClave() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean esIgual(Object q) {
        Venta v = (Venta)q;
        return Double.parseDouble(numeroFactura) == Double.parseDouble(v.getNumeroFactura());
    }

    @Override
    public boolean esMayor(Object q) {
        Venta v = (Venta)q;
        return Double.parseDouble(numeroFactura) > Double.parseDouble(v.getNumeroFactura());
    }

    @Override
    public boolean esMenor(Object q) {
        Venta v = (Venta)q;
        return Double.parseDouble(numeroFactura) < Double.parseDouble(v.getNumeroFactura());
    }

    @Override
    public boolean mayorIgual(Object q) {
        Venta v = (Venta)q;
        return Double.parseDouble(numeroFactura) >= Double.parseDouble(v.getNumeroFactura());
    }

    @Override
    public boolean menorIgual(Object q) {
        Venta v = (Venta)q;
        return Double.parseDouble(numeroFactura) <= Double.parseDouble(v.getNumeroFactura());
    }

    
    
}
