/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server.demo;

import com.server.dao.ImplementacionDao;
import com.server.modelo.Producto;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


/**
 *
 * @author da9ni5el
 */
public class demoSistema {
    
    
    public static void main(String[] args) {
//        B b = new B();        
//        TablaHash t = new TablaHash();
        ImplementacionDao imp = new ImplementacionDao();
        final String path = "/home/da9ni5el/Escritorio/Archivos/productos.csv";
        final String path1 = "/home/da9ni5el/Escritorio/Archivos/facturas2.csv";
        final String path2 = "/home/da9ni5el/Escritorio/Archivos/detalle.csv";
        final String path3 = "/home/da9ni5el/Escritorio/Archivos/usuarios.csv";
        final String path4 = "/home/da9ni5el/Escritorio/Archivos/direccion.csv";
        final String path5 = "/home/da9ni5el/Escritorio/Archivos/carrito.csv";
        final String path6 = "/home/da9ni5el/Escritorio/Archivos/porcomprar.csv";
        
        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String aux;
            String cadena = "";            
            while((aux = br.readLine()) != null) {
                cadena+= aux + "\n";
            }
            br.close();
            imp.cargarArchivoProducto(cadena);                                    
            
            fr = new FileReader(path3);
            br = new BufferedReader(fr);            
            aux = "";
            cadena = "";            
            while((aux = br.readLine()) != null) {
                cadena+= aux + "\n";
            }
            br.close();
            imp.cargarArchivoUsuario(cadena);
            
            
            fr = new FileReader(path4);
            br = new BufferedReader(fr);            
            aux = "";
            cadena = "";            
            while((aux = br.readLine()) != null) {
                cadena+= aux + "\n";
            }
            br.close();
            
            imp.cargarArchivoDireccion(cadena);
            
            
            fr = new FileReader(path5);
            br = new BufferedReader(fr);            
            aux = "";
            cadena = "";            
            while((aux = br.readLine()) != null) {
                cadena+= aux + "\n";
            }
            br.close();
            imp.cargarArchivoCarro(cadena);
            
            
            fr = new FileReader(path6);
            br = new BufferedReader(fr);            
            aux = "";
            cadena = "";            
            while((aux = br.readLine()) != null) {
                cadena+= aux + "\n";
            }
            br.close();
            imp.cargarArchivoCompra(cadena);
                                    
            fr = new FileReader(path1);
            br = new BufferedReader(fr);            
            aux = "";
            cadena = "";            
            while((aux = br.readLine()) != null) {
                cadena+= aux + "\n";
            }
            br.close();
            imp.cargarArchivoVentas(cadena);
            
            fr = new FileReader(path2);
            br = new BufferedReader(fr);            
            aux = "";
            cadena = "";            
            while((aux = br.readLine()) != null) {
                cadena+= aux + "\n";
            }
            br.close();
            
            imp.cargarArchivoDetalle(cadena);                        
            
//            imp.generarReporteProductos();
//            imp.generarReporteVentas();   
//            imp.generarReporteAvl();
//            
//            imp.generarReporteGeneralSistema();


//            imp.reporteBusquedaPorFecha("10/1/2019");
//            imp.generarReporteCarrito("fargan");

//            imp.reporteBusquedaPorNickname("pepe");
//            imp.generarFactura("2");
//            imp.factura("2");
            imp.reporteBusquedaCantidad(10);
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}
