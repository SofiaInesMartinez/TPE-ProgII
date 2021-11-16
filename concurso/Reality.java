package concurso;

import java.util.Comparator;

public class Reality { 
	private Comparator<GrupoAbstracto> criterio;

	public void setCriterio(Comparator<GrupoAbstracto> criterio) {
		this.criterio = criterio;
	}

	public Reality(Comparator<GrupoAbstracto> criterio) {
		this.criterio = criterio;
	}
	
	// este metodo devuelve el ganador de la batalla segun un comparador
	public GrupoAbstracto definirGanador(GrupoAbstracto p1, GrupoAbstracto p2) {
		int resultado = this.criterio.compare(p1, p2);
		if (resultado <= -1)
			return p2;
		if (resultado >= 1)
			return p1;
		return null;
	}



}
