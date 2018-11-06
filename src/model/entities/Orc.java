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
 * Description: A class for the Orc
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
 * A class for the Orc
 *
 * @author josephelvin
 */
public class Orc extends Enemy {

    // Parameters which are unique to the Orc class
    public static final double ATTACK_RATE = .75;
    public static final int SPEED = 2;
    public static final double STRENGTH = 1.5;
    public static final double MAX_HEALTH = 300;
    public static final int DEMAGE = 10;

    public Orc(int posX, int posY) {
        super(posX, posY, STRENGTH, ATTACK_RATE, MAX_HEALTH, SPEED);
        this.demage = DEMAGE;
        this.loadImg(ImgLoader.Orc[0][0]);
        this.width = 50;
        this.height = 126;
        this.curHealth = MAX_HEALTH;
        this.points = 20;

        Random rand = new Random();
        double dropChaunce = rand.nextDouble();

        if (dropChaunce < 0.4) {
            this.drop = null;
        }
        else if (dropChaunce < 0.7) {
            this.drop = new BottleUnit();
        }
        else if (dropChaunce < 0.95) {
            this.drop = new NinjaStarUnit();
        }
        else {
            this.drop = new Arrow();
        }
    }
}
