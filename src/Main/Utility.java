/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Domain.Triple;
import java.util.*;
import java.util.ArrayList;
import  java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.Graphics;

/**
 * * @author Silika
 */
public class Utility {
    static int small_rad = 16;
    static int med_rad = 32;
    static int lar_rad= 64;
    static int near_dist = 128;
    static int far_dist= 512;
    static String left_dir="left";
    static String right_dir = "right";
  
    public static List<Triple> populateTriple()
    {
        List<Triple> tripleList= new ArrayList<>();
        tripleList.add(new Triple(small_rad, left_dir, near_dist));
        tripleList.add(new Triple(small_rad, right_dir, near_dist));
        tripleList.add(new Triple(small_rad, left_dir, far_dist));
        tripleList.add(new Triple(small_rad, right_dir, far_dist));
        tripleList.add(new Triple(med_rad, left_dir, near_dist));
        tripleList.add(new Triple(med_rad, right_dir, near_dist));
        tripleList.add(new Triple(med_rad, left_dir, far_dist));
        tripleList.add(new Triple(med_rad, right_dir, far_dist));
        tripleList.add(new Triple(lar_rad, left_dir, near_dist));
        tripleList.add(new Triple(lar_rad, right_dir, near_dist));
        tripleList.add(new Triple(lar_rad, left_dir, far_dist));
        tripleList.add(new Triple(lar_rad, right_dir, far_dist));
        
        Collections.shuffle(tripleList);
  
        return tripleList;
    }
    
    public void getCentre(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
         int centerX = screenSize.width/2;
        System.out.println("centre x"+centerX);
        int centerY = screenSize.height/2;
        System.out.println("centre x"+centerX);
    }
    
    public static void drawCenteredCircle(Graphics g, int x, int y, int r) {
        x = x-(r/2);
        y = y-(r/2);
        g.fillOval(x,y,r,r);
    }
    
}
