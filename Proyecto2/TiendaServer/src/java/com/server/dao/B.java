package com.server.dao;

import com.server.Idao.Comparador;
import com.server.Idao.AdminObject;
import com.server.modelo.Venta;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class B<T> {

    private static final String RUTADOT = "/home/da9ni5el/ReportesProyecto/DotFiles/";
    private static final String RUTAIMG = "/home/da9ni5el/ReportesProyecto/Imagenes/";
    protected int orden;
    protected Pagina raiz;
    
    private ListaSimple reportes;
    public B() {
        orden = 5;
        raiz = null;
        reportes = null;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public Pagina getRaiz() {
        return raiz;
    }

    public void setRaiz(Pagina raiz) {
        this.raiz = raiz;
    }

    private boolean buscarNodo(Pagina actual, T valor, Logical l) {
        int index;
        boolean encontrado;
        Comparador dato = (Comparador) valor;
        if (dato.esMenor(actual.getClave(1))) {
            encontrado = false;
            index = 0;
        } else {
            index = actual.getCuenta();
            while (dato.esMenor(actual.getClave(index)) && index > 1) {
                index--;
            }
            encontrado = dato.esIgual(actual.getClave(index));
        }
        l.setLogicalIndex(index);
        return encontrado;
    }

    public T buscarElemento(T buscado) {
        Logical l = new Logical();
        Pagina resultado = buscar(buscado, l);
        if (resultado != null) {
            for (int i = 1; i <= resultado.getCuenta(); i++) {
                Comparador dato = (Comparador) resultado.getClave(i);
                if (dato.esIgual(buscado)) {
                    return (T) resultado.getClave(i);
                }
            }
        }
        return null;
    }

    protected Pagina buscar(T valor, Logical l) {
        return buscar(raiz, valor, l);
    }

    private Pagina buscar(Pagina actual, T valor, Logical l) {
        if (actual == null) {
            return null;
        } else {
            boolean esta = buscarNodo(actual, valor, l);
            if (esta) {
                return actual;
            } else {
                return buscar(actual.getRama(l.getLogicalIndex()), valor, l);
            }
        }
    }

    public void insertar(T valor) {
        raiz = insertar(raiz, valor);
    }

    Pagina insertar(Pagina raiz, T valor) {
        boolean sube;
        Logical mediana = new Logical();
        Logical nd = new Logical();
        sube = empujar(raiz, valor, mediana, nd);
        if (sube) {
            Pagina p;
            p = new Pagina();
            p.setCuenta(1);
            p.setClave(1, mediana.getLogicalMediana());
            p.setRama(0, raiz);
            p.setRama(1, nd.getLogicalNd());
            raiz = p;
        }
        return raiz;
    }

    private boolean empujar(Pagina actual, T cl, Logical mediana, Logical nuevo) {
        Logical k = new Logical(0);
        boolean sube = false;
        if (actual == null) {
            sube = true;
            mediana.setLogicalMediana(cl);
            nuevo.setLogialNd(null);
        } else {
            boolean esta;
            esta = buscarNodo(actual, cl, k);
            if (esta) { //No se aceptan claves duplicadas
                System.out.println("Clave duplicada");
                Venta v = (Venta) cl;
                new LogFile().escribirArchivo("ERROR", "ArbolB", v.getNumeroFactura() + " Repetido");
                return false;
            }
            sube = empujar(actual.getRama(k.getLogicalIndex()), cl, mediana, nuevo);
            if (sube) {

                if (actual.nodoLleno()) { //se debe dividir la pagina
                    dividirNodo(actual, mediana, nuevo, k);
                } else {
                    sube = false;
                    meterPagina(actual, mediana, nuevo, k);
                }

            }
        }
        return sube;
    }

    private void meterPagina(Pagina actual, Logical cl, Logical ramaDr, Logical k) {
        //Hace un corrimiento a la derecha para hacer un espacio
        for (int i = actual.getCuenta(); i >= k.getLogicalIndex(); i--) {
            actual.setClave(i + 1, actual.getClave(i));
            actual.setRama(i + 1, actual.getRama(i));
        }
        //pone la clave y la rama derecha en la posicion k+1
        actual.setClave(k.getLogicalIndex() + 1, cl.getLogicalMediana());

        actual.setRama(k.getLogicalIndex() + 1, ramaDr.getLogicalNd());
        //incrementa el contador de claves 
        actual.setCuenta((actual.getCuenta() + 1));
    }

    private void dividirNodo(Pagina actual, Logical mediana, Logical nuevo, Logical pos) {
        int i, posMdna, k;
        Pagina nuevaPag;
        k = pos.getLogicalIndex();
        posMdna = (k <= orden / 2) ? orden / 2 : orden / 2 + 1;
        nuevaPag = new Pagina();
        for (i = posMdna + 1; i < orden; i++) {
            //se desplaza la mitad derecha a la nueva pagina, la clave mediana se queda en pagina actual
            nuevaPag.setClave(i - posMdna, actual.getClave(i));
            nuevaPag.setRama(i - posMdna, actual.getRama(i));

            //		codigo de prueba 
            /*Es necesario eliminar los elementos que se trasladan a la nueva pagina*/
            actual.setClave(i, null);
            actual.setRama(i, null);

        }

        nuevaPag.setCuenta((orden - 1) - posMdna);//claves de nueva pagina
        actual.setCuenta(posMdna); // claves en pagina origen
        //inserta la clave y rama en la painga que le corresponde
        if (k <= orden / 2) {
            meterPagina(actual, mediana, nuevo, pos); //Pagina origen 
        } else {
            pos.setLogicalIndex((k - posMdna));
            meterPagina(nuevaPag, mediana, nuevo, pos); //pagina nueva	
        }
        //extrae clave mediana de la pagina origen 
        mediana.setLogicalMediana(actual.getClave(actual.getCuenta()));

        actual.setClave(actual.getCuenta(), null);

        //rama0 del nuevo nodo es la rama de la mediana
        nuevaPag.setRama(0, actual.getRama(actual.getCuenta()));
        actual.setRama(actual.getCuenta(), null);
        /*Se elimina la clave mediana de la pagina actual*/
        actual.setCuenta((actual.getCuenta() - 1));
        /*Se elimina la rama referencia de mediana de la pagina*/
        nuevo.setLogialNd(nuevaPag);
    }

    public void recorridoInorden() {
        System.out.println("RECORRIDO INORDEN");
        recorridoInorden(raiz);
    }

    private void recorridoInorden(Pagina raiz) {
        AdminObject dato;
        if (raiz != null) {
            recorridoInorden(raiz.getRama(0));
            for (int k = 1; k <= raiz.getCuenta(); k++) {
                System.out.printf("Rama numero %d ", k);
                dato = (AdminObject) raiz.getClave(k);
                System.out.println(dato.escribirObjetoConsole());
                recorridoInorden(raiz.getRama(k));
            }
        }
    }

    public boolean graficar(String nombre) {
        try {
            try (BufferedWriter dotcode = new BufferedWriter(new FileWriter(new File(RUTADOT + nombre + ".dot")))) {
                dotcode.write(generarDotB());
                dotcode.close();
            }

            Runtime rt = Runtime.getRuntime();
            rt.exec("dot -Tpng " + RUTADOT + nombre + ".dot -o " + RUTAIMG + nombre + ".png");
//            rt.exec("ristretto " + RUTAIMG + nombre + ".png");
            /*Esta linea podria eliminarse*/
            return true;
        } catch (IOException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    /*Usado para el reporte general*/
    public String toDot() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(escribirPagina(raiz));
        buffer.append(enlazarPaginas(raiz));
        buffer.append(ePaginas(raiz));
        return buffer.toString();
    }

    private String generarDotB() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("digraph arbolB{\n");
        buffer.append("node[shape=record];\n");
        buffer.append(escribirPagina(raiz));
        buffer.append(enlazarPaginas(raiz));
        buffer.append(ePaginas(raiz));
//        buffer.append(enlazarPaginas(raiz));
        buffer.append("}");
        return buffer.toString();
    }

    private String escribirPagina(Pagina raiz) {
        StringBuffer buffer = new StringBuffer();
        StringBuffer clusters = new StringBuffer();      
        AdminObject dato;
        boolean flag = false;
        if (raiz == null) {
            return "";
        }
        buffer.append("pagina").append(raiz.hashCode()).append("[label=\"");
        for (int i = 1; i <= raiz.getCuenta(); i++) {
            if (raiz.getClave(i) == null) {
                continue; //Evita nullpointer Exception
            }
            dato = (AdminObject) raiz.getClave(i);
            if (flag) {
                buffer.append(" | ");
            }
            buffer.append("<p").append(dato.hashCode()).append(">");
            buffer.append(dato.escribirObjeto());
            flag = true;

            Venta temporal = (Venta) raiz.getClave(i);
            if (temporal != null) {
                if (temporal.getDetalle() != null) {
                    String dotDetalle = temporal.getDetalle().toDot();
                    if (!dotDetalle.isEmpty()) {
                        clusters.append("subgraph cluster").append("p").append(dato.hashCode()).append("{\n");
                        clusters.append(dotDetalle);
                        clusters.append("label=\"Detalle\"\n");
                        clusters.append("}\n");
                        /*En este punto estoy fuera del cluster*/
                        clusters.append("pagina").append(raiz.hashCode());
                        clusters.append(":p").append(dato.hashCode());
                        clusters.append("->nodo").append(temporal.getDetalle().getPrimero().hashCode());
                        clusters.append("[label=\"Factura_").append(temporal.getNumeroFactura()).append("\"];\n");
                    }
                }

            }            

        }
        buffer.append("\"];\n");

        /*Agregar aqui el cluster a la cadena principal*/
        int i = 0;
        while (i <= raiz.getCuenta()) {
            if (raiz.getRama(i) != null) {
                buffer.append(escribirPagina(raiz.getRama(i)));
            }
            i++;
        }
        buffer.append(clusters);
        return buffer.toString();
    }

    private String ePaginas(Pagina raiz) {
        StringBuffer buffer = new StringBuffer();

        if (raiz == null) {
            return "";
        }
        int cont = 0;

        while (cont < orden) {
            buffer.append(enlazarPaginas(raiz.getRama(cont)));
            buffer.append(ePaginas(raiz.getRama(cont)));
            cont++;
        }

        return buffer.toString();
    }

    private String enlazarPaginas(Pagina raiz) {
        if (raiz == null) {
            return "";
        }
        StringBuffer buffer = new StringBuffer();
        int contador = 0;
        while (contador < orden) {
            if (raiz.getRama(contador) != null) {
                buffer.append("pagina").append(raiz.hashCode());
                buffer.append(" -> ");
                buffer.append("pagina").append(raiz.getRama(contador).hashCode());
                buffer.append("[label=\"rama").append(contador).append("\"];").append("\n");
            }
            contador++;
        }
        return buffer.toString();
    }
    
    //Recorrer el arbol B sacando todas sus listas de detalles. E invocar al metodo dentro de la lista. 
    
    
    public String conectarAvl() {
        return conectarAvl(raiz);
    }
    
    public String conectarAvl(Pagina raiz) {
        StringBuffer buffer = new StringBuffer();                    
        if (raiz == null) {
            return "";
        }
        //pagina:pasdkfaasdf->nodoasdfasdfasdf;
        
        String paginaActual = "pagina" + raiz.hashCode();        
        for (int i = 1; i <= raiz.getCuenta(); i++) {
            
            if (raiz.getClave(i) == null) {
                continue; //Evita nullpointer Exception
            }            
            
            buffer.append(paginaActual).append(":");                        
            buffer.append("p").append(raiz.getClave(i).hashCode());
            
            Venta v = (Venta)raiz.getClave(i);
            
            buffer.append("->nodo").append(v.getUsuario().hashCode()).append("\n");
        }       
        
        int i = 0;
        while (i <= raiz.getCuenta()) {
            if (raiz.getRama(i) != null) {
                buffer.append(conectarAvl(raiz.getRama(i)));
            }
            i++;
        }
        return buffer.toString();
    }
    
    public String conectarHash() {
        return conectarHash(raiz);
    }

    protected String conectarHash(Pagina raiz) {
        StringBuffer buffer = new StringBuffer();                    
        if (raiz == null) {
            return "";
        }        
        
        String paginaActual = "pagina" + raiz.hashCode();        
        for (int i = 1; i <= raiz.getCuenta(); i++) {
            
            if (raiz.getClave(i) == null) {
                continue; //Evita nullpointer Exception
            }                                               
            Venta v = (Venta)raiz.getClave(i);
            if(v.getDetalle() != null) {
                buffer.append(v.getDetalle().conectarProductoBHash());
            }            
        }       
        
        int i = 0;
        while (i <= raiz.getCuenta()) {
            if (raiz.getRama(i) != null) {
                buffer.append(conectarHash(raiz.getRama(i)));
            }
            i++;
        }
        return buffer.toString();
    }
            
            /*      TOP REPORTS     */
    
    /*Metodo raiz*/
    public ListaSimple reporteTop(LocalDate fechaI, LocalDate fechaF) {
        reportes = new ListaSimple();

        bucarPorRangoFecha(raiz, fechaI, fechaF);
        ayudateReporteTop(fechaI, fechaF, raiz);
        
        return reportes;
    }
    
    private void ayudateReporteTop(LocalDate fechaI, LocalDate fechaF, Pagina raiz) {
        if (raiz == null) {
            return;
        }
        int cont = 0;

        while (cont < orden) {            
            bucarPorRangoFecha(raiz.getRama(cont), fechaI, fechaF);
            ayudateReporteTop(fechaI, fechaF, raiz.getRama(cont));
            cont++;
        }
    }
    
    private void bucarPorRangoFecha(Pagina rama, LocalDate fechaI, LocalDate fechaF) {
        if(rama == null) {            
            return;
        }                    
        for(int i = 1; i <= rama.getCuenta(); i++) {
            if(rama.getClave(i) != null) {
                Venta v = (Venta)rama.getClave(i);
                if(compararFechas(v.getFecha(), fechaI, fechaF)) {
                    boolean esta = reportes.usuarioEsta(v.getUsuario().getNickname());
                    if(!esta) {
                        reportes.insertar(v);//Acepta valores repetidos
                    }                    
                }
            }
        }
    }
    
    
    
    //==========================================================================
                    /*Reporte Busquedas Por Parametro*/
    /*Reporte Busqueda por Fecha*/
    public ListaSimple reporteBusquedaPorFecha(LocalDate fecha) {
        reportes = new ListaSimple();
        bucarPorFecha(raiz, fecha);
        ayudanteReporteBusquedaPorFecha(raiz, fecha);
        return reportes;
    }
        
    private void ayudanteReporteBusquedaPorFecha(Pagina raiz, LocalDate fecha) {
        if (raiz == null) {
            return;
        }
        int cont = 0;

        while (cont < orden) {            
            bucarPorFecha(raiz.getRama(cont), fecha);
            ayudanteReporteBusquedaPorFecha(raiz.getRama(cont), fecha);
            cont++;
        }
    }
        
    private void bucarPorFecha(Pagina rama, LocalDate fecha) {
        if(rama == null) {            
            return;
        }                    
        for(int i = 1; i <= rama.getCuenta(); i++) {
            if(rama.getClave(i) != null) {
                Venta v = (Venta)rama.getClave(i);
                if(compararFecha(v.getFecha(), fecha)) {
                    reportes.insertar(v);
                }
            }
        }
    }
    
    /*Reporte Busqueda por Usuario*/
    public ListaSimple reporteBusquedaPorNickname(String nickname) {
        reportes = new ListaSimple();
        buscarPorNickname(raiz, nickname);
        ayudanteBusquedaPorNickname(raiz, nickname);
        return reportes;
    }
    
    private void ayudanteBusquedaPorNickname(Pagina raiz, String nickname) {
        if(raiz == null)
            return;
        
        int contador = 0;
        while(contador < orden) {
            buscarPorNickname(raiz.getRama(contador), nickname);
            ayudanteBusquedaPorNickname(raiz.getRama(contador), nickname);  
            contador++;
        }
    }
    
    private void buscarPorNickname(Pagina raiz, String nickname) {
        if(raiz == null) {
            return;
        }        
        for(int i = 1; i <= raiz.getCuenta(); i++) {
            if(raiz.getClave(i) != null) {
                Venta v = (Venta)raiz.getClave(i);
                if(v.getUsuario().getNickname().equals(nickname))
                    reportes.insertar(v); //todas las facturas del usuario en cuestion
            }           
        }
    }
    
    /*Hace una busqueda por medio del total de la factura*/
    public ListaSimple reporteBusquedaPorValor(double valor) {
        reportes = new ListaSimple();
        buscarPorValor(raiz, valor);
        ayudanteBusquedaPorValor(raiz, valor);
        return reportes;
    }
    
    private void ayudanteBusquedaPorValor(Pagina raiz, Double valor) {
         if(raiz == null)
            return;
        
        int contador = 0;
        while(contador < orden) {
            buscarPorValor(raiz.getRama(contador), valor);
            ayudanteBusquedaPorValor(raiz.getRama(contador), valor);  
            contador++;
        }
     }
     
    private void buscarPorValor(Pagina raiz, Double valor) {
         if(raiz == null)
            return;        
        for(int i = 1; i <= raiz.getCuenta(); i++) {
            if(raiz.getClave(i) != null) {
                Venta v = (Venta)raiz.getClave(i);
                if(v.getTotal() == valor)
                    reportes.insertar(v); //todas las facturas del usuario en cuestion
            }           
        }                  
     }
    
    public ListaSimple facturasPorNick(String nick) {
         reportes = new ListaSimple();
         buscarFacturasPorNick(raiz, nick);
         ayudanteFacturasPorNick(raiz, nick);
         return reportes;         
     }
     
    private void ayudanteFacturasPorNick(Pagina raiz, String nick) {
        if(raiz == null)
            return;
        
        int contador = 0;
        while(contador < orden) {
            buscarFacturasPorNick(raiz.getRama(contador), nick);
            ayudanteFacturasPorNick(raiz.getRama(contador), nick);  
            contador++;
        }
    }
    
    private void buscarFacturasPorNick(Pagina raiz, String nick) {         
        if(raiz == null)
            return;        
        for(int i = 1; i <= raiz.getCuenta(); i++) {
            if(raiz.getClave(i) != null) {
                Venta v = (Venta)raiz.getClave(i);
                if(v.getUsuario().getNickname().equals(nick))
                    reportes.insertar(v); //todas las facturas del usuario en cuestion
            }           
        }
    }
          
    private boolean compararFechas(LocalDate fechaVenta, LocalDate fechaI, LocalDate fechaF) {
        return fechaVenta.isBefore(fechaF) && fechaVenta.isAfter(fechaI) || fechaVenta.equals(fechaI) || fechaVenta.equals(fechaF);
    }
    
    private boolean compararFecha(LocalDate inner, LocalDate fecha) {
        return inner.equals(fecha);
    }
    
}



//==============================================================================





//Clase de apoyo para guardar referencias del arbol B de manera temporal.
class Logical<T> {

    boolean v;
    int index;
    Pagina nd;
    T mediana;    

    public Logical() {
        // TODO Auto-generated constructor stub		
    }

    public Logical(boolean v) {
        this.v = v;
    }

    public Logical(int i) {
        this.index = i;
    }

    public Logical(Pagina nd) {
        this.nd = nd;
    }

    public Logical(T mediana) {
        this.mediana = mediana;
    }

    public void setLogicalMediana(T m) {
        this.mediana = m;
    }

    public T getLogicalMediana() {
        return this.mediana;
    }

    public void setLogialNd(Pagina nd) {
        this.nd = nd;
    }

    public Pagina getLogicalNd() {
        return this.nd;
    }

    public void setLogicalBoolean(boolean v) {
        this.v = v;
    }

    public boolean getLogicalBoolean() {
        return v;
    }

    public void setLogicalIndex(int i) {
        this.index = i;
    }

    public int getLogicalIndex() {
        return this.index;
    }

}
