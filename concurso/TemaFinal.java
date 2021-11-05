package concurso;

public class TemaFinal extends TemaMusical {
	private int cantidadParticipantes;
	
	public TemaFinal(String titulo, int cantidadParticipantes) {
		super(titulo);
		this.cantidadParticipantes = cantidadParticipantes;
	}
	
	public boolean puedeSerInterpretado(GrupoAbstracto p) {
		return criterio.cumple(p) && p.cantMiembrosInstrumentos(this) >= cantidadParticipantes;
	}

	public int getCantidadParticipantes() {
		return cantidadParticipantes;
	}
}
