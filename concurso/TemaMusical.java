package concurso;

import java.util.ArrayList;

import concurso.filtros.Filtro;

public class TemaMusical {
	protected String titulo;
	protected ArrayList<String> generos;
	protected ArrayList<String> instrumentosNecesarios;
	private String idioma;
	protected Filtro criterio;

	public TemaMusical(String titulo, String idioma, Filtro criterio) {
		this.titulo = titulo;
		this.generos = new ArrayList<>();
		this.instrumentosNecesarios = new ArrayList<>();
		this.idioma = idioma;
		this.criterio = criterio;
	}

	
	public String getIdioma() {
		return idioma;
	}


	public Filtro getCriterio() {
		return criterio;
	}



	public void setCriterio(Filtro criterio) {
		this.criterio = criterio;
	}



	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}



	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void addGenero(String genero) {
		if (!generos.contains(genero)) {
			generos.add(genero);
		}
	}

	public ArrayList<String> getInstrumentosNecesarios() {
		return new ArrayList<String>(instrumentosNecesarios);
	}

	public void addInstrumento(String instrumento) {
		if (!instrumentosNecesarios.contains(instrumento)) {
			instrumentosNecesarios.add(instrumento);
		}
	}

	// este metodo verifica si grupo/banda/solista pasado por parametro 
	// cumple con el criterio de interpretacion del tema
	public boolean puedeSerInterpretado(GrupoAbstracto p) {
		return criterio.cumple(p);
	}

}
