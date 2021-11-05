package concurso;

import java.util.ArrayList;

import concurso.filtros.Filtro;

public abstract class GrupoAbstracto {
	protected String nombre;

	public String getNombre() {
		return nombre;
	}
	
	public abstract int getEdad();
	
	public abstract ArrayList<String> getListaGeneros();
	
	public abstract ArrayList<String> getListaIdiomas();
	
	public abstract ArrayList<String> getListaInstrumentos();
	
	public abstract boolean hablaIdioma(String idioma);
	
	public abstract boolean prefiereGenero(String genero);
	
	public abstract boolean tocaInstrumento(String instrumento); 	
	
	public abstract int calcularIntegrantes();
	
	public abstract ArrayList<GrupoAbstracto> buscar(Filtro f);
	
	public abstract int cantMiembrosInstrumentos(TemaMusical t);
	
	public abstract int cantInstrumentos();
	
	public abstract int cantGeneros();
	
	public abstract int cantIdiomas();

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public GrupoAbstracto(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "GrupoAbstracto [nombre=" + nombre + "]";
	}	
	
}
