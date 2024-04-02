package Validador;

import java.util.ArrayList;
import java.util.List;

public class Alumno {
    private String nombre;
    private String legajo;
    private List<Materia> materiasAprobadas;

    public Alumno(String nombre, String legajo) {
        this.nombre = nombre;
        this.legajo = legajo;
        this.materiasAprobadas = new ArrayList<>();
    }

    public List<Materia> getMateriasAprobadas() {
        return materiasAprobadas;
    }

    public boolean cumpleCorrelativas(Materia materia) {
            return materiasAprobadas.containsAll(materia.getCorrelativas());
        }
}

