package concurso;

import java.util.ArrayList;

public class Grupo extends GrupoAbstracto {
	private ArrayList<GrupoAbstracto> integrantes;

	public Grupo(String nombre, ArrayList<GrupoAbstracto> integrantes) {
		super(nombre);
		this.integrantes = new ArrayList<>(integrantes);

	}

	@Override
	public int getEdad() {
		int edad = 0;
		for (GrupoAbstracto g : integrantes) {
			edad += g.getEdad();
		}
		return (int) (edad / this.calcularIntegrantes());
	}

	@Override
	public int calcularIntegrantes() {
		int cantIntegrantes = 0;
		for (GrupoAbstracto g : integrantes) {
			cantIntegrantes += g.calcularIntegrantes();
		}
		return cantIntegrantes;
	}

	@Override
	public boolean hablaIdioma(String idioma) {
		return this.getListaIdiomas().contains(idioma);
	}

	@Override
	public boolean prefiereGenero(String genero) {
		return this.getListaGeneros().contains(genero);
	}

	@Override
	public boolean tocaInstrumento(String instrumento) {
		return this.getListaInstrumentos().contains(instrumento);
	}

	@Override
	public ArrayList<String> getListaGeneros() {
		ArrayList<String> generos = new ArrayList<>();
		if (integrantes.size() != 0) {
			ArrayList<String> generosPrimerParticipante = integrantes.get(0).getListaGeneros();
			for (String g : generosPrimerParticipante) {
				int contador = 1;
				for (int i = 1; i < integrantes.size(); i++) {
					ArrayList<String> generosP = integrantes.get(i).getListaGeneros();
					if (generosP.contains(g))											
						contador++;
				}
				if (contador == integrantes.size())
					generos.add(g);
			}

		}
		return generos;
	}

	
	
	
	
	@Override
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

	@Override
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

}
