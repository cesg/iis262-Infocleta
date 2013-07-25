package cl.ufro.infocleta.gui;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

public class UtilidadesGui {

	private static final String IMG_NAME = "appIcon.png";
	private static final String IMG_INICIO_NAME = "InfoCleta.png";
	public static final String VERSION = "1.5";

	public static Image obtenerAppImg() {
		URL imgUrl = UtilidadesGui.class.getClassLoader().getResource(IMG_NAME);
		ImageIcon img = new ImageIcon(imgUrl);
		return img.getImage();
	}

	public static ImageIcon obtenerInicioImg() {
		URL imgUrl = UtilidadesGui.class.getClassLoader().getResource(
		        IMG_INICIO_NAME);
		ImageIcon img = new ImageIcon(imgUrl);
		return img;
	}
}
