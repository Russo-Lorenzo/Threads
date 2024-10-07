

// Il programma deve garantire che i dati prodotti vengo consumati in ordine FIFO e che non vi devono essere perdite dei dati prodotti dal Consumatore.

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Buffer buffer = new Buffer();
		Produttore p = new Produttore(buffer);
		Consumatore c = new Consumatore(buffer);
		
		p.start();
		c.start();
		
	}

}
