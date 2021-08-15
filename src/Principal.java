
public class Principal {
	
	public static final int CHEGADA = 30;

	public static void main(String[] args) {
		
		
		int numeroGrilos = 5;
		while(numeroGrilos > 0) {
			Thread t = new Thread(new Grilo("Grilo_" + numeroGrilos));
			t.start();
			numeroGrilos --;
		}
		
		
		
			
		// TODO Auto-generated method stub

	}

}
