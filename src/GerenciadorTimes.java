import java.util.ArrayList;
import java.util.List;

public class GerenciadorTimes {
	private static final int GRILOS_POR_TIME = 3;

	private List<Time> times = new ArrayList<Time>();
	private Grilo[] grilos = new Grilo[GRILOS_POR_TIME];

	public void adicionaGrilo(Grilo grilo) {
		for (int i = 0; i < GRILOS_POR_TIME; i++) {
			if (grilos[i] == null) {
				grilos[i] = grilo;
				return;
			}
		}

		Grilo[] _grilos = new Grilo[GRILOS_POR_TIME];
		System.arraycopy(grilos, 0, _grilos, 0, GRILOS_POR_TIME);
		Time time = new Time(_grilos);
		times.add(time);

		grilos[0] = grilo;
		for (int i = 1; i < GRILOS_POR_TIME; i++) {
			grilos[i] = null;
		}
	}

	public Time[] finalizarEGetTimes() {
		if (grilos[0] != null) {
			Grilo[] _grilos = new Grilo[GRILOS_POR_TIME];
			System.arraycopy(grilos, 0, _grilos, 0, GRILOS_POR_TIME);
			Time novoTime = new Time(_grilos);
			times.add(novoTime);
		}

		Time[] _times = new Time[times.size()];

		times.toArray(_times);
		return _times;
	}
}
