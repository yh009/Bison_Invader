/* *****************************************
 * Software Engineering and Design
 * Spring 2017
 *
 * Name: Joseph Elvin, Jonathan Li, Yuxuan Huang
 * Date: Apr 9, 2017
 * Time: 8:02:14 PM
 *
 * Project: cBisonInvader
 * Package: GUI.mode
 * File: Wave.java
 * Description: A class to update and draw weapons on the ground 
 *
 * ****************************************
 */
package GUI.model;

import model.entities.MainChar;
import model.items.Item;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 *
 * @author Yuxuan Huang
 */
public class WeaponOnGround {

    private ArrayList<Item> weaponOnGround;
    private MainChar mainChar;

    public WeaponOnGround(MainChar mainChar) {
        this.weaponOnGround = new ArrayList<>();
        this.mainChar = mainChar;
    }

    public void updateAllWeaponOnGround() {
        for (int i = 0; i < weaponOnGround.size(); i++) {
            if (mainChar.intersectItem(weaponOnGround.get(i))) {
                System.out.println("Picked up weapon");
                mainChar.addItem(weaponOnGround.get(i), 10);
                removeItem(weaponOnGround.get(i));
                continue;
            }
        }
    }

    public void drawAllWeaponOnGround(Graphics2D g) {
        for (int i = 0; i < weaponOnGround.size(); i++) {
            weaponOnGround.get(i).draw(g);
        }
    }

    public void addItem(Item i) {
        weaponOnGround.add(i);
    }

    public void removeItem(Item i) {
        weaponOnGround.remove(i);
    }
}
