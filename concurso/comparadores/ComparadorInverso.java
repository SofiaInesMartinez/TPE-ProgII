package concurso.comparadores;

import java.util.Comparator;

import concurso.GrupoAbstracto;


public class ComparadorInverso implements Comparator<GrupoAbstracto> {
	private Comparator<GrupoAbstracto> c;
	
	

	public ComparadorInverso(Comparator<GrupoAbstracto> c) {
		this.c = c;
	}



	@Override
	public int compare(GrupoAbstracto o1, GrupoAbstracto o2) {
		return -c.compare(o1, o2);
	}

}