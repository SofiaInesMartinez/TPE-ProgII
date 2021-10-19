package concurso.filtros;

import concurso.Participante;

public class FiltroNOT implements Filtro {
	private Filtro f1;

	public FiltroNOT(Filtro f1) {
		this.f1 = f1;
	}

	@Override
	public boolean cumple(Participante p) {
		return !f1.cumple(p);
	}

}