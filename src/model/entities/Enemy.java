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
 * Description: A master class for the enemies
 *
 * ****************************************
 */
package model.entities;

import model.items.Item;
import model.weapons.Weapon;

/**
 * A master class for the enemies
 *
 * @author josephelvin
 */
public class Enemy extends Entity {

    /**
     * Strength of the enemy
     */
    private double attackStrength;

    /**
     * Rate at which the enemy attacks
     */
    private double attackRate;

    int demage;

    int points;

    Item drop;

    /**
     * Constructor for an enemy
     *
     * @param posX Initial x position
     * @param posY Initial y position
     */
    public Enemy(int posX, int posY, double attackStrength,
                 double attackRate, double maxHealth, int speed) {
        super(posX, posY, maxHealth);
        this.attackRate = attackRate;
        this.attackStrength = attackStrength;
        this.setSpeed(speed);
        //this.width = 50;
        //this.height = 50;
        //this.loadImg(ImgLoader.bottle[0][0]);

    }

    // Getter/setter methods
    public double getAttackStrength() {
        return attackStrength;
    }

    public double getAttackRate() {
        return attackRate;
    }

    public void setAttackStrength(double attackStrength) {
        this.attackStrength = attackStrength;
    }

    public void setAttackRate(double attackRate) {
        this.attackRate = attackRate;
    }

    public int getDemage() {
        return demage;
    }

    public boolean attacked(Weapon w) {
        this.curHealth = curHealth - w.getAttackStrength();
        return curHealth > 0;

    }

    public int getPoints() {
        return points;

    }

    public Item getDrop() {
        return this.drop;
    }

    /**
     * The enemy is dead once it reaches a certain boundary
     *
     * @return True if the enemy has been killed
     */
    @Override
    public boolean isDead() {
        return this.posX <= 70;
    }
}
