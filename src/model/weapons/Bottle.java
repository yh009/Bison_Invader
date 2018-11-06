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
 * File: Bottle.java
 * Description: A class for the Bottle weapon
 *
 * ****************************************
 */
package model.weapons;

import model.entities.Entity;
import model.items.BottleUnit;
import model.items.Item;

/**
 * A class for the Bottle weapon
 *
 * @author josephelvin
 */
public class Bottle extends Weapon {

    public static final Item AMMO = new BottleUnit();

    public static final double ATTACK = 45.0;

    public Bottle(Entity owner) {
        super(ATTACK, AMMO, owner);
    }

}
