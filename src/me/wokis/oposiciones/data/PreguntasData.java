package me.wokis.oposiciones.data;

import java.util.Arrays;
import java.util.List;

public class PreguntasData {

    public PregData[] preguntas;

    public class PregData {
        public String type;
        public String pregunta;
        public String respuesta;
    }

    public List<PregData> getPregData(){
        return Arrays.asList(preguntas);
    }
}
