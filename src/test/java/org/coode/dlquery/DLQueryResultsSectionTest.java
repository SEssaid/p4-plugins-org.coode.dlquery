package org.coode.dlquery;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * this TestNG-Test is just for illustration purposes.
 * @author DrCJ
 *
 */
public class DLQueryResultsSectionTest {
	private DLQueryResultsSection resultssection;

	@BeforeClass
	public void setup() {
		resultssection = new DLQueryResultsSection("Tim rocks");
	}

	@Test
	  public void testGetName() {
		  Assert.assertEquals("Tim rocks", resultssection.getName());
	  }
	
	@Test(dependsOnMethods = {"testGetName"})
	public void testGetNameAgain(String alabel){
		resultssection = new DLQueryResultsSection(alabel);
		Assert.assertEquals(alabel, resultssection.getName());
	}
	
	@Test
	public void testCanAdd(){
		Assert.assertFalse(resultssection.canAdd());
	}
}
