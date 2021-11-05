package concurso;
import java.util.ArrayList;

import concurso.filtros.Filtro;

public class TemaMusical {
	private String titulo;
	private ArrayList<String> generos;
	private ArrayList<String> instrumentosNecesarios;
	protected Filtro criterio;

	public TemaMusical(String titulo) {
		this.titulo = titulo;
		this.generos = new ArrayList<>();
		this.instrumentosNecesarios = new ArrayList<>();
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
	
	public boolean puedeSerInterpretado(GrupoAbstracto p) {
		return criterio.cumple(p);
	}

}
