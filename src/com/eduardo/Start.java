package com.eduardo;

public class Start {
	private static final int TIMER = 10;

	public static void main(String[] args) {
		Contador contador = new Contador(TIMER);
		
		Garfo garfo1 = new Garfo();
		Garfo garfo2 = new Garfo();
		Garfo garfo3 = new Garfo();
		Garfo garfo4 = new Garfo();
		Garfo garfo5 = new Garfo();
		
		Filosofo filo1 = new Filosofo("Fnx", 0, garfo1, garfo2, contador);
		Filosofo filo2 = new Filosofo("Fer", 1, garfo2, garfo3, contador);
		Filosofo filo3 = new Filosofo("Taco", 2, garfo3, garfo4, contador);
		Filosofo filo4 = new Filosofo("Fallen", 3, garfo4, garfo5, contador);
		Filosofo filo5 = new Filosofo("Cold", 4, garfo5, garfo1, contador);
				
		new Thread(contador).start(); 
		new Thread(filo1).start();
		new Thread(filo2).start();
		new Thread(filo3).start();
		new Thread(filo4).start();
		new Thread(filo5).start();
		
	}

}
