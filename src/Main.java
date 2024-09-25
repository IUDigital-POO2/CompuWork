import java.util.Date;

public class Main {
    public static void main(String[] args) {

        //Crear empleados permanentes
        EmpleadoPermanente empleado1 = new EmpleadoPermanente("John Eduar", "Perez", "001", "Ventas", "Permanente", new Date());
        EmpleadoPermanente empleado2 = new EmpleadoPermanente("Juan Esteban", "Osorno", "002", "Marketing", "Permanente", new Date());
        EmpleadoPermanente empleado3 = new EmpleadoPermanente("Cristian", "Vargas", "003", "Ventas", "Permanente", new Date());

        //Crear empleados temporales
        EmpleadoTemporal empleado4 = new EmpleadoTemporal("David", "Lopez", "004", "Marketing", "Temporal", new Date(), new Date());
        EmpleadoTemporal empleado5 = new EmpleadoTemporal("Juliana", "Correa", "005", "Ventas", "Temporal", new Date(), new Date());

        //Cambiar departamento
        empleado1.cambiarDepartamento("Recursos Humanos");
        empleado3.cambiarDepartamento("Finanzas");


        //Mostar los datos del empleado
        System.out.println("Empleado " + empleado1.getId() + ": " + empleado1.getNombre() + " " + empleado1.getApellido() + " - " + empleado1.getDepartamento());
        System.out.println("Empleado " + empleado2.getId() + ": " + empleado2.getNombre() + " " + empleado2.getApellido() + " - " + empleado2.getDepartamento());
        System.out.println("Empleado " + empleado3.getId() + ": " + empleado3.getNombre() + " " + empleado3.getApellido() + " - " + empleado3.getDepartamento());
        System.out.println("Empleado " + empleado4.getId() + ": " + empleado4.getNombre() + " " + empleado4.getApellido() + " - " + empleado4.getDepartamento());
        System.out.println("Empleado " + empleado5.getId() + ": " + empleado5.getNombre() + " " + empleado5.getApellido() + " - " + empleado5.getDepartamento());



    }
}