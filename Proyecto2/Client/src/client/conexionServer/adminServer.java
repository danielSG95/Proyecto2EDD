/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.conexionServer;

import com.server.servicio.Producto;
import com.server.servicio.Usuario;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author da9ni5el
 */
public class adminServer {

    public adminServer() {
    }
    
    
    public int loginController(String user, String password) {
        return login(user, password);
    }

    public boolean crearUsuarioController(String user, String password, String dir) {
        return crearUsuario(user, password, dir);
    }
    
    public Usuario buscarUsuarioController(String username) {
        return buscarUsuario(username);
    }
    
    public boolean modificarUsuarioController(String username, String password) {
        return modificarUsuario(username, password); //No se deberia de poder modificar el username
    }
    
    public boolean eliminarUsuarioController(String username) {
        return eliminarUsuario(username);
    }
    
    public String cargarArchivo(File selected, int type) {
        String salida = "";
        try {
            String data  =  leerArchivo(selected);
            switch(type) {
                case 0:
                    salida = cargarArchivoUsuario(data);
                    break;
                case 1:
                    salida = cargarArchivoDireccion(data);
                    break;
                case 2:
                    salida = cargarArchivoCompra(data);
                    break;
                case 3:
                    salida = cargarArchivoCarro(data);
                    break;
                case 4:
                    salida = cargarArchivoProducto(data);
                    break;
                case 5:
                    salida = cargarArchivoVenta(data);
                    break;
                case 6:
                    salida = cargarArchivoDetalle(data);
            }
        } catch (Exception e) {
            System.out.println(e. toString());            
        }
        return salida;
    }      
    
