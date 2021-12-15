/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server.dao;

/**
 *
 * @author da9ni5el
 *
 *
 * En esta clase se prentende escribir la implementacion de la mayoria de las
 * estructuras
 */
//Imports de los modelos necesarios
import com.server.modelo.Detalle;
import com.server.modelo.Direccion;
import com.server.modelo.Producto;
import com.server.modelo.Usuario;
import com.server.modelo.Venta;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ImplementacionDao {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "toor";
    private static final String RUTAIMG = "/home/da9ni5el/ReportesProyecto/Imagenes/";
    private static final String RUTADOT = "/home/da9ni5el/ReportesProyecto/DotFiles/";

    private static final arbolAvl<Usuario> AVLUSUARIOS = new arbolAvl<>();
    private static final TablaHash PRODUCTOS = new TablaHash();
    private static final B ARBOLB = new B();

    private final LogFile log = new LogFile();

    public ImplementacionDao() {
    }

    /**
     * Insercion de un usuario Uso = Servlet, Cliente
     *
     * @param username
     * @param password
     * @param direccion
     * @return
     */
    /*Arreglar eficiencia del avl*/
    public boolean insertarUsuarioAvl(String username, String password, String direccion) {
        boolean salida;
        try {
            AVLUSUARIOS.insertar(new Usuario(username, password));
            new LogFile().escribirArchivo("INFO", "Arbol_Avl", "Insertando usuario: " + username);
            /*Se inserta el usuario*/
            NodoAvl temporal = AVLUSUARIOS.buscarNodo(new Usuario(username));
             
            /*Se busca el nodo recien insertado*/
            if (direccion != null) {
                if (temporal.getDirecciones() == null) {
                    temporal.setDirecciones(new ListaSimple<>());
                    /*Se reserva memoria para la lista en caso de que no exista*/
                }
                temporal.getDirecciones().insertar(new Direccion(direccion, 1, 1));/*Se inserta la direccion en la lista*/
 /*Se escribe el archivo de log*/
                new LogFile().escribirArchivo("INFO", "Arbol_Avl_Direccion", "Insertando Direccion para usuario: " + username);
            }
            salida = true;
        } catch (Exception ex) {
            Logger.getLogger(ImplementacionDao.class.getName()).log(Level.SEVERE, null, ex);
            salida = false;
        }
        return salida;
    }

    /*Login de Usuario*/
    public int login(String username, String password) {
        /*Se comprueba si es administrador primero*/
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            return 1;
        } else {
            Usuario dato = AVLUSUARIOS.buscarElemento(new Usuario(username));
            /*Se busca el usuario dentro del avl*/
            if (dato != null) {
                return (dato.getNickname().equals(username) && dato.getPassword().equals(password)) ? 0 : -1;/*Se evalua si las credenciales coinciden*/
            }
            return -1;
        }
    }

    /*Busqueda de usuario por nickname*/
    public Usuario buscarUsuario(String nickname) {
        Usuario temporal = AVLUSUARIOS.buscarElemento(new Usuario(nickname));
        return temporal;
        /*No determino si el objeto devuelto es nulo*/
    }

    /*Se modifica la informacion del usuario, excepto la direccion de envio*/
 /*Implementar modificacion de direccion*/
    public boolean modificarUsuario(String username, String password) {
        boolean salida = AVLUSUARIOS.modificarElemento(new Usuario(username, password));
        return salida = false;
    }
    
    public boolean eliminarUsuario(String username) {        
        boolean salida = false;
        try {
            Usuario temporal = new Usuario(username);
            AVLUSUARIOS.eliminar(temporal);
            if(AVLUSUARIOS.buscarElemento(temporal) == null) { //Se busca de nuevo el elemento para asegurar que se elimino correctamente del avl
                salida = true;
            }        
        } catch (Exception ex) {
            Logger.getLogger(ImplementacionDao.class.getName()).log(Level.SEVERE, null, ex);
            salida = false;
        }
        return salida;
    }
    
                /*      PRODUCTOS ABC       */
    public boolean insertarProducto(String codigoProducto, String nombre, String marca, String precio, String pathImagen) {
        boolean salida = false;
        Producto p = new Producto(codigoProducto, nombre, marca, Float.parseFloat(precio) , pathImagen);
        salida = PRODUCTOS.insertar(p);
        return salida;
    }
    
    public Producto buscarProducto(String codigo) {
        Producto buscado = (Producto)PRODUCTOS.buscar(codigo);
        return buscado; //linea de mas
    }
    
    public boolean modificarProducto(String codigoProducto, String nombre, String marca, String precio, String pathImagen) {
        boolean salida = false;
        Producto p = new Producto(codigoProducto, nombre, marca, Float.parseFloat(precio) , pathImagen);
        salida = PRODUCTOS.modificar(p);
        return salida;
    }
    
    public boolean eliminarProducto(String codigo) {
        boolean salida = false;
        salida = PRODUCTOS.eliminar(new Producto(codigo));       
        return salida;
    }

    /*Se insertan las direccinoes a un usuario especifico*/
    public boolean ingresarDireccion(String username, String direccion, int envio, int factura) {
        NodoAvl temporal = AVLUSUARIOS.buscarNodo(new Usuario(username));
        /*Se busca el usuario en cuestion*/
        if (temporal != null) {
            if (temporal.getDirecciones() == null) {
                temporal.setDirecciones(new ListaSimple());
                /*Si no existe la lista se reserva memoria para ella*/
            }
            /*Se crea la nueva direccion y se inserta en la lista*/
            temporal.getDirecciones().insertar(new Direccion(direccion, envio, factura));
            /*Se escribe en el log que se ingreso una nueva direccion*/
            String mensaje = "Se ha agregado la direccion: " + direccion + "Al usuario: " + username;
            new LogFile().escribirArchivo("INFO", "Lista Direcciones", mensaje);
            return true;
        }
        return false;
    }

    /*Inserta un producto en la lista de deseos de compra del usuario especificado*/
    public boolean insertarCompra(String username, int cantidad, String idProducto) {
        /*Lista de productos por comprar*/
        /**
         * Comprobar que el usuario exista Comprobar que el producto exista
         */

        Producto buscado = (Producto) PRODUCTOS.buscar(new Producto(idProducto));
        /*Si el producto no existe, no hay razon de seguir el proceso*/
        if (buscado != null) {
            NodoAvl temporal = AVLUSUARIOS.buscarNodo(new Usuario(username));/*Se recupera el nodo del avl donde se aloja el usario*/
            if (temporal != null) {/*se verifica que exista*/
 /*Se verifica que la cola sobre la que se quiere trabajar, exista en memoria RAM*/
                if (temporal.getLista_pedidos() == null) {
                    temporal.setLista_pedidos(new Cola());/*Se reserva memoria para la cola*/
                }
                temporal.getLista_pedidos().insertar(buscado, cantidad);/*Se inserta el producto que se recupera de la Tabla Hash y la cantidad deseada*/
                String mensaje = "Se ha ingresado el Producto" + idProducto + " a la lista de deseos del usuario: " + username;
                new LogFile().escribirArchivo("INFO", "Cola Productos", mensaje);
                return true;
            }
        }
        return false;
    }

    /*Inserta un producto en la lista de carro de compra del usuario especificado*/
    public boolean insertarCarro(String username, int cantidad, String idProducto) {
        /*Lista de productos por comprar*/
        /**
         * Comprobar que el usuario exista Comprobar que el producto exista
         */

        Producto buscado = (Producto) PRODUCTOS.buscar(new Producto(idProducto));
        /*Si el producto no existe, no hay razon de seguir el proceso*/
        if (buscado != null) {
            NodoAvl temporal = AVLUSUARIOS.buscarNodo(new Usuario(username));/*Se recupera el nodo del avl donde se aloja el usario*/
            if (temporal != null) {/*se verifica que exista*/
 /*Se verifica que la cola sobre la que se quiere trabajar, exista en memoria RAM*/
                if (temporal.getCarrito_compra() == null) {
                    temporal.setCarrito_compra(new Cola());
                    /*Se reserva memoria para la cola*/
                }
                temporal.getCarrito_compra().insertar(buscado, cantidad);/*Se inserta el producto que se recupera de la Tabla Hash y la cantidad deseada*/
                String mensaje = "Se ha ingresado el Producto" + idProducto + " al carrito de compra del usuario: " + username;
                new LogFile().escribirArchivo("INFO", "Cola Carrito", mensaje);
                return true;
            }
        }
        return false;
    }
    
    /*Elimina un elemento del carrito de compra, buscandolo dentro de la lista*/
    public boolean eliminarProductoCarrito(String username, String idproducto) {
        boolean salida = false;
        NodoAvl temporal = AVLUSUARIOS.buscarNodo(new Usuario(username));
        if(temporal != null) {
            if(temporal.getCarrito_compra() != null) {
                Object a = temporal.getCarrito_compra().elminar(new Producto(idproducto));
                if(a != null) { //se elimino correctamente
                    salida = true;
                }
            }
        }
        return salida;
    }
    
    /*Elimina un elemento de lista deseos, buscandolo dentro de la lista*/
    public boolean eliminarProductoListaDeseos(String username, String idproducto) {
        boolean salida = false;
        NodoAvl temporal = AVLUSUARIOS.buscarNodo(new Usuario(username));
        if(temporal != null) {
            if(temporal.getLista_pedidos()!= null) {
                Object a = temporal.getLista_pedidos().elminar(new Producto(idproducto));
                if(a != null) { //se elimino correctamente
                    salida = true;
                }
            }
        }
        return salida;
    }

    public String cargarArchivoUsuario(String data) {
        int contador = 0;
        int contadorErr = 0;
        if (data == null) /*Si la data es vacia se sale*/ {
            return null;
            /*Debe retornar la salida como nulo*/
        }
        /*Se intenta quitar algunos caracteres especiales*/
        data = data.replace(" ", "");/*Si viene algun espacio en blanco lo elimino*/
        String separados[] = data.split("\n");/*Se divide la cadena por saltos de linea*/
        for (String usuario : separados) {/*Se recorre el arreglo generado para crear los usuarios*/
            try {
                /*Formato de cadena en este momento----> username,password  */
                String usuarios[] = usuario.split(",");/*La salida deberia de ser 0->nickname 1->password*/
                if (usuarios[0] != null && usuarios[1] != null) {/*Se comprueba que ambos elementos existan*/
                    insertarUsuarioAvl(usuarios[0], usuarios[1], null);
                    ++contador;
                }
            } catch (Exception e) {
                System.out.println("Error al cargar el archivo: " + e.toString());
                ++contadorErr;
            }
        }
        StringBuffer retorno = new StringBuffer();
        retorno.append("Procesadas: ").append(contador).append("\n");
        retorno.append("Rechazadas: ").append(contadorErr);
        return retorno.toString();
    }

    public String cargarArchivoDireccion(String data) {
        int contador = 0;
        int contadorErr = 0;
        StringBuffer retorno = new StringBuffer();
        if (data == null) /*Si la data es vacia se sale*/ {
            return null;
            /*Debe retornar la salida como nulo*/
        }
        /*Se intenta quitar algunos caracteres especiales*/
        data = data.replace(" ", "");/*Si viene algun espacio en blanco lo elimino*/
        String separados[] = data.split("\n");/*Se divide la cadena por saltos de linea*/
        for (String direccion : separados) {/*Se recorre el arreglo generado para crear los usuarios*/
 /*Formato de cadena en este momento----> username,password  */
            String direcciones[] = direccion.split(",");
            /*La salida deberia de ser   0->nickname 1->direccion 2->envio 3->factura*/
            if (procesarCargaDireccion(direcciones)) {
                ++contador;
            } else {
                ++contadorErr;
            }
        }
        retorno.append("Procesados: ").append(contador).append("\n");
        retorno.append("Rechazados: ").append(contadorErr);
        return retorno.toString();
    }

    public String cargarArchivoCompra(String data) {
        int contador = 0;
        int contadorErr = 0;
        StringBuffer retorno = new StringBuffer();
        if (data == null) {
            return null;
        }

        data = data.replace(" ", "");
        String separados[] = data.split("\n");
        for (String compra : separados) {
            String compras[] = compra.split(",");
            if (procesarCargarCompras(compras)) {
                ++contador;
            } else {
                ++contadorErr;
            }
        }
        retorno.append("Procesados: ").append(contador).append("\n");
        retorno.append("Rechazados: ").append(contadorErr);
        return retorno.toString();
    }

    public String cargarArchivoCarro(String data) {
        int contador = 0;
        int contadorErr = 0;
        StringBuffer retorno = new StringBuffer();
        if (data == null) {
            return null;
        }

        data = data.replace(" ", "");
        String separados[] = data.split("\n");
        for (String carro : separados) {
            String carros[] = carro.split(",");
            if (procesarCargaCarrito(carros)) {
                ++contador;
            } else {
                ++contadorErr;
            }
        }
        retorno.append("Procesados: ").append(contador).append("\n");
        retorno.append("Rechazados: ").append(contadorErr);
        return retorno.toString();
    }

    /*Carga la informacion a la tabla Hash*/
    public String cargarArchivoProducto(String data) {
        if (data == null) {
            return null;
        }
        int contador = 0;
        int contadorErr = 0;
        StringBuffer buffer = new StringBuffer();
        data = data.replace("\t", "");
        String separados[] = data.split("\n");
        for (String productos : separados) {
            String producto[] = productos.split(",");
            try {
                /*Se craen extraen los atributos del producto*/
                String codigo = producto[0];
                String nombre = producto[1];
                String marca = producto[2];
                float precio = Float.parseFloat(producto[3]);
                String imagen = producto[4];
                /*Se crea un nuevo producto y se inserta en la Tabla Hash*/
                PRODUCTOS.insertar(new Producto(codigo, nombre, marca, precio, imagen));
                ++contador;
            } catch (NumberFormatException e) {
                System.out.println("Error al cargar el archivo de Producto: " + e.toString());
                ++contadorErr;
            }
        }

        buffer.append("Procesados: ").append(contador).append("\n");
        buffer.append("Rechazados: ").append(contadorErr);
        return buffer.toString();
    }

    /*Carga la informacion al arbol B*/
    public String cargarArchivoVentas(String data) {
        if (data == null) {
            return null;
        }
        int contador = 0;
        int contadorErr = 0;
        StringBuffer buffer = new StringBuffer();
        data = data.replace(" ", "");
        String separados[] = data.split("\n");
        for (String ventas : separados) {
            String venta[] = ventas.split(",");
            try {
                /*Se craen extraen los atributos del producto*/
//                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String factura = venta[0];
                String fecha = venta[1].replace(" ", "");
                fecha = fecha.replace(",", "/");
                double total = Double.parseDouble(venta[2]);
                String usuario = venta[3];
                
                
                DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder()
                .parseCaseInsensitive().parseLenient()
//                .parseDefaulting(ChronoField.YEAR_OF_ERA, 2019L)                
                .appendPattern("[dd/MM/yyyy]")
                .appendPattern("[d/MM/yyyy]")
                .appendPattern("[d/M/yyyy]");        
                 
                DateTimeFormatter formatter2 = builder.toFormatter();    
                LocalDate fechaL = LocalDate.parse(fecha, formatter2);
                
                Usuario u = AVLUSUARIOS.buscarElemento(new Usuario(usuario));
                if(u != null) {                    
                    ARBOLB.insertar(new Venta(factura, fechaL , total, u));
                    ++contador;
                }
                /*LocalDate.parse(fecha, formatter)*/
                
            } catch (NumberFormatException e) {
                System.out.println("Error al cargar el archivo de Ventas: " + e.toString());
                ++contadorErr;
            }
        }

        buffer.append("Procesados: ").append(contador).append("\n");
        buffer.append("Rechazados: ").append(contadorErr);
        return buffer.toString();
    }

    /*Carga el archivo detalle de factura al arbol B*/
    public String cargarArchivoDetalle(String data) {
        if (data == null) {
            return null;
        }
        int contador = 0;
        int contadorErr = 0;
        StringBuffer buffer = new StringBuffer();
        data = data.replace(" ", "");
        String separados[] = data.split("\n");
        for (String ventas : separados) {
            String venta[] = ventas.split(",");
            try {
                /*Se crean extraen los atributos del producto*/
                Venta v = (Venta) ARBOLB.buscarElemento(new Venta(venta[0]));
                if (v != null) {                    
                    if (v.getDetalle() == null) {
                        v.setDetalle(new ListaSimple());
                    }
                    Producto p = (Producto) PRODUCTOS.buscar(venta[3]);
                    if (p != null) {
                        int cantidad = Integer.parseInt(venta[1]);
                        float precio = Float.parseFloat(venta[2]);
                        v.getDetalle().insertar(new Detalle(cantidad, precio, p), cantidad);
                        ++contador;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Error al cargar el archivo de Ventas: " + e.toString());
                ++contadorErr;
            }
        }

        buffer.append("Procesados: ").append(contador).append("\n");
        buffer.append("Rechazados: ").append(contadorErr);
        return buffer.toString();
    }

    /*Procesa una linea del archivo de carrito de compras*/
    private boolean procesarCargaCarrito(String c[]) {
        boolean salida;
        try {
            Producto buscado = (Producto) PRODUCTOS.buscar(c[2]);
            if (buscado != null) {
                NodoAvl temporal = AVLUSUARIOS.buscarNodo(new Usuario(c[0]));/*Se busca el nodo del usuario selecionado*/
                if (temporal != null) {

                    if (temporal.getCarrito_compra() == null) {
                        temporal.setCarrito_compra(new Cola());
                    }
                    temporal.getCarrito_compra().insertar(buscado, Integer.parseInt(c[1]));/*Ingreso el producto y la cantidad*/
                    salida = true;
                } else {
                    salida = false;
                }
            } else {
                salida = false;
            }
        } catch (NumberFormatException e) {
            System.out.println("Error en carga de archivo Carrito: " + e.toString());
            salida = false;
        }
        return salida;
    }

    /*Procesa una linea del archivo de Compras*/
    private boolean procesarCargarCompras(String c[]) {
        boolean salida;
        try {
            Producto buscado = (Producto) PRODUCTOS.buscar(c[2]);
            if (buscado != null) {
                NodoAvl temporal = AVLUSUARIOS.buscarNodo(new Usuario(c[0]));/*Se busca el nodo del usuario selecionado*/
                if (temporal != null) {

                    if (temporal.getLista_pedidos() == null) {
                        temporal.setLista_pedidos(new Cola());
                    }
                    temporal.getLista_pedidos().insertar(buscado, Integer.parseInt(c[1]));/*Ingreso el producto y la cantidad*/
                    salida = true;
                } else {
                    salida = false;
                }
            } else {
                salida = false;
            }
        } catch (NumberFormatException e) {
            System.out.println("Error en carga de archivo Compras: " + e.toString());
            salida = false;
        }

        return salida;
    }

    /*Procesa una linea del archivo de entrada de direcciones*/
    private boolean procesarCargaDireccion(String a[]) {
        try {
            NodoAvl temporal = AVLUSUARIOS.buscarNodo(new Usuario(a[0]));/*Se busca el nodo del usuario seleccionado*/
            if (temporal != null) {
                Direccion dir = new Direccion(a[1], Integer.parseInt(a[2]), Integer.parseInt(a[3]));
                if (temporal.getDirecciones() == null) {
                    temporal.setDirecciones(new ListaSimple<>());
                }
                temporal.getDirecciones().insertar(dir);
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println("Error en carga de archivo direcciones: " + e.toString());
            return false;
        }
    }

    /*      Reportes para el Cliente        */
 /*Genera el reporte por usuario del lista de productor por comprar*/
    public String generarReporteCompras(String username) {
        /*Devulve la direccion donde se generan los reportes*/
        NodoAvl buscado = AVLUSUARIOS.buscarNodo(new Usuario(username));
        if (buscado != null) {
            if (buscado.getLista_pedidos() != null) {/*Se verifica que la cola no este vacia, para evitar excepciones*/
                if (buscado.getLista_pedidos().graficar("colaCompras")) {
//                    return RUTAIMG + "colaCompras.png"; /*Se retorna la ruta y el nombre del archivo generado*/                    
                    try {
                        Runtime rt = Runtime.getRuntime();
                        rt.exec("ristretto " + RUTAIMG +"colaCompras.png");
                    } catch (Exception e) {
                        System.out.println(e.toString());
                    }
                } else {
                    return "NOT_IMPLEMENTED";
                }
            }
        }
        return null;
    }

    /*Genera el reporte por usuario del carrito de compra*/
    public String generarReporteCarrito(String username) {
        /*Devulve la direccion donde se generan los reportes*/
        NodoAvl buscado = AVLUSUARIOS.buscarNodo(new Usuario(username));
        if (buscado != null) {
            if (buscado.getCarrito_compra() != null) {
                /*Se verifica que la cola no este vacia, para evitar excepciones*/
                if (buscado.getCarrito_compra().graficar("colaCarrito")) {
//                    return RUTAIMG + "colaCarrito.png"; /*Se retorna la ruta y el nombre del archivo generado*/
                    try {
                        Runtime rt = Runtime.getRuntime();
                        rt.exec("ristretto " + RUTAIMG + "colaCarrito.png");
                    } catch (Exception e) {
                        System.out.println(e.toString());
                    }
                } else {
                    return "NOT_IMPLEMENTED";
                }
            }
        }
        return null;
    }

    /*      Reportes para el Administrador      */
 /*No recibe parametros, ya que grafica el sistema de usuarios*/
    public String generarReporteAvl() {
        if (AVLUSUARIOS.graficar("arbolAvlUsuarios")) {             
            try {
                Runtime rt = Runtime.getRuntime();
                rt.exec("ristretto " + RUTAIMG + "arbolAvlUsuarios.png");
//                return RUTAIMG + "arbolAvlUsuarios";
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        } else {
            return "NOT_IMPLEMENTED";
        }
        return null;
    }

    /*Se genera el reporte de la tabla hash de productos*/
    public String generarReporteProductos() {
        if (PRODUCTOS.graficar("tablaHashProductos")) {
//            return RUTAIMG + "tablaHashProductos";
            try {
                Runtime rt = Runtime.getRuntime();
                rt.exec("ristretto " + RUTAIMG + "tablaHashProductos.png");
//                return RUTAIMG + "arbolAvlUsuarios";
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        } else {
            return "NOT_IMPLEMENTED";
        }
        return null;
    }

    /*Se genera el reporte de Ventas*/
    public String generarReporteVentas() {
        if (ARBOLB.graficar("arbolBVentas")) {
            try {
                Runtime rt = Runtime.getRuntime();
                rt.exec("ristretto " + RUTAIMG + "arbolBVentas.png");
//                return RUTAIMG + "arbolAvlUsuarios";
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        } else {
            return "NOT_IMPLEMENTED";
        }
        return null;
    }

    /*Se genera el reporte general del sistema*/
    public String generarReporteGeneralSistema() {
        if (graficar("ReporteGeneral", toDotSistema(), false)) {
//            return RUTAIMG + "ReporteGeneral";
            try {
                Runtime rt = Runtime.getRuntime();
                rt.exec("ristretto " + RUTAIMG + "ReporteGeneral.png");
//                return RUTAIMG + "arbolAvlUsuarios";
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        } else {
            return "NOT_IMPLEMENTED";
        }
        return null;
    }
                 
    public boolean graficar(String nombre, String args, boolean flag) {
        try {
            try (BufferedWriter dotcode = new BufferedWriter(new FileWriter(new File(RUTADOT + nombre + ".dot")))) {
                dotcode.write(args);
                dotcode.close();
            }

            Runtime rt = Runtime.getRuntime();
            if(flag) {
                rt.exec("dot -Tpdf " + RUTADOT + nombre + ".dot -o " + RUTAIMG + nombre + ".pdf");
            }else {
                rt.exec("dot -Tpng " + RUTADOT + nombre + ".dot -o " + RUTAIMG + nombre + ".png");
            }
            
//            rt.exec("ristretto " + RUTAIMG + nombre + ".png");/*Esta linea podria eliminarse*/
            return true;
        } catch (IOException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public String toDotSistema() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("digraph Sistema{\n");
        buffer.append("node[shape=record];\n");  
        buffer.append("Edge[minlen = 2];\n");
        buffer.append("graph[ranksep = 1.5];\n");
//        buffer.append("graph[rankdir=LR, ordering=out];\n");
        
        /*Sub-Grafo Arbol B */
        buffer.append("subgraph clusterVentas{\n");   
        buffer.append(ARBOLB.toDot());
        buffer.append("label=\"Arbol B\"");
        buffer.append("\n}\n\n");

        /*Sub-Grafo Tabla Hash*/
        buffer.append("subgraph clusterProductos{\n");
        buffer.append("rank=max;\n");
        buffer.append(PRODUCTOS.toDot());
        buffer.append("label=\"Tabla Hash\"");
        buffer.append("\n}\n\n");

        /*Sub-Grafo Avl*/
        buffer.append("subgraph clusterUsuarios{\n");
        buffer.append("rank=max;\n");
        buffer.append("node[shape= oval];\n");
        buffer.append(AVLUSUARIOS.toDot());
        buffer.append("label=\"Arbol AVL\"");
        buffer.append("\n}\n\n");

        buffer.append(AVLUSUARIOS.conectarProductoHash());
        buffer.append("\n\n");
        
        
        buffer.append(ARBOLB.conectarAvl());
        buffer.append("\n\n");
        
        buffer.append(ARBOLB.conectarHash());
        buffer.append("\n");
        /*Resta interconectar las estructruas entre si*/
        buffer.append("\n}");
        return buffer.toString();
    }
            

    /*      Devolver lista de productos     */
    public String listadoProductos() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("{\n");
        buffer.append("\"producto\":\n[");
        boolean flag = false;
        Object v[] = PRODUCTOS.elementos;
        for (Object elemento : v) {
            if (elemento != null) {
                if (flag) {
                    buffer.append(",");
                }
                Producto p = (Producto) elemento;
                buffer.append("{\n");
                buffer.append("\"Id\": \"").append(p.getCodigoProducto()).append("\",\n");
                buffer.append("\"nombre\": \"").append(p.getNombre()).append("\",\n");
                buffer.append("\"marca\": \"").append(p.getMarca()).append("\",\n");
                buffer.append("\"imagen\": \"").append(p.getPathImagen()).append("\",\n");
                buffer.append("\"precio\": ").append(p.getPrecio()).append("\n");
                buffer.append("\n}");
                flag = true;
            }
        }
        buffer.append("\n]");
        buffer.append("\n}");

        return buffer.toString();
    }

    /*      Devolver lista de Direcciones de un usuario especifio       */
    public String devolverDirecciones(String username) {
        NodoAvl temporal = AVLUSUARIOS.buscarNodo(new Usuario(username));
        if (temporal != null) {
            if (temporal.getDirecciones() != null) {
                StringBuffer buffer = new StringBuffer();
                buffer.append("{\n");
                buffer.append("\"direcciones\": [\n");
                NodoSimple pivote = temporal.getDirecciones().getPrimero();
                while(pivote != null) {
                    Direccion d = (Direccion)pivote.getDato();
                    buffer.append("{\n");
                    buffer.append("\"Direccion\": \"").append(d.getDireccion()).append("\",\n");
                    buffer.append("\"Envio\": ").append(d.getEnvio()).append(",\n");
                    buffer.append("\"Factura\": ").append(d.getFacturacion());
                    buffer.append("\n}");
                    pivote = pivote.getSiguiente();
                }               
                buffer.append("\n]");
                buffer.append("\n}");
                return buffer.toString();
            }
        }
        return null;
    }
   
    /*      Devolver la Cola de productos por comprar de un usuario especificado        */
    public String devolverColaProductos(String username) {
        NodoAvl temporal = AVLUSUARIOS.buscarNodo(new Usuario(username));
        if (temporal != null) {
            if (temporal.getLista_pedidos()!= null) {
                StringBuffer buffer = new StringBuffer();
                buffer.append("{\n");
                buffer.append("\"productos\": [\n");
                NodoSimple pivote = temporal.getLista_pedidos().getPrimero();
                while(pivote != null) {                    
                    Producto p = (Producto)pivote.getDato();
                    int cantidad = pivote.getNumerico();
                    buffer.append("{\n");
                    buffer.append("\"codigo\": \"").append(p.getCodigoProducto()).append("\",\n");
                    buffer.append("\"nombre\": \"").append(p.getNombre()).append("\",\n");
                    buffer.append("\"marca\": \"").append(p.getMarca()).append("\",\n");
                    buffer.append("\"precio\": ").append(p.getPrecio()).append(",\n");
                    buffer.append("\"imagen\": \"").append(p.getPathImagen()).append("\",\n");
                    buffer.append("\"cantidad\": ").append(cantidad).append("\n");
                    buffer.append("\n}");
                    pivote = pivote.getSiguiente();
                }               
                buffer.append("\n]");
                buffer.append("\n}");
                return buffer.toString();
            }
        }
        return null;
    }

    /*      Devolver la cola de Carrito de compra de un usuario especificado        */
    public String devolverColaCarrito(String username) {
        NodoAvl temporal = AVLUSUARIOS.buscarNodo(new Usuario(username));
        if (temporal != null) {
            if (temporal.getCarrito_compra()!= null) {
                StringBuffer buffer = new StringBuffer();
                buffer.append("{\n");
                buffer.append("\"carrito\": [\n");
                NodoSimple pivote = temporal.getCarrito_compra().getPrimero();
                while(pivote != null) {                    
                    Producto p = (Producto)pivote.getDato();
                    int cantidad = pivote.getNumerico();
                    buffer.append("{\n");
                    buffer.append("\"codigo\": \"").append(p.getCodigoProducto()).append("\",\n");
                    buffer.append("\"nombre\": \"").append(p.getNombre()).append("\",\n");
                    buffer.append("\"marca\": \"").append(p.getMarca()).append("\",\n");
                    buffer.append("\"precio\": ").append(p.getPrecio()).append(",\n");
                    buffer.append("\"imagen\": \"").append(p.getPathImagen()).append("\",\n");
                    buffer.append("\"cantidad\": ").append(cantidad).append("\n");
                    buffer.append("\n}");
                    pivote = pivote.getSiguiente();
                }               
                buffer.append("\n]");
                buffer.append("\n}");
                return buffer.toString();
            }
        }
        return null;
    }
    
    
            /*      Generando los reportes como Estadisticas        */
    
    /*Genera el reporte de usuarios que hicieron mas compras*/
    public String reporteTopUsuarios(LocalDate fechaI, LocalDate fechaF) {
        ListaSimple<Venta> top;        
        top = ARBOLB.reporteTop(fechaI, fechaF);
        top.ordenar(top);
        StringBuffer buffer = new StringBuffer();
        boolean flag = false;
        buffer.append("{\n");
        buffer.append("\"FechaI\": \"").append(fechaI.toString()).append("\",\n");
        buffer.append("\"FechaF\": \"").append(fechaF.toString()).append("\",\n");
        buffer.append("\"topUsers\" :[\n");
        
        NodoSimple pivote = top.primero;
        while(pivote != null) {           
            Venta v = (Venta)pivote.getDato();
            if(flag)
                buffer.append(",");
            buffer.append("\"").append(v.getUsuario()).append("\"");
            flag = true;
            pivote = pivote.getSiguiente();
        }
        
        buffer.append("\n]\n");
        buffer.append("\n}");
                        
        return buffer.toString();
    }
    
    public String reporteBusquedaPorFecha(String fecha) {
        StringBuffer buffer = new StringBuffer();
        
        fecha = fecha.replace("-", "/");
        fecha = fecha.replace(" ", "");
        
        DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder()
                .parseCaseInsensitive().parseLenient()                
                .appendPattern("[dd/MM/yyyy]")
                .appendPattern("[d/MM/yyyy]")
                .appendPattern("[d/M/yyyy]");

        DateTimeFormatter formatter2 = builder.toFormatter();
        LocalDate fechaL = LocalDate.parse(fecha, formatter2);
        
        ListaSimple report = ARBOLB.reporteBusquedaPorFecha(fechaL);
        if(report.getPrimero() != null) { //si se lleno           
            boolean flag = false;
            buffer.append("{\n");
            
            buffer.append("\n}");
        }
        
        return buffer.toString();
    }
    
    public String reporteBusquedaPorNickname(String nickname) {
        StringBuffer buffer = new StringBuffer();
        ListaSimple reporte = ARBOLB.reporteBusquedaPorNickname(nickname);
        if (reporte.getPrimero() != null) {
            if (reporte.graficar("BusquedaPorNickname")) {
                try {
                    Runtime rt = Runtime.getRuntime();
                    rt.exec("ristretto " + RUTAIMG + "BusquedaPorNickname.png");
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
            }
        }
        return buffer.toString();
    }
    
    public String reporteBusquedaCantidad(double cant) {
        StringBuffer buffer = new StringBuffer();
        ListaSimple reporte = ARBOLB.reporteBusquedaPorValor(cant);
        if(!reporte.esVacio()) {
            if(reporte.graficar("ReporteBusquedaPorCantidad")) {
                 try {
                    Runtime rt = Runtime.getRuntime();
                    rt.exec("ristretto " + RUTAIMG + "ReporteBusquedaPorCantidad.png");
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
            }
        }
        return buffer.toString();
    }
    
    private String  generarFactura(String codigoFactura, String nickname) {        
        StringBuffer buffer = new StringBuffer();
        Venta factura = (Venta)ARBOLB.buscarElemento(new Venta(codigoFactura));
        if(!factura.getUsuario().getNickname().equals(nickname))
            return "";
        if(factura != null) {            
            buffer.append("digraph ReporteFactura{\n");
            buffer.append("node [shape=plaintext];\n");
            buffer.append("struct [label=<");
            buffer.append("<TABLE ALIGN=\"CENTER\" BORDER=\"2\" ");
            buffer.append("CELLBORDER=\"1\" CELLSPACING=\"0\" ");
            buffer.append("FIXEDSIZE=\"TRUE\"> \n");
            //Encabezados
            buffer.append("<TR>\n<TD COLSPAN=\"4\" ALIGN=\"CENTER\">Tienda0nline</TD>\n</TR>");
            buffer.append("<TR>\n");
            buffer.append("<TD>#Factura</TD>\n").append("<TD>NOMBRE</TD>\n");
            buffer.append("<TD>Fecha</TD>\n").append("<TD>Total (Quetzales)</TD>\n");
            buffer.append("</TR>\n");
            //Datos de la venta
            buffer.append("<TR>\n");
            buffer.append("<TD>").append(factura.getNumeroFactura()).append("</TD>\n");
            buffer.append("<TD>").append(factura.getUsuario().getNickname()).append("</TD>\n");
            buffer.append("<TD>").append(factura.getFecha().toString()).append("</TD>\n");
            buffer.append("<TD>").append(factura.getTotal()).append("</TD>\n");
            buffer.append("</TR>\n");
            
            buffer.append("<TR>\n");
            buffer.append("<TD COLSPAN=\"4\" ALIGN=\"CENTER\">").append("Listado de Productos").append("</TD>\n");
            buffer.append("</TR>\n");
            buffer.append("<TR>\n");
            buffer.append("<TD>").append("Id Producto").append("</TD>\n");
            buffer.append("<TD>").append("Nombre").append("</TD>\n");
            buffer.append("<TD>").append("Cantidad").append("</TD>\n");
            buffer.append("<TD>").append("Precio").append("</TD>\n");
            buffer.append("</TR>\n");
            
            ListaSimple temporal = factura.getDetalle();
            if(!temporal.esVacio()) {
                NodoSimple pivote = temporal.getPrimero();
                while(pivote != null) {
                    Detalle d = (Detalle)pivote.getDato();
                    if(d != null) {
                        Producto p = (Producto)d.getProducto();
                        buffer.append("<TR>\n");
                         buffer.append("<TD>").append(p.getCodigoProducto()).append("</TD>\n");
                         buffer.append("<TD>").append(p.getNombre()).append("</TD>\n");
                         buffer.append("<TD>").append(d.getCantidad()).append("</TD>\n");
                         buffer.append("<TD>").append(d.getPrecio()).append("</TD>\n");
                         buffer.append("</TR>\n");
                    }
                    pivote = pivote.siguiente;
                }                                                
            }
            buffer.append("</TABLE>>];\n");
            buffer.append("}");            
        }
        return buffer.toString();
    }

    public boolean factura(String codigo, String nickname) {
        boolean salida = false;
        String dotFile = generarFactura(codigo, nickname);
        if (dotFile != null) {
            if (graficar("FacturaGenerated", generarFactura(codigo, nickname), true)) {
                try {
                    Runtime rt = Runtime.getRuntime();
                    rt.exec("evince " + RUTAIMG + "FacturaGenerated.pdf");
                } catch (Exception e) {
                    salida = false;
                }
                salida = true;
            } else {
                salida = false;
            }           
        }
        return salida;
    }    
}
