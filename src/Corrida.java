import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Corrida {
	public int chegada;
	private int numeroGrilos;
	
	private Semaforo semaforo;
	private Time[] times;
	private List<Grilo> vencedores = new ArrayList<Grilo>();
	
	public Corrida() {
		
		Scanner in = new Scanner(System.in);
	
		
		System.out.println("Quantos Grilos irao correr?");
	    numeroGrilos=in.nextInt();
		System.out.println("O numero de participantes sao: " + numeroGrilos);
		
		
		System.out.println("Qual a distancia da linha de chegada?");
	    chegada=in.nextInt();
		System.out.println("A distancia da chegada e: " + chegada);

		in.close(); 
		
		semaforo = new Semaforo();
		Thread t = new Thread(semaforo);
		t.start();
		
		GerenciadorTimes gerenciadorTimes = new GerenciadorTimes();
		
		for (int i = 0; i < numeroGrilos; i++) {
			Grilo g = new Grilo("Grilo_" + i, this);
			gerenciadorTimes.adicionaGrilo(g);
			t = new Thread(g);
			t.start();
		}
		
		times = gerenciadorTimes.finalizarEGetTimes();
	}
	
	public boolean tentarCruzarChegada(Grilo grilo) {
		if (grilo.getCaminhoPercorrido() >= chegada) {
			while (!semaforo.tryAcquire()) {
				// Loop infinito
			}
			
			vencedores.add(grilo);
			int quantiaVencedores = vencedores.size();
			
			System.out.println(grilo.getNome() + " foi o " + quantiaVencedores + "º colocado com " + grilo.getTotalPulo() + " pulos.");
			
			if (quantiaVencedores == numeroGrilos)
				finalizarCorrida();
			
			semaforo.release();
			
			return true;
		}
		
		return false;
	}
	
	private void finalizarCorrida() {
		System.out.println("\nFIM DA CORRIDA!");
		
		for (int i = 0; i < times.length; i++) {
			Time t = times[i];
			//t.test();
			System.out.println("[Time " + (i + 1) + "] Total de Pulos: " + t.getTotalPulos() +
								" | Total de caminho percorrido: " + t.getTotalCaminhoPercorrido());
		}
		
		Grilo vencedor = vencedores.get(0);
		for (int i = 0; i < times.length; i++) {
			Time t = times[i];
			if (vencedor.time == t) {
				System.out.println("\nO Time " + (i + 1) + " venceu a corrida! | " + vencedor.getNome() + " foi o primeiro colocado!");
				break;
			}
		}
	}
	
	public Semaforo getSemaforo() {
		return semaforo;
	}
}
