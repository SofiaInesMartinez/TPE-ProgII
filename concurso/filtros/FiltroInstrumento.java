package concurso.filtros;

import concurso.GrupoAbstracto;

public class FiltroInstrumento implements Filtro{
	private String instrumento;
	
	@Override
	public boolean cumple(GrupoAbstracto p) {
		return p.tocaInstrumento(instrumento);
	}

	public FiltroInstrumento(String instrumento) {
		this.instrumento = instrumento;
	}

}
