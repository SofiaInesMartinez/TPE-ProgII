package concurso.filtros;

import concurso.Participante;

public class FiltroEdadMin implements Filtro {
	private int edadMin;

	@Override
	public boolean cumple(Participante p) {
		return p.getEdad() >= edadMin;
	}

	public FiltroEdadMin(int edadMin) {
		this.edadMin = edadMin;
	}

}
