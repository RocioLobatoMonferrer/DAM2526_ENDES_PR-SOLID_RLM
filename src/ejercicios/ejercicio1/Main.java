package ejercicios.ejercicio1;

public class Main {
	public static void main(String[] args) {
// Principio SRP
		Empleado empleado = new Empleado(1, "Juan Pérez", "Desarrollador");
		EmpleadoRepositorio repo = new EmpleadoRepositorio();
		EmpleadoInforme informe = new EmpleadoInforme();

		repo.guardarEmpleado(empleado);
		informe.generarInformeEmpleado(empleado);
		repo.eliminarEmpleado(empleado);
	}
}
