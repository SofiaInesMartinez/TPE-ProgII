import java.util.ArrayList;

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

	public boolean getIdioma(String idioma) {
		return idiomas.contains(idioma);
	}

	public boolean getGenero(String genero) {
		return generosPreferidos.contains(genero);
	}

	public boolean getInstrumento(String instrumento) {
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
	public boolean equals(Object o) {
		return this.getNombre().equals(((Participante) o).getNombre());
	}

	@Override
	public String toString() {
		return "Participante [nombre=" + nombre + ", apellido=" + apellido + "]";
	}

}
