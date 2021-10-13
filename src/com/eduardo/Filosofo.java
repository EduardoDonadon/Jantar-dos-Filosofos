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
		if (this.pos == 2) {
			if(this.garfoDireita.pegar()) {
				System.out.println("[" + this.nome + "] pegou garfo da direita");
							
				if(this.garfoEsquerda.pegar()) {
					System.out.println("[" + this.nome + "] pegou garfo da esquerda");
					System.out.println("[" + this.nome + "] esta COMENDO");
					Thread.sleep(r.nextInt(1500) + 500);
					this.garfoDireita.soltar();
					this.garfoEsquerda.soltar();
					System.out.println("[" + this.nome + "] terminou de comer\n");
					this.comeu = true;
				} else {
					this.garfoDireita.soltar();
					System.out.println("[" + this.nome + "] esta pensando");
					Thread.sleep(r.nextInt(1500) + 500);
				}			
				
			} else {
				System.out.println("[" + this.nome + "] esta pensando");
				Thread.sleep(r.nextInt(1500) + 500);
			}
			
		} else {
			if(this.garfoEsquerda.pegar()) {
				System.out.println("[" + this.nome + "] pegou garfo da esquerda");
							
				if(this.garfoDireita.pegar()) {
					System.out.println("[" + this.nome + "] pegou garfo da direita");
					System.out.println("[" + this.nome + "] esta COMENDO");
					Thread.sleep(r.nextInt(1500) + 500);
					this.garfoDireita.soltar();
					this.garfoEsquerda.soltar();
					System.out.println("[" + this.nome + "] terminou de comer\n");
					this.comeu = true;
				} else {
					this.garfoEsquerda.soltar();
					System.out.println("[" + this.nome + "] esta pensando");
					Thread.sleep(r.nextInt(1500) + 500);
				}
				
			} else {
				System.out.println("[" + this.nome + "] esta pensando");
				Thread.sleep(r.nextInt(1500) + 500);
			}
		}
	}
	
	@Override
	public void run() {
		while (true) {
			if(this.comeu == false) {
				try {
					this.comer();
					Thread.sleep(r.nextInt(500) + 100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
