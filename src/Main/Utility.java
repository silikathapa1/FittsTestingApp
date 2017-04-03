/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Domain.Triple;
import java.util.*;
import java.util.ArrayList;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Point2D;

/**
 * * @author Silika
 */
public class Utility {

    final static int small_rad = 16;
    final static int med_rad = 32;
    final static int lar_rad = 64;
    final static int near_dist = 128;
    final static int far_dist = 512;
    final static String left_dir = "left";
    final static String right_dir = "right";

    public static final List<Triple> tripleList = new ArrayList<>();

    static {
        tripleList.add(new Triple(small_rad, left_dir, near_dist));
        tripleList.add(new Triple(lar_rad, right_dir, far_dist));
        tripleList.add(new Triple(med_rad, right_dir, near_dist));
        tripleList.add(new Triple(small_rad, right_dir, near_dist));
        tripleList.add(new Triple(lar_rad, right_dir, near_dist));
        tripleList.add(new Triple(med_rad, left_dir, far_dist));
        tripleList.add(new Triple(small_rad, right_dir, far_dist));
        tripleList.add(new Triple(med_rad, left_dir, near_dist));
        tripleList.add(new Triple(small_rad, left_dir, far_dist));
        tripleList.add(new Triple(lar_rad, left_dir, near_dist));
        tripleList.add(new Triple(med_rad, right_dir, far_dist));
        tripleList.add(new Triple(lar_rad, left_dir, far_dist));
      
    }

    public static Point getCentre() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int Xc = screenSize.width / 2;
        System.out.println("centre x" + Xc);
        int Xy = screenSize.height / 2;
        System.out.println("centre y" + Xy);
        Point centre = new Point(Xc, Xy);
        return centre;
    }

    public static void drawCenteredCircle(Graphics g, int x, int y, int r) {
        x = x - (r / 2);
        y = y - (r / 2);
        g.fillOval(x, y, r, r);
    }

}
