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
 * Description: A class for the BottleUnit item
 *
 * ****************************************
 */
package model.items;

import GUI.utility.ImgLoader;

/**
 * A class for the BOttleUnit item
 *
 * @author josephelvin
 */
public class BottleUnit extends Item {

    /**
     * Constructor for the BottleUnit object
     */
    public BottleUnit() {
        super();
        this.width = 10;
        this.height = 34;

        this.loadImg(ImgLoader.bottle[0][0]);
    }
}
