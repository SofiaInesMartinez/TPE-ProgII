package concurso;

import java.util.ArrayList;
import java.util.Comparator;

import concurso.comparadores.ComparadorCompuesto;
import concurso.comparadores.ComparadorEdad;
import concurso.comparadores.ComparadorGenero;
import concurso.comparadores.ComparadorIdioma;
import concurso.comparadores.ComparadorInstrumento;
import concurso.filtros.Filtro;
import concurso.filtros.FiltroAND;
import concurso.filtros.FiltroEdadMin;
import concurso.filtros.FiltroGenero;
import concurso.filtros.FiltroIdioma;
import concurso.filtros.FiltroInstrumento;
import concurso.filtros.FiltroOR;
import concurso.filtros.FiltroTemaMusical;

public class MainConcurso {

	public static void main(String[] args) {
		
		ArrayList<String> rock = new ArrayList<String>();
		rock.add("Rock");
		rock.add("Rock alternativo");
		ArrayList<String> idiomas1 = new ArrayList<String>();
		idiomas1.add("Español");
		idiomas1.add("Ingles");
		ArrayList<String> instrumentos1 = new ArrayList<String>();
		instrumentos1.add("Guitarra");
		instrumentos1.add("Bajo");
		
		ArrayList<String> cumbia = new ArrayList<String>();
		cumbia.add("Cumbia");
		
		Participante p1 = new Participante("Santiago", 20, rock, idiomas1, instrumentos1);
		Participante p2 = new Participante("Agustina", 25, rock, idiomas1, instrumentos1);
		Participante p3 = new Participante("Gustavo", 51, rock, idiomas1, instrumentos1);
		
		Participante p7 = new Participante("L-gante", 21, cumbia, idiomas1, instrumentos1);
		Participante p8 = new Participante("Nicki Nicole", 20, cumbia, idiomas1, instrumentos1);
		Participante p9 = new Participante("Maria Becerra", 22, cumbia, idiomas1, instrumentos1);
		
		Grupo g1 = new Grupo("Rock cracks");
		g1.agregarIntegrante(p1);
		g1.agregarIntegrante(p2);
		g1.agregarIntegrante(p3);
		
		Coach c1 = new Coach("Mariel");
		c1.addParticipante(g1);
		c1.addParticipante(p7);
		c1.addParticipante(p8);
		
		ArrayList<String> pop = new ArrayList<String>();
		pop.add("Pop");
		pop.add("Electropop");
		pop.add("Synthpop");
		ArrayList<String> idiomas2 = new ArrayList<String>();
		idiomas2.add("Español");
		idiomas2.add("Ingles");
		idiomas2.add("Frances");
		ArrayList<String> instrumentos2 = new ArrayList<String>();
		instrumentos2.add("Bateria");
		instrumentos2.add("Teclado");
		
		Participante p4 = new Participante("Dua", 26, pop, idiomas2, instrumentos2);
		Participante p5 = new Participante("Miley", 28, pop, idiomas2, instrumentos2);
		
		Grupo g2 = new Grupo("Pop it");
		g2.agregarIntegrante(p4);
		g2.agregarIntegrante(p5);
		
		Filtro filtroIdioma1 = new FiltroIdioma("Ingles");
		Filtro filtroIdioma2 = new FiltroIdioma("Español");
		Filtro filtroAND1 = new FiltroAND(filtroIdioma1, filtroIdioma2);
		Filtro filtroGenero1 = new FiltroGenero("Pop");
		Filtro filtroGenero2 = new FiltroGenero("Balada");
		Filtro filtroInstrumento1 = new FiltroInstrumento("Bateria");
		Filtro filtroInstrumento2 = new FiltroInstrumento("Guitarra");
		Filtro filtroAND2 = new FiltroAND(filtroGenero1, filtroInstrumento1);
		Filtro filtroAND3 = new FiltroAND(filtroAND1, filtroAND2);
		Filtro filtroOR1 = new FiltroOR(filtroGenero2, filtroInstrumento2);
		Filtro filtroAND4 = new FiltroAND(filtroInstrumento2, filtroOR1);
		
		Coach c2 = new Coach("José", filtroAND3);
		c2.addParticipante(g2);
		c2.addParticipante(p9);
		
		System.out.println("Listado instrumentos (Coach 1): " + c1.getListaInstrumentosSinRepetir());
		System.out.println("Listado idiomas (Coach 1): " + c1.getListaIdiomasSinRepetir());
		System.out.println("Listado generos (Coach 1): " + c1.getListaGenerosSinRepetir());
		System.out.println("Promedio edad (Coach 1): " + c1.getPromedioEdad());
		
		System.out.println("Participantes que cantan en ingles (Coach 2): " + c2.buscar(filtroIdioma1));
		System.out.println("Participantes que prefieren rock (Coach 2): " + c2.buscar(new FiltroGenero("rock")));
		System.out.println("Participantes mayores de 28 años (Coach 2): " + c2.buscar(new FiltroEdadMin(28)));
		System.out.println("Participantes participantes que toquen guitarra y prefieran el género “balada” o que canten en inglés (Coach 2): " + c2.buscar(filtroAND4));
		
		Filtro filtroTema = new FiltroAND(filtroIdioma1, new FiltroGenero("Rock"));
		TemaMusical t1 = new TemaMusical("Dancing With Myself", "Ingles", filtroTema);
		t1.addGenero("Rock");
		t1.addInstrumento("Bajo");
		System.out.println("Participantes que tocan cierto tema (Coach 1): " + c1.buscar(new FiltroTemaMusical(t1)));
		
		TemaMusical t2 = new TemaFinal("Everywhere", "Ingles", filtroTema, 3);
		t2.addGenero("Rock");
		t2.addInstrumento("Bajo");
		t2.addInstrumento("Guitarra");
		System.out.println("Participantes que cumplen para cierto tema final (Coach 1): " + c1.buscar(new FiltroTemaMusical(t2)));
		
		Filtro filtroAND5 = new FiltroAND(filtroInstrumento1, filtroGenero1);
		Filtro filtroExigente = new FiltroAND(filtroAND1,filtroAND5);
		Coach c3 = new Coach("Martin", filtroExigente);
		
		Participante p6 = new Participante("Maria", 33, pop, idiomas1, instrumentos2);
		c3.addParticipante(p6);
		
		System.out.println("Batallas:");
		Comparator<GrupoAbstracto> comparadorInstrumento = new ComparadorInstrumento();
		Reality batalla1 = new Reality(comparadorInstrumento);
		System.out.println("El ganador de la primer batalla es: " + batalla1.definirGanador(c1.getMejorCandidato(comparadorInstrumento), c2.getMejorCandidato(comparadorInstrumento)));
		
		Comparator<GrupoAbstracto> comparadorGenero = new ComparadorGenero();
		Reality batalla2 = new Reality(comparadorGenero);
		System.out.println("El ganador de la segunda batalla es: " + batalla2.definirGanador(c1.getMejorCandidato(comparadorInstrumento), c2.getMejorCandidato(comparadorInstrumento)));
		
		Comparator<GrupoAbstracto> comparadorEdad = new ComparadorEdad();
		Reality batalla3 = new Reality(new ComparadorCompuesto(comparadorInstrumento, comparadorEdad));
		System.out.println("El ganador de la tercer batalla es: " + batalla3.definirGanador(c1.getMejorCandidato(comparadorInstrumento), c2.getMejorCandidato(comparadorInstrumento)));
		
		Comparator<GrupoAbstracto> comparadorIdioma = new ComparadorIdioma();
		Reality batalla4 = new Reality(new ComparadorCompuesto(comparadorEdad, comparadorIdioma));
		System.out.println("El ganador de la cuarta batalla es: " + batalla4.definirGanador(c1.getMejorCandidato(comparadorInstrumento), c2.getMejorCandidato(comparadorInstrumento)));
		
	}

}
