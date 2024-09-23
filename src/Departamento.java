public class Departamento {
    private String nombreDepartamento;
    private String empleados;
    private String descripcion;
    private String jefe;

    public Departamento(String nombreDepartamento, String empleados, String descripcion, String jefe) {
        this.nombreDepartamento = nombreDepartamento;
        this.empleados = empleados;
        this.descripcion = descripcion;
        this.jefe = jefe;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    public String getEmpleados() {
        return empleados;
    }

    public void setEmpleados(String empleados) {
        this.empleados = empleados;
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

    @Override
    public String toString() {
        return "Departamento{" +
                "nombreDepartamento='" + nombreDepartamento + '\'' +
                ", empleados='" + empleados + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", jefe='" + jefe + '\'' +
                '}';
    }
}
