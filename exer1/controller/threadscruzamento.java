package controller;

import java.util.concurrent.Semaphore;

public class threadscruzamento extends Thread{
	private String sentido;
	private Semaphore semaforo;
	static int numero =0;
	private int carro;
	
	public threadscruzamento( int carro, Semaphore semaforo) {
		this.carro = carro;
		this.semaforo = semaforo;
	}
	@Override
	public void run() {
		try {
			semaforo.acquire();
			travessia();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
		super.run();
	}
	private void travessia() {
		if(numero == 0) {
			sentido = "direita";
		} else if(numero == 1) {
			sentido ="baixo";
		} else if(numero == 2) {
			sentido = "esquerda";
		} else {
			sentido = "cima";
		}
		System.err.println("O "+(carro+1) + " o. carro esta seguindo no sentido para " + sentido);
		numero++;
	}
	
}
