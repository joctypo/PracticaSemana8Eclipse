package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;

import com.google.gson.Gson;

import processing.core.PApplet;

public class Main extends PApplet {

	// Globales
	int xBolita = -1000;
	int yBolita = -1000;
	int pantalla =0;

	private Avatar player1;
	private Avatar player2;

	private TCPConnectionP1 conexionJ1;
	private TCPConnectionP2 conexionJ2;

	private ArrayList <Bala> balasj1;
	private ArrayList <Bala> balasj2;
	
	
	public static void main(String[] args) {
		PApplet.main("main.Main");
	}

	// 1
	public void settings() {
		size(500, 500);
	}

	// 1
	public void setup() {
		conexionJ1 = new TCPConnectionP1();
		// Metodo de suscripcion
		conexionJ1.setMain(this);
		conexionJ1.start();

		conexionJ2 = new TCPConnectionP2();
		// Metodo de suscripcion
		conexionJ2.setMain(this);
		conexionJ2.start();

		player1 = new Avatar(this, 100, 100, color(255, 0, 0));
		player2 = new Avatar(this, 400, 400, color(0, 0, 255));
		
		balasj1 = new ArrayList<>();
		balasj2 = new ArrayList<>();
		
	}

	// Inifito
	public void draw() {
		
		
		switch (pantalla) {
		
		case 0: 
			
			background(0, 0, 0);
			fill(255, 0, 0);
			ellipse(xBolita, yBolita, 50, 50);

			player1.pintar();
			player2.pintar();
			
			for(int i=0; i<balasj1.size();i++) {
				
				Bala b = balasj1.get(i);
				b.pintar();
				
				if(dist(balasj1.get(i).getX(), balasj1.get(i).getY(), player2.getX(), player2.getY())<50) {
					
					pantalla = 1;
					balasj1.remove(i);
					
				}
				
				if (b.getX()<0 || b.getX()>500) {
					
					balasj1.remove(i);
					
					
				}
				
			}
			for(int i=0; i<balasj2.size();i++) {
				
				Bala b = balasj2.get(i);
				b.pintar();
				if(dist(balasj2.get(i).getX(), balasj2.get(i).getY(), player1.getX(), player1.getY())<50) {
					
					pantalla = 1;
					balasj1.remove(i);
					
				}
				
			if (b.getX()<0 || b.getX()>500) {
					
					balasj2.remove(i);
				}
				
			}
			
			
			break;
			
		case 1: 
			
			background(255);
			fill(0);
			text("fin del juego",150,150);
			
			break;
		}

		
		
	}


	// El metodo de notificacion: Aqui se recibe la informacion del evento
	public void notificar(Acciones c, Object obj) {

		//Verificar que clase es o que TCP mando la info 
		if(obj instanceof TCPConnectionP1) {
			
			//imprimo en la consola que sucede
			System.out.println("Jugador 1"+c.getAccion());
			
			//Dice que acción activar 
			switch(c.getAccion()) {
			
			case "UPSTART":
				player1.arribamuevalo();
				
				break;
			
			case "UPSTOP":
				
				player1.arribaparelo();
				
				break;
				
			case "DOWNSTART":
				
				player1.abajomuevalo();
				
				break;
				
			
			case "DOWNSTOP":
				
				player1.abajoparelo();
				
				break;
			
				
			case "LEFTSTART":
				
				player1.izquierdomuevalo();
				
				break;
			
			case "LEFTSTOP":
				
				player1.izquierdoparelo();
				
				break;
				
				
			case "RIGHTSTART":
				
				player1.derechomuevalo();
				
				break;
			
			case "RIGHTSTOP":
				
				player1.derechoparelo();
				
				break;
			case "CATCHIT":
				
				Bala bala= new Bala(this,player1.getX(),player1.getY(), true);
				balasj1.add(bala);
				
				break;
			
			}
			
			
			
		}else if(obj instanceof TCPConnectionP2) {
			
			System.out.println("Jugador 2"+c.getAccion());
			
			switch(c.getAccion()) {
			
			case "UPSTART":
				
				player2.arribamuevalo();
				
				break;
			
			case "UPSTOP":
				
				player2.arribaparelo();
				
				break;
				
			case "DOWNSTART":
				
				player2.abajomuevalo();
				
				break;
				
			
			case "DOWNSTOP":
				
				player2.abajoparelo();
				
				break;
			
				
			case "LEFTSTART":
				
				player2.izquierdomuevalo();
				
				break;
			
			case "LEFTSTOP":
				
				player2.izquierdoparelo();
				
				break;
				
				
			case "RIGHTSTART":
				
				player2.derechomuevalo();
				
				break;
			
			case "RIGHTSTOP":
				
				player2.derechoparelo();
				
				break;
			case "CATCHIT":
				
				Bala bala= new Bala(this,player2.getX(),player2.getY(), true);
				balasj2.add(bala);
				
				break;
			
			}	
		}
	}
}
