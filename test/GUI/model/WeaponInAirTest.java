/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.model;

import GUI.model.WeaponInAir;
import GUI.model.Wave;
import GUI.ctrl.GameState.GameStateManager;
import GUI.ctrl.GameState.PlayState;
import model.entities.MainChar;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import model.weapons.Tomato;

/**
 *
 * @author yh009
 */
public class WeaponInAirTest extends TestCase {

    Wave w;
    WeaponInAir wia;
    PlayState ps;
    GameStateManager gsm;
    MainChar me;

    public WeaponInAirTest(String testName) {
        super(testName);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        gsm = new GameStateManager();
        ps = new PlayState(gsm, 1);
        w = new Wave(1, ps);
        wia = new WeaponInAir(w);
        me = new MainChar(0, 0);

    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
        gsm = null;
        ps = null;
        w = null;
        wia = null;
        me = null;
    }

    /**
     * Test of addWeapon method, of class WeaponInAir.
     */
    @Test
    public void testAddWeapon() {
        System.out.println("addWeapon");
        assertTrue(wia.getWeaponInAir().size() == 0);
        wia.addWeapon(new Tomato(me));
        assertTrue(wia.getWeaponInAir().size() == 1);
    }

    /**
     * Test of removeWeapon method, of class WeaponInAir.
     */
    @Test
    public void testRemoveWeapon() {
        System.out.println("removeWeapon");
        wia.addWeapon(new Tomato(me));
        assertTrue(wia.getWeaponInAir().size() == 1);
        wia.removeWeapon(wia.getWeaponInAir().get(0));
        assertTrue(wia.getWeaponInAir().size() == 0);
    }

}
