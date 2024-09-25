public class Main {
        public static void main(String[] args) {
            // Generar y mostrar reportes de desempeño individuales
            System.out.println("\nReporte de Desempeño de los Empleados:");
            System.out.println(ReporteDesempenio.generarReporte(empleado1));
            System.out.println(ReporteDesempenio.generarReporte(empleado2));
            System.out.println(ReporteDesempenio.generarReporte(empleado3));

            // Generar y mostrar reporte de desempeño del departamento IT
            System.out.println("\nReporte de Desempeño del Departamento " + departamentoIT.getNombreDepartamento() + ":");
            System.out.println(ReporteDesempenio.generarReporte(departamentoIT));
        }
}