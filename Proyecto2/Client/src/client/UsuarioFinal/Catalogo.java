/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.UsuarioFinal;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

/**
 *
 * @author da9ni5el
 */
public class Catalogo extends RecursiveTreeObject<Catalogo> {

    public Catalogo() {
    }
    
    public boolean generarFacturaController(String nickname, String codigo) {
        return generarFactura(nickname, codigo);
    }
    
    public String listaFacturasController(String username) {
        return listaFacturas(username);
    }
    
    public String generarReporteCarritoController(String username) {
        return generarReporteCarrito(username);
    }
    
    public String generarReporteDeseos(String nickname) {
        return generarReporteCompras(nickname);        
    }

    private static boolean generarFactura(java.lang.String nickname, java.lang.String codigo) {
        com.server.servicio.Servicio_Service service = new com.server.servicio.Servicio_Service();
        com.server.servicio.Servicio port = service.getServicioPort();
        return port.generarFactura(nickname, codigo);
    }

    private static String listaFacturas(java.lang.String nickname) {
        com.server.servicio.Servicio_Service service = new com.server.servicio.Servicio_Service();
        com.server.servicio.Servicio port = service.getServicioPort();
        return port.listaFacturas(nickname);
    }

    private static String generarReporteCarrito(java.lang.String username) {
        com.server.servicio.Servicio_Service service = new com.server.servicio.Servicio_Service();
        com.server.servicio.Servicio port = service.getServicioPort();
        return port.generarReporteCarrito(username);
    }

    private static String generarReporteCompras(java.lang.String username) {
        com.server.servicio.Servicio_Service service = new com.server.servicio.Servicio_Service();
        com.server.servicio.Servicio port = service.getServicioPort();
        return port.generarReporteCompras(username);
    }
        
    
}
