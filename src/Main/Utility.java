/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Domain.triple;
import java.util.*;
import java.util.ArrayList;
import static java.util.Collections.list;


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
  
    public List<triple> populateTriple()
    {
        TripleList.add(new triple(small_rad, left_dir, near_dist));
        TripleList.add(new triple(small_rad, right_dir, near_dist));
        TripleList.add(new triple(small_rad, left_dir, far_dist));
        TripleList.add(new triple(small_rad, right_dir, far_dist));
        TripleList.add(new triple(med_rad, left_dir, near_dist));
        TripleList.add(new triple(med_rad, right_dir, near_dist));
        TripleList.add(new triple(med_rad, left_dir, far_dist));
        TripleList.add(new triple(med_rad, right_dir, far_dist));
        TripleList.add(new triple(lar_rad, left_dir, near_dist));
        TripleList.add(new triple(lar_rad, right_dir, near_dist));
        TripleList.add(new triple(lar_rad, left_dir, far_dist));
        TripleList.add(new triple(lar_rad, right_dir, far_dist));
        
        return TripleList;
    }
    
}
