package ejercicios.ejercicio4;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaSistema {

	// "BD" interna acoplada (detalle)
	private List<Libro> libros;

	public BibliotecaSistema() {
		libros = new ArrayList<>();
	}

	public void eliminarLibro(String isbn) {
		Libro libro;
		libro = buscarPorIsbn(isbn);

		if (libro == null) {
			System.out.println("No existe el libro con ISBN: " + isbn);
			return;
		}

		libros.remove(libro);
		System.out.println("Libro eliminado: " + libro.getTitulo());
	}

	public boolean estaDisponible(String isbn) {
		Libro libro;
		libro = buscarPorIsbn(isbn);

		if (libro == null) {
			return false;
		}

		return libro.getEstado().equals("DISPONIBLE");
	}

	// Préstamos (responsabilidad 2)
	public void prestar(String isbn) {
		Libro libro;
		libro = buscarPorIsbn(isbn);

		if (libro == null) {
			System.out.println("No existe el libro con ISBN: " + isbn);
			return;
		}

		if (libro.getEstado().equals(EstadoLibro.DISPONIBLE)) {
			System.out.println("No se puede prestar: ya está prestado -> " + libro.getTitulo());
			return;
		}

		libro.setEstado(EstadoLibro.PRESTADO);
		System.out.println("Préstamo realizado: " + libro.getTitulo());
	}

	public void devolver(String isbn) {
		Libro libro;
		libro = buscarPorIsbn(isbn);

		if (libro == null) {
			System.out.println("No existe el libro con ISBN: " + isbn);
			return;
		}

		if (libro.getEstado().equals(EstadoLibro.DISPONIBLE)) {
			System.out.println("No se puede devolver: ya estaba disponible -> " + libro.getTitulo());
			return;
		}

		libro.setEstado(EstadoLibro.DISPONIBLE);
		System.out.println("Devolución realizada: " + libro.getTitulo());
	}

	// Informes (responsabilidad 3) + salida directa (detalle)
	public void imprimirInformeDetallado() {
		Libro libro;

		System.out.println("=== INFORME DETALLADO ===");
		for (int i = 0; i < libros.size(); i++) {
			libro = libros.get(i);
			System.out.println("- " + libro.getIsbn() + " | " + libro.getTitulo() + " | " + libro.getAutor() + " | "
					+ libro.getEstado());
		}
	}

	public void imprimirInformeDisponibles() {
		Libro libro;

		System.out.println("=== INFORME DISPONIBLES ===");
		for (int i = 0; i < libros.size(); i++) {
			libro = libros.get(i);
			if (libro.getEstado().equals("DISPONIBLE")) {
				System.out.println("- " + libro.getTitulo());
			}
		}
	}

	public void imprimirInformePrestados() {
		Libro libro;

		System.out.println("=== INFORME PRESTADOS ===");
		for (int i = 0; i < libros.size(); i++) {
			libro = libros.get(i);
			if (libro.getEstado().equals("PRESTADO")) {
				System.out.println("- " + libro.getTitulo());
			}
		}
	}
}