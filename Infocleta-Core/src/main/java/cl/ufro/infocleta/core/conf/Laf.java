package cl.ufro.infocleta.core.conf;

public enum Laf {
    DEFAULT("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"), SYSTEM(null), SYSTEM_LINUX(
            "com.sun.java.swing.plaf.gtk.GTKLookAndFeel"), SYSTEM_WINDOWS(
            "com.sun.java.swing.plaf.windows.WindowsLookAndFeel"),SEAGLASS("com.seaglasslookandfeel.SeaGlassLookAndFeel"),WEB("com.alee.laf.WebLookAndFeel");

    private String value;

    private Laf(String value) {
        this.value = value;
    }
    
    public String toString(){
        return value;
    }
};