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
 * File: GameState.java
 * Description: An abstract class to handle GameStates
 *
 * ****************************************
 */
package GUI.ctrl.GameState;

import java.awt.Graphics2D;

/**
 * An abstract class to handle each of the GameStates: EndState, MenuState,
 * PauseState,PlayState,and WinState
 *
 * @author Yuxuan Huang
 */
public abstract class GameState {

    protected GameStateManager gsm;

    public GameState(GameStateManager gsm) {
        this.gsm = gsm;
    }

    public abstract void init();

    public abstract void update();

    public abstract void draw(Graphics2D g);

    public abstract void handleInput();

}
