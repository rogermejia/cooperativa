package com.empresa.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the referencia database table.
 * 
 */
@Entity
@NamedQuery(name="Referencia.findAll", query="SELECT r FROM Referencia r")
public class Referencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idreferencia;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="idcliente")
	private Cliente cliente;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="idpersona")
	private Persona persona;
	
	private int tiempoconocerse;

	public Referencia() {
	}

	public int getIdreferencia() {
		return this.idreferencia;
	}

	public void setIdreferencia(int idreferencia) {
		this.idreferencia = idreferencia;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public int getTiempoconocerse() {
		return tiempoconocerse;
	}

	public void setTiempoconocerse(int tiempoconocerse) {
		this.tiempoconocerse = tiempoconocerse;
	}
	
	 

}