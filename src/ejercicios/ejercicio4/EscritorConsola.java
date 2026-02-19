package ejercicios.ejercicio4;

public class EscritorConsola implements IEscritor {

	@Override
	public void escribir(String texto) {
		System.out.println(texto);
	}
}
