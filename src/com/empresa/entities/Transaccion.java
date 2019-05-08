package com.empresa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the transaccion database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Transaccion.findAll", query="SELECT t FROM Transaccion t"),
	@NamedQuery(name="transacciones.byCuenta", query="SELECT t FROM Transaccion t where t.cuenta.idcuenta =:idCuenta")
})

public class Transaccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idtran;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private BigDecimal montoabono;

	private BigDecimal montocargo;

	//bi-directional many-to-one association to Cuenta
	@ManyToOne
	@JoinColumn(name="idcuenta")
	private Cuenta cuenta;

	public Transaccion() {
	}

	public int getIdtran() {
		return this.idtran;
	}

	public void setIdtran(int idtran) {
		this.idtran = idtran;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getMontoabono() {
		return this.montoabono;
	}

	public void setMontoabono(BigDecimal montoabono) {
		this.montoabono = montoabono;
	}

	public BigDecimal getMontocargo() {
		return this.montocargo;
	}

	public void setMontocargo(BigDecimal montocargo) {
		this.montocargo = montocargo;
	}

	public Cuenta getCuenta() {
		return this.cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

}