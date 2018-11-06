/* *****************************************
 * Software Engineering and Design
 * Spring 2017
 *
 * Name: Joseph Elvin, Yuxuan Huang
 * Date: Apr 9, 2017
 * Time: 8:02:14 PM
 *
 * Project: BisonInvader
 * Package: buildings
 * File: Building.java
 * Description: A master class for the buildings
 *
 * ****************************************
 */
package model.buildings;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * A master class for the buildings
 *
 * @author josephelvin
 */
public class Building {

    private BufferedImage img;
    /**
     * Max health of the building
     */
    private double maxHealth;

    /**
     * Current health of the building
     */
    private double curHealth;

    /**
     * Constructor for a building
     *
     * @param initHealth Initial building health
     */
    public Building(double initHealth) {
        this.maxHealth = initHealth;
        this.curHealth = maxHealth;
    }

    // Getter/Setter methods
    public double getMaxHealth() {
        return this.maxHealth;
    }

    public double getCurHealth() {
        return this.curHealth;
    }

    public void setMaxHealth(double h) {
        this.maxHealth = h;
    }

    public void setCurHealth(double h) {
        this.curHealth = h;
    }

    /**
     * Change the buildings health when damage is inflicted
     *
     * @param delta Change building health by delta amount
     */
    public void changeHealth(double delta) {
        this.curHealth += delta;

        if (this.curHealth < 0) {
            this.curHealth = 0;
        }
        else if (this.curHealth > this.maxHealth) {
            this.curHealth = this.maxHealth;
        }
    }

    /**
     * Load Building image
     *
     * @param img
     */
    public void loadImg(BufferedImage img) {
        this.img = img;
    }

    /**
     * Draw Building
     *
     * @param g
     */
    public void draw(Graphics2D g) {
        g.drawImage(img, -50, 100, null);
    }
}
