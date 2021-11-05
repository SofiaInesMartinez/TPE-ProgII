package concurso.comparadores;

import java.util.Comparator;

import concurso.GrupoAbstracto;

public class ComparadorIdioma implements Comparator<GrupoAbstracto> {

	@Override
	public int compare(GrupoAbstracto o1, GrupoAbstracto o2) {
		return o1.cantIdiomas() - o2.cantIdiomas();
	}

}