
public class Time {
	private Grilo[] grilos;
	
	public Time(Grilo[] grilos) {
		this.grilos = grilos;
		for (int i = 0; i < grilos.length; i++) {
			if (grilos[i] == null)
				break;
			grilos[i].time = this;
		}
	}
	
	public void test() {
		String nomes = "";
		for (int i = 0; i < grilos.length; i++) {
			if (grilos[i] != null)
				nomes += grilos[i].getNome();
		}
		
		System.out.println("Teste: " + nomes);
	}
	
	public int getTotalPulos() {
		int totalPulos = 0;
		
		for (int i = 0; i < grilos.length; i++) {
			if (grilos[i] == null)
				break;
			totalPulos += grilos[i].getTotalPulo();
		}
		return totalPulos;
	}
	
	public int getTotalCaminhoPercorrido() {
		int totalCaminhoPercorrido = 0;
		
		for (int i = 0; i < grilos.length; i++) {
			if (grilos[i] == null)
				break;
			totalCaminhoPercorrido += grilos[i].getCaminhoPercorrido();
		}
		return totalCaminhoPercorrido;
	}
}
