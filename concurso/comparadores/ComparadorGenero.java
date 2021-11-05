package concurso.comparadores;

import java.util.Comparator;

import concurso.GrupoAbstracto;

public class ComparadorGenero implements Comparator<GrupoAbstracto> {

	@Override
	public int compare(GrupoAbstracto o1, GrupoAbstracto o2) {
		return o1.cantGeneros() - o2.cantGeneros();
	}

}