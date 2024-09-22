import java.util.ArrayList;

public class Departamento {

    // Atributos
    private String nombre;
    private ArrayList<Empleado> empleados;

    // Constructor
    public Departamento(String nombre) {
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }
    // Agregar un empleado al departamento
    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    // Eliminar un empleado del departamento
    public void eliminarEmpleado(int id) throws Exception {
        for (Empleado e : empleados) {
            if (e.getId() == id) {
                empleados.remove(e);
                return;
            }
        }
        throw new Exception("Empleado no encontrado");
    }

    // Getters
    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public String getNombre() {
        return nombre;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
