package TestCorrelatividades;


import Validador.Alumno;
import Validador.Inscripcion;
import Validador.Materia;
import org.junit.Assert;
import org.junit.Test;

public class ValidadorTest {
    @Test
    public void alumnoCumpleCorrelativas(){
        Materia materia1 = new Materia("pdep");
        Materia materia2 = new Materia("ayed");
        Materia materia3 = new Materia("syo");
        Materia materia4 = new Materia("adc");
        Materia materia5 = new Materia("so");
        Materia materia0 = new Materia("dds");


        materia0.getCorrelativas().add(materia1);
        materia0.getCorrelativas().add(materia2);
        materia0.getCorrelativas().add(materia3);

        materia5.getCorrelativas().add(materia4);

        //La materia0 es correlativa con materia1 ,materia2 y materia3
        //la materia 5 es correlativa con la materia 4

        Alumno valen = new Alumno("Valen", "12345");

//valen aprobo las materias 1,2,3 y 4
        valen.getMateriasAprobadas().add(materia1);
        valen.getMateriasAprobadas().add(materia2);
        valen.getMateriasAprobadas().add(materia3);
        valen.getMateriasAprobadas().add(materia4);

        Inscripcion inscripcion = new Inscripcion(valen);

//valen quiere inscribirse a la materia 0 y 5, aprobo las materias correlativas. Inscripcion aceptada

        inscripcion.getMaterias().add(materia0);
        inscripcion.getMaterias().add(materia5);

        Assert.assertTrue(inscripcion.aprobada());
    }

    @Test
    public void alumnoNoCumpleCorrelativas(){
        Materia materia1 = new Materia("pdep");
        Materia materia2 = new Materia("ayed");
        Materia materia3 = new Materia("syo");
        Materia materia4 = new Materia("adc");
        Materia materia5 = new Materia("so");
        Materia materia0 = new Materia("dds");


        materia0.getCorrelativas().add(materia1);
        materia0.getCorrelativas().add(materia2);
        materia0.getCorrelativas().add(materia3);

        materia5.getCorrelativas().add(materia4);

        //La materia0 es correlativa con materia1 ,materia2 y materia3
        //la materia 5 es correlativa con la materia 4

        Alumno valen = new Alumno("Valen", "12345");


        valen.getMateriasAprobadas().add(materia1);
        valen.getMateriasAprobadas().add(materia3);
        valen.getMateriasAprobadas().add(materia4);

        Inscripcion inscripcion = new Inscripcion(valen);

//valen quiere inscribirse a la materia 0 y 5, pero no aprobo la materia 2. Inscripcion rechazada

        inscripcion.getMaterias().add(materia0);
        inscripcion.getMaterias().add(materia5);

        Assert.assertFalse(inscripcion.aprobada());
    }
}
