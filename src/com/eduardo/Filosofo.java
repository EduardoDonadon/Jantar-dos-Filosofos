package com.eduardo;

import java.util.Random;

public class Filosofo extends Thread{
	private String nome;
	private int pos;
	private Garfo garfoDireita;
	private Garfo garfoEsquerda;
	private Contador contador;
	private final Random r = new Random();
	
	public Filosofo(String nome, int pos, Garfo garfoDireita, Garfo garfoEsquerda, Contador contador) {
		this.nome = nome;
		this.pos = pos;
		this.garfoDireita = garfoDireita;
		this.garfoEsquerda = garfoEsquerda;
		this.contador = contador;
		
		Contador.nomes[pos] = nome; 
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
					this.contador.adionarJantares(pos);
				} else {
					this.garfoDireita.soltar();
					System.out.println("[" + this.nome + "] esta pensando");
					Thread.sleep(r.nextInt(1500) + 500);
					this.contador.adionarPensamentos(pos);
				}			
				
			} else {
				System.out.println("[" + this.nome + "] esta pensando");
				Thread.sleep(r.nextInt(1500) + 500);
				this.contador.adionarPensamentos(pos);
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
					this.contador.adionarJantares(pos);
				} else {
					this.garfoEsquerda.soltar();
					System.out.println("[" + this.nome + "] esta pensando");
					Thread.sleep(r.nextInt(1500) + 500);
					this.contador.adionarPensamentos(pos);
				}
				
			} else {
				System.out.println("[" + this.nome + "] esta pensando");
				Thread.sleep(r.nextInt(1500) + 500);
				this.contador.adionarPensamentos(pos);
			}
		}
	}
	
	@Override
	public void run() {
		while (true) {
			if(this.contador.comer) {
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
