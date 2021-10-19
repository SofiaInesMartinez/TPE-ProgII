
public class FiltroGenero implements Filtro{
	private String genero;
	
	@Override
	public boolean cumple(Participante p) {
		return p.getGenero(genero);
	}

	public FiltroGenero(String genero) {
		this.genero = genero;
	}

}
