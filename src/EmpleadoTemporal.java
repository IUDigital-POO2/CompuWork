import java.util.Date;

public class EmpleadoTemporal extends Empleado{
    //Atributos
    private Date fechaFin;

    //Constructor
    public EmpleadoTemporal(String nombre, String apellido, String id, String departamento, String tipoEmpleado, Date fechaInicio, Date fechaFin) {
        super(nombre, apellido, id, departamento, tipoEmpleado, fechaInicio);
        this.fechaFin = fechaFin;
    }

    //Getters y Setters
    public Date getFechaFin() {
        return fechaFin;
    }
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    //Métodos
    //Implementación del método abstracto
    @Override
    public void cambiarDepartamento(String nuevoDepartamento) {
        setDepartamento(nuevoDepartamento);
    }

}
