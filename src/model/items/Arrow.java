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
 * File: TomatoUnit.java
 * Description: A class for the Arrow item
 *
 * ****************************************
 */
package model.items;

import GUI.utility.ImgLoader;

/**
 * A class for the Arrow item
 *
 * @author josephelvin
 */
public class Arrow extends Item {

    /**
     * Constructor for the Arrow object
     */
    public Arrow() {
        this.width = 552;
        this.height = 132;

        this.loadImg(ImgLoader.ammoArrow[0][0]);
    }
}
