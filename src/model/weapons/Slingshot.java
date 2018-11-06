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
 * File: Slingshot.java
 * Description: A class for the Slingshot weapon
 *
 * ****************************************
 */
package model.weapons;

import model.entities.Entity;
import model.items.Item;
import model.items.Pellet;

/**
 * A class for the Slingshot weapon
 *
 * @author josephelvin
 */
public class Slingshot extends Weapon {

    public static final Item AMMO = new Pellet();

    public static final double ATTACK = 35.0;

    public Slingshot(Entity owner) {
        super(ATTACK, AMMO, owner);
    }

}
