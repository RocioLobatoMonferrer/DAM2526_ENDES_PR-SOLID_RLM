package ejercicios.ejercicio1;

public class EmpleadoRepositorio {

	public void guardarEmpleado(Empleado empleado) {
		System.out.println("Conectando a la base de datos...");
		System.out.println("Empleado " + empleado.getNombre() + " guardado");
	}

	public void eliminarEmpleado(Empleado empleado) {
		System.out.println("Conectando a la base de datos...");
		System.out.println("Empleado " + empleado.getNombre() + " eliminado");
	}
}
