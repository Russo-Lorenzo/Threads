import java.util.Random;



//Produttore: genera all’infinito un numero casuale tra 0 e 1023 ogni Xms, dove X è un numero casuale tra 100 e 1000. 

public class Produttore extends Thread implements Runnable {
	
	Random r = new Random();
	int xms, random;											// Variabile dei millisecondi randomici da aspettare e numero random generato
	Buffer buffer;												// Variabile per interagire con l'istanza del buffer
	
	public Produttore(Buffer b) {								
		xms = r.nextInt(901) + 1000;							// Randomizzo i millisecondi da aspettare
		this.buffer = b;
	}
	
	@Override
	public void run() {
		while(true) {							
			random = r.nextInt(1024);							// Genero il numero random tra 0 e 1023
			buffer.putValue(random);							// Inserisco il valore nel buffer
			
			try {
				sleep(xms);										// Aspetto x millisecondi
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}	
}
