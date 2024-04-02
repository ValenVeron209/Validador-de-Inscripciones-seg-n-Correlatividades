package Validador;

import java.util.ArrayList;
import java.util.List;
public class Inscripcion {
    private Alumno alumno;
    private  List<Materia> materias;

    public Inscripcion (Alumno alumno) {
        this.alumno = alumno;
        this.materias = new ArrayList<>();
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public boolean aprobada() {
        for (Materia materia : materias) {
            if (!alumno.cumpleCorrelativas(materia)) {
                return false;
            }
        }
        return true;
    }

}
