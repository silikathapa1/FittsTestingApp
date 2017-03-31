/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author Silika
 */
public class Triple {

    private int size;
    private String direction;
    private int distance;

    public Triple(int size, String direction, int distance){
        this.size =size;
        this.direction=direction;
        this.distance = distance;        
    }
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Triple{" + "size=" + size + ", direction=" + direction + ", distance=" + distance + '}';
    }
    
    

}
