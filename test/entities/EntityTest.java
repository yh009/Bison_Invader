/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2017
 *
 * Name: Joseph Elvin, Jonathan Li, Yuxuan Huang
 * Date: Apr 9, 2017
 * Time: 8:02:14 PM
 *
 * Project: csci205Final
 * Package: entities
 * File: EntityTest.java
 * Description: A series of JUnit tests for the Entity class
 *
 * ****************************************
 */
package entities;

import model.entities.Entity;
import junit.framework.TestCase;

/**
 * A series of JUnit tests for the Entity class
 *
 * @author josephelvin
 */
public class EntityTest extends TestCase {

	static final double EPSILON = 1.0E-12;

	private Entity instance;

	public EntityTest(String testName) {
		super(testName);
	}

	@Override
	public void setUp() throws Exception {
		super.setUp();
		instance = new Entity(0, 0, 100);
	}

	@Override
	public void tearDown() throws Exception {
		super.tearDown();
		instance = null;
	}

	/**
	 * Test of moveX method, of class Entity.
	 */
	public void testMoveX() {
		System.out.println("moveX");
		int x = 5;
		instance.moveX(x);
		assertEquals(instance.getX(), 5);
	}

	/**
	 * Test of moveY method, of class Entity.
	 */
	public void testMoveY() {
		System.out.println("moveY");
		int y = 5;
		instance.moveY(y);
		assertEquals(instance.getY(), 5);
	}

}
