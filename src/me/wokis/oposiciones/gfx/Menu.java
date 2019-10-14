package me.wokis.oposiciones.gfx;

import me.wokis.oposiciones.Oposiciones;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Menu extends JFrame {

    private Oposiciones main;
    public Menu(Oposiciones instance){
        this.main = instance;
    }

    private int x = 10, width = 570, y = 15;
    private JTextField nombreTF, steamTF, opositorTF;
    private JLabel userLbl, steamlabel, opos;
    private JButton btnEmpOpos;

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
        nombreTF = new JTextField();
        nombreTF.setBounds(x, y + 30, width, 30);

        steamTF = new JTextField();
        steamTF.setBounds(x, y + 90, width, 30);

        opositorTF = new JTextField();
        opositorTF.setBounds(x, y + 150, width, 30);

        userLbl = new JLabel();
        userLbl.setText("Nombre del usuario:");
        userLbl.setBounds(x, y, width, 30);

        steamlabel = new JLabel();
        steamlabel.setText("Nombre de Steam:");
        steamlabel.setBounds(x, y + 60, width, 30);

        opos = new JLabel();
        opos.setText("Nombre del opositor:");
        opos.setBounds(x, y + 120, width, 30);

        btnEmpOpos = new JButton("Empezar oposiciones");
        btnEmpOpos.setBounds(main.getWidth()/2-100, main.getHeight()-500, 200, 60);
        btnEmpOpos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                main.data.name = nombreTF.getText();
                main.data.steam = steamTF.getText();
                main.data.opositor = opositorTF.getText();
                disableEverything();
                main.preguntas.confVent();

            }
        });

        JLabel label = new JLabel("Hecho con <3 por Wokis. Versión 1.0.");
        label.setBounds(x, main.getHeight()-60, 300, 20);

        main.add(userLbl);
        main.add(nombreTF);
        main.add(steamTF);
        main.add(opositorTF);
        main.add(opos);
        main.add(steamlabel);
        main.add(btnEmpOpos);
        main.add(label);
    }

    private void disableEverything(){
        userLbl.setVisible(false);
        nombreTF.setVisible(false);
        steamTF.setVisible(false);
        opositorTF.setVisible(false);
        opos.setVisible(false);
        steamlabel.setVisible(false);
        btnEmpOpos.setVisible(false);
    }
}
