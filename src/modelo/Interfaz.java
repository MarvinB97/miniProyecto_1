/*
 * ------------------------------------------------------------
 * Name Proyecto: miniProyecto-1
 * nombre participantes: Alejandro Medina Garcia, Marvin Brayan Nuñez Zuñiga
 * File: Interfaz.java
 * Relaciones: contiene los elementos de la GUI mas la logica del programa
 * Ultima Modificacion : 08-10-23
 * Pogramación Orientada a Objetos Grupo 80
 * ------------------------------------------------------------
 */

package modelo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Interfaz extends JPanel implements ActionListener{

    //atributos de diferentes tipos
    Image Fondo;
    private Sonido ringtong;

    private JTextField txtInputNombre;
    private JLabel txtNombre,txtCantFiguras,txtPuntaje,txtRanking,txtInstrucciones, txtFallos;
    private JButton btnJugar,btnSalir,btnRanking,btnInstrucciones,btnFigura1,btnFigura2,btnFigura3,btnFigura4;
    private ImageIcon icono1Escala,icono2Escala,icono3Escala,icono4Escala;
    private Figuras figura1 = new Figuras();
    private Usuario usuarios = new Usuario(); //nombres y puntajes de cada jugador
    private int indiceUsuario, fallo;
    
    
    public Interfaz() { // constructor

   //---Imagen de fondo de pantalla
    	ImageIcon objeto = new ImageIcon("src/images/fondo.png");
	    Fondo = objeto.getImage();
	    indiceUsuario = 0;
            fallo = 0;
	    ringtong = new Sonido();
    
        setLayout(null);
    
  //-----INPUT-----
        txtInputNombre = new JTextField("Nombre del Jugador");
        txtInputNombre.setBounds(200,145,200,30);
    
  //----------ETIQUETAS DE TEXTO-----
        txtNombre = new JLabel("Nombre del Jugador");
        txtNombre.setForeground(Color.white);
        txtNombre.setBounds(0,0,300,50);
    
        txtCantFiguras = new JLabel("Cant. de Figuras = 4");
        txtCantFiguras.setForeground(Color.white);
        txtCantFiguras.setBounds(150,0,200, 50);

        txtPuntaje = new JLabel("Puntaje = 0");
        txtPuntaje.setForeground(Color.white);
        txtPuntaje.setBounds(300,0,100, 50);
        
        txtFallos = new JLabel("Fallos = " + fallo);
        txtFallos.setForeground(Color.white);
        txtFallos.setBounds(400, 0, 100, 50);
        
        txtRanking = new JLabel("--------RANKING--------");
        txtRanking.setForeground(Color.white);
        txtRanking.setBounds(200,50,250, 300);
        
        txtInstrucciones = new JLabel("<html><h3>Instrucciones</strong></h3> "
        		+ "<p> Se debe ingresar un nombre de usuario.</p>"
        		+ "<p> Al dar click en jugar apareceran cuatro figuras, "
        		+ "siendo la figura de la izquierda la que se debe comparar con las otras tres.</p>"
        		+ "<p>Se debe seleccionar la figura que coincida en tamaño.</p>"
        		+ "<p> Por cada acierto, se obtendrá un punto extra.</p></html>");
        txtInstrucciones.setForeground(Color.white);
        txtInstrucciones.setBounds(200,110,400, 200);


  //-------BOTONES---------
        btnJugar = new JButton("JUGAR");
        btnSalir = new JButton("SALIR");
        btnRanking = new JButton("Ranking");
        btnInstrucciones = new JButton("Instrucciones");
        btnFigura1 = new JButton();
        btnFigura2 = new JButton();
        btnFigura3 = new JButton();
        btnFigura4 = new JButton();

  //quitar los bordes de los botones
        btnFigura1.setBorder(null);
        btnFigura2.setBorder(null);
        btnFigura3.setBorder(null);
        btnFigura4.setBorder(null);

	//se genera de forma aleatoria las imagenes sobre los botones
        cambiarFiguras();
	    
  //Se añaden los iconos a los botones
        btnFigura1.setIcon(this.icono1Escala);
        btnFigura2.setIcon(this.icono2Escala);
        btnFigura3.setIcon(this.icono3Escala);
        btnFigura4.setIcon(this.icono4Escala);
    
    
        btnJugar.setBounds(250,260,100,50);
        btnSalir.setBounds(510,320,80,40);
        btnRanking.setBounds(250,215,100,35);
        btnInstrucciones.setBounds(230,180,140,35);
    
    
        btnFigura1.setBounds(50,150,this.figura1.getLado(0),this.figura1.getLado(0));
        btnFigura2.setBounds(200,150,this.figura1.getLado(1),this.figura1.getLado(1));
        btnFigura3.setBounds(300,150,this.figura1.getLado(2),this.figura1.getLado(2));
        btnFigura4.setBounds(400,150,this.figura1.getLado(3),this.figura1.getLado(3));
    

        btnJugar.addActionListener(this);
        btnSalir.addActionListener(this);
        btnRanking.addActionListener(this);
        btnInstrucciones.addActionListener(this);
        btnFigura2.addActionListener(this);
        btnFigura3.addActionListener(this);
        btnFigura4.addActionListener(this);
    
    
  //---AÑADIR ELEMENTOS------
        add(txtInputNombre);
        add(txtNombre);
        add(txtCantFiguras);
        add(txtPuntaje);
        add(txtFallos);
        add(txtRanking);
        add(txtInstrucciones);
        add(btnJugar);
        add(btnSalir);
        add(btnRanking);
        add(btnInstrucciones);
        add(btnFigura1);
        add(btnFigura2);
        add(btnFigura3);
        add(btnFigura4);
    
  //Visibilidad en la pantalla
        txtNombre.setVisible(false);
        txtCantFiguras.setVisible(false);
        txtPuntaje.setVisible(false);
        txtFallos.setVisible(false);
        txtRanking.setVisible(false);
        txtInstrucciones.setVisible(false);
        btnSalir.setVisible(false);
        btnFigura1.setVisible(false);
        btnFigura2.setVisible(false);
        btnFigura3.setVisible(false);
        btnFigura4.setVisible(false);
      
  }
    
    
    public void cambiarFiguras(){
    	//creamos el objeto figura(circulo,luna,etc)
	    ImageIcon icono = new ImageIcon(this.figura1.getUbicacion());
	      
	    this.figura1.barajarDimension();//obtenemos los diferentes tamaños de las figuras

	    //se reescalan los iconos para tener diferentes tamaños
  	    this.icono1Escala = new ImageIcon(icono.getImage().getScaledInstance(this.figura1.getLado(0),this.figura1.getLado(0), java.awt.Image.SCALE_DEFAULT));
	    this.icono2Escala = new ImageIcon(icono.getImage().getScaledInstance(this.figura1.getLado(1),this.figura1.getLado(1), java.awt.Image.SCALE_DEFAULT));
	    this.icono3Escala = new ImageIcon(icono.getImage().getScaledInstance(this.figura1.getLado(2),this.figura1.getLado(2), java.awt.Image.SCALE_DEFAULT));
	    this.icono4Escala = new ImageIcon(icono.getImage().getScaledInstance(this.figura1.getLado(3),this.figura1.getLado(3), java.awt.Image.SCALE_DEFAULT));
	  
	  
	    this.btnFigura1.setIcon(this.icono1Escala);
	    this.btnFigura2.setIcon(this.icono2Escala);
	    this.btnFigura3.setIcon(this.icono3Escala);
	    this.btnFigura4.setIcon(this.icono4Escala);
	      
            this.btnFigura1.setBounds(50,150,this.figura1.getLado(0),this.figura1.getLado(0));
	    this.btnFigura2.setBounds(200,150,this.figura1.getLado(1),this.figura1.getLado(1));
	    this.btnFigura3.setBounds(300,150,this.figura1.getLado(2),this.figura1.getLado(2));
	    this.btnFigura4.setBounds(400,150,this.figura1.getLado(3),this.figura1.getLado(3));    
	  
  }
    
    
    public void seleccionarBien() {
        usuarios.subirPuntaje(this.indiceUsuario);
        txtPuntaje.setText("Puntaje = " + usuarios.getPuntaje(this.indiceUsuario));
        this.ringtong.realizarSonido("src/sound/correcto.wav");     
    }
    
    public void seleccionarMal() {
        this.fallo += 1;
        this.ringtong.realizarSonido("src/sound/incorrecto.wav");
    }
    

    
        @Override
    public void actionPerformed(ActionEvent e) {
    	if (e.getSource() == btnJugar) {
            String nombre = txtInputNombre.getText();

            //Guardar informacion del nombre y puntaje en los JLabel
            txtNombre.setText(nombre);
            //txtPuntaje.setText(0);
            //Añadirlo a la lista
            usuarios.agregarUsuario(nombre);
            //Guardar en la variable indiceUsuario el indice del usuario
            indiceUsuario = usuarios.getIndiceFinal();

            txtInputNombre.setVisible(false);
            txtNombre.setVisible(true);
            txtCantFiguras.setVisible(true);
            txtPuntaje.setVisible(true);
            txtFallos.setVisible(true);
            btnJugar.setVisible(false);
            btnSalir.setVisible(true);
            btnRanking.setVisible(false);
            btnInstrucciones.setVisible(false);
            btnFigura1.setVisible(true);
            btnFigura2.setVisible(true);
            btnFigura3.setVisible(true);
            btnFigura4.setVisible(true);

            txtRanking.setVisible(false);
            txtInstrucciones.setVisible(false);
	    }
        if (e.getSource() == btnSalir) {
            txtInputNombre.setVisible(true);
            txtNombre.setVisible(false);
            txtCantFiguras.setVisible(false);
            txtPuntaje.setVisible(false);
            txtFallos.setVisible(false);
            btnJugar.setVisible(true);
            btnSalir.setVisible(false);
            btnRanking.setVisible(true);
            btnInstrucciones.setVisible(true);
            btnFigura1.setVisible(false);
            btnFigura2.setVisible(false);
            btnFigura3.setVisible(false);
            btnFigura4.setVisible(false);
            fallo = 0;

            txtRanking.setVisible(false);
            txtInstrucciones.setVisible(false);
		    
	    }
        if (e.getSource() == btnRanking) {
	    	
            txtRanking.setText(usuarios.getRanking());

            txtInputNombre.setVisible(false);
            txtNombre.setVisible(false);
            txtCantFiguras.setVisible(false);
            txtPuntaje.setVisible(false);
            txtFallos.setVisible(false);
            btnJugar.setVisible(false);
            btnSalir.setVisible(true);
            btnRanking.setVisible(false);
            btnInstrucciones.setVisible(false);
            btnFigura1.setVisible(false);
            btnFigura2.setVisible(false);
            btnFigura3.setVisible(false);
            btnFigura4.setVisible(false);

            txtRanking.setVisible(true);
            txtInstrucciones.setVisible(false);


	    }
        if (e.getSource() == btnInstrucciones) {
            txtInputNombre.setVisible(false);
            txtNombre.setVisible(false);
            txtCantFiguras.setVisible(false);
            txtPuntaje.setVisible(false);
            txtFallos.setVisible(false);

            btnJugar.setVisible(false);
            btnSalir.setVisible(true);
            btnRanking.setVisible(false);
            btnInstrucciones.setVisible(false);
            btnFigura1.setVisible(false);
            btnFigura2.setVisible(false);
            btnFigura3.setVisible(false);
            btnFigura4.setVisible(false);

            txtRanking.setVisible(false);
            txtInstrucciones.setVisible(true);

	    }
        if (e.getSource() == btnFigura2) {
            if(this.figura1.getLado(0) == this.figura1.getLado(1)){
              cambiarFiguras();
              seleccionarBien();
            }
            else{
                seleccionarMal();
                cambiarFiguras();
                }
        }
        if (e.getSource() == btnFigura3) {
            if(this.figura1.getLado(0) == this.figura1.getLado(2)){
                cambiarFiguras();
	    	seleccionarBien();
	      }
            else{
                seleccionarMal();
                cambiarFiguras();
                }
        }
        if (e.getSource() == btnFigura4) {
            if(this.figura1.getLado(0) == this.figura1.getLado(3)){
	    	cambiarFiguras();
	    	seleccionarBien();
	      }
            else{
                seleccionarMal();
                cambiarFiguras();
                }
        }    
    }


    
    
        @Override
    public void paintComponent(Graphics g){
    	super.paintComponent(g);
        g.drawImage(Fondo,0,0,null);    
    }
  

}
