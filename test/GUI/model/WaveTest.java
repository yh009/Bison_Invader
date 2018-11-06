/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.model;

import GUI.model.Wave;
import GUI.ctrl.GameState.GameStateManager;
import GUI.ctrl.GameState.PlayState;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author yh009
 */
public class WaveTest extends TestCase {

    Wave w;
    PlayState ps;
    GameStateManager gsm;

    public WaveTest(String testName) {
        super(testName);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        gsm = new GameStateManager();
        ps = new PlayState(gsm, 1);
        w = new Wave(1, ps);
    }

    @After
    public void tearDown() {
        gsm = null;
        ps = null;
        w = null;
    }

    /**
     * Test of isFinished method, of class Wave.
     */
    @Test
    public void testIsFinished() {
        System.out.println("isFinished");
        assertTrue(w.isFinished() == false);
    }

    /**
     * Test of removeEnemy method, of class Wave.
     */
    @Test
    public void testRemoveEnemy() {
        System.out.println("removeEnemy");
        assertTrue(w.getEnemyList().size() == 6);
        w.removeEnemy(w.getEnemyList().get(0));
        assertTrue(w.getEnemyList().size() == 5);
    }

}
