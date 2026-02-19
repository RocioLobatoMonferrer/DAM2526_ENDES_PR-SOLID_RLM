package ejercicios.ejercicio4;

import java.util.ArrayList;
import java.util.List;

public class InventarioService {

	private List<Libro> libros;

	public InventarioService() {
		this.libros = new ArrayList<>();
	}

	public void agregarLibro(String isbn, String titulo, String autor) {
		Libro libro;
		libro = new Libro(isbn, titulo, autor);
		libros.add(libro);
		System.out.println("Libro agregado: " + titulo);
	}

	public boolean eliminarPorIsbn(String isbn) {
		Libro libro;
		libro = buscarPorIsbn(isbn);

		if (libro == null) {
			System.out.println("No existe el libro con ISBN: " + isbn);
			return false;
		}

		libros.remove(libro);
		System.out.println("Libro eliminado: " + libro.getTitulo());
		return true;
	}

	public Libro buscarPorIsbn(String isbn) {
		Libro libro;

		for (int i = 0; i < libros.size(); i++) {
			libro = libros.get(i);
			if (libro.getIsbn().equals(isbn)) {
				return libro;
			}
		}

		return null;
	}

	public boolean estarDisponible(String isbn) {
		Libro libro;
		libro = buscarPorIsbn(isbn);

		if (libro == null) {
			return false;
		}

		return libro.getEstado().equals(EstadoLibro.DISPONIBLE);
	}

	public List<Libro> getLibros() {
		return libros;
	}
}
