package concurso.filtros;

import concurso.Participante;

public class FiltroIdioma implements Filtro{
	private String idioma;
	
	@Override
	public boolean cumple(Participante p) {
		return p.hablaIdioma(idioma);
	}

	public FiltroIdioma(String idioma) {
		this.idioma = idioma;
	}

	
}
