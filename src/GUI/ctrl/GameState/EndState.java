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

import GUI.utility.ImgLoader;
import GUI.utility.Keys;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * This is the state for when the player loses
 *
 * @author Yuxuan Huang
 */
public class EndState extends GameState {

    private BufferedImage bg;
    private BufferedImage arrow;

    // options in the menu
    private int currentOption = 0;
    private String[] options = {
        "Return To Menu",
        "QUIT"
    };

    public EndState(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void init() {
        bg = ImgLoader.loseScreen[0][0];
        arrow = ImgLoader.arrow[0][0];

    }

    @Override
    public void update() {
        handleInput();

    }

    /**
     * GDraws the losing state with the messages and moves the cursor depending
     * on the option that is currently selected
     *
     * @param g
     */
    @Override
    public void draw(Graphics2D g) {
        g.drawImage(bg, 0, 0, null);
        ImgLoader.drawString(g, "You lose", 230, 330);

        ImgLoader.drawString(g, options[0], 230, 400);
        ImgLoader.drawString(g, options[1], 230, 440);

        switch (currentOption) {
            case 0:
                g.drawImage(arrow, 190, 400, null);
                break;
            case 1:
                g.drawImage(arrow, 190, 440, null);
                break;
            default:
                break;
        }

    }

    /**
     * Changes the current option selected when the up or down arrow is pressed
     */
    @Override
    public void handleInput() {
        if (Keys.isPressed(Keys.DOWN) && currentOption < options.length - 1) {
            currentOption++;
            System.out.printf("%d\n", currentOption);
        }
        if (Keys.isPressed(Keys.UP) && currentOption > 0) {
            currentOption--;
            System.out.printf("%d\n", currentOption);
        }
        if (Keys.isPressed(Keys.ENTER)) {
            System.out.printf("%d\n", currentOption);

            selectOption();
        }

    }

    /**
     * Executes action once <enter> is pressed
     */
    private void selectOption() {

        if (currentOption == 0) {
            gsm.setState(GameStateManager.MENU);
        }
        if (currentOption == 1) {
            System.exit(0);
        }
    }
}
