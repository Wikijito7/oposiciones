package me.wokis.oposiciones.manager;

import me.wokis.oposiciones.Oposiciones;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileManager {

    private Oposiciones oposiciones;
    public FileManager(Oposiciones oposiciones){
        this.oposiciones = oposiciones;
    }

    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm:ss");
    private static LocalDateTime now = LocalDateTime.now();
    private static String date = dtf.format(now).replace(" ", "").replace(":", "").replace("/", "");;
    private static File f = new File("./oposiciones",date + ".txt");
    private int npreg = 0, puntuacion = 0;

    public void checkFile() {
        try {
            f.getParentFile().mkdirs();
            f.createNewFile();
            generateFile();
            System.out.println(f);
        } catch (IOException e) {}
    }

    private void generateFile(){
        try {
            BufferedWriter w = new BufferedWriter(new FileWriter(f));
            w.write("Nombre: " + oposiciones.data.name + "\n");
            w.write("Steam: " + oposiciones.data.steam + "\n");
            w.write("Oposición hecha por: " + oposiciones.data.opositor + "\n");
            w.write("Fecha y hora: " + dtf.format(now) + "\n");
            w.write("Preguntas:\n");

            oposiciones.data.respuestas.forEach(e->{
                String[] pregunta = e.split(", ");
                npreg++;
                try {
                    w.write("\tPregunta " + npreg + ":\n\t\t");
                    w.write("Pregunta: " + pregunta[0] + "\n\t\t");
                    w.write("Puntuación: " + pregunta[1] + "\n\t\t");
                    w.write("Observaciones: "+ "\n\t\t\t");
                    if(pregunta.length == 3){
                        String[] observaciones = pregunta[2].split("/");
                        for (int x = 0; x < observaciones.length; x++) w.write(observaciones[x] + "\n\t\t\t");
                    }
                    w.write("\n");
                    puntuacion += Integer.parseInt(pregunta[1]);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });
            w.write("Puntuación: " + puntuacion + "/" + 3*npreg + " (" + puntuacion * 10 / (3*npreg) + ")");
            w.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
