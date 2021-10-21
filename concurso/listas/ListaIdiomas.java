package concurso.listas;

import java.util.ArrayList;
import concurso.Participante;

public class ListaIdiomas extends Lista {

	@Override
	public ArrayList<String> getLista(Participante p) {
		return p.getListaIdiomas();
	}

}
