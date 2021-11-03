package concurso.filtros;

import concurso.GrupoAbstracto;

public class FiltroGenero implements Filtro{
	private String genero;
	
	@Override
	public boolean cumple(GrupoAbstracto p) {
		return p.prefiereGenero(genero);
	}

	public FiltroGenero(String genero) {
		this.genero = genero;
	}

}
