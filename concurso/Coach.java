package concurso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import concurso.comparadores.ComparadorInverso;
import concurso.filtros.Filtro;

public class Coach {
	private String nombre;
	private Filtro comportamiento;
	private ArrayList<GrupoAbstracto> equipo;
	
	//Constructores coach
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

	//este metodo realiza la busqueda de participantes que cumplen con cierto criterio
	public ArrayList<GrupoAbstracto> buscar(Filtro f) { 
		ArrayList<GrupoAbstracto> participantesFiltrados = new ArrayList<>();
		for (GrupoAbstracto p : equipo) {
			if (f.cumple(p)) {
				participantesFiltrados.add(p);
			}
		}
		return participantesFiltrados;
	}
	
	public void addParticipante(GrupoAbstracto p) { //agrega nuevos integrantes al equipo 
		if (!equipo.contains(p)) {					//de acuerdo a un comportamiento de exigencia
			if (comportamiento != null) {
				if (comportamiento.cumple(p)) {
					equipo.add(p);
				}
			} else
				equipo.add(p);  //si el comportamiento es null, agrega sin condiciones (solo controla que no este ya en el equipo) 
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	//este metodo devuelve el listado de instrumentos que toca el equipo sin repetidos
	public ArrayList<String> getListaInstrumentosSinRepetir() {
		ArrayList<String> listaInstrumentos = new ArrayList<>(); //crea arraylist vacio
		for (GrupoAbstracto p : equipo) {
			ArrayList<String> listaParticipante = p.getListaInstrumentos(); //pide lista de instrumentos de cada integrante
			for (String inst : listaParticipante) {
				if (!listaInstrumentos.contains(inst)) { //si el intrumento todavia no fue agregado, lo agrega
					listaInstrumentos.add(inst);
				}
			}
		}
		return listaInstrumentos; //devuelve la lista de instrumentos como la union de los instrumentos de los integrantes
	}
	
	//realiza lo mismo que el metodo de instrumentos pero con idiomas
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
	
	//realiza lo mismo que el metodo de instrumentos pero con generos
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
		Collections.sort(listaGeneros); //y ademas los ordena alfabeticamente
		return listaGeneros;
	}
	
	//este metodo obtiene el promedio de la edad del equipo
	public int getPromedioEdad() {
		int edad = 0;
		for (GrupoAbstracto p : equipo) {
			edad += p.getEdad();
		}
		return edad / equipo.size(); //promedio = total de edad divido el tamaño del equipo

	}

	//obtiene un listado de mejores a peores en el equipo segun el criterio para ganar una batalla
	public ArrayList<GrupoAbstracto> getMejoresEquipo(Comparator<GrupoAbstracto> criterio) {
		Comparator<GrupoAbstracto> criterioDescendente = new ComparadorInverso(criterio); //se invierte el criterio para que el mejor se encuentre primero
		ArrayList<GrupoAbstracto> listadoMejores = new ArrayList<>(equipo);
		Collections.sort(listadoMejores, criterioDescendente);
		return listadoMejores;
	}
	
	//este metodo obtiene el primer elemento del listado de mejores del equipo segun un criterio,
	//el cual seria el mejor asi este compite en la batalla
	public GrupoAbstracto getMejorCandidato(Comparator<GrupoAbstracto> criterio) {
		ArrayList<GrupoAbstracto> listadoMejores = this.getMejoresEquipo(criterio);
		if (!listadoMejores.isEmpty()) {
			return listadoMejores.get(0);
		}
		return null;
	}

}
