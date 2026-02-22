package servicios;

import java.util.List;

import modelos.Candidato;

public class CandidatosService {
    private List<Candidato> candidatos;

    public CandidatosService() {
        this.candidatos = new java.util.ArrayList<>();
    }

    public void agregarCandidato(Candidato candidato) {
        candidatos.add(candidato);
    }

    public void ordenarCandidatos() {
        Ordenamiento ordenamiento = new Ordenamiento();
        ordenamiento.ordenarCandidatos(candidatos);
    }

    public List<Candidato> getCandidatos() {
        return candidatos;
    }
}
