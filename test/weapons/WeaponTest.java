/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2017
 *
 * Name: Joseph Elvin, Jonathan Li, Yuxuan Huang
 * Date: Apr 9, 2017
 * Time: 8:02:14 PM
 *
 * Project: csci205Final
 * Package: weapons
 * File: WeaponTest.java
 * Description: A series of JUnit tests for the Weapon class
 *
 * ****************************************
 */
package weapons;

import model.weapons.Weapon;
import model.entities.Entity;
import model.items.Item;
import junit.framework.TestCase;

/**
 * A series of JUnit tests for the Weapon class
 *
 * @author josephelvin
 */
public class WeaponTest extends TestCase {

	private Weapon instance;
	private Entity entity;

	public WeaponTest(String testName) {
		super(testName);
	}

	@Override
	public void setUp() throws Exception {
		super.setUp();
		entity = new Entity(0, 0, 100);
		Item ammo = new Item();
		instance = new Weapon(10, ammo, entity);
	}

	@Override
	public void tearDown() throws Exception {
		super.tearDown();
		instance = null;
	}

}
