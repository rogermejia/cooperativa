package com.empresa.entities;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the beneficiario database table.
 * 
 */
@Entity
@NamedQuery(name="Beneficiario.findAll", query="SELECT b FROM Beneficiario b")
public class Beneficiario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	/**@Column(name="idcliente")**/
	private int idbeneficiario;

	private int edad;

	private String parentesco;

	private double porcentaje;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="idcliente")
	private Cliente cliente;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="idpersona")
	private Persona persona;

	public Beneficiario() {
	}

	public int getIdbeneficiario() {
		return this.idbeneficiario;
	}

	public void setIdbeneficiario(int idbeneficiario) {
		this.idbeneficiario = idbeneficiario;
	}

	public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getParentesco() {
		return this.parentesco;
	}

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}

	public double getPorcentaje() {
		return this.porcentaje;
	}

	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
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

}