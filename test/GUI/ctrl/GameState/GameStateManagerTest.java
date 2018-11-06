/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.ctrl.GameState;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author yh009
 */
public class GameStateManagerTest extends TestCase {

    private GameStateManager gsm;

    public GameStateManagerTest(String testName) {
        super(testName);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        gsm = new GameStateManager();
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
        gsm = null;
    }

    /**
     * Test of setState method, of class GameStateManager.
     */
    @Test
    public void testSetState() {
        System.out.println("setState");
        assertTrue(gsm.gameStates[GameStateManager.PLAY] == null);
        gsm.setState(GameStateManager.PLAY);
        assertTrue(gsm.gameStates[GameStateManager.PLAY] != null);

    }

    /**
     * Test of unloadState method, of class GameStateManager.
     */
    @Test
    public void testUnloadState() {
        System.out.println("unloadState");
        //assertTrue(gsm.gameStates[GameStateManager.PLAY] == null);
        gsm.setState(GameStateManager.PLAY);
        assertTrue(gsm.gameStates[GameStateManager.PLAY] != null);
        gsm.unloadState(GameStateManager.PLAY);
        assertTrue(gsm.gameStates[GameStateManager.PLAY] == null);
    }

    /**
     * Test of setPaused method, of class GameStateManager.
     */
    @Test
    public void testSetPaused() {
        System.out.println("setPaused");
        assertTrue(gsm.paused == false);
        gsm.setPaused(true);
        assertTrue(gsm.paused == true);

    }

}
