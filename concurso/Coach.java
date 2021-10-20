package concurso;

import java.util.ArrayList;
import java.util.Collections;

import concurso.filtros.Filtro;

public class Coach {
	private String nombre;
	private Comportamiento comportamiento;
	private ArrayList<Participante> equipo;

	public Coach(String nombre) {
		this.nombre = nombre;
		this.equipo = new ArrayList<>();
		this.comportamiento = new ComportamientoOK();
	}

	public void setComportamiento(Comportamiento comportamiento) {
		this.comportamiento = comportamiento;
	}

	public void setEquipo(ArrayList<Participante> equipo) {
		this.equipo = equipo;
	}

	public ArrayList<Participante> getListaParticipantes(Filtro f) {
		ArrayList<Participante> participantesFiltrados = new ArrayList<>();
		for (Participante p : equipo) {
			if (f.cumple(p)) {
				participantesFiltrados.add(p);
			}
		}
		return participantesFiltrados;
	}

	public void addParticipante(Participante p) {
		if (comportamiento.isParticipanteOK(p)) {
			if (!equipo.contains(p)) {
				equipo.add(p);
			}
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<String> getListaInstrumentos() {
		ArrayList<String> listaInstrumentos = new ArrayList<>();
		for (Participante p : equipo) {
			ArrayList<String> listaParticipante = p.getListaInstrumentos();
			for (String inst : listaParticipante) {
				if (!listaInstrumentos.contains(inst)) {
					listaInstrumentos.add(inst);
				}
			}
		}
		return listaInstrumentos;
	}

	public ArrayList<String> getListaIdiomas() {
		ArrayList<String> listaIdiomas = new ArrayList<>();
		for (Participante p : equipo) {
			ArrayList<String> listaParticipante = p.getListaIdiomas();
			for (String inst : listaParticipante) {
				if (!listaIdiomas.contains(inst)) {
					listaIdiomas.add(inst);
				}
			}
		}
		return listaIdiomas;
	}

	public ArrayList<String> getListaGeneros() {
		ArrayList<String> listaGeneros = new ArrayList<>();
		for (Participante p : equipo) {
			ArrayList<String> listaParticipante = p.getListaGeneros();
			for (String inst : listaParticipante) {
				if (!listaGeneros.contains(inst)) {
					listaGeneros.add(inst);
				}
			}
		}
		Collections.sort(listaGeneros);
		return listaGeneros;
	}

	public double getPromedioEdad() {
		double sumaEdad = 0;
		for (Participante p : equipo) {
			sumaEdad += p.getEdad();
		}
		return sumaEdad / (double) equipo.size();

	}

}
