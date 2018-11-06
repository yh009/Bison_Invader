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
 * File: MainCharTest.java
 * Description: A series of JUnit tests for the MainChar class
 *
 * ****************************************
 */
package entities;

import model.entities.MainChar;
import model.items.Item;
import junit.framework.TestCase;
import model.weapons.Weapon;

/**
 * A series of JUnit tests for the MainChar class
 *
 * @author josephelvin
 */
public class MainCharTest extends TestCase {

	private MainChar instance;

	public MainCharTest(String testName) {
		super(testName);
	}

	@Override
	public void setUp() throws Exception {
		super.setUp();
		instance = new MainChar(0, 0);
	}

	@Override
	public void tearDown() throws Exception {
		super.tearDown();
		instance = null;
	}

	/**
	 * Test the addWeapon method, of class MainChar.
	 */
	public void testAddWeapon() {
		System.out.println("addWeapon");
		Item ammo = new Item();
		Weapon weapon = new Weapon(50, ammo, instance);
		instance.addWeapon(weapon);

		assertEquals(instance.getWeaponList().size(), 1);

		assertTrue(instance.getWeaponList().contains(weapon));
	}

	/**
	 * Test the addItem method, of class MainChar.
	 */
	public void testAddItem() {
		System.out.println("addItem");
		Item item = new Item();
		instance.addItem(item, 1);

		assertEquals(instance.getItemList().size(), 1);
		assertTrue(instance.getItemList().containsKey(item));
		assertTrue(instance.getItemList().get(item) == 1);

		Item item2 = new Item();
		instance.addItem(item, 1);
		instance.addItem(item2, 1);

		assertEquals(instance.getItemList().size(), 2);
		assertTrue(instance.getItemList().containsKey(item));
		assertTrue(instance.getItemList().containsKey(item2));
		assertTrue(instance.getItemList().get(item2) == 1);
		assertTrue(instance.getItemList().get(item) == 2);
	}

}
