/* *****************************************
 * Software Engineering and Design
 * Spring 2017
 *
 * Name: Joseph Elvin, Yuxuan Huang
 * Date: Apr 9, 2017
 * Time: 8:02:14 PM
 *
 * Project: BisonInvader
 * Package: Main
 * File: Main.java
 * Description: A main class to run
 *
 * ****************************************
 */
package Main;

import GUI.view.Game;
import javax.swing.JFrame;

/**
 * A main class to run
 *
 * @author Yuxuan Huang
 */
public class Main {

    public static void main(String[] args) {

        JFrame window = new JFrame("Bison Invaders");

        window.add(new Game());

        window.setResizable(false);
        window.pack();

        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
