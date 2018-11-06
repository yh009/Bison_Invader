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
 * File: Bow.java
 * Description: A class for the Bow weapon
 *
 * ****************************************
 */
package model.weapons;

import model.entities.Entity;
import model.items.Arrow;
import model.items.Item;

/**
 * A class for the Bow weapon
 *
 * @author josephelvin
 */
public class Bow extends Weapon {

    public static final Item AMMO = new Arrow();

    public static final double ATTACK = 65.0;

    public Bow(Entity owner) {
        super(ATTACK, AMMO, owner);
    }

}
