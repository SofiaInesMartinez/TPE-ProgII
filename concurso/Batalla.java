package concurso;

import java.util.Comparator;

public class Batalla {
	private GrupoAbstracto p1;
	private GrupoAbstracto p2;
	private Comparator<GrupoAbstracto> criterio;
	
	public Comparator<GrupoAbstracto> getCriterio() {
		return criterio;
	}
	public void setCriterio(Comparator<GrupoAbstracto> criterio) {
		this.criterio = criterio;
	}
	public GrupoAbstracto getP1() {
		return p1;
	}
	public GrupoAbstracto getP2() {
		return p2;
	}
	public Batalla(GrupoAbstracto p1, GrupoAbstracto p2,
			Comparator<GrupoAbstracto> criterio) {
		super();
		this.p1 = p1;
		this.p2 = p2;
		this.criterio = criterio;
	}
	
	public String definirGanador() {
		int resultado = this.criterio.compare(p1, p2);
		if (resultado == -1) {
			return "Ganó participante 2.";
		} else {
			if (resultado == 1)
				return "Ganó participante 1.";
		}
		return "Empate.";
	}
	
	@Override
	public String toString() {
		return "Batalla [p1=" + p1 + ", p2=" + p2 + ", criterio=" + criterio
				+ "]";
	}
	
}
