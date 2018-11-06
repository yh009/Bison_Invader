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
 * File: PlayState.java
 * Description: A class to handle the PlayStates
 *
 * ****************************************
 */
package GUI.ctrl.GameState;

import GUI.utility.ImgLoader;
import GUI.utility.Keys;
import GUI.model.Wave;
import GUI.model.WeaponInAir;
import GUI.model.WeaponOnGround;
import model.buildings.Building;
import model.buildings.Castle;
import model.entities.MainChar;
import model.items.Item;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * A class to handle the PlayStates
 *
 * @author Yuxuan Huang
 */
public class PlayState extends GameState {

    private int opt;//1 -- normal; 2-- infinite
    private BufferedImage bg;
    private MainChar me;
    private Building building;
    private WeaponInAir wia;
    private Wave curWave;
    private WeaponOnGround wog;
    private int WaveCounter;
    private int Points;
    private final int MAX_WAVE = 3;
    private final int MAX_WAVE_INF = 10000;
    private int maxWave;
    private ArrayList<Item> itemsToBeAdded;
    //private Rectangle HPBase;

    public PlayState(GameStateManager gsm, int opt) {
        super(gsm);
        //Story Mode
        if (opt == 1) {
            maxWave = MAX_WAVE;

        }
        //Continuous Mode
        else if (opt == 2) {
            maxWave = MAX_WAVE_INF;
        }

    }

    @Override
    public void init() {

        itemsToBeAdded = new ArrayList<>();

        bg = ImgLoader.playScreen[0][0];
        //sets where the character spawns
        me = new MainChar(75, 250);
        building = new Castle();
        //weapon = new NinjaStar(me);

        //loads the castle
        me.loadImg(ImgLoader.mainChar[0][0]);
        building.loadImg(ImgLoader.castle[0][0]);

        this.WaveCounter = 1;
        curWave = new Wave(WaveCounter, this);
        wia = new WeaponInAir(curWave);
        wog = new WeaponOnGround(me);
        Points = 0;
        //HPBase = new Rectangle(0, 180, 50, 3);

    }

    /**
     * Updates the waves and the weapons
     */
    @Override
    public void update() {
        //check keys
        handleInput();
        wia.updateAllWeaponInAir();
        wog.updateAllWeaponOnGround();
        curWave.updateEnemyList();

        for (Item i : curWave.getNewItems()) {
            itemsToBeAdded.add(i);
        }

        if (itemsToBeAdded.size() > 0) {
        }

        for (Item i : itemsToBeAdded) {
            wog.addItem(i);
        }

        if (curWave.isFinished()) {
            if (WaveCounter < maxWave) {
                WaveCounter++;

                curWave = new Wave(WaveCounter, this);
                wia.setEnemy(curWave);
            }
            else {
                beatGame();

            }

        }
        itemsToBeAdded.clear();
        meHit();
        checkHealth();

    }

    /**
     * Draws the UI on the png overlay
     *
     * @param g
     */
    @Override
    public void draw(Graphics2D g) {
        g.drawImage(bg, 0, 0, null);
        ImgLoader.drawString(g, "Points: ", 230, 550);
        ImgLoader.drawString(g, String.format("%d", Points), 480, 550);

        building.draw(g);
        g.setColor(Color.red);
        g.fillRect(8, 400, (int) building.getMaxHealth(), 4);
        g.setColor(Color.green);
        g.fillRect(8, 400, (int) building.getCurHealth(), 4);
        me.draw(g);
        wia.drawAllWeaponInAir(g);
        //wog.drawAllWeaponOnGround(g);
        curWave.drawWave(g);

    }

    /**
     * Action buttons , allows the player to shoot and move in the game
     */
    @Override
    public void handleInput() {
        if (Keys.isPressed(Keys.ESCAPE)) {
            gsm.setPaused(true);
        }
        if (Keys.isDown(Keys.LEFT)) {
            me.moveX(-1);
        }
        if (Keys.isDown(Keys.RIGHT)) {
            me.moveX(1);
        }
        if (Keys.isDown(Keys.UP)) {
            me.moveY(-1);
        }
        if (Keys.isDown(Keys.DOWN)) {
            me.moveY(1);
        }
        if (Keys.isPressed(Keys.SPACE)) {
            wia.addWeapon(me.attack());
            //me.getWeaponList().get(me.getWeaponList().size() - 1);

            //System.out.println("Attacked");
        }
    }

    /**
     * Sets the game state to End State and the user loses if the player
     * intersects an enemy
     */
    private void meHit() {
        for (int i = 0; i < curWave.getEnemyList().size(); i++) {
            if (me.intersectEntity(curWave.getEnemyList().get(i))) {
                gsm.setState(GameStateManager.END);
                //System.out.println("Under attack");
            }
        }
    }

    /**
     * Gets the building
     *
     * @return
     */
    public Building getBuilding() {
        return building;
    }

    /**
     * Checks the health of the castle and sets the State to EndState if the
     * health is depleted
     */
    private void checkHealth() {
        if (this.building.getCurHealth() <= 0) {
            gsm.setState(GameStateManager.END);

        }
    }

    /**
     * Adds points to the user point score
     *
     * @param value
     */
    public void addPoints(int value) {
        Points += value;
    }

    /**
     * Sets the state to the Win State once the game is won
     */
    public void beatGame() {

        gsm.setState(GameStateManager.WIN);
    }

}
