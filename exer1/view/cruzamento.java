package view;

import java.util.concurrent.Semaphore;

import controller.threadscruzamento;

public class cruzamento {

	public static void main(String[] args) {
		Semaphore semaforo = new Semaphore(1);
		
		for(int i=0; i< 4; i++) {
			Thread cruzamento = new threadscruzamento(i, semaforo);
			cruzamento.start();
		}
		
	}

}
