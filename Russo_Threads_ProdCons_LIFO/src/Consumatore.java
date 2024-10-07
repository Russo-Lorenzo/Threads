
// Consumatore: deve consumare i numeri generati dal Produttore e ogni volta che li consuma stampa il numero letto e stampa una statistica dei numeri pari e dei numeri
// dispari letti


public class Consumatore extends Thread implements Runnable {
	
	int num, odd = 0, even = 0;										// Creo una variabile per il numero creato, una per contare i dispari e una per i pari
	Buffer buffer;														
	
	public Consumatore(Buffer b) {
		this.buffer = b;											// Mi salvo l'istanza del buffer da cui prenderò i numeri generati
	}
	
	@Override
	public void run() {
		while(true) {	
			num = buffer.getValue();								// Prendo il numero dal buffer
			
			if(num % 2 == 0) {										// Controllo se è pari
				even ++;											// Incremento il conta dei pari
			}else {
				odd++;												// Sennò i dispari
			}
			
			System.out.println("Numero letto: " + num + "\nNumeri pari: " + even + "\nNumeri dispari: " + odd + "\n\n");
		}
	}

}
