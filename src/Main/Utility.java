/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Domain.triple;
import java.util.*;
import java.util.ArrayList;


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
   
    List<triple>  TripleList= new ArrayList<triple>();
    triple t = new triple(1,"s",2);
   TripleList.add(t);
    
}
