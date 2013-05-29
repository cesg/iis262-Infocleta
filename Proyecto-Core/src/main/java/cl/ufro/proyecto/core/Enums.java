
package cl.ufro.proyecto.core;

/**
 *
 * @author kristian
 */
public class Enums {

    public enum LAF {
        DEFAULT(""),
        SYSTEM(null),
        SYSTEM_LINUX("com.sun.java.swing.plaf.gtk.GTKLookAndFeel"),
        SYSTEM_WINDOWS("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"),
        JTATOO("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
        
        private String value;
        
        private LAF (String value){
        this.value = value;
        }
        public String getValue(){
            return value;
        }
    }
}
