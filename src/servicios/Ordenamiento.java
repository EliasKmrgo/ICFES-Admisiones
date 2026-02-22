package servicios;

import java.util.List;

import modelos.Candidato;

public class Ordenamiento {

public void ordenarCandidatos(List<Candidato> candidatos) {
    candidatos.sort((c1, c2) -> {
        int comparacion = Double.compare(c2.getIcfesGlobal(), c1.getIcfesGlobal());

        if (comparacion == 0) {
            comparacion = Double.compare(c2.getMatematicas(), c1.getMatematicas());
        }
        if (comparacion == 0) {
            comparacion = Double.compare(c2.getIngles(), c1.getIngles());
        }
        return comparacion;
    });
}
}
