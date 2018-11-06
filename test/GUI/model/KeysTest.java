/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.model;

import GUI.utility.Keys;
import java.awt.event.KeyEvent;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author yh009
 */
public class KeysTest extends TestCase {

    public KeysTest(String testName) {
        super(testName);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
        Keys.keyState = new boolean[Keys.NUM_KEYS];
        Keys.prevKeyState = new boolean[Keys.NUM_KEYS];
    }

    /**
     * Test of keySet method, of class Keys.
     */
    @Test
    public void testKeySet() {
        System.out.println("keySet");
        assertTrue(Keys.keyState[Keys.DOWN] == false);
        Keys.keySet(KeyEvent.VK_DOWN, true);
        assertTrue(Keys.keyState[Keys.DOWN] == true);
    }

    /**
     * Test of update method, of class Keys.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        assertTrue(Keys.prevKeyState[Keys.UP] == false);
        Keys.keySet(KeyEvent.VK_UP, true);
        Keys.update();
        assertTrue(Keys.prevKeyState[Keys.UP] == true);

    }

    /**
     * Test of isPressed method, of class Keys.
     */
    @Test
    public void testIsPressed() {
        System.out.println("isPressed");
        assertTrue(Keys.isPressed(Keys.LEFT) == false);
        Keys.keySet(KeyEvent.VK_LEFT, true);
        assertTrue(Keys.isPressed(Keys.LEFT) == true);
    }

}
