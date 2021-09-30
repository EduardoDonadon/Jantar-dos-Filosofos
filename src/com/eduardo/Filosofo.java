package com.eduardo;

import java.util.Random;

public class Filosofo extends Thread{
	private String nome;
	private int pos;
	private Garfo garfoDireita;
	private Garfo garfoEsquerda;
	private boolean comeu = false;
	private final Random r = new Random();
	
	public Filosofo(String nome, int pos, Garfo garfoDireita, Garfo garfoEsquerda) {
		this.nome = nome;
		this.pos = pos;
		this.garfoDireita = garfoDireita;
		this.garfoEsquerda = garfoEsquerda;
	}
	
	public void comer() throws InterruptedException {
		if (this.pos == 3) {
			if(this.garfoDireita.pegar()) {
				System.out.println("Filosofo " + this.nome + " pegou garfo da direita");
							
				if(this.garfoEsquerda.pegar()) {
					System.out.println("Filosofo " + this.nome + " esta COMENDO");
					Thread.sleep(r.nextInt(1500) + 500);
					this.garfoDireita.soltar();
					this.garfoEsquerda.soltar();
					System.out.println("Filosofo " + this.nome + " terminou de comer\n");
					this.comeu = true;
				} else {
					System.out.println("Filosofo " + this.nome + " esta pensando");
					Thread.sleep(r.nextInt(1500) + 500);
				}
				
				this.garfoDireita.soltar();
			}
		} else {
			if(this.garfoEsquerda.pegar()) {
				System.out.println("Filosofo " + this.nome + " pegou garfo da direita");
							
				if(this.garfoDireita.pegar()) {
					System.out.println("Filosofo " + this.nome + " esta COMENDO");
					Thread.sleep(r.nextInt(1500) + 500);
					this.garfoDireita.soltar();
					this.garfoEsquerda.soltar();
					System.out.println("Filosofo " + this.nome + " terminou de comer\n");
					this.comeu = true;
				} else {
					System.out.println("Filosofo " + this.nome + " esta pensando");
					Thread.sleep(r.nextInt(1500) + 500);
				}
				
				this.garfoEsquerda.soltar();
			}
		}
	}
	
	@Override
	public void run() {
		while (true) {
			if(this.comeu == false) {
				try {
					this.comer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
