package ejercicios.ejercicio1;

public class Empleado {

	private int id;
	private String nombre;
	private String puesto;

	public Empleado(int id, String nombre, String puesto) {
		this.id = id;
		this.nombre = nombre;
		this.puesto = puesto;
	}

	public String getNombre() {
		return nombre;
	}

	public int getId() {
		return id;
	}

	public String getPuesto() {
		return puesto;
	}

}