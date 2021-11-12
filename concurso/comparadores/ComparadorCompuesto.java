package concurso.comparadores;

import java.util.Comparator;

import concurso.GrupoAbstracto;


public class ComparadorCompuesto implements Comparator<GrupoAbstracto> {
	private Comparator<GrupoAbstracto> c1;
	private Comparator<GrupoAbstracto> c2;
	
	

	public ComparadorCompuesto(Comparator<GrupoAbstracto> c1,
			Comparator<GrupoAbstracto> c2) {
		this.c1 = c1;
		this.c2 = c2;
	}



	@Override
	public int compare(GrupoAbstracto o1, GrupoAbstracto o2) {
		int res = c1.compare(o1, o2);
		if (res == 0) {
			return c2.compare(o1, o2);
		}
		return res;
	}

}