package cl.ufro.infocleta.core;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.apache.commons.lang.SystemUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Ayudante {
    private static Propiedades prop = new Propiedades();
    private static final Logger LOG = LoggerFactory.getLogger(Ayudante.class);
    public static final String SISTEMA_OP = System.getProperty("os.name");

    /**
     * <p>
     * Establece el estilo visual que tendra la aplicacion.
     * </p>
     * <b>iniciaEstiloVisual()</b>
     */
    public static void iniciaEstiloVisual() {
        Laf proLaf = prop.getLookAndFeel();
        if (proLaf != null)
            setLookAndFeel(proLaf.toString());
    }

    private static void setLookAndFeel(final String laf) {
        try {
            UIManager.setLookAndFeel(laf);
            LOG.debug("LAF: {}", laf);
        } catch (ClassNotFoundException | InstantiationException
                | IllegalAccessException | UnsupportedLookAndFeelException e) {
            LOG.error("## Eror al establecer el LookAndFeel", e);
        }
    }

    /**
     * <p>
     * Se encarga de asociar un valor de la propiedad
     * <code>aplicacion.laf</code> a un LookAndFeel soportado por la aplicacion.
     * </p>
     * <b>Laf stringToLaf (String prop)</b>
     * 
     * @param prop
     *            propiedad obtenida.
     * @return el LookAndFeel asociado.
     */
    public static Laf stringToLaf(String prop) {
        Laf laf = Laf.DEFAULT;
        switch (prop) {
        case "jtattoo":
            laf = Laf.JTATOO;
            break;
        case "sistema":
            if (SystemUtils.IS_OS_LINUX)
                laf = Laf.SYSTEM_LINUX;
            else if (SystemUtils.IS_OS_WINDOWS)
                laf = Laf.SYSTEM_WINDOWS;
            break;
        default:
            break;
        }
        return laf;
    }
}
