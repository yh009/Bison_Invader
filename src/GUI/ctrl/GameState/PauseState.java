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
 * File: PauseState.java
 * Description: A class for pause state
 *
 * ****************************************
 */
package GUI.ctrl.GameState;

import GUI.utility.ImgLoader;
import GUI.utility.Keys;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * Escape Button is pressed to reach this screen, the pause State
 *
 * @author Yuxuan Huang
 */
public class PauseState extends GameState {

    private BufferedImage bg = ImgLoader.menuBG[0][0];
    private BufferedImage arrow = ImgLoader.arrow[0][0];

    private int currentOption = 0;
    private String[] options = {
        "Resume",
        "Return to Menu",
        "QUIT"
    };

    public PauseState(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void init() {

    }

    @Override
    public void update() {
        handleInput();
    }

    /**
     * Draws the pause state UI
     *
     * @param g
     */
    @Override
    public void draw(Graphics2D g) {
        g.drawImage(bg, 0, 0, null);

        ImgLoader.drawString(g, options[0], 230, 400);
        ImgLoader.drawString(g, options[1], 230, 440);
        ImgLoader.drawString(g, options[2], 230, 480);

        switch (currentOption) {
            case 0:
                g.drawImage(arrow, 190, 400, null);
                break;
            case 1:
                g.drawImage(arrow, 190, 440, null);
                break;
            case 2:
                g.drawImage(arrow, 190, 480, null);
                break;
            default:
                break;
        }

    }

    /**
     * FOr moving the cursor up and down the menu.
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
     * Selects options from the menu
     */
    private void selectOption() {

        if (currentOption == 0) {
            gsm.setPaused(false);
        }
        if (currentOption == 1) {
            gsm.setPaused(false);
            gsm.setState(GameStateManager.MENU);

        }
        if (currentOption == 2) {
            System.exit(0);
        }
    }

}
