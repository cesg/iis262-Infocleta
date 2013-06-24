package cl.ufro.infocleta.gui;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

public class UtilidadesGui {
    
    public static Image obtenerAppImg(){
        URL imgUrl = UtilidadesGui.class.getClassLoader().getResource("appIcon.png");
        return new ImageIcon(imgUrl).getImage();
    }
}
