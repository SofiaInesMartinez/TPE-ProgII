package concurso.filtros;

import concurso.Participante;

public class FiltroInstrumento implements Filtro{
	private String instrumento;
	
	@Override
	public boolean cumple(Participante p) {
		return p.tocaInstrumento(instrumento);
	}

	public FiltroInstrumento(String instrumento) {
		this.instrumento = instrumento;
	}

}
