public class Main {
        public static void main(String[] args) {
            // Crear algunos empleados
            Empleado emp1 = new Empleado("Juan Pérez", 1, "Permanente");
            Empleado emp2 = new Empleado("Ana López", 2, "Temporal");
            Empleado emp3 = new Empleado("Carlos Ruiz", 3, "Permanente");

            // Crear un departamento
            Departamento departamentoIT = new Departamento("IT");

            // Asignar empleados al departamento
            departamentoIT.agregarEmpleado(emp1);
            departamentoIT.agregarEmpleado(emp2);
            departamentoIT.agregarEmpleado(emp3);

            // Generar y mostrar reportes de desempeño individuales
            System.out.println(ReporteDesempenio.generarReporte(emp1));
            System.out.println(ReporteDesempenio.generarReporte(emp2));
            System.out.println(ReporteDesempenio.generarReporte(emp3));

            // Generar y mostrar reporte de desempeño del departamento IT
            System.out.println("\nReporte de Desempeño del Departamento " + departamentoIT.getNombre() + ":");
            System.out.println(ReporteDesempenio.generarReporte(departamentoIT));
        }
}