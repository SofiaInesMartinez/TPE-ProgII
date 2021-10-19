package concurso.filtros;

import concurso.Participante;

public interface Filtro {
	public abstract boolean cumple(Participante p);
}
