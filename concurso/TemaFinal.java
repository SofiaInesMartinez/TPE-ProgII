package concurso;

import concurso.filtros.Filtro;

public class TemaFinal extends TemaMusical {
	private int cantidadParticipantes;
	
	public TemaFinal(String titulo, String idioma, Filtro criterio, int cantidadParticipantes) {
		super(titulo, idioma, criterio);
		this.cantidadParticipantes = cantidadParticipantes;
	}
	
	public boolean puedeSerInterpretado(GrupoAbstracto p) {
		//super.puedeSerInterpretado
		//Criterio instrumento, con contador que si cumple con cant de participantes return true;
		return criterio.cumple(p) && p.cantMiembrosInstrumentos(this) >= cantidadParticipantes;
	}

	public int getCantidadParticipantes() {
		return cantidadParticipantes;
	}
}
