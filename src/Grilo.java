import java.util.Random;
public class Grilo implements Runnable {
    
	private static final int TAMANHO_MINIMO_PULO = 1;
	private static final int TAMANHO_MAXIMO_PULO = 10;
	
	private static final int RESETAR_TEMPO_MINIMO = 500;
	private static final int RESETAR_TEMPO_MAXIMO = 3000;
	
	private Corrida corrida;
	
    private String nomeGrilo;
    private int tamanhoPulo = 1;
    private int totalPulo;
    private int caminhoPercorrido;
    //private int contadorTempo;
    //private int Principal.CHEGADA = 10;
    //boolean chegada = false;
    
    private Thread thread;

    public Grilo(String nomeGrilo, Corrida corrida) {
    	this.nomeGrilo = nomeGrilo;
    	this.corrida = corrida;
    	
    	thread = new Thread(this, nomeGrilo);
    	thread.start();
    }
    
    public void pula() 
    { 	
    	if (!corrida.getSemaforo().isFair()) {
    		System.out.println("NÃO VAI CORRER NÃO");
    		return;
    	}
    	
        totalPulo +=1;
        caminhoPercorrido = caminhoPercorrido+tamanhoPulo;
        System.out.println(nomeGrilo + " pulou " + tamanhoPulo + "cm e já percorreu " + caminhoPercorrido + "cm.");
        
        if (!corrida.tentarCruzarChegada(this))
        	thread.run();
    }

    public String getNome() {
    	return nomeGrilo;
    }
    
    public int getTotalPulo() {
    	return totalPulo;
    }
    
    public int getCaminhoPercorrido() {
    	return caminhoPercorrido;
    }
    
	@Override
	public void run() {
    	Random random = new Random();
		
    	try {
			Thread.sleep(RESETAR_TEMPO_MINIMO + random.nextInt(RESETAR_TEMPO_MAXIMO - RESETAR_TEMPO_MINIMO));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	
    	tamanhoPulo = TAMANHO_MINIMO_PULO + random.nextInt(TAMANHO_MAXIMO_PULO - TAMANHO_MINIMO_PULO);
    	pula();
	}

}