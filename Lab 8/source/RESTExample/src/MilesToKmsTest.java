import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 
 */

/**
 * 
 *
 */
public class MilesToKmsTest {

	
	
	FtoCService x = new FtoCService();
	
	long y  = x.mlTokms(1);
	
	long test = (long) 2.60934;

	
	
	@Test	
	public void testConversion() {
		//System.out.println("@Test sum(): " + sum + " = " + testSum);
		assertEquals(y,test);
	}
	
}
