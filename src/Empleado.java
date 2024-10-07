import java.util.Date;

public abstract class Empleado {
    // Atributos
    private String nombre;
    private String apellido;
    private String id;
    private String tipoEmpleado;
    private Date fechaInicio;
    private ReporteDesempenio reporteDesempenio;

    // Constructor con departamento
    /*public Empleado(String nombre, String apellido, String id, String departamento, String tipoEmpleado, Date fechaInicio, ReporteDesempenio desempenio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
        this.departamento = departamento;
        this.tipoEmpleado = tipoEmpleado;
        this.fechaInicio = fechaInicio;
        this.desempenio = desempenio;
    }*/

    // Constructor  departamento
    public Empleado(String nombre, String apellido, String id, String tipoEmpleado, Date fechaInicio, ReporteDesempenio desempenio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
        this.tipoEmpleado = tipoEmpleado;
        this.fechaInicio = fechaInicio;
        this.reporteDesempenio = desempenio;
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

    public ReporteDesempenio getReporteDesempenio() {return reporteDesempenio;}

    public void setReporteDesempenio(ReporteDesempenio reporteDesempenio) {this.reporteDesempenio = reporteDesempenio;
    }

    // Métodos
    // Método abstracto para cambiar el departamento de un empleado
    public abstract void cambiarDepartamento(String nuevoDepartamento);

    // Método para cambiar el tipo de empleado
    public void cambiarTipoEmpleado(String nuevoTipoEmpleado) {
        this.tipoEmpleado = nuevoTipoEmpleado;
    }
}

