/**
 * 
 */
package org.mai.string;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author mai
 * 
 */
public class LevenshteinDistanceV1Test {

	/**
	 * Test method for
	 * {@link org.mai.string.LevenshteinDistanceV1#cal(char[], char[])}.
	 */
	@Test
	public void testCal() {
		char[] s = "hello".toCharArray();
		char[] t = "hellj".toCharArray();
		assertEquals(1,LevenshteinDistanceV1.cal(s, t));
	}

}
