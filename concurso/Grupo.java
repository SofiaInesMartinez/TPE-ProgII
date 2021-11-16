package concurso;

import java.util.ArrayList;

import concurso.filtros.Filtro;

public class Grupo extends GrupoAbstracto {
	private ArrayList<GrupoAbstracto> integrantes;

	public Grupo(String nombre) {
		super(nombre);
		this.integrantes = new ArrayList<>();

	}

	@Override //obtiene la edad del grupo
	public int getEdad() {
		int edad = 0;
		for (GrupoAbstracto g : integrantes) {
			edad += g.getEdad();
		}
		return (int) (edad / this.calcularIntegrantes());
	}

	@Override //obtiene la cantidad total de integrantes del grupo
	public int calcularIntegrantes() {
		int cantIntegrantes = 0;
		for (GrupoAbstracto g : integrantes) {
			cantIntegrantes += g.calcularIntegrantes();
		}
		return cantIntegrantes;
	}

	@Override //verifica si algun integrante habla cierto idioma
	public boolean hablaIdioma(String idioma) {
		return this.getListaIdiomas().contains(idioma);
	}

	@Override //verifica si algun integrante prefiere cierto genero
	public boolean prefiereGenero(String genero) {
		return this.getListaGeneros().contains(genero);
	}

	@Override //verifica si algun integrante toca cierto instrumento
	public boolean tocaInstrumento(String instrumento) {
		return this.getListaInstrumentos().contains(instrumento);
	}

	@Override //obtiene el listado de generos que prefieren los integrantes
	public ArrayList<String> getListaGeneros() {
		ArrayList<String> generos = new ArrayList<>();
		if (integrantes.size() != 0) { //primero obtiene los generos que prefiere el primer integrante
			ArrayList<String> generosPrimerParticipante = integrantes.get(0).getListaGeneros();
			for (String g : generosPrimerParticipante) {
				int contador = 1; //por cada genero que prefiere se verifica si los demas integrantes tambien lo prefieren
				for (int i = 1; i < integrantes.size(); i++) {
					ArrayList<String> generosP = integrantes.get(i).getListaGeneros();
					if (generosP.contains(g)) //si tambien lo prefieren se aumenta el contador
						contador++;
				}
				if (contador == integrantes.size()) //si el contador es igual a la cantidad de integrantes es porque 
					generos.add(g);                 //todos prefieren el genero, entonces se agrega
			}

		}
		return generos;
	}

	@Override //obtiene el listado de idiomas que saben hablar los integrantes sin repetidos
	public ArrayList<String> getListaIdiomas() {
		ArrayList<String> idiomas = new ArrayList<>();
		for (GrupoAbstracto p : integrantes) {
			ArrayList<String> idiomasP = p.getListaIdiomas();
			for (String i : idiomasP) {
				if (!idiomas.contains(i))
					idiomas.add(i);
			}
		}
		return idiomas;
	}

	@Override //obtiene el listado de instrumentos que saben tocar los integrantes sin repetidos
	public ArrayList<String> getListaInstrumentos() {
		ArrayList<String> instrumentos = new ArrayList<>();
		for (GrupoAbstracto p : integrantes) {
			ArrayList<String> instrumentosP = p.getListaInstrumentos();
			for (String i : instrumentosP) {
				if (!instrumentos.contains(i))
					instrumentos.add(i);
			}
		}
		return instrumentos;
	}

	public void agregarIntegrante(GrupoAbstracto g) {
		if (!integrantes.contains(g)) {
			integrantes.add(g);
		}
	}

	public boolean tieneElementos() {
		return !integrantes.isEmpty();
	}

	@Override //este metodo realiza la busqueda de elementos que cumplan con cierto criterio
	public ArrayList<GrupoAbstracto> buscar(Filtro criterio) {
		ArrayList<GrupoAbstracto> participantesQueCumplen = new ArrayList<GrupoAbstracto>();
		if (criterio.cumple(this)) { //si el grupo cumple, devuelve el grupo
			Grupo g = new Grupo(this.getNombre());
			for (GrupoAbstracto i : integrantes) {
				g.agregarIntegrante(i);
			}
			participantesQueCumplen.add(g);
			return participantesQueCumplen;
		} else { //si el grupo no cumple, se busca cuales de sus miembros cumplen
			for (GrupoAbstracto p : integrantes)
				participantesQueCumplen.addAll(p.buscar(criterio));
		}
		return participantesQueCumplen;
	}

	@Override //este metodo obtiene la cantidad de miembros que tocan intrumentos de cierto tema
	public int cantMiembrosInstrumentos(TemaMusical t) {
		int cant = 0;
		for (GrupoAbstracto p : integrantes) {
			cant += p.cantMiembrosInstrumentos(t);
		}
		return cant;
	}

	@Override
	public int cantInstrumentos() {
		return this.getListaInstrumentos().size();
	}

	@Override
	public int cantGeneros() {
		return this.getListaGeneros().size();
	}

	@Override
	public int cantIdiomas() {
		return this.getListaIdiomas().size();
	}

}
