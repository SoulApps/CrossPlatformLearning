package ejercicios;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Alejandro on 17/05/2016.
 */
public class TestString {
    @Test
    public void testConcat() {
        String ies = "IES";
        String saladillo="Saladillo";
        String concatenada=ies.concat(saladillo);
        assertEquals("IESSaladillo", concatenada);
    }
}
