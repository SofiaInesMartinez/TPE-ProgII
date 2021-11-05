package concurso.comparadores;

import java.util.Comparator;

import concurso.GrupoAbstracto;

public class ComparadorInstrumento implements Comparator<GrupoAbstracto> {

	@Override
	public int compare(GrupoAbstracto o1, GrupoAbstracto o2) {
		return o1.cantInstrumentos() - o2.cantInstrumentos();
	}

}
