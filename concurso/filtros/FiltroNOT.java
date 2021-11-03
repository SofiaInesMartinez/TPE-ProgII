package concurso.filtros;

import concurso.GrupoAbstracto;

public class FiltroNOT implements Filtro {
	private Filtro f1;

	public FiltroNOT(Filtro f1) {
		this.f1 = f1;
	}

	@Override
	public boolean cumple(GrupoAbstracto p) {
		return !f1.cumple(p);
	}

}