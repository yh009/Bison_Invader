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
 * File: NinjaStar.java
 * Description: A class for the NinjaStar weapon
 *
 * ****************************************
 */
package model.weapons;

import GUI.utility.ImgLoader;
import model.entities.Entity;
import model.items.Item;
import model.items.NinjaStarUnit;

/**
 * A class for the NinjaStar weapon
 *
 * @author josephelvin
 */
public class NinjaStar extends Weapon {

    public static final Item AMMO = new NinjaStarUnit();

    public static final double ATTACK = 55.0;

    public NinjaStar(Entity owner) {
        super(ATTACK, AMMO, owner);
        setInitPos();
        this.width = 25;
        this.height = 25;
        this.img = ImgLoader.NinjaStar[0][0];

    }

}
