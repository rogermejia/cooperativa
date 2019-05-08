package com.empresa.test;

import java.util.ArrayList;
import java.util.List;

import com.empresa.dao.PersonaDAO;
import com.empresa.entities.Beneficiario;
import com.empresa.entities.Cliente;
import com.empresa.entities.Direccion;
import com.empresa.entities.Persona;
import com.empresa.entities.Referencia;
import com.empresa.entities.Telefono;

public class TestPersona {
	public static void main(String[] args) {
		Persona persona = new Persona(); //cliente
		persona.setNombres("Luis");
		persona.setApellidos("Escobar");
		persona.setDocumentonum("04598545-7");
		
		List<Cliente> cliList = new ArrayList<Cliente>();
		Cliente cli = new Cliente();
		cli.setMiembro("1");
		cli.setPersona(persona);
		cliList.add(cli);
		
		List<Telefono> telList = new ArrayList<Telefono>();
		Telefono telCli = new Telefono();
		telCli.setTelefono("7864-9003");
		telCli.setPersona(persona);
		telList.add(telCli);
		
		//Telefono telList2 = new ArrayList<Telefono>();
		telCli = new Telefono();
		telCli.setTelefono("2216-9003");
		telCli.setPersona(persona);
		telList.add(telCli);
		
		List<Direccion> dirList = new ArrayList<Direccion>();
		Direccion dir = new Direccion();
		dir.setDireccion("Direccion generica");
		dir.setPersona(persona);
		dirList.add(dir);
		
		persona.setDireccions(dirList);
		persona.setTelefonos(telList);
		persona.setClientes(cliList);
		
		//Guardando persona
		PersonaDAO perDAO = new PersonaDAO();
		Persona perRest = perDAO.insertPersona(persona);
		System.out.println("id persona insertada" + perRest.getIdpersona());
		
		//Beneficiarios
		List<Beneficiario> benList = new ArrayList<Beneficiario>();
		Beneficiario ben = new Beneficiario();
		Persona perBen = new Persona();
		perBen.setNombres("Beneficiario");
		perBen.setApellidos("Apellido");
		perBen.setDocumentonum("000045466-8");
		Persona respuestaPerBen = perDAO.insertPersona(perBen);
		ben.setPersona(respuestaPerBen);
		ben.setCliente(persona.getClientes().get(0));
		ben.setEdad(20);
		ben.setParentesco("padre");
		ben.setPorcentaje(30.02);
		benList.add(ben);
		cli.setBeneficiarios(benList);
		String respuestaBen = perDAO.insertarBeneficiarios(benList);
		System.out.println("Respuesta beneficiarios" + respuestaBen);
		
		//Referencias
		List<Referencia> refList = new ArrayList<Referencia>();
		Referencia ref = new Referencia();
		Persona perRef = new Persona();
		perRef.setNombres("Referenciado");
		perRef.setApellidos("Apellido");
		perRef.setDocumentonum("00545466546-7");
		Persona respuestaPerRef = perDAO.insertPersona(perRef);
		ref.setPersona(respuestaPerRef);
		ref.setCliente(persona.getClientes().get(0));
		refList.add(ref);
		cli.setReferencias(refList);
		String respuestaRef = perDAO.insertarReferencias(refList);
		System.out.println("Respuesta referencia" + respuestaRef);
	}
	

}
