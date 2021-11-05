package concurso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import concurso.filtros.Filtro;

public class Coach {
	private String nombre;
	private Filtro comportamiento;
	private ArrayList<GrupoAbstracto> equipo;

	public Coach(String nombre) {
		this.nombre = nombre;
		this.equipo = new ArrayList<>();
		this.comportamiento = null;
	}
	
	public Coach(String nombre, Filtro comportamiento) {
		this(nombre);
		this.equipo = new ArrayList<>();
		this.comportamiento = comportamiento;
	}
	

	public void setComportamiento(Filtro comportamiento) {
		this.comportamiento = comportamiento;
	}

	public void setEquipo(ArrayList<GrupoAbstracto> equipo) {
		this.equipo = equipo;
	}

	public ArrayList<GrupoAbstracto> getListaParticipantes(Filtro f) {
		ArrayList<GrupoAbstracto> participantesFiltrados = new ArrayList<>();
		for (GrupoAbstracto p : equipo) {
			if (f.cumple(p)) {
				participantesFiltrados.add(p);
			}
		}
		return participantesFiltrados;
	}

	public void addParticipante(GrupoAbstracto p) {
		if (!equipo.contains(p)) {
			if (comportamiento != null) {
				if (comportamiento.cumple(p)) {
					equipo.add(p);
				}
			} else
				equipo.add(p);
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<String> getListaInstrumentosSinRepetir() {
		ArrayList<String> listaInstrumentos = new ArrayList<>();
		for (GrupoAbstracto p : equipo) {
			ArrayList<String> listaParticipante = p.getListaInstrumentos();
			for (String inst : listaParticipante) {
				if (!listaInstrumentos.contains(inst)) {
					listaInstrumentos.add(inst);
				}
			}
		}
		return listaInstrumentos;
	}

	public ArrayList<String> getListaIdiomasSinRepetir() {
		ArrayList<String> listaIdiomas = new ArrayList<>();
		for (GrupoAbstracto p : equipo) {
			ArrayList<String> listaParticipante = p.getListaIdiomas();
			for (String idioma : listaParticipante) {
				if (!listaIdiomas.contains(idioma)) {
					listaIdiomas.add(idioma);
				}
			}
		}
		return listaIdiomas;
	}
	


	public ArrayList<String> getListaGenerosSinRepetir() {
		ArrayList<String> listaGeneros = new ArrayList<>();
		for (GrupoAbstracto p : equipo) {
			ArrayList<String> listaParticipante = p.getListaGeneros();
			for (String genero : listaParticipante) {
				if (!listaGeneros.contains(genero)) {
					listaGeneros.add(genero);
				}
			}
		}
		Collections.sort(listaGeneros);
		return listaGeneros;
	}

	public int getPromedioEdad() {
		int edad = 0;
		for (GrupoAbstracto p : equipo) {
			edad += p.getEdad();
		}
		return edad / equipo.size();

	}
	
	public ArrayList<GrupoAbstracto> getMejoresEquipo(Comparator<GrupoAbstracto> criterio) {
		ArrayList<GrupoAbstracto> listadoMejores = new ArrayList<>(equipo);
		Collections.sort(listadoMejores, criterio);
		return listadoMejores;
	}

}
