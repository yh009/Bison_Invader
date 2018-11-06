/* *****************************************
 * Software Engineering and Design
 * Spring 2017
 *
 * Name: Joseph Elvin, Yuxuan Huang
 * Date: Apr 9, 2017
 * Time: 8:02:14 PM
 *
 * Project: cBisonInvader
 * Package: GUI.mode
 * File: Wave.java
 * Description: A class to update and draw flying weapons
 *
 * ****************************************
 */
package GUI.model;

import java.awt.Graphics2D;
import java.util.ArrayList;
import model.weapons.Weapon;

/**
 *
 * @author Yuxuan Huang
 */
public class WeaponInAir {

    private ArrayList<Weapon> weaponInAir;
    private Wave enemy;

    public WeaponInAir(Wave curWave) {
        this.weaponInAir = new ArrayList<>();
        this.enemy = curWave;
    }

    public void updateAllWeaponInAir() {
        for (int i = 0; i < weaponInAir.size(); i++) {
            if (weaponInAir.get(i).checkOutOfBorder()) {
                removeWeapon(weaponInAir.get(i));
                continue;
            }
            else if (enemy.handleIntersect(weaponInAir.get(i))) {
                removeWeapon(weaponInAir.get(i));
                continue;
            }
            else {
                weaponInAir.get(i).move();
            }
        }
    }

    public void drawAllWeaponInAir(Graphics2D g) {
        for (int i = 0; i < weaponInAir.size(); i++) {
            weaponInAir.get(i).draw(g);
        }
    }

    /**
     * Adds weapon to the air
     *
     * @param w
     */
    public void addWeapon(Weapon w) {
        weaponInAir.add(w);
    }

    /**
     * Removes the weapon when the enemy is struck
     *
     * @param w
     */
    public void removeWeapon(Weapon w) {
        weaponInAir.remove(w);
    }

    /**
     * setter for wave
     *
     * @param enemy
     */
    public void setEnemy(Wave enemy) {
        this.enemy = enemy;
    }

    /**
     * getter for weaponInAir
     *
     * @return
     */
    public ArrayList<Weapon> getWeaponInAir() {
        return weaponInAir;
    }

}
