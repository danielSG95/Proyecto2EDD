/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server.servicio;

import com.server.dao.ImplementacionDao;
import com.server.modelo.Producto;
import com.server.modelo.Usuario;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author da9ni5el
 */
@WebService(serviceName = "servicio")
public class servicio {

    private static final ImplementacionDao IMP = new ImplementacionDao();

    @WebMethod(operationName = "Login")
    public int Login(@WebParam(name = "user") String user, @WebParam(name = "password") String password) {
        int retorno = IMP.login(user, password);
        return retorno;
    }

    @WebMethod(operationName = "crearUsuario")
    public boolean crearUsuario(@WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "dir") String dir) {
        return IMP.insertarUsuarioAvl(username, password, dir);
    }

    @WebMethod(operationName = "buscarUsuario")
    public Usuario buscarUsuario(@WebParam(name = "username") String username) {
        return IMP.buscarUsuario(username);
        /*Le delego al usuario la validacion de retornos nulos*/
    }

    @WebMethod(operationName = "modificarUsuario")
    public boolean modificarUsuario(@WebParam(name = "username") String username, @WebParam(name = "password") String password) {
        return IMP.modificarUsuario(username, password);
    }

    @WebMethod(operationName = "eliminarUsuario")
    public boolean eliminarUsuario(@WebParam(name = "username") String username) {
        return IMP.eliminarUsuario(username);
    }
    
    @WebMethod(operationName = "ingresarDireccion")
    public boolean ingresarDireccion(@WebParam(name = "username") String username, @WebParam(name = "direccion") String direccion,
            @WebParam(name = "envio") int envio, @WebParam(name = "factura") int factura) {

        return false;
    }

    @WebMethod(operationName = "ingresarProductoCompra")
    public boolean ingresarProductoCompra(@WebParam(name = "username") String username, @WebParam(name = "cantidad") int cantidad,
            @WebParam(name = "idP") String idP) {

        return IMP.insertarCompra(username, cantidad, idP);
    }
    
    @WebMethod(operationName = "ingresarCarrito")
    public boolean ingresarCarrito(@WebParam(name = "username") String username, @WebParam(name = "cantidad") int cantidad,
            @WebParam(name = "idP") String idP) {

        return IMP.insertarCarro(username, cantidad, idP);
    }
    
            /*      Metodos ABC Productos       */
    @WebMethod(operationName = "insertarProducto")
    public boolean insertarProducto(@WebParam(name = "id") String id, @WebParam(name = "nombre") String nombre
                                    ,@WebParam(name = "marca") String marca, @WebParam(name = "precio") String precio,
                                    @WebParam(name = "imgpath") String img ) {
        
        
        return IMP.insertarProducto(id, nombre, marca, precio, img);
    }
    
    
    @WebMethod(operationName = "buscarProducto")
    public Producto buscarProducto(@WebParam(name = "id") String id) {                
        return IMP.buscarProducto(id);
    }
    
     @WebMethod(operationName = "modificarProducto")
    public boolean modificarProducto(@WebParam(name = "id") String id, @WebParam(name = "nombre") String nombre
                                    ,@WebParam(name = "marca") String marca, @WebParam(name = "precio") String precio,
                                    @WebParam(name = "imgpath") String img ) {
        
        
        return IMP.modificarProducto(id, nombre, marca, precio, img);
    }
    
    @WebMethod(operationName = "generarReporteBusquedaFecha")
    public String generarReporteBusquedaFecha(@WebParam(name = "fecha") String fecha) {
        return IMP.reporteBusquedaPorFecha(fecha);
    }
    
    @WebMethod(operationName = "generarReporteBusquedaNickname")
    public String generarReporteBusquedaNickname(@WebParam(name = "fecha") String nickname) {
        return IMP.reporteBusquedaPorNickname(nickname);
    }
    
    @WebMethod(operationName = "generarReporteBusquedaCantidad")
    public String generarReporteBusquedaCantidad(@WebParam(name = "fecha") double cantidad) {
        return IMP.reporteBusquedaCantidad(cantidad);
    }
    
    //Esta es exclusiva del cliente
    @WebMethod(operationName = "generarFactura")
    public boolean generarFactura(@WebParam(name = "nickname") String nickname, @WebParam(name = "codigo") String codigo) {
        return IMP.factura(codigo, nickname);
    }
    
    @WebMethod(operationName = "eliminarProducto")
    public boolean eliminarProducto(@WebParam(name = "id") String id) {                
        return IMP.eliminarProducto(id);
    }
    
    
    
            /*      Metodos especificos para el administrador       */
    @WebMethod(operationName = "cargarArchivoUsuario")
    public String cargarArchivoUsuario(@WebParam(name = "data") String data) {
        
        return IMP.cargarArchivoUsuario(data);
    }
    
    @WebMethod(operationName = "cargarArchivoDireccion")
    public String cargarArchivoDireccion(@WebParam(name = "data") String data) {
        
        return IMP.cargarArchivoDireccion(data);
    }
    
    @WebMethod(operationName = "cargarArchivoCompra")
    public String cargarArchivoCompra(@WebParam(name = "data") String data) {
        
        return IMP.cargarArchivoCompra(data);
    }
            
    @WebMethod(operationName = "cargarArchivoCarro")
    public String cargarArchivoCarro(@WebParam(name = "data") String data) {        
        return IMP.cargarArchivoCarro(data);
    }
    
    //modificar los siguientes 3 metodos
    @WebMethod(operationName = "cargarArchivoProducto")
    public String cargarArchivoProducto(@WebParam(name = "data") String data) {        
        return IMP.cargarArchivoProducto(data);
    }
    
    @WebMethod(operationName = "cargarArchivoVenta")
    public String cargarArchivoVenta(@WebParam(name = "data") String data) {        
        return IMP.cargarArchivoVentas(data);
    }
    
    @WebMethod(operationName = "cargarArchivoDetalle")
    public String cargarArchivoDetalle(@WebParam(name = "data") String data) {        
        return IMP.cargarArchivoDetalle(data);
    }
            /*      Reportes para el Cliente        */
    
    @WebMethod(operationName = "generarReporteCompras")
    public String generarReporteComras(@WebParam(name = "username") String username) {        
        return IMP.generarReporteCompras(username);
    }
    
    @WebMethod(operationName = "generarReporteCarrito")
    public String generarReporteCarrito(@WebParam(name = "username") String username) {        
        return IMP.generarReporteCarrito(username);
    }
    
            /*      Reportes para el Administrador      */
    @WebMethod(operationName =  "generarReporteUsuarios")
    public String generarReporteUsuarios() {
        return IMP.generarReporteAvl();        
    }
    
    @WebMethod(operationName =  "generarReporteProductos")
    public String generarReporteProductos() {
        return IMP.generarReporteProductos();        
    }
    
    @WebMethod(operationName =  "generarReporteVentas")
    public String generarReporteVentas() {
        return IMP.generarReporteVentas();        
    }
    
    @WebMethod(operationName = "generarReporteGeneral")/*Falta completar el metodo*/
    public String generarReporteGeneral() {
        return IMP.generarReporteGeneralSistema();
    }
    
            /*      Devolver Elementos Usuario      */
    
    @WebMethod(operationName = "obtenerDirecciones")
    public String obtenerDirecciones(@WebParam(name = "username") String username) {
        return IMP.devolverDirecciones(username);
    }
    
    @WebMethod(operationName = "obtenerProductos")
    public String obtenerProductos(@WebParam(name = "username") String username) {
        return IMP.devolverColaProductos(username);
    }
    
    @WebMethod(operationName = "obtenerCarrito")
    public String obtenerCarrito(@WebParam(name = "username") String username) {
        return IMP.devolverColaCarrito(username);
    }
    
    
}
