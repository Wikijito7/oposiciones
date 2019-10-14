package me.wokis.oposiciones.gfx;

import me.wokis.oposiciones.Oposiciones;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Preguntas extends JFrame {

    private Oposiciones main;
    public Preguntas(Oposiciones instance){
        this.main = instance;
    }

    private int x = 10, width = 570, y = 15, puntuacion = -1;
    private final ButtonGroup rGroup = new ButtonGroup();
    private JRadioButton[] radioButtons = new JRadioButton[4];
    private JTextArea area;
    private JTextField preguntaTF;
    private JButton btnCont, finBtn;
    private JLabel rlabel;

    public void confVent(){
        main.setTitle("Oposiciones Mecánicos");
        main.setFocusable(true);
        main.setBounds(50,50,600,900);
        main.setLayout(null);
        main.setResizable(false);
        main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        registerJThingies();
    }

    private void registerJThingies() {
        area = new JTextArea();
        area.setBounds(x,y + 150, width, 200);
        area.setBorder(new LineBorder(Color.black));

        preguntaTF = new JTextField();
        preguntaTF.setBorder(new LineBorder(Color.black));
        preguntaTF.setBounds(x, y + 30, width, 30);

        JLabel preguntaLbl = new JLabel();
        preguntaLbl.setText("Pregunta:");
        preguntaLbl.setBounds(x, y, width, 30);

        JLabel obslabel = new JLabel();
        obslabel.setText("Observaciones:");
        obslabel.setBounds(x, y + 120, width, 30);

        rlabel = new JLabel();
        rlabel.setText("Puntación:");
        rlabel.setBounds(x, y + 60, width, 30);

        btnCont = new JButton("Siguiente pregunta");
        btnCont.setBounds(10, 500, 200, 50);
        btnCont.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarPregunta();
            }
        });

        finBtn = new JButton("Finalizar");
        finBtn.setBounds(10, 560, 200, 50);
        finBtn.setVisible(false);
        finBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarPregunta();
                main.fileManager.checkFile();
            }
        });

        for(int b = 0; b < 4; b++){
            radioButtons[b] = new JRadioButton(Integer.toString(b));
            JRadioButton r1 = radioButtons[b];
            r1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    puntuacion = Integer.parseInt(r1.getText());
                }
            });
            r1.setBounds(x + 40*b, y + 90, 40, 30);
            rGroup.add(r1);
            main.add(r1);
        }

        main.add(preguntaLbl);
        main.add(rlabel);
        main.add(preguntaTF);
        main.add(obslabel);
        main.add(area);
        main.add(btnCont);
        main.add(finBtn);
    }

    private void guardarPregunta(){
        if(preguntaTF.getText().equals("")){
            preguntaTF.setBorder(new LineBorder(Color.red));
            System.out.println("No hay pregunta escrita");
            return;
        }

        if(puntuacion == -1) {
            rlabel.setForeground(Color.red);
            System.out.println("No hay puntuacion escrita");
            return;
        }
        String[] textarea = area.getText().split("\n");
        String obs = "";
        for(int r = 0; r < textarea.length; r++){
            if(r == 0) obs = textarea[r];
            else obs = obs + "/" + textarea[r];
        }

        main.data.respuestas.add(preguntaTF.getText() + ", " + puntuacion + ", " + obs);
        System.out.println(preguntaTF.getText() + ", " + puntuacion + ", " + obs);

        preguntaTF.setBorder(new LineBorder(Color.black));
        rlabel.setForeground(Color.black);
        preguntaTF.setText("");
        area.setText("");
        rGroup.clearSelection();
        finBtn.setVisible(true);
    }
}
