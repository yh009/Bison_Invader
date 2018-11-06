/* *****************************************
 * Software Engineering and Design
 * Spring 2017
 *
 * Name: Joseph Elvin, Yuxuan Huang
 * Date: Apr 9, 2017
 * Time: 8:02:14 PM
 *
 * Project: BisonInvader
 * Package: entities
 * File: Troll.java
 * Description: A class for the Troll
 *
 * ****************************************
 */
package model.entities;

import GUI.utility.ImgLoader;
import model.items.Arrow;
import model.items.BottleUnit;
import model.items.NinjaStarUnit;
import java.util.Random;

/**
 * A class for the Troll
 *
 * @author josephelvin
 */
public class Troll extends Enemy {

    // Parameters which are unique to the Troll class
    public static final double ATTACK_RATE = 1;
    public static final int SPEED = 5;
    public static final double STRENGTH = 1;
    public static final double MAX_HEALTH = 50;
    public static final int DEMAGE = 20;

    public Troll(int posX, int posY) {
        super(posX, posY, STRENGTH, ATTACK_RATE, MAX_HEALTH, SPEED);
        this.demage = DEMAGE;
        this.loadImg(ImgLoader.Troll[0][0]);
        this.width = 30;
        this.height = 34;
        this.curHealth = MAX_HEALTH;
        this.points = 10;

        Random rand = new Random();
        double dropChaunce = rand.nextDouble();

        if (dropChaunce < 0.3) {
            this.drop = null;
        }
        else if (dropChaunce < 0.6) {
            this.drop = new BottleUnit();
        }
        else if (dropChaunce < 0.8) {
            this.drop = new NinjaStarUnit();
        }
        else {
            this.drop = new Arrow();
        }
    }

}
