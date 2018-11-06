/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2017
 *
 * Name: Joseph Elvin, Jonathan Li, Yuxuan Huang
 * Date: Apr 9, 2017
 * Time: 8:02:14 PM
 *
 * Project: csci205Final
 * Package: buildings
 * File: BuildingTest.java
 * Description: A series of JUnit tests for the Building class
 *
 * ****************************************
 */
package buildings;

import model.buildings.Building;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * A series of JUnit tests for the Building class
 *
 * @author josephelvin
 */
public class BuildingTest extends TestCase {

	static final double EPSILON = 1.0E-12;

	private Building instance;

	public BuildingTest(String testName) {
		super(testName);
	}

	@Override
	public void setUp() throws Exception {
		super.setUp();
		instance = new Building(100);
	}

	@Override
	public void tearDown() throws Exception {
		super.tearDown();
		instance = null;
	}

	/**
	 * Test of changeHealth method, of class Building.
	 */
	@Test
	public void testChangeHealth() {
		System.out.println("changeHealth");
		double delta = -10.0;
		instance.changeHealth(delta);
		assertEquals(instance.getCurHealth(), 90.0, EPSILON);
	}

}
