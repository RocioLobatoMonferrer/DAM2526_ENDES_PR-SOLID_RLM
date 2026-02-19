package ejercicios.ejercicio4;

import java.util.ArrayList;
import java.util.List;

public class InformeService {
	public String informeDetallado(List<Libro> libros) {
		return listar(libros);
	}

	public String informeDisponible(List<Libro> libros) {
		return listar(filtrarPorEstado(libros, EstadoLibro.DISPONIBLE));
	}

	public String informePrestados(List<Libro> libros) {
		return listar(filtrarPorEstado(libros, EstadoLibro.PRESTADO));
	}

	private List<Libro> filtrarPorEstado(List<Libro> libros, EstadoLibro estado) {
		List<Libro> filtrados = new ArrayList<>();
		for (Libro libro : libros) {
			if (libro.getEstado() == estado) {
				filtrados.add(libro);
			}
		}
		return filtrados;
	}

	private String listar(List<Libro> libros) {
		StringBuilder lista = new StringBuilder();

		for (Libro libro : libros) {
			lista.append("- " + libro.getTitulo());
		}
		return lista.toString();
	}

}
