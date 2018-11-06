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
 * File: MenuState.java
 * Description: A class for the MenuState
 *
 * ****************************************
 */
package GUI.ctrl.GameState;

import GUI.utility.ImgLoader;
import GUI.utility.Keys;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * A class for the MenuState, the main menu
 *
 * @author Yuxuan Huang
 */
public class MenuState extends GameState {

    private BufferedImage bg;
    private BufferedImage arrow;

    //different options on this menu
    private int currentOption = 0;
    private String[] options = {
        "Story Mode",
        "Endless Mode",
        "QUIT"
    };

    public MenuState(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void init() {
        bg = ImgLoader.menuBG[0][0];
        arrow = ImgLoader.arrow[0][0];
    }

    @Override
    public void update() {
        handleInput();
    }

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

    private void selectOption() {
        if (currentOption == 0) {
            gsm.setState(GameStateManager.PLAY);
        }
        if (currentOption == 1) {
            gsm.setState(GameStateManager.PLAYINF);
        }
        if (currentOption == 2) {
            System.exit(0);
        }
    }

}
