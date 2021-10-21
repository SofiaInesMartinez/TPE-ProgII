package concurso;
import java.util.ArrayList;
import java.util.Objects;

public class Participante {
	private String nombre;
	private String apellido;
	private int edad;
	private ArrayList<String> generosPreferidos;
	private ArrayList<String> idiomas;
	private ArrayList<String> instrumentos;

	public Participante(String nombre, String apellido, int edad) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.generosPreferidos = new ArrayList<>();
		this.idiomas = new ArrayList<>();
		this.instrumentos = new ArrayList<>();
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

	public boolean hablaIdioma(String idioma) {
		return idiomas.contains(idioma);
	}

	public boolean prefiereGenero(String genero) {
		return generosPreferidos.contains(genero);
	}

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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
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
		return Objects.equals(apellido, other.apellido) && Objects.equals(nombre, other.nombre);
	}
	

	@Override
	public String toString() {
		return "Participante [nombre=" + nombre + ", apellido=" + apellido + "]";
	}



}
