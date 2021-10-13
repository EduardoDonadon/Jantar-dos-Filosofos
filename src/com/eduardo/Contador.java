package com.eduardo;

public class Contador extends Thread {
	private int[] filosofosJantar = {0, 0, 0, 0, 0};
	private int[] filosofosPensar = {0, 0, 0, 0, 0};
	public static String[] nomes = new String[5]; 
	private int timer = 0;
	public boolean comer = true;
	
	
	public void adionarJantares(int pos) {
		filosofosJantar[pos] ++; 
	}
	
	public void adionarPensamentos(int pos) {
		filosofosPensar[pos] ++; 
	}
	
	private void mostrarResultado() {
		System.out.println("\n\n\n\n\tRESULTADO: ");
		
		System.out.println("Jantares:");
		for(int i = 0; i < 5; i++) {			
			System.out.println("Filosofo " + nomes[i] + " comeu: " + filosofosJantar[i]  + " vezes");
		}
		
		System.out.println("\nPensamentos:");
		for(int i = 0; i < 5; i++) {			
			System.out.println("Filosofo " + nomes[i] + " pensou: " + filosofosPensar[i]  + " vezes");
		}
	};

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
				timer++;
				
				if (timer == 90) {
					comer = false;
					
					Thread.sleep(2200);
					mostrarResultado();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
