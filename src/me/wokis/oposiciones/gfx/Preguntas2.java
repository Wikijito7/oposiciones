package me.wokis.oposiciones.gfx;

import me.wokis.oposiciones.Oposiciones;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Preguntas2 extends JFrame {

    private Oposiciones main;
    public Preguntas2(Oposiciones instance){
        this.main = instance;
    }

    private int x = 10, width = 570, y = 15, puntuacion = -1;
    private final ButtonGroup rGroup = new ButtonGroup();
    private JRadioButton[] radioButtons = new JRadioButton[4];
    private JTextArea area;
    private JComboBox<String> preguntaCB, tipopreguntaCB;
    private JButton btnCont, finBtn;
    private JLabel rlabel;
    private ArrayList<String> tipos = new ArrayList<>();

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
        JLabel tipoPreguntaLbl = new JLabel();
        tipoPreguntaLbl.setText("Tipo de pregunta:");
        tipoPreguntaLbl.setBounds(x, y, width, 30);

        tipopreguntaCB = new JComboBox<>();
        main.archivos.loadFilesFromLocal().forEach(e->{
            if (!tipos.contains(e.getType())){
                tipos.add(e.getType());
                tipopreguntaCB.addItem(e.getType());
            }
        });
        tipopreguntaCB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                preguntaCB.removeAllItems();
                main.archivos.loadFilesFromLocal().stream().filter(b -> b.getType().equals(tipopreguntaCB.getSelectedItem())).forEach(g-> preguntaCB.addItem(g.getPregunta()));

            }
        });
        tipopreguntaCB.setBounds(x, y + 30, width/3, 30);

        area = new JTextArea();
        area.setBounds(x,y + 210, width, 200);
        area.setLineWrap(true);
        area.setBorder(new LineBorder(Color.black));

        preguntaCB = new JComboBox<>();
        //preguntaCB.setBorder(new LineBorder(Color.black));
        preguntaCB.setBounds(x, y + 90, width, 30);

        JLabel preguntaLbl = new JLabel();
        preguntaLbl.setText("Pregunta:");
        preguntaLbl.setBounds(x, y + 60, width, 30);

        JLabel obslabel = new JLabel();
        obslabel.setText("Observaciones:");
        obslabel.setBounds(x, y + 180, width, 30);

        rlabel = new JLabel();
        rlabel.setText("Puntación:");
        rlabel.setBounds(x, y + 120, width, 30);

        btnCont = new JButton("Siguiente pregunta");
        btnCont.setBounds(main.getWidth()/2 - 255, 500, 200, 50);
        btnCont.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarPregunta();
            }
        });

        finBtn = new JButton("Finalizar");
        finBtn.setBounds(main.getWidth()/2 + 50, 500, 200, 50);
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
            r1.setBounds(x + 40*b, y + 150, 40, 30);
            rGroup.add(r1);
            main.add(r1);
        }
        main.add(tipoPreguntaLbl);
        main.add(tipopreguntaCB);
        main.add(preguntaLbl);
        main.add(rlabel);
        main.add(preguntaCB);
        main.add(obslabel);
        main.add(area);
        main.add(btnCont);
        main.add(finBtn);
    }

    private void guardarPregunta(){
        /*if(preguntaTF.getText().equals("")){
            preguntaTF.setBorder(new LineBorder(Color.red));
            System.out.println("No hay pregunta escrita");
            return;
        }*/

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

        /*main.data.respuestas.add(preguntaTF.getText() + ", " + puntuacion + ", " + obs);
        System.out.println(preguntaTF.getText() + ", " + puntuacion + ", " + obs);

        preguntaTF.setBorder(new LineBorder(Color.black));
        rlabel.setForeground(Color.black);
        preguntaTF.setText("");*/
        area.setText("");
        rGroup.clearSelection();
        finBtn.setVisible(true);
    }
}
