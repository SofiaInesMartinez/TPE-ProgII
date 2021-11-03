package concurso.filtros;

import concurso.GrupoAbstracto;

public class FiltroEdadMin implements Filtro {
	private int edadMin;

	@Override
	public boolean cumple(GrupoAbstracto p) {
		return p.getEdad() >= edadMin;
	}

	public FiltroEdadMin(int edadMin) {
		this.edadMin = edadMin;
	}

}
