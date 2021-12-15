/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server.demo;

import com.server.dao.Cola;
import com.server.dao.ListaSimple;
import com.server.dao.NodoAvl;
import com.server.dao.arbolAvl;
import com.server.modelo.Direccion;
import com.server.modelo.Producto;
import com.server.modelo.Usuario;

/**
 *
 * @author da9ni5el
 */
public class demoAvl {

    public static void main(String[] args) throws Exception {
        Usuario user;
        arbolAvl arbol = new arbolAvl();
        Producto p;
        Direccion d;

        arbol.insertar(new Usuario("da9ni5el", "123"));
        NodoAvl temporal = arbol.buscarNodo(new Usuario("da9ni5el"));
        
        temporal.setLista_pedidos(new Cola());
        temporal.setDirecciones(new ListaSimple());
        temporal.setCarrito_compra(new Cola());
        
        
        temporal.getCarrito_compra().insertar(new Producto("151654"), 5);
        temporal.getCarrito_compra().insertar(new Producto("166579"), 58);
        
        
        temporal.getDirecciones().insertar(new Direccion("nosetu",1, 1));
        temporal.getDirecciones().insertar(new Direccion("nosetu2",0, 0));
        
        temporal.getLista_pedidos().insertar(new Producto("54986"),1);
        temporal.getLista_pedidos().insertar(new Producto("54876"),2);
        
        arbol.insertar(new Usuario("zerottar_95", "324"));
        arbol.insertar(new Usuario("95_zerottar", "324"));
        arbol.insertar(new Usuario("xor_", "324"));
        arbol.insertar(new Usuario("ezquer", "324"));
        arbol.insertar(new Usuario("fin23", "324"));
        arbol.insertar(new Usuario("floan2", "324"));
        arbol.insertar(new Usuario("lgoan234", "324"));
        arbol.insertar(new Usuario("fornite84", "324"));
        arbol.insertar(new Usuario("123cool", "324"));
        arbol.insertar(new Usuario("CaptainM", "324"));
        arbol.insertar(new Usuario("cura1123", "324"));
        arbol.insertar(new Usuario("zeroCool", "324"));
        arbol.insertar(new Usuario("123zxsfe2", "324"));
        arbol.insertar(new Usuario("fuck_world12", "324"));
        arbol.insertar(new Usuario("asdf3kj", "324"));
        arbol.insertar(new Usuario("321cba", "324"));
        arbol.insertar(new Usuario("12", "324"));
        arbol.insertar(new Usuario("carmen12", "324"));
        arbol.insertar(new Usuario("piolis", "324"));
        arbol.insertar(new Usuario("wich12", "324"));
        arbol.insertar(new Usuario("123casdvg", "324"));
        arbol.insertar(new Usuario("zandarr123", "324"));
        arbol.insertar(new Usuario("porvz112", "324"));
        arbol.insertar(new Usuario("zarzar123", "324"));
        arbol.insertar(new Usuario("ca23fhjj", "324"));
        arbol.insertar(new Usuario("c@rol", "324"));
        arbol.insertar(new Usuario("11234fc", "324"));
        arbol.insertar(new Usuario("0123ijva", "324"));
        arbol.insertar(new Usuario("poiuna13r", "324"));
        arbol.insertar(new Usuario("great12", "324"));
        arbol.insertar(new Usuario("fas33", "324"));
        arbol.insertar(new Usuario("gray23", "324"));
        arbol.insertar(new Usuario("512GT", "324"));
        arbol.insertar(new Usuario("greatdeath", "324"));
        
        
        arbol.graficar("avlPruebas");

    }
}
