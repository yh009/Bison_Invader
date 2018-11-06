/* *****************************************
 * Software Engineering and Design
 * Spring 2017
 *
 * Name: Joseph Elvin, Yuxuan Huang
 * Date: Apr 9, 2017
 * Time: 8:02:14 PM
 *
 * Project: BisonInvader
 * Package: weapons
 * File: Weapon.java
 * Description: A master class for the weapons
 *
 * ****************************************
 */
package model.weapons;

import model.entities.Entity;
import model.items.Item;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 * A master class for the weapons
 *
 * @author josephelvin, Yuxuan Huang
 */
public class Weapon {

    BufferedImage img;
    /**
     * The weapon's attack strength
     */
    private double attackStrength;

    /**
     * The ammo is used by the weapon
     */
    private Item ammo;

    private int speed;

    /**
     * X coordinate of entity
     */
    int posX;

    /**
     * Y coordinate of entity
     */
    int posY;

    /**
     * pic width
     */
    int width;

    /**
     * pic height
     */
    int height;

    Entity owner;

    /**
     * Constructor for a weapon
     *
     * @param attackStrength Attack strength of the weapon
     * @param ammo Ammo used by the weapon
     */
    public Weapon(double attackStrength, Item ammo, Entity owner) {
        this.ammo = ammo;
        this.attackStrength = attackStrength;
        this.speed = 10;
        this.owner = owner;

    }

    // Getter/settter methods
    public double getAttackStrength() {
        return attackStrength;
    }

    public Item getAmmo() {
        return ammo;
    }

    public void setAttackStrength(double attackStrength) {
        this.attackStrength = attackStrength;
    }

    public void setAmmo(Item ammo) {
        this.ammo = ammo;
    }

    /**
     * Fire the weapon
     */
    public void move() {
        this.posX += this.speed;

    }

    public boolean checkOutOfBorder() {
        return this.posX > 800;
    }

    public void loadImg(BufferedImage img) {
        this.img = img;
    }

    public BufferedImage getImg() {
        return img;
    }

    /**
     * Makes sure the weapon fires from where the player is
     */
    public void setInitPos() {
        int tempx = this.owner.getX();
        int tempy = this.owner.getY();
        this.posX = tempx;
        this.posY = tempy;
    }

    /**
     * Draws where the weapon is
     *
     * @param g
     */
    public void draw(Graphics2D g) {

        g.drawImage(img, posX - width / 2, posY - 30 + height / 2, null);
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public Rectangle getRectangle() {
        return new Rectangle(posX, posY, width, height);
    }

    /**
     * Sets when two objects intersect, used for when the weapon hits the enemy
     * and when the player hits the enemy
     *
     * @param o
     * @return
     */
    public boolean intersect(Entity o) {
        return getRectangle().intersects(o.getRectangle());
    }

}
