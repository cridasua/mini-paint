package paquete;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Cargar {
	
	static JFileChooser abrir = new JFileChooser();
	static File abrirarchivo;
	static byte[] imagen;
	static FileInputStream entrar;

	
	public static byte[] Abrir(File archivo) 
	{
		byte[] imagen = new byte[1024*100];
		try 
		{
			entrar= new FileInputStream(archivo);
			entrar.read(imagen);
		} 
		catch (Exception e) 
		{
			JOptionPane.showMessageDialog(null, "Hubo un error al leer el archivo");
		}
		return imagen;
	}
	
	
	public static void Carga() 
	{
		if (abrir.showDialog(null,null)==JFileChooser.APPROVE_OPTION) 
		{
			abrirarchivo=abrir.getSelectedFile();
			if(abrirarchivo.canRead()) 
			{
				if(abrirarchivo.getName().endsWith("jpg") || abrirarchivo.getName().endsWith("JPG")) 
				{
					imagen=Abrir(abrirarchivo);
					ImageIcon img = new ImageIcon(imagen);
					Icon img2 = new ImageIcon (img.getImage().getScaledInstance(Ventana.label.getWidth(), Ventana.label.getHeight(), Image.SCALE_DEFAULT));
					Ventana.label.setIcon(img2);
					Ventana.panel.add(Ventana.label);
					Ventana.panel.repaint();

				}
				else 
				{
					JOptionPane.showMessageDialog(null, "Archivo No Compatible");
				}
			}
		}
	}
	

}
