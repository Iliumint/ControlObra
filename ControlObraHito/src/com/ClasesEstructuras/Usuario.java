package com.ClasesEstructuras;

public class Usuario {

	String Nombre;
	String Cedula;
	String Contrase�a;
	String Perfil;
	
	
	public Usuario()
	{}
	
	public Usuario(String _nombre, String _cedula, String _pass, String _perfil)
	{
		Nombre=_nombre;
		Cedula=_cedula;
		Contrase�a=_pass;
		Perfil=_perfil;
	}

	
	
	//
	//Desde este punto  comienzan los metodos SET Y GET
	//
	
	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getCedula() {
		return Cedula;
	}

	public void setCedula(String cedula) {
		Cedula = cedula;
	}

	public String getContrase�a() {
		return Contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		Contrase�a = contrase�a;
	}

	public String getPerfil() {
		return Perfil;
	}

	public void setPerfil(String perfil) {
		Perfil = perfil;
	}
	
	
	
}
