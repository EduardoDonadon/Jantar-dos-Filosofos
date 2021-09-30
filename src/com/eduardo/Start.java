package com.eduardo;

public class Start {

	public static void main(String[] args) {
		Garfo garfo1 = new Garfo();
		Garfo garfo2 = new Garfo();
		Garfo garfo3 = new Garfo();
		Garfo garfo4 = new Garfo();
		Garfo garfo5 = new Garfo();
		
		Filosofo filo1 = new Filosofo("Fnx", 0, garfo1, garfo2);
		Filosofo filo2 = new Filosofo("Fer", 1, garfo2, garfo3);
		Filosofo filo3 = new Filosofo("Taco", 2, garfo3, garfo4);
		Filosofo filo4 = new Filosofo("Fallen", 3, garfo4, garfo5);
		Filosofo filo5 = new Filosofo("Cold", 4, garfo5, garfo1);
		
		new Thread(filo1).start();
		new Thread(filo2).start();
		new Thread(filo3).start();
		new Thread(filo4).start();
		new Thread(filo5).start();
	}

}
