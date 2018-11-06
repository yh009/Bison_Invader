/* *****************************************
 * Software Engineering and Design
 * Spring 2017
 *
 * Name: Joseph Elvin, Yuxuan Huang
 * Date: Apr 9, 2017
 * Time: 8:02:14 PM
 *
 * Project: BisonInvader
 * Package: buildings
 * File: Castle.java
 * Description: A class for the Fortress
 *
 * ****************************************
 */
package model.buildings;

/**
 * A class for the Fortress
 *
 * @author josephelvin
 */
public class Fortress extends Building {

    public static final double MAX_HEALTH = 200.0;

    public Fortress() {
        super(MAX_HEALTH);
    }

}
