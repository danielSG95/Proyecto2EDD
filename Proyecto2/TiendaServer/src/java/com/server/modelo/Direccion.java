package com.server.modelo;

import com.server.Idao.AdminObject;

public class Direccion implements AdminObject {
	private String direccion;
	private int envio;
	private int facturacion;
	
	public Direccion(String direccion, int envio, int facturacion) {
		super();
		this.direccion = direccion;
		this.envio = envio;
		this.facturacion = facturacion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getEnvio() {
		return envio;
	}

	public void setEnvio(int envio) {
		this.envio = envio;
	}

	public int getFacturacion() {
		return facturacion;
	}

	public void setFacturacion(int facturacion) {
		this.facturacion = facturacion;
	}

	@Override
	public String escribirObjetoConsole() {
		// TODO Auto-generated method stub
		
		return "Direccion: " + direccion + " Envio: " + envio + " Facturacion: " + facturacion;
	}

	@Override
	public void modificarObjeto(Object q) {
		// TODO Auto-generated method stub
		Direccion d = (Direccion)q;
		direccion = d.getDireccion();
		envio = d.getEnvio();
		facturacion = d.getFacturacion();		
	}

	@Override
	public String escribirObjeto() {
		// TODO Auto-generated method stub
		return "Direccion: " + direccion + "\\nSe Envia: " + envio + "\\nFacturacion: " + facturacion;		
	}

	@Override
	public String devolverClave() {
		// TODO Auto-generated method stub
		return null;
	}	
}
