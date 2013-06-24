package cl.ufro.infocleta.gui;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

public class UtilidadesGui {

	private static final String IMG_NAME = "appIcon.png";

	public static Image obtenerAppImg() {
		URL imgUrl = UtilidadesGui.class.getClassLoader().getResource(IMG_NAME);
		ImageIcon img = new ImageIcon(imgUrl);
		return img.getImage();
	}
}
