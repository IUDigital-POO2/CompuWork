public class Empleado {
    //Atributos
    private String nombre;
    private String apellido;
    private int id;
    private String departamento;
    private String tipoEmpleado;

    //Constructor
    public Empleado(String nombre, String apellido, int id, String departamento, String tipoEmpleado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
        this.departamento = departamento;
        this.tipoEmpleado = tipoEmpleado;
    }

    //Getters y Setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getDepartamento() {
        return departamento;
    }
        public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getTipoEmpleado() {
        return tipoEmpleado;
    }
        public void setTipoEmpleado(String tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

    //Métodos
    //Método para cambiar el departamento de un empleado
    public void cambiarDepartamento(String nuevoDepartamento) {
        this.departamento = nuevoDepartamento;
    }

    //Método para cambiar el tipo de empleado
    public void cambiarTipoEmpleado(String nuevoTipoEmpleado) {
        this.tipoEmpleado = nuevoTipoEmpleado;
    }
}
