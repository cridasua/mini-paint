package paquete;

import javax.imageio.ImageIO;
//----------------

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.Color;
import java.util.*;

import paquete.Ventana;

public class Dibujar extends Ventana {

    static Color nuevocolor = new Color(0, 0, 0);
    static int x;
    static int y;
    static BufferedImage bimage;
    static Graphics grafico;
    static Graphics2D grafico2;
    static ArrayList<Linea> lineas = new ArrayList<Linea>();

    public void Leer(MouseEvent ev) {
        if (!ev.isMetaDown()) {
            x = ev.getX();
            y = ev.getY();
        }
    }

    public void Dibuja(MouseEvent ev, int grueso) {

        if (!ev.isMetaDown()) {
            // bimage = new BufferedImage(Ventana.panel.getWidth(), Ventana.panel.getHeight(), BufferedImage.TYPE_INT_RGB);
            // grafico2 = (Graphics2D) bimage.getGraphics();
            // grafico = (Graphics2D) panel.getGraphics();
            // ((Graphics2D) grafico).setStroke(new BasicStroke(grueso));
            // grafico.setColor(nuevocolor);
            int x2 = ev.getX();
            int y2 = ev.getY();
            // grafico.drawLine(x, y, x2, y2);
            lineas.add(new Linea(x, y, x2, y2, grueso, nuevocolor));            
            x = x2;
            y = y2;

            // grafico.dispose();
            panel.repaint();
            // panel.paint(grafico);            
        } 
        else if (ev.isMetaDown()) {
            // grafico = (Graphics2D) panel.getGraphics();
            // ((Graphics2D) grafico).setStroke(new BasicStroke(grueso));
            // grafico.setColor(Color.white);
            // grafico.drawLine(ev.getX(), ev.getY(), ev.getX(), ev.getY());

            
        }
    }

    public static void DibujarLineas(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        for (Linea linea : lineas) {
            g2.setStroke(new BasicStroke(linea.grueso));
            g2.setColor(linea.color);
            g2.drawLine(linea.x1, linea.y1, linea.x2, linea.y2);
        }
    }

    public static void Eventos() {
        panel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                pincel.Leer(e);
            }
        });

        panel.addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                pincel.Dibuja(e, desgrosor.getValue());
            }
        });
    }

    public class Linea {

        public int x1 = 0;
        public int y1 = 0;
        public int x2 = 0;
        public int y2 = 0;
        public int grueso = 0;
        public Color color = new Color(0, 0, 0);
    
        public Linea(int x1, int y1, int x2, int y2, int grueso, Color color) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.grueso = grueso;
            this.color = color;
        }
    }
}