
package com.server.servicio;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para generarReporteBusquedaCantidad complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="generarReporteBusquedaCantidad">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fecha" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "generarReporteBusquedaCantidad", propOrder = {
    "fecha"
})
public class GenerarReporteBusquedaCantidad {

    protected double fecha;

    /**
     * Obtiene el valor de la propiedad fecha.
     * 
     */
    public double getFecha() {
        return fecha;
    }

    /**
     * Define el valor de la propiedad fecha.
     * 
     */
    public void setFecha(double value) {
        this.fecha = value;
    }

}
