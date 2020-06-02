package paquete;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Limpiar extends Ventana {

    public static void Limpia() {
        limpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel.repaint();
            }
        });
    }
}
