/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server.dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 *
 * @author da9ni5el
 */
public class LogFile {

    private static final String NAMEFILE = "LogServer.txt";

    public LogFile() {
    }

 /*Se escribe el archivo en java*/
    public void escribirArchivo(String cabecera, String recurso, String args) {
        comprobarExistenciaFichero();
        
        
        try {
            FileWriter fstream = new FileWriter(NAMEFILE, true);
            try (BufferedWriter salida = new BufferedWriter(fstream)) {
                salida.write(">>>>>>>>>>>>" + cabecera + "<<<<<<<<<<<<\n");
                salida.write("Fecha y Hora:");                
                salida.write(LocalDateTime.now().toString() + "\n");                
                salida.write(recurso + ": ");
                salida.write(args + "\n\n");
                salida.close();
                
                
                System.out.println("Escrito correctamente");
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
    
    private void comprobarExistenciaFichero() {
        File archivo = new File(NAMEFILE);
        try {
            if(!archivo.exists()) {
                if(archivo.createNewFile()) {
                    System.out.println("Archivo creado");                   
                }                
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}
