/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server.demo;

/**
 *
 * @author da9ni5el
 */

import com.server.dao.B;
import com.server.dao.ImplementacionDao;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class demoB {
    
    
    
    public static void main(String[] args) {        
        B b = new B();                                       
        ImplementacionDao imp = new ImplementacionDao();
        final String path = "/home/da9ni5el/Escritorio/ventas.csv";
        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String aux;
            String cadena = "";            
            while((aux = br.readLine()) != null) {
                cadena+= aux + "\n";
            }
            
            
            imp.cargarArchivoVentas(cadena);
            imp.generarReporteVentas();            
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
    
    
    
}
