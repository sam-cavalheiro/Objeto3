import java.util.concurrent.Semaphore;

public class Semaforo implements Runnable {
	private static final int TEMPO_DE_ESPERA = 1000;
	
	private Semaphore semaphore = new Semaphore(1);
	private boolean estaContando;

	@Override
	public void run() {
		try {
			semaphore.acquire();
			estaContando = true;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		esperaContagem();
		System.out.println("3...");
		esperaContagem();
		System.out.println("2...");
		esperaContagem();
		System.out.println("1...");
		
		esperaContagem();
		System.out.println("INÍCIO DA CORRIDA!\n");
		
		semaphore.release();
		estaContando = false;
	}
	
	private void esperaContagem() {
		try {
			Thread.sleep(TEMPO_DE_ESPERA);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public boolean podeCorrer() {
		return !semaphore.hasQueuedThreads() && !estaContando;
	}
}
