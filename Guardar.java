package paquete;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Guardar {

	static JFileChooser guardar;
	static FileOutputStream salir;
	static File Archivo;
	static byte[] imagenguardada;
	static BufferedImage img;
	static Graphics graf;

	public static String guardar(File Archivo, byte[] imagenguardada) {
		String msj = null;
		try {
			salir = new FileOutputStream(Archivo);
			salir.write(imagenguardada);
			msj = "Se ha guardado el archivo";
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Hubo un error al guardar el archivo");
		}
		return msj;
	}

	public static void Guarda() {

		try {
			guardar = new JFileChooser();
			guardar.showSaveDialog(guardar);
			Archivo = guardar.getSelectedFile();
			if (Archivo == null) {
			return;
			}

			String Name = Archivo.getName();
			Name = Name + ".jpg";

			Archivo = new File(Archivo.getParent(), Name);

			img = new BufferedImage(Ventana.panel.getWidth(), Ventana.panel.getHeight(),
			BufferedImage.TYPE_INT_RGB);
			graf = img.getGraphics();
			// graf2.drawImage(Dibujar.bimage, 0, 0, Ventana.panel);
			// Ventana.panel.print(graf);
			Ventana.panel.print(graf);
			graf.dispose();

			ImageIO.write(img, "jpg", Archivo);	
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Hubo un error al guardar el archivo");
			e.printStackTrace();
		}
	}
}
