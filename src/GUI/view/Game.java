/* *****************************************
 * Software Engineering and Design
 * Spring 2017
 *
 * Name: Joseph Elvin, Yuxuan Huang
 * Date: Apr 9, 2017
 * Time: 8:02:14 PM
 *
 * Project: BisonInvader
 * Package: GUI.view
 * File: Game.java
 * Description: A view class for the Game
 *
 * ****************************************
 */
package GUI.view;

import GUI.ctrl.GameState.GameStateManager;
import GUI.utility.Keys;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 * A view class for the Game
 *
 * @author Yuxuan Huang
 */
public class Game extends JPanel implements Runnable, KeyListener {

    // dimensions
    // HEIGHT is the playing area size
    // HEIGHT2 includes the bottom window
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    // game loop stuff
    private Thread thread;
    private boolean running;
    private final int FPS = 45;
    private final int TARGET_TIME = 1000 / FPS;

    // drawing stuff
    private BufferedImage image;
    private Graphics2D g;

    // game state manager
    private GameStateManager gsm;

    // constructor
    public Game() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

    }

    // ready to display
    @Override
    public void addNotify() {
        super.addNotify();
        if (thread == null) {
            addKeyListener(this);
            thread = new Thread(this);
            thread.start();
        }
    }

    @Override
    public void run() {
        init();

        long start;
        long elapsed;
        long wait;

        // game loop
        while (running) {

            start = System.nanoTime();

            update();
            draw();
            drawToScreen();

            elapsed = System.nanoTime() - start;

            wait = TARGET_TIME - elapsed / 1000000;
            if (wait < 0) {
                wait = TARGET_TIME;
            }

            try {
                Thread.sleep(wait);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    // initializes fields
    private void init() {
        running = true;
        image = new BufferedImage(WIDTH, HEIGHT, 1);
        g = (Graphics2D) image.getGraphics();
        gsm = new GameStateManager();
    }

    // updates game
    private void update() {
        gsm.update();
        Keys.update();
    }

    // draws game
    private void draw() {
        gsm.draw(g);
    }

    // copy buffer to screen
    private void drawToScreen() {
        Graphics g2 = getGraphics();
        g2.drawImage(image, 0, 0, WIDTH, HEIGHT, null);
        g2.dispose();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        Keys.keySet(e.getKeyCode(), true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        Keys.keySet(e.getKeyCode(), false);
    }

}
