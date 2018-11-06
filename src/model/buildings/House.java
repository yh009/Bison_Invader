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
 * Description: A class for the House
 *
 * ****************************************
 */
package model.buildings;

/**
 * A class for the House
 *
 * @author josephelvin
 */
public class House extends Building {

    public static final double MAX_HEALTH = 50.0;

    public House() {
        super(MAX_HEALTH);
    }

}
