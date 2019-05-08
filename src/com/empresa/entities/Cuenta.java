package com.empresa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the cuenta database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Cuenta.findAll", query="SELECT c FROM Cuenta c"),
	@NamedQuery(name="cuentas.byCliente", query="SELECT c FROM Cuenta c where c.cliente.idcliente =:idCliente")
})

public class Cuenta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idcuenta;

	private int numcuenta;

	private BigDecimal saldo;

	private BigDecimal totalabonos;

	private BigDecimal totalcargos;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="idcliente")
	private Cliente cliente;

	//bi-directional many-to-one association to Tipocuenta
	@ManyToOne
	@JoinColumn(name="idtipocuenta")
	private Tipocuenta tipocuenta;
	

	//bi-directional many-to-one association to Transaccion
	@OneToMany(mappedBy="cuenta", cascade = CascadeType.ALL)
	private List<Transaccion> transaccions;

	public Cuenta() {
	}

	public int getIdcuenta() {
		return this.idcuenta;
	}

	public void setIdcuenta(int idcuenta) {
		this.idcuenta = idcuenta;
	}

	public int getNumcuenta() {
		return this.numcuenta;
	}

	public void setNumcuenta(int numcuenta) {
		this.numcuenta = numcuenta;
	}

	public BigDecimal getSaldo() {
		return this.saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public BigDecimal getTotalabonos() {
		return this.totalabonos;
	}

	public void setTotalabonos(BigDecimal totalabonos) {
		this.totalabonos = totalabonos;
	}

	public BigDecimal getTotalcargos() {
		return this.totalcargos;
	}

	public void setTotalcargos(BigDecimal totalcargos) {
		this.totalcargos = totalcargos;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Tipocuenta getTipocuenta() {
		return this.tipocuenta;
	}

	public void setTipocuenta(Tipocuenta tipocuenta) {
		this.tipocuenta = tipocuenta;
	}

	public List<Transaccion> getTransaccions() {
		return this.transaccions;
	}

	public void setTransaccions(List<Transaccion> transaccions) {
		this.transaccions = transaccions;
	}

	public Transaccion addTransaccion(Transaccion transaccion) {
		getTransaccions().add(transaccion);
		transaccion.setCuenta(this);

		return transaccion;
	}

	public Transaccion removeTransaccion(Transaccion transaccion) {
		getTransaccions().remove(transaccion);
		transaccion.setCuenta(null);

		return transaccion;
	}

}