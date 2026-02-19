package ejercicios.ejercicio4;

public class PrestamoService {
	private InventarioService inventario;

	public PrestamoService(InventarioService inventario) {
		this.inventario = inventario;
	}

	public boolean prestar(String isbn) {
		Libro libro = inventario.buscarPorIsbn(isbn);

		if (libro == null) {
			System.out.println("No existe el libro con ISBN: " + isbn);
			return false;
		}

		if (libro.getEstado().equals(EstadoLibro.DISPONIBLE)) {
			System.out.println("No se puede prestar: ya está prestado -> " + libro.getTitulo());
			return false;
		}

		libro.setEstado(EstadoLibro.PRESTADO);
		System.out.println("Préstamo realizado: " + libro.getTitulo());
		return true;
	}

	public boolean devolver(String isbn) {
		Libro libro = inventario.buscarPorIsbn(isbn);

		if (libro == null) {
			System.out.println("No existe el libro con ISBN: " + isbn);
			return false;
		}

		if (libro.getEstado().equals(EstadoLibro.DISPONIBLE)) {
			System.out.println("No se puede devolver: ya estaba disponible -> " + libro.getTitulo());
			return false;
		}

		libro.setEstado(EstadoLibro.DISPONIBLE);
		System.out.println("Devolución realizada: " + libro.getTitulo());
		return true;
	}
}
