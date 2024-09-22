public class Empleado {

    // Atributos
    private String nombre;
    private int id;
    private String tipo; // Permanente o Temporal
    private ReporteDesempenio desempenio;

    // Constructor
    public Empleado(String nombre, int id, String tipo) {
        this.nombre = nombre;
        this.id = id;
        this.tipo = tipo;
        this.desempenio = new ReporteDesempenio();
    }

    // Actualizar el desempeño del empleado
    public void actualizarDesempeño(ReporteDesempenio nuevoDesempenio) {
        this.desempenio = nuevoDesempenio;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public ReporteDesempenio getDesempenio() {
        return desempenio;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDesempenio(ReporteDesempenio desempenio) {
        this.desempenio = desempenio;
    }

}
