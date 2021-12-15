/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server.demo;

import com.server.dao.ImplementacionDao;
import com.server.dao.TablaHash;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author da9ni5el
 */
public class demoTablaHash {

    public static void main(String[] args) {
        TablaHash t = new TablaHash();
        ImplementacionDao imp = new ImplementacionDao();
        final String path = "/home/da9ni5el/Escritorio/productos.csv";
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
            imp.generarReporteProductos();            
//            System.out.println(imp.listadoProductos());
        } catch (IOException e) {
            System.out.println(e.toString());
        }
//        t.insertar(new Producto("15648"));
//        t.insertar(new Producto("156546"));
//        t.insertar(new Producto("416871"));
//        t.insertar(new Producto("9955461"));
//        t.insertar(new Producto("498716"));
//        t.insertar(new Producto("897162"));
//        t.insertar(new Producto("9871321"));
//        t.insertar(new Producto("6547855"));
//        t.insertar(new Producto("15648"));
//        
//        t.graficar("HashPruebas2");
    }

}
