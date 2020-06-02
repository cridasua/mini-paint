package paquete;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import javax.swing.border.EtchedBorder;

import paquete.EColor;

public class Ventana extends JFrame {

    static JFrame cuadro = new JFrame("MiniPaint");
    static Font fuente = new Font("Avenir Negra", Font.PLAIN, 12);
    static JButton color = new JButton("Color del pincel");
    static JButton limpiar = new JButton("Limpiar");
    static JLabel grosor = new JLabel("Grosor del pincel");
    static JLabel label = new JLabel();
    static JPanel panel = new JPanel();
    static JSlider desgrosor = new JSlider();
    static Dibujar pincel = new Dibujar();

    public static void CrearVentana() {
        cuadro.setLocation(400, 200);
        cuadro.setSize(790, 615);
        cuadro.setVisible(true);
        cuadro.setResizable(false);
        cuadro.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        InicioComponentes();
        MenuBar.Barra();

    }

    public static void InicioComponentes() {
        cuadro.getContentPane().setLayout(null);
        cuadro.setDefaultCloseOperation(EXIT_ON_CLOSE);
        color.setBounds(20, 80, 150, 25);
        color.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new paquete.EColor(pincel);
            }

        });
        limpiar.setBounds(610, 80, 150, 25);
        Limpiar.Limpia();
        grosor.setFont(fuente);
        grosor.setBounds(330, 55, 100, 25);
        desgrosor.setMaximum(10);
        desgrosor.setBounds(300, 80, 150, 25);
        panel = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Dibujar.DibujarLineas(g);
            }
        };
        panel.setBounds(12, 130, 760, 420);
        panel.setBackground(Color.white);
        panel.setBorder(new EtchedBorder(EtchedBorder.RAISED));
        label.setBounds(0, 0, 760, 420);
        Dibujar.Eventos();
        cuadro.getContentPane().add(color);
        cuadro.getContentPane().add(limpiar);
        cuadro.getContentPane().add(grosor);
        cuadro.getContentPane().add(desgrosor);
        cuadro.getContentPane().add(panel);
    }

}
