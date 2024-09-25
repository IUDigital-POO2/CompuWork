import java.util.Date;

public abstract class Empleado {
    // Atributos
    private String nombre;
    private String apellido;
    private String id;
    private String departamento;
    private String tipoEmpleado;
    private Date fechaInicio;
    private ReporteDesempenio desempenio;

    // Constructor
    public Empleado(String nombre, String apellido, String id, String departamento, String tipoEmpleado, Date fechaInicio, ReporteDesempenio desempenio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
        this.departamento = departamento;
        this.tipoEmpleado = tipoEmpleado;
        this.fechaInicio = fechaInicio;
        this.desempenio = desempenio;
    }

    // Getters y Setters
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

    public String getId() {
        return id;
    }
    public void setId(String id) {
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

    public Date getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public ReporteDesempenio getDesempenio() {
        return desempenio;
    }
    public void setDesempenio(ReporteDesempenio desempenio) {
        this.desempenio = desempenio;
    }

    // Métodos
    // Método abstracto para cambiar el departamento de un empleado
    public abstract void cambiarDepartamento(String nuevoDepartamento);

    // Método para cambiar el tipo de empleado
    public void cambiarTipoEmpleado(String nuevoTipoEmpleado) {
        this.tipoEmpleado = nuevoTipoEmpleado;
    }
}

