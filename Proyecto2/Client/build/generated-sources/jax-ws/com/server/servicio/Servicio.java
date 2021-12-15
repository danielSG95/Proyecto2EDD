
package com.server.servicio;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "servicio", targetNamespace = "http://servicio.server.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Servicio {


    /**
     * 
     * @param password
     * @param user
     * @return
     *     returns int
     */
    @WebMethod(operationName = "Login")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "Login", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.Login")
    @ResponseWrapper(localName = "LoginResponse", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.LoginResponse")
    @Action(input = "http://servicio.server.com/servicio/LoginRequest", output = "http://servicio.server.com/servicio/LoginResponse")
    public int login(
        @WebParam(name = "user", targetNamespace = "")
        String user,
        @WebParam(name = "password", targetNamespace = "")
        String password);

    /**
     * 
     * @param password
     * @param dir
     * @param username
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "crearUsuario", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.CrearUsuario")
    @ResponseWrapper(localName = "crearUsuarioResponse", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.CrearUsuarioResponse")
    @Action(input = "http://servicio.server.com/servicio/crearUsuarioRequest", output = "http://servicio.server.com/servicio/crearUsuarioResponse")
    public boolean crearUsuario(
        @WebParam(name = "username", targetNamespace = "")
        String username,
        @WebParam(name = "password", targetNamespace = "")
        String password,
        @WebParam(name = "dir", targetNamespace = "")
        String dir);

    /**
     * 
     * @param username
     * @return
     *     returns com.server.servicio.Usuario
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "buscarUsuario", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.BuscarUsuario")
    @ResponseWrapper(localName = "buscarUsuarioResponse", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.BuscarUsuarioResponse")
    @Action(input = "http://servicio.server.com/servicio/buscarUsuarioRequest", output = "http://servicio.server.com/servicio/buscarUsuarioResponse")
    public Usuario buscarUsuario(
        @WebParam(name = "username", targetNamespace = "")
        String username);

    /**
     * 
     * @param password
     * @param username
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "modificarUsuario", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.ModificarUsuario")
    @ResponseWrapper(localName = "modificarUsuarioResponse", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.ModificarUsuarioResponse")
    @Action(input = "http://servicio.server.com/servicio/modificarUsuarioRequest", output = "http://servicio.server.com/servicio/modificarUsuarioResponse")
    public boolean modificarUsuario(
        @WebParam(name = "username", targetNamespace = "")
        String username,
        @WebParam(name = "password", targetNamespace = "")
        String password);

    /**
     * 
     * @param username
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "eliminarUsuario", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.EliminarUsuario")
    @ResponseWrapper(localName = "eliminarUsuarioResponse", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.EliminarUsuarioResponse")
    @Action(input = "http://servicio.server.com/servicio/eliminarUsuarioRequest", output = "http://servicio.server.com/servicio/eliminarUsuarioResponse")
    public boolean eliminarUsuario(
        @WebParam(name = "username", targetNamespace = "")
        String username);

    /**
     * 
     * @param envio
     * @param factura
     * @param direccion
     * @param username
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "ingresarDireccion", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.IngresarDireccion")
    @ResponseWrapper(localName = "ingresarDireccionResponse", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.IngresarDireccionResponse")
    @Action(input = "http://servicio.server.com/servicio/ingresarDireccionRequest", output = "http://servicio.server.com/servicio/ingresarDireccionResponse")
    public boolean ingresarDireccion(
        @WebParam(name = "username", targetNamespace = "")
        String username,
        @WebParam(name = "direccion", targetNamespace = "")
        String direccion,
        @WebParam(name = "envio", targetNamespace = "")
        int envio,
        @WebParam(name = "factura", targetNamespace = "")
        int factura);

    /**
     * 
     * @param idP
     * @param cantidad
     * @param username
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "ingresarProductoCompra", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.IngresarProductoCompra")
    @ResponseWrapper(localName = "ingresarProductoCompraResponse", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.IngresarProductoCompraResponse")
    @Action(input = "http://servicio.server.com/servicio/ingresarProductoCompraRequest", output = "http://servicio.server.com/servicio/ingresarProductoCompraResponse")
    public boolean ingresarProductoCompra(
        @WebParam(name = "username", targetNamespace = "")
        String username,
        @WebParam(name = "cantidad", targetNamespace = "")
        int cantidad,
        @WebParam(name = "idP", targetNamespace = "")
        String idP);

    /**
     * 
     * @param idP
     * @param cantidad
     * @param username
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "ingresarCarrito", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.IngresarCarrito")
    @ResponseWrapper(localName = "ingresarCarritoResponse", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.IngresarCarritoResponse")
    @Action(input = "http://servicio.server.com/servicio/ingresarCarritoRequest", output = "http://servicio.server.com/servicio/ingresarCarritoResponse")
    public boolean ingresarCarrito(
        @WebParam(name = "username", targetNamespace = "")
        String username,
        @WebParam(name = "cantidad", targetNamespace = "")
        int cantidad,
        @WebParam(name = "idP", targetNamespace = "")
        String idP);

    /**
     * 
     * @param marca
     * @param precio
     * @param imgpath
     * @param id
     * @param nombre
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "insertarProducto", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.InsertarProducto")
    @ResponseWrapper(localName = "insertarProductoResponse", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.InsertarProductoResponse")
    @Action(input = "http://servicio.server.com/servicio/insertarProductoRequest", output = "http://servicio.server.com/servicio/insertarProductoResponse")
    public boolean insertarProducto(
        @WebParam(name = "id", targetNamespace = "")
        String id,
        @WebParam(name = "nombre", targetNamespace = "")
        String nombre,
        @WebParam(name = "marca", targetNamespace = "")
        String marca,
        @WebParam(name = "precio", targetNamespace = "")
        String precio,
        @WebParam(name = "imgpath", targetNamespace = "")
        String imgpath);

    /**
     * 
     * @param id
     * @return
     *     returns com.server.servicio.Producto
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "buscarProducto", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.BuscarProducto")
    @ResponseWrapper(localName = "buscarProductoResponse", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.BuscarProductoResponse")
    @Action(input = "http://servicio.server.com/servicio/buscarProductoRequest", output = "http://servicio.server.com/servicio/buscarProductoResponse")
    public Producto buscarProducto(
        @WebParam(name = "id", targetNamespace = "")
        String id);

    /**
     * 
     * @param marca
     * @param precio
     * @param imgpath
     * @param id
     * @param nombre
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "modificarProducto", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.ModificarProducto")
    @ResponseWrapper(localName = "modificarProductoResponse", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.ModificarProductoResponse")
    @Action(input = "http://servicio.server.com/servicio/modificarProductoRequest", output = "http://servicio.server.com/servicio/modificarProductoResponse")
    public boolean modificarProducto(
        @WebParam(name = "id", targetNamespace = "")
        String id,
        @WebParam(name = "nombre", targetNamespace = "")
        String nombre,
        @WebParam(name = "marca", targetNamespace = "")
        String marca,
        @WebParam(name = "precio", targetNamespace = "")
        String precio,
        @WebParam(name = "imgpath", targetNamespace = "")
        String imgpath);

    /**
     * 
     * @param fecha
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "generarReporteBusquedaFecha", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.GenerarReporteBusquedaFecha")
    @ResponseWrapper(localName = "generarReporteBusquedaFechaResponse", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.GenerarReporteBusquedaFechaResponse")
    @Action(input = "http://servicio.server.com/servicio/generarReporteBusquedaFechaRequest", output = "http://servicio.server.com/servicio/generarReporteBusquedaFechaResponse")
    public String generarReporteBusquedaFecha(
        @WebParam(name = "fecha", targetNamespace = "")
        String fecha);

    /**
     * 
     * @param fechas
     */
    @WebMethod
    @RequestWrapper(localName = "generarReporteRangoFecha", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.GenerarReporteRangoFecha")
    @ResponseWrapper(localName = "generarReporteRangoFechaResponse", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.GenerarReporteRangoFechaResponse")
    @Action(input = "http://servicio.server.com/servicio/generarReporteRangoFechaRequest", output = "http://servicio.server.com/servicio/generarReporteRangoFechaResponse")
    public void generarReporteRangoFecha(
        @WebParam(name = "fechas", targetNamespace = "")
        String fechas);

    /**
     * 
     * @param fecha
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "generarReporteBusquedaNickname", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.GenerarReporteBusquedaNickname")
    @ResponseWrapper(localName = "generarReporteBusquedaNicknameResponse", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.GenerarReporteBusquedaNicknameResponse")
    @Action(input = "http://servicio.server.com/servicio/generarReporteBusquedaNicknameRequest", output = "http://servicio.server.com/servicio/generarReporteBusquedaNicknameResponse")
    public String generarReporteBusquedaNickname(
        @WebParam(name = "fecha", targetNamespace = "")
        String fecha);

    /**
     * 
     * @param fecha
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "generarReporteBusquedaCantidad", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.GenerarReporteBusquedaCantidad")
    @ResponseWrapper(localName = "generarReporteBusquedaCantidadResponse", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.GenerarReporteBusquedaCantidadResponse")
    @Action(input = "http://servicio.server.com/servicio/generarReporteBusquedaCantidadRequest", output = "http://servicio.server.com/servicio/generarReporteBusquedaCantidadResponse")
    public String generarReporteBusquedaCantidad(
        @WebParam(name = "fecha", targetNamespace = "")
        double fecha);

    /**
     * 
     * @param codigo
     * @param nickname
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "generarFactura", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.GenerarFactura")
    @ResponseWrapper(localName = "generarFacturaResponse", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.GenerarFacturaResponse")
    @Action(input = "http://servicio.server.com/servicio/generarFacturaRequest", output = "http://servicio.server.com/servicio/generarFacturaResponse")
    public boolean generarFactura(
        @WebParam(name = "nickname", targetNamespace = "")
        String nickname,
        @WebParam(name = "codigo", targetNamespace = "")
        String codigo);

    /**
     * 
     * @param nickname
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "listaFacturas", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.ListaFacturas")
    @ResponseWrapper(localName = "listaFacturasResponse", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.ListaFacturasResponse")
    @Action(input = "http://servicio.server.com/servicio/listaFacturasRequest", output = "http://servicio.server.com/servicio/listaFacturasResponse")
    public String listaFacturas(
        @WebParam(name = "nickname", targetNamespace = "")
        String nickname);

    /**
     * 
     * @param id
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "eliminarProducto", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.EliminarProducto")
    @ResponseWrapper(localName = "eliminarProductoResponse", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.EliminarProductoResponse")
    @Action(input = "http://servicio.server.com/servicio/eliminarProductoRequest", output = "http://servicio.server.com/servicio/eliminarProductoResponse")
    public boolean eliminarProducto(
        @WebParam(name = "id", targetNamespace = "")
        String id);

    /**
     * 
     * @param data
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "cargarArchivoUsuario", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.CargarArchivoUsuario")
    @ResponseWrapper(localName = "cargarArchivoUsuarioResponse", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.CargarArchivoUsuarioResponse")
    @Action(input = "http://servicio.server.com/servicio/cargarArchivoUsuarioRequest", output = "http://servicio.server.com/servicio/cargarArchivoUsuarioResponse")
    public String cargarArchivoUsuario(
        @WebParam(name = "data", targetNamespace = "")
        String data);

    /**
     * 
     * @param data
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "cargarArchivoDireccion", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.CargarArchivoDireccion")
    @ResponseWrapper(localName = "cargarArchivoDireccionResponse", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.CargarArchivoDireccionResponse")
    @Action(input = "http://servicio.server.com/servicio/cargarArchivoDireccionRequest", output = "http://servicio.server.com/servicio/cargarArchivoDireccionResponse")
    public String cargarArchivoDireccion(
        @WebParam(name = "data", targetNamespace = "")
        String data);

    /**
     * 
     * @param data
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "cargarArchivoCompra", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.CargarArchivoCompra")
    @ResponseWrapper(localName = "cargarArchivoCompraResponse", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.CargarArchivoCompraResponse")
    @Action(input = "http://servicio.server.com/servicio/cargarArchivoCompraRequest", output = "http://servicio.server.com/servicio/cargarArchivoCompraResponse")
    public String cargarArchivoCompra(
        @WebParam(name = "data", targetNamespace = "")
        String data);

    /**
     * 
     * @param data
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "cargarArchivoCarro", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.CargarArchivoCarro")
    @ResponseWrapper(localName = "cargarArchivoCarroResponse", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.CargarArchivoCarroResponse")
    @Action(input = "http://servicio.server.com/servicio/cargarArchivoCarroRequest", output = "http://servicio.server.com/servicio/cargarArchivoCarroResponse")
    public String cargarArchivoCarro(
        @WebParam(name = "data", targetNamespace = "")
        String data);

    /**
     * 
     * @param data
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "cargarArchivoProducto", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.CargarArchivoProducto")
    @ResponseWrapper(localName = "cargarArchivoProductoResponse", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.CargarArchivoProductoResponse")
    @Action(input = "http://servicio.server.com/servicio/cargarArchivoProductoRequest", output = "http://servicio.server.com/servicio/cargarArchivoProductoResponse")
    public String cargarArchivoProducto(
        @WebParam(name = "data", targetNamespace = "")
        String data);

    /**
     * 
     * @param data
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "cargarArchivoVenta", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.CargarArchivoVenta")
    @ResponseWrapper(localName = "cargarArchivoVentaResponse", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.CargarArchivoVentaResponse")
    @Action(input = "http://servicio.server.com/servicio/cargarArchivoVentaRequest", output = "http://servicio.server.com/servicio/cargarArchivoVentaResponse")
    public String cargarArchivoVenta(
        @WebParam(name = "data", targetNamespace = "")
        String data);

    /**
     * 
     * @param data
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "cargarArchivoDetalle", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.CargarArchivoDetalle")
    @ResponseWrapper(localName = "cargarArchivoDetalleResponse", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.CargarArchivoDetalleResponse")
    @Action(input = "http://servicio.server.com/servicio/cargarArchivoDetalleRequest", output = "http://servicio.server.com/servicio/cargarArchivoDetalleResponse")
    public String cargarArchivoDetalle(
        @WebParam(name = "data", targetNamespace = "")
        String data);

    /**
     * 
     * @param username
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "generarReporteCompras", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.GenerarReporteCompras")
    @ResponseWrapper(localName = "generarReporteComprasResponse", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.GenerarReporteComprasResponse")
    @Action(input = "http://servicio.server.com/servicio/generarReporteComprasRequest", output = "http://servicio.server.com/servicio/generarReporteComprasResponse")
    public String generarReporteCompras(
        @WebParam(name = "username", targetNamespace = "")
        String username);

    /**
     * 
     * @param username
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "generarReporteCarrito", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.GenerarReporteCarrito")
    @ResponseWrapper(localName = "generarReporteCarritoResponse", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.GenerarReporteCarritoResponse")
    @Action(input = "http://servicio.server.com/servicio/generarReporteCarritoRequest", output = "http://servicio.server.com/servicio/generarReporteCarritoResponse")
    public String generarReporteCarrito(
        @WebParam(name = "username", targetNamespace = "")
        String username);

    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "generarReporteUsuarios", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.GenerarReporteUsuarios")
    @ResponseWrapper(localName = "generarReporteUsuariosResponse", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.GenerarReporteUsuariosResponse")
    @Action(input = "http://servicio.server.com/servicio/generarReporteUsuariosRequest", output = "http://servicio.server.com/servicio/generarReporteUsuariosResponse")
    public String generarReporteUsuarios();

    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "generarReporteProductos", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.GenerarReporteProductos")
    @ResponseWrapper(localName = "generarReporteProductosResponse", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.GenerarReporteProductosResponse")
    @Action(input = "http://servicio.server.com/servicio/generarReporteProductosRequest", output = "http://servicio.server.com/servicio/generarReporteProductosResponse")
    public String generarReporteProductos();

    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "generarReporteVentas", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.GenerarReporteVentas")
    @ResponseWrapper(localName = "generarReporteVentasResponse", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.GenerarReporteVentasResponse")
    @Action(input = "http://servicio.server.com/servicio/generarReporteVentasRequest", output = "http://servicio.server.com/servicio/generarReporteVentasResponse")
    public String generarReporteVentas();

    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "generarReporteGeneral", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.GenerarReporteGeneral")
    @ResponseWrapper(localName = "generarReporteGeneralResponse", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.GenerarReporteGeneralResponse")
    @Action(input = "http://servicio.server.com/servicio/generarReporteGeneralRequest", output = "http://servicio.server.com/servicio/generarReporteGeneralResponse")
    public String generarReporteGeneral();

    /**
     * 
     * @param username
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "obtenerDirecciones", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.ObtenerDirecciones")
    @ResponseWrapper(localName = "obtenerDireccionesResponse", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.ObtenerDireccionesResponse")
    @Action(input = "http://servicio.server.com/servicio/obtenerDireccionesRequest", output = "http://servicio.server.com/servicio/obtenerDireccionesResponse")
    public String obtenerDirecciones(
        @WebParam(name = "username", targetNamespace = "")
        String username);

    /**
     * 
     * @param username
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "obtenerProductos", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.ObtenerProductos")
    @ResponseWrapper(localName = "obtenerProductosResponse", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.ObtenerProductosResponse")
    @Action(input = "http://servicio.server.com/servicio/obtenerProductosRequest", output = "http://servicio.server.com/servicio/obtenerProductosResponse")
    public String obtenerProductos(
        @WebParam(name = "username", targetNamespace = "")
        String username);

    /**
     * 
     * @param username
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "obtenerCarrito", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.ObtenerCarrito")
    @ResponseWrapper(localName = "obtenerCarritoResponse", targetNamespace = "http://servicio.server.com/", className = "com.server.servicio.ObtenerCarritoResponse")
    @Action(input = "http://servicio.server.com/servicio/obtenerCarritoRequest", output = "http://servicio.server.com/servicio/obtenerCarritoResponse")
    public String obtenerCarrito(
        @WebParam(name = "username", targetNamespace = "")
        String username);

}