    public String leerArchivo(File file) {
        FileReader fr = null;
        String cadena= "";
        try {
            fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String aux;            
            while((aux = br.readLine()) != null) {
                cadena+= aux + "\n";
            }  
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(adminServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(adminServer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(adminServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return cadena;
    }
    
    public String generarReporteUsuariosController() {
        return generarReporteUsuarios();
    }
    
    public String generarReporteVentasController() {
        return generarReporteVentas();
    }
    
    public String generarReporteProductosController() {
        return generarReporteProductos();
    }
    
    public String generarReporteGeneralController() {
        return generarReporteGeneral();
    }
    
    
    public boolean insertarProductoController(String id, String nombre, String marca, String precio, String img)  {
        return insertarProducto(id, nombre, marca, precio, img);
    }          
    
    public Producto buscarProductoController(String id) {
        return buscarProducto(id);
    }
    
    public boolean modificarProductoController(String id, String nombre, String marca, String precio, String img){
        return modificarProducto(id, nombre, marca, precio, img);
    } 
    
    public boolean eliminarProductoController(String id) {
        return eliminarProducto(id);
    }
    
    public void generarReporteBusquedaCantidadController(double cantidad) {
        generarReporteBusquedaCantidad(cantidad);
    }
    
    public void generarReporteBusquedaFechaController(String fecha) {
        generarReporteBusquedaFecha(fecha);
    }
    
    public void generarReporteBusquedaNicknameController(String nickname) {
        generarReporteBusquedaNickname(nickname);
    }
    
    public void generarReportePorRangoFecha(String fechas) {
        generarReporteRangoFecha(fechas);
    }
    
                        /*Llamadas al servidor*/
    
    
    private static int login(java.lang.String user, java.lang.String password) {
        com.server.servicio.Servicio_Service service = new com.server.servicio.Servicio_Service();
        com.server.servicio.Servicio port = service.getServicioPort();
        return port.login(user, password);
    }

    private static Usuario buscarUsuario(java.lang.String username) {
        com.server.servicio.Servicio_Service service = new com.server.servicio.Servicio_Service();
        com.server.servicio.Servicio port = service.getServicioPort();
        return port.buscarUsuario(username);
    }

    private static String cargarArchivoCarro(java.lang.String data) {
        com.server.servicio.Servicio_Service service = new com.server.servicio.Servicio_Service();
        com.server.servicio.Servicio port = service.getServicioPort();
        return port.cargarArchivoCarro(data);
    }

    private static String cargarArchivoCompra(java.lang.String data) {
        com.server.servicio.Servicio_Service service = new com.server.servicio.Servicio_Service();
        com.server.servicio.Servicio port = service.getServicioPort();
        return port.cargarArchivoCompra(data);
    }

    private static String cargarArchivoDetalle(java.lang.String data) {
        com.server.servicio.Servicio_Service service = new com.server.servicio.Servicio_Service();
        com.server.servicio.Servicio port = service.getServicioPort();
        return port.cargarArchivoDetalle(data);
    }

    private static String cargarArchivoDireccion(java.lang.String data) {
        com.server.servicio.Servicio_Service service = new com.server.servicio.Servicio_Service();
        com.server.servicio.Servicio port = service.getServicioPort();
        return port.cargarArchivoDireccion(data);
    }

    private static String cargarArchivoProducto(java.lang.String data) {
        com.server.servicio.Servicio_Service service = new com.server.servicio.Servicio_Service();
        com.server.servicio.Servicio port = service.getServicioPort();
        return port.cargarArchivoProducto(data);
    }

    private static String cargarArchivoUsuario(java.lang.String data) {
        com.server.servicio.Servicio_Service service = new com.server.servicio.Servicio_Service();
        com.server.servicio.Servicio port = service.getServicioPort();
        return port.cargarArchivoUsuario(data);
    }

    private static String cargarArchivoVenta(java.lang.String data) {
        com.server.servicio.Servicio_Service service = new com.server.servicio.Servicio_Service();
        com.server.servicio.Servicio port = service.getServicioPort();
        return port.cargarArchivoVenta(data);
    }

    private static boolean crearUsuario(java.lang.String username, java.lang.String password, java.lang.String dir) {
        com.server.servicio.Servicio_Service service = new com.server.servicio.Servicio_Service();
        com.server.servicio.Servicio port = service.getServicioPort();
        return port.crearUsuario(username, password, dir);
    }

    private static String generarReporteGeneral() {
        com.server.servicio.Servicio_Service service = new com.server.servicio.Servicio_Service();
        com.server.servicio.Servicio port = service.getServicioPort();
        return port.generarReporteGeneral();
    }

    private static String generarReporteProductos() {
        com.server.servicio.Servicio_Service service = new com.server.servicio.Servicio_Service();
        com.server.servicio.Servicio port = service.getServicioPort();
        return port.generarReporteProductos();
    }

    private static String generarReporteUsuarios() {
        com.server.servicio.Servicio_Service service = new com.server.servicio.Servicio_Service();
        com.server.servicio.Servicio port = service.getServicioPort();
        return port.generarReporteUsuarios();
    }

    private static String generarReporteVentas() {
        com.server.servicio.Servicio_Service service = new com.server.servicio.Servicio_Service();
        com.server.servicio.Servicio port = service.getServicioPort();
        return port.generarReporteVentas();
    }

    private static boolean modificarUsuario(java.lang.String username, java.lang.String password) {
        com.server.servicio.Servicio_Service service = new com.server.servicio.Servicio_Service();
        com.server.servicio.Servicio port = service.getServicioPort();
        return port.modificarUsuario(username, password);
    }

    private static boolean eliminarUsuario(java.lang.String username) {
        com.server.servicio.Servicio_Service service = new com.server.servicio.Servicio_Service();
        com.server.servicio.Servicio port = service.getServicioPort();
        return port.eliminarUsuario(username);
    }

    private static Producto buscarProducto(java.lang.String id) {
        com.server.servicio.Servicio_Service service = new com.server.servicio.Servicio_Service();
        com.server.servicio.Servicio port = service.getServicioPort();
        return port.buscarProducto(id);
    }

    private static boolean eliminarProducto(java.lang.String id) {
        com.server.servicio.Servicio_Service service = new com.server.servicio.Servicio_Service();
        com.server.servicio.Servicio port = service.getServicioPort();
        return port.eliminarProducto(id);
    }

    private static boolean insertarProducto(java.lang.String id, java.lang.String nombre, java.lang.String marca, java.lang.String precio, java.lang.String imgpath) {
        com.server.servicio.Servicio_Service service = new com.server.servicio.Servicio_Service();
        com.server.servicio.Servicio port = service.getServicioPort();
        return port.insertarProducto(id, nombre, marca, precio, imgpath);
    }

    private static boolean modificarProducto(java.lang.String id, java.lang.String nombre, java.lang.String marca, java.lang.String precio, java.lang.String imgpath) {
        com.server.servicio.Servicio_Service service = new com.server.servicio.Servicio_Service();
        com.server.servicio.Servicio port = service.getServicioPort();
        return port.modificarProducto(id, nombre, marca, precio, imgpath);
    }

    private static String generarReporteBusquedaCantidad(double fecha) {
        com.server.servicio.Servicio_Service service = new com.server.servicio.Servicio_Service();
        com.server.servicio.Servicio port = service.getServicioPort();
        return port.generarReporteBusquedaCantidad(fecha);
    }

    private static String generarReporteBusquedaFecha(java.lang.String fecha) {
        com.server.servicio.Servicio_Service service = new com.server.servicio.Servicio_Service();
        com.server.servicio.Servicio port = service.getServicioPort();
        return port.generarReporteBusquedaFecha(fecha);
    }

    private static String generarReporteBusquedaNickname(java.lang.String fecha) {
        com.server.servicio.Servicio_Service service = new com.server.servicio.Servicio_Service();
        com.server.servicio.Servicio port = service.getServicioPort();
        return port.generarReporteBusquedaNickname(fecha);
    }

    private static void generarReporteRangoFecha(java.lang.String fechas) {
        com.server.servicio.Servicio_Service service = new com.server.servicio.Servicio_Service();
        com.server.servicio.Servicio port = service.getServicioPort();
        port.generarReporteRangoFecha(fechas);
    }

  
    
}
