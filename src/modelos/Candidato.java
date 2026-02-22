package modelos;
import java.time.LocalDate;

public class Candidato {
    private String nombre;
    private String apellido;
    private String etnia;
    private double icfesGlobal;
    private double matematicas;
    private double ingles;
    private LocalDate fechaInscripcion;

    public Candidato(String nombre, String apellido, String etnia, double icfesGlobal, double matematicas, double ingles) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.etnia = etnia;
        this.icfesGlobal = icfesGlobal;
        this.matematicas = matematicas;
        this.ingles = ingles;
        this.fechaInscripcion = LocalDate.now();
    }

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
    public String getEtnia() {
        return etnia;
    }
    public void setEtnia(String etnia) {
        this.etnia = etnia;
    }
    public double getIcfesGlobal() {
        return icfesGlobal;
    }
    public void setIcfesGlobal(double icfesGlobal) {
        this.icfesGlobal = icfesGlobal;
    }
    public double getMatematicas() {
        return matematicas;
    }
    public void setMatematicas(double matematicas) {
        this.matematicas = matematicas;
    }
    public double getIngles() {
        return ingles;
    }
    public void setIngles(double ingles) {
        this.ingles = ingles;
    }
    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }
    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }
}
