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
 * File: Enemy.java
 * Description: A class for the Fiend
 *
 * ****************************************
 */
package model.entities;

import GUI.utility.ImgLoader;
import java.util.Random;
import model.items.BottleUnit;
import model.items.NinjaStarUnit;
import model.items.Pellet;

/**
 * A class for the Fiend
 *
 * @author josephelvin
 */
public class Fiend extends Enemy {

    // Parameters which are unique to the Fiend class
    public static final double ATTACK_RATE = 1.5;
    public static final int SPEED = 3;
    public static final double STRENGTH = 0.5;
    public static final double MAX_HEALTH = 150;
    public static final int DEMAGE = 15;

    public Fiend(int posX, int posY) {
        super(posX, posY, STRENGTH, ATTACK_RATE, MAX_HEALTH, SPEED);
        this.demage = DEMAGE;
        this.loadImg(ImgLoader.Fiend[0][0]);
        this.width = 50;
        this.height = 97;
        this.curHealth = MAX_HEALTH;
        this.points = 15;

        Random rand = new Random();
        double dropChaunce = rand.nextDouble();

        if (dropChaunce < 0.4) {
            this.drop = null;
        }
        else if (dropChaunce < 0.7) {
            this.drop = new Pellet();
        }
        else if (dropChaunce < 0.9) {
            this.drop = new BottleUnit();
        }
        else {
            this.drop = new NinjaStarUnit();
        }

    }
}
