package cl.ufro.infocleta.core;

enum Laf {
    DEFAULT("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"), SYSTEM(null), SYSTEM_LINUX(
            "com.sun.java.swing.plaf.gtk.GTKLookAndFeel"), SYSTEM_WINDOWS(
            "com.sun.java.swing.plaf.windows.WindowsLookAndFeel"), JTATOO(
            "com.jtattoo.plaf.acryl.AcrylLookAndFeel");

    private String value;

    private Laf(String value) {
        this.value = value;
    }
    
    public String toString(){
        return value;
    }
};

enum Llaves {
    LAF("aplicacion.laf");
    private String value;
    private Llaves(String value){
        this.value = value;
    }
    public String toString(){
        return value;
    }
};
