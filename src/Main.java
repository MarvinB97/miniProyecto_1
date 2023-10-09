/*
 * ------------------------------------------------------------
 * Name Proyecto: miniProyecto-1
 * nombre participantes: Alejandro Medina Garcia, Marvin Brayan Nuñez Zuñiga
 * File: Main.java
 * Relaciones: clase principal en donde se ejecuta el codigo
 * Ultima modificacion 08-10-23
 * Pogramación Orientada a Objetos Grupo 80
 * ------------------------------------------------------------
 */


//Se importan las librerias
import javax.swing.*;
import modelo.*;


public class Main {
	
  public static void main(String args[]) {
	  
	  JFrame frame = new JFrame("JUEGO DE FIGURAS");
	  frame.setSize(600, 400);
	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  
	  Interfaz Juego = new Interfaz();
	  frame.add(Juego);  
    
	  
	  frame.setVisible(true);
	  frame.setLocationRelativeTo(null); // la ubicamos en el centro de la pantalla
  }
}
