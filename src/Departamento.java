import java.util.ArrayList;

public class Departamento {
    private String nombreDepartamento;
    private String descripcion;
    private String jefe;
    private ArrayList<Empleado> empleados;

    public Departamento(String nombreDepartamento, String descripcion, String jefe) {
        this.nombreDepartamento = nombreDepartamento;
        this.descripcion = descripcion;
        this.jefe = jefe;
        //this.empleados = new ArrayList<>();
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getJefe() {
        return jefe;
    }

    public void setJefe(String jefe) {
        this.jefe = jefe;
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "nombreDepartamento='" + nombreDepartamento + '\'' +
                ", empleados='" + empleados + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", jefe='" + jefe + '\'' +
                '}';
    }

    // Agregar un empleado al departamento
    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    // Eliminar un empleado del departamento
    public void eliminarEmpleado(String id) throws Exception {
        for (Empleado e : empleados) {
            if (e.getId() == id) {
                empleados.remove(e);
                return;
            }
        }
        throw new Exception("Empleado no encontrado");
    }
}