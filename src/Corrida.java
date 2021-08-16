import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Corrida {
	public int chegada;
	private int numeroGrilos;
	
	private Semaforo semaforo;
	private List<Time> times = new ArrayList<Time>();
	private Grilo[] vencedores;
	
	public Corrida() {
		
		Scanner in = new Scanner(System.in);
	
		
		System.out.println("Quantos Grilos irao correr?");
	    numeroGrilos=in.nextInt();
		System.out.println("O numero de participantes sao:" + numeroGrilos);
		
		
		System.out.println("Qual a distancia da linha de chegada?");
	    chegada=in.nextInt();
		System.out.println("a distancia da chegada e:" + chegada);

		in.close(); 
		
		vencedores = new Grilo[numeroGrilos];
		
		semaforo = new Semaforo();
		Thread t = new Thread(semaforo);
		t.start();
		
		for (int i = 0; i < numeroGrilos; i++) {
			t = new Thread(new Grilo("Grilo_" + i, this));
			t.start();
		}
	}
	
	public boolean tentarCruzarChegada(Grilo grilo) {
		if (grilo.getCaminhoPercorrido() >= chegada) {
			for (int i = 0; i < numeroGrilos; i++) {
				if (vencedores[i] == null) {
					vencedores[i] = grilo;
					System.out.println(grilo.getNome() + " foi o " + (i + 1) + "º colocado com " + grilo.getTotalPulo() + " pulos.");
					return true;
				}
			}	
		}
		
		return false;
	}
	
	public Semaforo getSemaforo() {
		return semaforo;
	}
}
