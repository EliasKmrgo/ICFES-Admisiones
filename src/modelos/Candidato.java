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

    public Candidato(String nombre, String apellido, String etnia, double icfesGlobal, double matematicas, double ingles, LocalDate fechaInscripcion) {

        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }

        if (apellido == null || apellido.trim().isEmpty()) {
            throw new IllegalArgumentException("El apellido no puede estar vacío.");
        }

        if (etnia == null) {
            throw new IllegalArgumentException("Debe seleccionar una etnia válida.");
        }

        if (icfesGlobal < 0 || icfesGlobal > 500) {
            throw new IllegalArgumentException("ICFES global debe estar entre 0 y 500.");
        }

        if (matematicas < 0 || matematicas > 100) {
            throw new IllegalArgumentException("Matemáticas debe estar entre 0 y 100.");
        }

        if (ingles < 0 || ingles > 100) {
            throw new IllegalArgumentException("Inglés debe estar entre 0 y 100.");
        }

        if (fechaInscripcion.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha no puede ser futura.");
        }

        this.nombre = nombre.trim();
        this.apellido = apellido.trim();
        this.etnia = etnia;
        this.icfesGlobal = icfesGlobal;
        this.matematicas = matematicas;
        this.ingles = ingles;
        this.fechaInscripcion = fechaInscripcion;
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
