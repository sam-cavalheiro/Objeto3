public class Corrida {
	public static final int CHEGADA = 30;
	private static final int NUMERO_GRILOS = 5;
	
	private Semaforo semaforo;
	private Grilo[] vencedores;
	
	public Corrida() {
		vencedores = new Grilo[NUMERO_GRILOS];
		
		for (int i = 0; i < NUMERO_GRILOS; i++) {
			new Grilo("Grilo_" + i, this);
		}
	}
	
	// TODO implementar semáforo nessa lógica
	public boolean tentarCruzarChegada(Grilo grilo) {
		if (grilo.getCaminhoPercorrido() >= CHEGADA) {
			for (int i = 0; i < NUMERO_GRILOS; i++) {
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
