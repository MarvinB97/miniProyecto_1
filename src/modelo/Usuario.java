/*
 * ------------------------------------------------------------
 * Name Proyecto: miniProyecto-1
 * nombre participantes: Alejandro Medina Garcia, Marvin Nuñez
 * File: Usuario.java
 * Relaciones: Registro del nombre del usuario y de la puntuacion obtenida en el juego
 * Ultima Modificacion : 06-10-23
 * Pogramación Orientada a Objetos Grupo 80
 * ------------------------------------------------------------
 */


package modelo;

import java.util.*;
import java.util.stream.Collectors;


public class Usuario {

	//Atributos
	private List<String> nombresUsuarios;
	private List<Integer> puntaje;

	//CONSTRUCTOR
	public Usuario() {
		this.nombresUsuarios = new ArrayList<String>();
		this.puntaje = new ArrayList<Integer>();
	}

	//Metodos Getters
	public int getIndice(String nombre) {
		return this.nombresUsuarios.indexOf(nombre);
	}
	
	public int getIndiceFinal() {
		return this.nombresUsuarios.size()-1;
	}
	
	public int getPuntaje(int indice) {
		return this.puntaje.get(indice);
	}
	
	public String getRanking() {
		List<Integer> puntajesOrdenados = this.puntaje.stream().sorted().collect(Collectors.toList());
		
		String text = "<html><h2>RANKING</h2>";
		int indice = 0;
		for(int i = 0; i < puntajesOrdenados.size();i++) {
			indice = this.puntaje.indexOf(puntajesOrdenados.get(i));
			text += "<p>"+ (i+1) +"."+ this.nombresUsuarios.get(indice) + "............" + this.puntaje.get(indice) + "</p>";			
		}
		text += "</html>";
		
		return text;
	}
	
	public String getNombre(int indice) {
		return this.nombresUsuarios.get(indice);
	}
	

	//Registro de nuevo usuario
	public void agregarUsuario(String nombre) {
		this.nombresUsuarios.add(nombre);
		this.puntaje.add(0);
	}

	//Cambio de la puntuacion
	public void subirPuntaje(int indice) {
		this.puntaje.set(indice, this.puntaje.get(indice)+1);
	}
}
