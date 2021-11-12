package concurso;

public class TemaFinal extends TemaMusical {
	private int cantidadParticipantes;
	
	public TemaFinal(String titulo, int cantidadParticipantes) {
		super(titulo);
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
