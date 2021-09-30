package com.eduardo;

public class Garfo {
	private boolean available = true;
	
	public boolean pegar() {
		if (this.available) {
			this.available = false;
			return true;
		} else {
			return false;
		}
	}
	
	public void soltar() {
		this.available = true;
	}
}
