/* *****************************************
 * Software Engineering and Design
 * Spring 2017
 *
 * Name: Joseph Elvin, Yuxuan Huang
 * Date: Apr 9, 2017
 * Time: 8:02:14 PM
 *
 * Project: BisonInvader
 * Package: items
 * File: Pellet.java
 * Description: A class for the Pellet item
 *
 * ****************************************
 */
package model.items;

import GUI.utility.ImgLoader;

/**
 * A class for the Pellet item
 *
 * @author josephelvin
 */
public class Pellet extends Item {

    /**
     * Constructor for the Pellet object
     */
    public Pellet() {
        super();
        this.width = 192;
        this.height = 186;

        this.loadImg(ImgLoader.pellet[0][0]);
    }
}
