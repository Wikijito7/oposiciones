package me.wokis.oposiciones;

import me.wokis.oposiciones.data.Data;
import me.wokis.oposiciones.gfx.Menu;
import me.wokis.oposiciones.gfx.Preguntas;
import me.wokis.oposiciones.gfx.Preguntas2;
import me.wokis.oposiciones.manager.Archivos;
import me.wokis.oposiciones.manager.FileManager;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;

public class Oposiciones extends JFrame {

    private Menu menu;
    public Preguntas2 preguntas;
    public Data data;
    public FileManager fileManager;
    public Archivos archivos;

    private Oposiciones(){
        menu = new Menu(this);
        preguntas = new Preguntas2(this);
        fileManager = new FileManager(this);
        archivos = new Archivos();
        data = new Data();
        menu.confVent();
        archivos.loadFilesFromLocal().forEach(e-> {
            System.out.println(e.getType());
            System.out.println(e.getPregunta());
            System.out.println(e.getRespuesta());
            System.out.println("\n");
        });
    }

    public static void main(String[] args) {
        Oposiciones frame = new Oposiciones();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setFocusable(true);
        frame.setSize(600,900);
        try {
            frame.setIconImage(ImageIO.read(Oposiciones.class.getResource("/rsc/tool-button.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
