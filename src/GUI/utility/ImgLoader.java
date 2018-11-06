/* *****************************************
 * Software Engineering and Design
 * Spring 2017
 *
 * Name: Joseph Elvin, Yuxuan Huang
 * Date: Apr 9, 2017
 * Time: 8:02:14 PM
 *
 * Project: BisonInvader
 * Package: entities
 * File: ImgLoader.java
 * Description: A class for the Image Loader
 *
 * ****************************************
 */
package GUI.utility;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/**
 * A class for the Image Loader
 *
 * @author Yuxuan Huang
 */
public class ImgLoader {

    public static BufferedImage[][] menuBG = load("menuscreen.png", 800,
                                                  600);
    public static BufferedImage[][] playScreen = load("gamespace.png", 800, 600);
    public static BufferedImage[][] endScreen = load("endscreen.png", 800, 600);
    public static BufferedImage[][] loseScreen = load("loseScreen.png", 800, 600);

    public static BufferedImage[][] castle = load("Castle.png", 300, 300);

    public static BufferedImage[][] mainChar = load("MainChar.png", 37, 81);
    public static BufferedImage[][] tomato = load("Tomato.png", 8, 8);
    public static BufferedImage[][] NinjaStar = load("NinjaStar.png", 22, 21);
    public static BufferedImage[][] arrow = load("diamond.gif", 32, 32);

    public static BufferedImage[][] bottle = load("Bottle.png", 10, 34);
    public static BufferedImage[][] ammoArrow = load("Arrow.png", 37, 9);
    public static BufferedImage[][] pellet = load("Pellet.png", 20, 19);

    public static BufferedImage[][] font = load("font1.gif", 32, 32);

    public static BufferedImage[][] Fiend = load("Fiend.png", 50, 97);
    public static BufferedImage[][] Orc = load("Orc.png", 50, 126);
    public static BufferedImage[][] Troll = load("Troll.png", 30, 34);

    public static BufferedImage[][] load(String s, int w, int h) {
        BufferedImage[][] ret;
        try {
            BufferedImage spritesheet = ImageIO.read(
                    ImgLoader.class.getResourceAsStream(s));
            int width = spritesheet.getWidth() / w;
            int height = spritesheet.getHeight() / h;
            ret = new BufferedImage[height][width];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    ret[i][j] = spritesheet.getSubimage(
                            j * w, i * h, w, h);

                }
            }
            return ret;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error loading graphics.");
            System.exit(0);
        }
        return null;
    }

    public static void drawString(Graphics2D g, String s, int x, int y) {
        s = s.toUpperCase();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 47) {
                c = 36; // slash
            }
            if (c == 58) {
                c = 37; // colon
            }
            if (c == 32) {
                c = 38; // space
            }
            if (c >= 65 && c <= 90) {
                c -= 65; // letters
            }
            if (c >= 48 && c <= 57) {
                c -= 22; // numbers
            }
            int row = c / font[0].length;
            int col = c % font[0].length;
            g.drawImage(font[row][col], x + 32 * i, y, null);
        }
    }

}
