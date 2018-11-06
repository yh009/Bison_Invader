/* *****************************************
 * Software Engineering and Design
 * Spring 2017
 *
 * Name: Joseph Elvin, Yuxuan Huang
 * Date: Apr 9, 2017
 * Time: 8:02:14 PM
 *
 * Project: cBisonInvader
 * Package: GUI.mode
 * File: Wave.java
 * Description: A class to represent a wave of enemies
 *
 * ****************************************
 */
package GUI.model;

import GUI.ctrl.GameState.PlayState;
import model.entities.Enemy;
import model.entities.Fiend;
import model.entities.Orc;
import model.entities.Troll;
import model.items.Item;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import model.weapons.Weapon;

/**
 * A class to represent a wave of enemies
 *
 * @author josephelvin, Yuxuan Huang
 */
public class Wave {

    public static ArrayList<Item> newItemList = new ArrayList<>();
    public static Item newItem;

    public static final int DIAMETER = 400;
    public static final double OFFSET = 40.0;
    public static final double Y_WAVE_OFFSET = (600 - DIAMETER) / 2;

    private int numFiends;
    private int numOrcs;
    private int numTrolls;
    private PlayState ps;

    private CopyOnWriteArrayList<Enemy> enemyList;

    public Wave(int n, PlayState ps) {
        this.numTrolls = 2 * n;
        this.numFiends = 3 * n;
        this.numOrcs = 1 * n;
        this.enemyList = new CopyOnWriteArrayList<Enemy>();
        this.ps = ps;

        int i;
        int INIT_X = 1000;
        Random rand = new Random();
        //randomizes the enemies and their location in attacking
        for (i = 0; i < numTrolls; i++) {
            double posY = DIAMETER * rand.nextDouble() + Y_WAVE_OFFSET;
            this.enemyList.add(new Troll(INIT_X, (int) posY));
            INIT_X += OFFSET / n;
        }
        for (i = 0; i < numOrcs; i++) {
            double posY = DIAMETER * rand.nextDouble() + Y_WAVE_OFFSET;
            this.enemyList.add(new Orc(INIT_X, (int) posY));
            INIT_X += OFFSET / n;
        }
        for (i = 0; i < numFiends; i++) {
            double posY = DIAMETER * rand.nextDouble() + Y_WAVE_OFFSET;
            this.enemyList.add(new Fiend(INIT_X, (int) posY));
            INIT_X += OFFSET / n;
        }

        long seed = System.nanoTime();
        Collections.shuffle(this.enemyList, new Random(seed));

    }

    /**
     * Denotes when the enemies are all killed and a wave is over
     *
     * @return
     */
    public boolean isFinished() {
        return this.enemyList.isEmpty();
    }

    /**
     * Moves the enemies and if enemy reaches the left side, deduct health from
     * castle
     */
    public void updateEnemyList() {
        for (Enemy e : this.enemyList) {
            if (e.isDead()) {
                this.ps.getBuilding().setCurHealth(
                        ps.getBuilding().getCurHealth() - e.getDemage());
                this.enemyList.remove(e);
            }
            else {
                e.moveX(-1 * e.getSpeed());
            }
        }
    }

    /**
     * Visualizes the current wave
     *
     * @param g
     */
    public void drawWave(Graphics2D g) {
        for (int i = 0; i < enemyList.size(); i++) {
            enemyList.get(i).draw(g);
        }
    }

    public CopyOnWriteArrayList<Enemy> getEnemyList() {
        return enemyList;
    }

    /**
     * Removes the enemy from the list and the screen
     *
     * @param e
     */
    public void removeEnemy(Enemy e) {
        this.enemyList.remove(e);
    }

    /**
     * Handles when weapon hits the enemy
     *
     * @param w
     * @return
     */
    public boolean handleIntersect(Weapon w) {

        int curX;
        int curY;

        for (Enemy e : this.enemyList) {
            curX = e.getX();
            curY = e.getY();
            if (w.intersect(e)) {
                boolean alive = e.attacked(w);
                if (alive == false) {
                    newItem = e.getDrop();
                    if (newItem != null) {
                        newItem.drop(curX, curY);
                        newItemList.add(newItem);
                    }
                    enemyList.remove(e);
                    ps.addPoints(e.getPoints());
                }

                return true;
            }

        }
        return false;
    }

    public ArrayList<Item> getNewItems() {
        return newItemList;
    }

    public void clearList() {
        newItemList.clear();
    }

}
