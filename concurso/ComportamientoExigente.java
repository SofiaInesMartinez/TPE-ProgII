package concurso;

import concurso.filtros.Filtro;

public class ComportamientoExigente extends Comportamiento {
	private Filtro f;
	
	@Override
	public boolean isParticipanteOK(Participante p) {
		return f.cumple(p);
	}

	public ComportamientoExigente(Filtro f) {
		this.f = f;
	}
	

}
