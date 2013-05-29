package cl.ufro.proyecto.beans.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestUtildades {

    @Test
    public final void testEsNuloTrue() {
        Object o = null;
        boolean resultado = Utilidades.esNulo(o);
        assertTrue(resultado);
    }
    
    @Test
    public final void testEsNuloFalse(){
        Object o = new Object();
        boolean resultado = Utilidades.esNulo(o);
        assertFalse(resultado);
    }
}
