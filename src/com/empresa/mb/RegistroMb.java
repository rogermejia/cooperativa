package com.empresa.mb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;

import com.empresa.dao.PersonaDAO;
import com.empresa.entities.*;

@ManagedBean
@ViewScoped
public class RegistroMb {
	private Persona persona;
	private List<Cliente> cliList;
	private Cliente cliente;
	private List<Direccion> listDirCliente;
	private List<Telefono> telListCliente;
	private List<PersonaGenerica> referencias;
	private List<PersonaGenerica> beneficiarios;
	private List<Referencia> refListRef;
	private List<Beneficiario> refListBenCliente;
	private PersonaDAO perDao;

	@PostConstruct
	public void init() {
		persona = new Persona();
		cliList = new ArrayList<Cliente>();
		cliente = new Cliente();
		listDirCliente = new ArrayList<Direccion>();
		telListCliente = new ArrayList<Telefono>();
		referencias = new ArrayList<PersonaGenerica>();
		beneficiarios = new ArrayList<PersonaGenerica>();		
		refListRef = new ArrayList<Referencia>();
		refListBenCliente = new ArrayList<Beneficiario>();
		perDao = new PersonaDAO();
	}

	public void insertCliente() {
		cliente.setPersona(persona);
		cliList.add(cliente);
		persona.setClientes(cliList);
		
		for(Direccion dir: listDirCliente) {
			dir.setPersona(persona);
		}
		persona.setDireccions(listDirCliente);
		for(Telefono tel: telListCliente) {
			tel.setPersona(persona);
		}
		persona.setTelefonos(telListCliente);
		for(PersonaGenerica per: beneficiarios) {
			Beneficiario ben = new Beneficiario();
			ben.setCliente(cliente);
			ben.setEdad(per.getEdad());
			ben.setParentesco(per.getParentesco());
			Persona perBen = new Persona();
			perBen.setNombres(per.getNombre());
			perBen.setApellidos(per.getApellidos());
			perBen.setDocumentonum(per.getNumeroDocumento());
			Persona perRespuesta = perDao.insertPersona(perBen);
			ben.setPersona(perRespuesta);
			ben.setPorcentaje(per.getPorcentaje());
			refListBenCliente.add(ben);
		}
		persona.setBeneficiarios(refListBenCliente);
		
		for(PersonaGenerica perGen: referencias) {
			Referencia ref = new Referencia();
			ref.setCliente(cliente);
			Persona perBen = new Persona();
			perBen.setNombres(perGen.getNombre());
			perBen.setApellidos(perGen.getApellidos());
			perBen.setDocumentonum(perGen.getNumeroDocumento());
			Persona personaGeRespuesta = perDao.insertPersona(perBen);
			ref.setPersona(personaGeRespuesta);
			ref.setTiempoconocerse(perGen.getTiempoconocerse());
			refListRef.add(ref);
		}
		
		persona.setReferencias(refListRef);
		Persona clienteGuardado = perDao.insertPersona(persona);
		FacesMessage msg = new FacesMessage("Persona Guardada" + clienteGuardado.getIdpersona());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	//*******************Metodos para agregar otro campo en la vista*********************
	
	public void addDireccion() {
		listDirCliente.add(new Direccion());
	}
	
	public void addTelefono() {
		telListCliente.add(new Telefono());
	}
	
	public void addReferencia() {
		referencias.add(new PersonaGenerica());
	}
	
	public void addBeneficiario() {
		beneficiarios.add(new PersonaGenerica());
	}
	
	public String iraCuentas() {
		return "cuentas.xhtml";
	}
	
	//*******************Getters and Setters*********************

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public List<Cliente> getCliList() {
		return cliList;
	}

	public void setCliList(List<Cliente> cliList) {
		this.cliList = cliList;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Direccion> getListDirCliente() {
		return listDirCliente;
	}

	public void setListDirCliente(List<Direccion> listDirCliente) {
		this.listDirCliente = listDirCliente;
	}

	public List<Telefono> getTelListCliente() {
		return telListCliente;
	}

	public void setTelListCliente(List<Telefono> telListCliente) {
		this.telListCliente = telListCliente;
	}

	public List<Referencia> getRefListRef() {
		return refListRef;
	}

	public void setRefListRef(List<Referencia> refListRef) {
		this.refListRef = refListRef;
	}

	public List<Beneficiario> getRefListBenCliente() {
		return refListBenCliente;
	}

	public void setRefListBenCliente(List<Beneficiario> refListBenCliente) {
		this.refListBenCliente = refListBenCliente;
	}

	public List<PersonaGenerica> getReferencias() {
		return referencias;
	}

	public void setReferencias(List<PersonaGenerica> referencias) {
		this.referencias = referencias;
	}

	public List<PersonaGenerica> getBeneficiarios() {
		return beneficiarios;
	}

	public void setBeneficiarios(List<PersonaGenerica> beneficiarios) {
		this.beneficiarios = beneficiarios;
	}
	
	

}
