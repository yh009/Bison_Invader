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
 * File: Tomato.java
 * Description: A class for the Tomato weapon
 *
 * ****************************************
 */
package model.weapons;

import GUI.utility.ImgLoader;
import model.entities.Entity;
import model.items.Item;
import model.items.TomatoUnit;

/**
 * A class for the Tomato weapon
 *
 * @author josephelvin
 */
public class Tomato extends Weapon {

    public static final Item AMMO = new TomatoUnit();

    public static final double ATTACK = 50;

    public Tomato(Entity owner) {
        super(ATTACK, AMMO, owner);
        setInitPos();
        this.width = 25;
        this.height = 25;
        this.img = ImgLoader.tomato[0][0];

    }

}
