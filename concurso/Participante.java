package concurso;
import java.util.ArrayList;
import java.util.Objects;

public class Participante extends GrupoAbstracto{
	private int edad;
	private ArrayList<String> generosPreferidos;
	private ArrayList<String> idiomas;
	private ArrayList<String> instrumentos;


	public Participante(String nombre, int edad, ArrayList<String> generosPreferidos,
			ArrayList<String> idiomas, ArrayList<String> instrumentos) {
		super(nombre);
		this.edad = edad;
		this.generosPreferidos = new ArrayList<>(generosPreferidos);
		this.idiomas = new ArrayList<>(idiomas);
		this.instrumentos = new ArrayList<>(instrumentos);
	}

	public ArrayList<String> getListaInstrumentos() {
		ArrayList<String> lista = new ArrayList<>(instrumentos);
		return lista;
	}
	
	public ArrayList<String> getListaIdiomas() {
		ArrayList<String> lista = new ArrayList<>(idiomas);
		return lista;
	}

	public ArrayList<String> getListaGeneros() {
		ArrayList<String> lista = new ArrayList<>(generosPreferidos);
		return lista;
	}

	@Override
	public boolean hablaIdioma(String idioma) {
		return idiomas.contains(idioma);
	}

	@Override
	public boolean prefiereGenero(String genero) {
		return generosPreferidos.contains(genero);
	}

	@Override
	public boolean tocaInstrumento(String instrumento) {
		return instrumentos.contains(instrumento);
	}

	public void addGenero(String genero) {
		if (!generosPreferidos.contains(genero)) {
			generosPreferidos.add(genero);
		}
	}

	public void addInstrumento(String instrumento) {
		if (!instrumentos.contains(instrumento)) {
			instrumentos.add(instrumento);
		}
	}

	public void addIdioma(String idioma) {
		if (!idiomas.contains(idioma)) {
			idiomas.add(idioma);
		}
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Participante other = (Participante) obj;
		return Objects.equals(nombre, other.nombre);
	}
	

	@Override
	public String toString() {
		return "Participante [nombre=" + nombre + "]";
	}

	@Override
	public int calcularIntegrantes() {
		// TODO Auto-generated method stub
		return 1;
	}



}
