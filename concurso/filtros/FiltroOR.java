package concurso.filtros;

import concurso.GrupoAbstracto;

public class FiltroOR implements Filtro {
	private Filtro f1;
	private Filtro f2;

	public FiltroOR(Filtro f1, Filtro f2) {
		this.f1 = f1;
		this.f2 = f2;
	}

	@Override
	public boolean cumple(GrupoAbstracto p) {
		return f1.cumple(p) || f2.cumple(p);
	}

}