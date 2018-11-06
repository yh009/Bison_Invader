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
 * File: Entity.java
 * Description: A master class for the entities
 *
 * ****************************************  */
package model.entities;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 * * A master class for the entities * * @author josephelvin, Yuxuan Huang
 */
public class Entity {

    private BufferedImage img;
    /**
     * * Max health for entity
     */
    double maxHealth;
    /**
     * * Current health of entity
     */
    double curHealth;
    /**
     * * X coordinate of entity
     */
    int posX;
    /**
     * * Y coordinate of entity
     */
    int posY;
    /**
     * * movement speed
     */
    int speed;
    /**
     * * pic width
     */
    int width;
    /**
     * * pic height
     */
    int height;

    /**
     * Constructor for an Entity
     *
     *
     * @param posX Initial X Position
     *
     *
     * @param posY Initial Y Position
     */
    public Entity(int posX, int posY, double maxHealth) {
        this.posX = posX;
        this.posY = posY;
        this.maxHealth = maxHealth;
        this.curHealth = maxHealth;
    }
    // Getter/Setter methods

    public int getX() {
        return this.posX;
    }

    public int getY() {
        return this.posY;
    }

    public double getMaxHealth() {
        return this.maxHealth;
    }

    public double getCurHealth() {
        return this.curHealth;
    }

    public void setX(int x) {
        this.posX = x;
    }

    public void setY(int y) {
        this.posY = y;
    }

    public void setMaxHealth(double health) {
        this.maxHealth = health;
    }

    public void setCurHealth(double health) {
        this.curHealth = health;
    }

    public BufferedImage getImg() {
        return img;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * * Moves the entity in the X direction by n * * @param x Position
     * displacement
     */
    public void moveX(int x) {
        this.posX += x;
    }

    /**
     * * Moves the entity in the Y direction by n * * @param y Position
     * displacement
     */
    public void moveY(int y) {
        this.posY += y;
    }

    /**
     * * Add health to the entity * * @param n Amount of health to add
     */
    public void addHealth(double n) {
        this.curHealth += n;
        if (this.curHealth > this.maxHealth) {
            this.curHealth = this.maxHealth;
        }
        else if (this.curHealth < 0) {
            this.curHealth = 0;
        }
    }

    /**
     * Determines if entity is dead
     *
     * @return True if enemy is dead, false if alive.
     */
    public boolean isDead() {
        return (this.curHealth <= 0);
    }

    /**
     * Load entity image
     *
     * @param img
     */
    public void loadImg(BufferedImage img) {
        this.img = img;
    }

    /**
     * Draw entity
     *
     * @param g
     */
    public void draw(Graphics2D g) {
        g.drawImage(img, posX - width / 2, posY - height / 2, null);
    }

    /**
     * Get rectangle surrounding entity
     *
     * @return Rectangle which surrounds the entity
     */
    public Rectangle getRectangle() {
        return new Rectangle(posX, posY, width, height);
    }

    /**
     * Determines if the entity is intersecting another entity
     *
     * @param o Entity to be checked
     * @return True if the entities overlap
     */
    public boolean intersectEntity(Entity o) {
        return getRectangle().intersects(o.getRectangle());
    }

}
