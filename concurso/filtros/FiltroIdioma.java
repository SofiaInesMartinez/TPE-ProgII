package concurso.filtros;

import concurso.GrupoAbstracto;

public class FiltroIdioma implements Filtro{
	private String idioma;
	
	@Override
	public boolean cumple(GrupoAbstracto p) {
		return p.hablaIdioma(idioma);
	}

	public FiltroIdioma(String idioma) {
		this.idioma = idioma;
	}

	
}
