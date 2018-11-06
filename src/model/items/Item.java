/* *****************************************
 * Software Engineering and Design
 * Spring 2017
 *
 * Name: Joseph Elvin, Yuxuan Huang
 * Date: Apr 9, 2017
 * Time: 8:02:14 PM
 *
 * Project: BisonInvader
 * Package: items
 * File: Item.java
 * Description: A master class for the items
 *
 * ****************************************
 */
package model.items;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 * A master class for the items
 *
 * @author josephelvin
 */
public class Item {

    /**
     * Pic for item
     */
    private BufferedImage img;

    /**
     * * pic width
     */
    int width;
    /**
     * * pic height
     */
    int height;

    /**
     * * X coordinate of item
     */
    int posX;

    /**
     * * Y coordinate of item
     */
    int posY;

    /**
     * Constructor
     */
    public Item() {
    }

    public BufferedImage getImg() {
        return img;
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

    public void drop(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

}
