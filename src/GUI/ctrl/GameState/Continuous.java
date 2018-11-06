/* *****************************************
 * Software Engineering and Design
 * Spring 2017
 *
 * Name: Joseph Elvin, Yuxuan Huang
 * Date: Apr 9, 2017
 * Time: 8:02:14 PM
 *
 * Project: BisonInvader
 * Package: GUI.mode
 * File: Continuous.java
 * Description: A class for the Continuous game mode
 *
 * ****************************************
 */
package GUI.ctrl.GameState;

import model.entities.Enemy;
import model.entities.Fiend;
import model.entities.Orc;
import model.entities.Troll;
import java.util.ArrayList;
import java.util.Random;

/**
 * A class for the Continuous game mode
 *
 * @author josephelvin
 */
public class Continuous {

    public static final Random rand = new Random();

    private double timer;
    private ArrayList<Enemy> enemyList;
    private double spawnThreshold;
    private int nextSpawn;

    public Continuous() {
        this.timer = 0;
        this.enemyList = new ArrayList<Enemy>();
        rand.nextInt(4);

    }

    public int getTime() {
        return (int) this.timer;
    }

    public void update() {
        for (Enemy e : this.enemyList) {
            if (e.isDead()) {
                this.enemyList.remove(e);
            }
        }

        this.timer += 0.033;
        this.spawnThreshold = 2.0 / (1 + Math.exp(-.01 * this.timer)) - 1;

        double posY;
        if (rand.nextDouble() < this.spawnThreshold) {
            this.nextSpawn = rand.nextInt(3);
            if (this.nextSpawn == 0) {
                posY = 400 * rand.nextDouble() + 100;
                this.enemyList.add(new Fiend(840, (int) posY));
            }
            else if (this.nextSpawn == 1) {
                posY = 400 * rand.nextDouble() + 100;
                this.enemyList.add(new Troll(840, (int) posY));
            }
            else {
                posY = 400 * rand.nextDouble() + 100;
                this.enemyList.add(new Orc(840, (int) posY));
            }
        }

    }
}
