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
 * File: MainChar.java
 * Description: A class for the main character
 *
 * ****************************************
 */
package model.entities;

import GUI.utility.ImgLoader;
import model.items.Item;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import model.weapons.Tomato;
import model.weapons.Weapon;

/**
 * A class for the main character
 *
 * @author josephelvin, Yuxuan Huang
 */
public class MainChar extends Entity {

    public static final double MAX_HEALTH = 100;

    /**
     * An item list to keep track of items picked up
     */
    private Map<Item, Integer> itemList;

    /**
     * An array to keep track of weapons owned
     */
    private ArrayList<Weapon> weaponList;

    /**
     * The current weapon being used by the character
     */
    //private Weapon curWeapon;
    /**
     * Constructor for the main character
     *
     * @param posX Initial x position
     * @param posY Initial y position
     */
    public MainChar(int posX, int posY) {
        super(posX, posY, MAX_HEALTH);
        this.weaponList = new ArrayList<Weapon>();
        this.itemList = new HashMap<Item, Integer>();
        weaponList.add(new Tomato(this));
        //this.curWeapon = weaponList.get(this.weaponList.size() - 1);
        this.width = 50;
        this.height = 100;

        this.loadImg(ImgLoader.mainChar[0][0]);
        this.setSpeed(7);

    }

    // Getter/setter methods
    public Map<Item, Integer> getItemList() {
        return itemList;
    }

    public ArrayList<Weapon> getWeaponList() {
        return weaponList;
    }

    /*
    public Weapon getCurWeapon() {
        this.curWeapon.setInitPos();
        return this.curWeapon;
    }*/
    public void setItemList(Map<Item, Integer> itemList) {
        this.itemList = itemList;
    }

    public void setWeaponList(ArrayList<Weapon> weaponList) {
        this.weaponList = weaponList;
    }

    /*
    public void setCurWeapon(Weapon weapon) {
        this.curWeapon = weapon;
    }*/
    /**
     * Adds a weapon to the main characters weapon list
     *
     * @param weapon Weapon to be added
     */
    public void addWeapon(Weapon weapon) {
        this.weaponList.add(weapon);
    }

    /**
     * Adds an item to the main characters item list
     *
     * @param item Item to be added
     * @param n The number of said item to be added
     */
    public void addItem(Item item, int n) {
        int count = n;
        if (this.itemList.containsKey(item)) {
            count = this.itemList.get(item) + n;
        }
        this.itemList.put(item, count);

    }

    /**
     * Cause main character to fire weapon
     *
     * @return
     */
    public Weapon attack() {
        Tomato temp = new Tomato(this);
        return temp;

        //this.weaponList.add(temp);
        //this.curWeapon = new Tomato(this);
        //this.curWeapon = new Tomato(this);
        /*
        if (this.itemList.get(this.curWeapon.getAmmo()) > 0) {

            this.curWeapon.fire();

            int count = this.itemList.get(this.curWeapon.getAmmo());

            this.itemList.put(this.curWeapon.getAmmo(), count - 1);
        }*/
    }

    /**
     * Move main character by x in the x position
     *
     * @param x Distance to move
     */
    public void moveX(int x) {
        this.posX += this.speed * x;
    }

    /**
     * Move main character by y in the y position
     *
     * @param y Distance to move
     */
    public void moveY(int y) {
        this.posY += this.speed * y;
    }

    /**
     * Draw the character
     *
     * @param g
     */
    @Override
    public void draw(Graphics2D g) {
        super.draw(g);
    }

    public boolean intersectItem(Item i) {
        return getRectangle().intersects(i.getRectangle());
    }

}
