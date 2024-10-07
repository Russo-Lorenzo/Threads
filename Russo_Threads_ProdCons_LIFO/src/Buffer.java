import java.util.LinkedList;
import java.util.Deque;

public class Buffer {
	
	private int limit = 10;
	private Deque<Integer> queue = new LinkedList<>();
	
	
	public synchronized void putValue(int n){
		
		if(queue.size() == limit) {									// Controllo se la lunghezza della mia coda è uguale a 10
			try {
				wait();												// Se è vero e quindi il mio buffer è pieno aspetto che il ricevitore prenda dei valori
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		this.queue.add(n);											// Se non è pieno aggiungo il mio valore n alla coda
		notify();
	}
	
	public synchronized int getValue() {
		if(queue.isEmpty() == true) {								// Controllo se il mio buffer è vuoto
            try {
                wait();  											// Se lo è aspetto che venga inserito un valore
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
		
		notify();													// Risveglio il produttore
		return queue.pollLast();									// Do l'ultimo numero della coda al consumatore
	}
	
}
