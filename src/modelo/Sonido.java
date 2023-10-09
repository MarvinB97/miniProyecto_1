/*
 * ------------------------------------------------------------
 * Name Proyecto: miniProyecto-1
 * nombre participantes: Alejandro Medina Garcia, Marvin Brayan Nuñez Zuñiga
 * File: Sonido.java
 * Relaciones: Obtiene la ubicacion del sonido y lo reproduce segun sea la accion
 * Ultima Modificacion : 08-10-23
 * Pogramación Orientada a Objetos Grupo 80
 * ------------------------------------------------------------
 */


package modelo;

import javax.sound.sampled.*;
import java.io.*;


public class Sonido {

	//Método Constructor
	public Sonido() {

	}

	//Este método obtiene la ubicacion del sonido por medio de un parametro, luego lo abre y lo reproduce
	public void realizarSonido(String nombreSonido){
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(nombreSonido).getAbsoluteFile());
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start();
	        } catch(UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
	        System.out.println("Error al reproducir el sonido.");
	        }
	     }

}
