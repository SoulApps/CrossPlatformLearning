import static org.junit.Assert.*;

import org.junit.Test;


public class TestString {

	@Test
	public void testConcat() {
		
		String ies = "IES";
		String saladillo="Saladillo";
		String concatenada=ies.concat(saladillo);
		assertEquals("IESSaladillo", concatenada);

		
	}

}
