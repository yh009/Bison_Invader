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
 * Description: A class for the Castle
 *
 * ****************************************
 */
package model.buildings;

/**
 * A class for the Castle
 *
 * @author josephelvin
 */
public class Castle extends Building {

    public static final double MAX_HEALTH = 100.0;

    public Castle() {
        super(MAX_HEALTH);
    }
}
