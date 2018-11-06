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
 * File: NinjaStarUnit.java
 * Description: A class for the NinjaStarUnit item
 *
 * ****************************************
 */
package model.items;

import GUI.utility.ImgLoader;

/**
 * A class for the NinjaStarUnit item
 *
 * @author josephelvin
 */
public class NinjaStarUnit extends Item {

    /**
     * Constructor for the NinjaStarUnit object
     */
    public NinjaStarUnit() {
        super();
        this.width = 22;
        this.height = 21;

        this.loadImg(ImgLoader.NinjaStar[0][0]);
    }
}
