package Question1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestOctalConversion {

	// check when binary input is provided
	@Test
	public void testWhenBinary() {
		OctalConversion octalconversion = new OctalConversion();
		int num = octalconversion.convertBinaryToOctal(Integer
				.parseInt("000100"));
		assertEquals(4, num);
	}

	// check when provided input is not binary
	@Test
	public void testWhenNotBinary() {
		OctalConversion octalconversion = new OctalConversion();
		int num = octalconversion.convertBinaryToOctal(Integer
				.parseInt("12101"));
		assertEquals(-1, num);
	}
}
