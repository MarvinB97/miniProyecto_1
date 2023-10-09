/*
 * ------------------------------------------------------------
 * Name Proyecto: miniProyecto-1
 * nombre participantes: Alejandro , Marvin Nuñez
 * File: Figuras.java
 * Relaciones: subclase en donde se organizan y se obtienen las ubicaciones de las imagenes (figuras)
 * Ultima modificacion 06-10-23
 * Pogramación Orientada a Objetos Grupo 80
 * ------------------------------------------------------------
 */

package modelo;

import java.lang.Math;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Figuras{
  //Atributos
  private String figuras[]= {"circulo","cuadrado","triangulo","doblecirculo","luna"};
  private String color[]={"amarillo","rojo","verde"};
  private int lado[] = new int[4];

  //Método Constructor
  public Figuras(){
  }

  //Métodos Getters
  public String getUbicacion(){
    int numAleatorio = (int)(Math.random()*5);
    int numAleatorio2 = (int)(Math.random()*3);
    String ubicacion = "src/images/" + this.figuras[numAleatorio] + "-" + this.color[numAleatorio2] + ".jpeg";
    return ubicacion;
  }

  public int getLado(int index){
    return this.lado[index];
  }

  /*
  Se guarda en una lista las dimensiones establecidas, luego con el método shuffle
  de logra reordenar estos valores de manera aleatoria
  */
  public void barajarDimension(){
    List<Integer> values = Arrays.asList(40,60,80);
    Collections.shuffle(values);
    int numAleatorio = (int)(Math.random()*3);

    this.lado[0]=values.get(numAleatorio);
    for(int i=1;i<4;i++){
      this.lado[i] = values.get(i-1);
    }
  }
    

    
}
