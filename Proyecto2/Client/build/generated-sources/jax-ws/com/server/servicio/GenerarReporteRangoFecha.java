
package com.server.servicio;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para generarReporteRangoFecha complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="generarReporteRangoFecha">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fechas" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "generarReporteRangoFecha", propOrder = {
    "fechas"
})
public class GenerarReporteRangoFecha {

    protected String fechas;

    /**
     * Obtiene el valor de la propiedad fechas.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechas() {
        return fechas;
    }

    /**
     * Define el valor de la propiedad fechas.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechas(String value) {
        this.fechas = value;
    }

}
