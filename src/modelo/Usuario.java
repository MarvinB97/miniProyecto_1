package modelo;

import java.util.*;
import java.util.stream.Collectors;


public class Usuario {
	
	private List<String> nombresUsuarios;
	private List<Integer> puntaje;

	public Usuario() {
		this.nombresUsuarios = new ArrayList<String>();
		this.puntaje = new ArrayList<Integer>();
	}
	
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
	
	
	public void agregarUsuario(String nombre) {
		this.nombresUsuarios.add(nombre);
		this.puntaje.add(0);
	}
	
	public void subirPuntaje(int indice) {
		this.puntaje.set(indice, this.puntaje.get(indice)+1);
	}
}