/* *****************************************
 * Software Engineering and Design
 * Spring 2017
 *
 * Name: Joseph Elvin, Yuxuan Huang
 * Date: Apr 9, 2017
 * Time: 8:02:14 PM
 *
 * Project: BisonInvader
 * Package: GUI.ctrl.GameState
 * File: GameStateManager.java
 * Description: A class for the GameStateManager
 *
 * ****************************************
 */
package GUI.ctrl.GameState;

import java.awt.Graphics2D;

/**
 * A class for the GameStateManager, where all the states are managed and
 * consolidated.
 *
 * @author Yuxuan Huang
 */
public class GameStateManager {

    boolean paused;
    PauseState pauseState;

    GameState[] gameStates;
    private int currentState;
    private int previousState;

    public static final int NUM_STATES = 5;
    public static final int MENU = 0;
    public static final int PLAY = 1;
    public static final int PLAYINF = 2;
    public static final int END = 3;
    public static final int WIN = 4;

    public GameStateManager() {

        paused = false;
        pauseState = new PauseState(this);

        gameStates = new GameState[NUM_STATES];
        setState(MENU);

    }

    /**
     * Changes states and screens
     *
     * @param i
     */
    public void setState(int i) {
        previousState = currentState;
        unloadState(previousState);
        currentState = i;
        if (i == MENU) {
            gameStates[i] = new MenuState(this);
            gameStates[i].init();
        }
        else if (i == PLAY) {
            gameStates[i] = new PlayState(this, i);
            gameStates[i].init();
        }
        else if (i == PLAYINF) {
            gameStates[i] = new PlayState(this, i);
            gameStates[i].init();
        }
        else if (i == END) {
            gameStates[i] = new EndState(this);
            gameStates[i].init();

        }
        else if (i == WIN) {
            gameStates[i] = new WinState(this);
            gameStates[i].init();
        }
    }

    /**
     * Tells the program when the current state is changed and that it needs to
     * be deleted.
     *
     * @param i
     */
    public void unloadState(int i) {
        gameStates[i] = null;
    }

    /**
     * Denotes when the game is paused
     *
     * @param b
     */
    public void setPaused(boolean b) {
        paused = b;
    }

    /**
     * Updates the game when states are changed
     */
    public void update() {
        if (paused) {
            pauseState.update();
        }
        else if (gameStates[currentState] != null) {
            gameStates[currentState].update();
        }
    }

    /**
     * Parent Function that adds the graphics and UI to the current screen
     *
     * @param g
     */
    public void draw(Graphics2D g) {
        if (paused) {
            pauseState.draw(g);
        }
        else if (gameStates[currentState] != null) {
            gameStates[currentState].draw(g);
        }
    }

}
