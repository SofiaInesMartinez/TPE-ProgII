package concurso.filtros;

import concurso.GrupoAbstracto;
import concurso.TemaMusical;

public class FiltroTemaMusical implements Filtro {
	private TemaMusical t;

	public FiltroTemaMusical(TemaMusical t) {
		this.t = t;
	}

	@Override
	public boolean cumple(GrupoAbstracto p) {
		return t.puedeSerInterpretado(p);
	}

}
