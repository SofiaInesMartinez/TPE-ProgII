package concurso;
import java.util.ArrayList;

public class TemaMusical {
	private String titulo;
	private ArrayList<String> generos;
	private ArrayList<String> instrumentosNecesarios;

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

	public void addInstrumento(String instrumento) {
		if (!instrumentosNecesarios.contains(instrumento)) {
			instrumentosNecesarios.add(instrumento);
		}
	}

}
