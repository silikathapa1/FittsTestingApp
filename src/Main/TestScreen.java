/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import DatabaseConnection.DatabaseConnection;
import Domain.Triple;
import Main.Utility;
import Repository.FittsRepository;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.sql.Time;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
/**
 *
 * @author Silika
 */
public class TestScreen extends javax.swing.JFrame {

    boolean called = false;
    boolean completed = false;
    int count = 0;
    int mainCount = 0;
    int x = 0;
    List<Triple> triples = Utility.tripleList;
    int missHits = 0;
    
    int missHitsPerTrial = 0;
    
    double totalDistance = 0;
    Time totalTimeTaken;
    
    long startTime;
    
    String name;
    
    
    /**
     * Creates new form TestScreen
     */
    
    public TestScreen() {
        called = false;
        completed = false;
        count = 0;
        mainCount = 0;
        x = 0;
        missHits = 0;
        missHitsPerTrial = 0;
        startTime = new Date().getTime();
          
        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me);
                if((me.getY() >= 380 && me.getY() <= 390) && (me.getX() >= x-7 && me.getX() <= x+7)){
                    performRePaint();
                }else{
                    ++missHitsPerTrial;
                    jLabel2.setText("Miss Hits: " + ++missHits);
                }
            }
        });
        
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e){
                int xaxis = e.getX();
                int yaxis = e.getY();

        	//Compute the distance to target center.  This is sqrt( dx^2 + dy^2 )
                double distX = Math.abs( (double) xaxis - x );
                double distY = Math.abs( (double) yaxis - 384 );
                double dist = Math.sqrt( distX * distX + distY * distY );
                totalDistance = totalDistance + dist;
            }
        }
        );
        initComponents();
    }
    
    public TestScreen(String name){
        this();
        this.name = name;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 153, 153));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        Cursor te = new Cursor(Cursor.CROSSHAIR_CURSOR);
        jPanel1.setCursor(te);

        try{
            Robot robot = new Robot();
            robot.mouseMove(683, 384);
        }catch(Exception e){

        }

        jButton1.setText("Finish");
        jButton1.setVisible(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Total Number of Trials: 0");

        jLabel2.setText("Miss Hits: 0");

        jLabel3.setText("Current Trial: 0");

        jLabel4.setVisible(false);
        jLabel4.setText("You have Successfully Completed !!");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(246, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1)
                        .addComponent(jButton1)))
                .addGap(36, 36, 36))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 184, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(28, 28, 28))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       //add to database informations
       
       this.setVisible(false);
       Main jframe = new Main();
                jframe.setVisible(true);
                jframe.setExtendedState(jframe.MAXIMIZED_BOTH);
    }//GEN-LAST:event_jButton1ActionPerformed

    public void performRePaint(){
        System.out.println("Total Distance: " + totalDistance);
        long timeNow = new Date().getTime();
        long timeDiff = timeNow - startTime;
        totalTimeTaken = new Time(timeDiff);
        System.out.println("Time Taken: " + totalTimeTaken.getTime());
        
        FittsRepository.insertToTrialsTable(name, mainCount, missHitsPerTrial, totalTimeTaken.getTime(),(int) totalDistance);
        
        missHitsPerTrial = 0;
        totalDistance = 0;
        startTime = new Date().getTime();
                    
          try{
            Robot robot = new Robot();
            robot.mouseMove(683, 384);
        }catch(Exception e){

        }
        called = false;
        repaint();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        //TestScreen testScreen = new TestScreen();
        //testScreen.setExtendedState(MAXIMIZED_BOTH);
	//testScreen.setVisible(true);
    }
    
     
    
    public Triple getTriple(){
        if(!called){
            called = true;
            ++mainCount;
            if(count >= 12){
                count = 0;
                Collections.shuffle(triples);
                return triples.get(count++);
            }else{  
                return triples.get(count++);
            }
        }
        return null;
    }
    
    @Override
    public void paint(Graphics g) {
        //L ->y-384, x-683| near=100, far=200 : 683-100
        super.paint(g);
        g.setColor(Color.red);
        Triple triple = getTriple();
        if(triple != null && !completed){
                 int size = triple.getSize();
                 String direction = triple.getDirection();
                 int distance = triple.getDistance();

                  if(direction.equals("left")){
                      x = 683-distance;
                      Utility.drawCenteredCircle(g, x, 384, size);
                  }else if(direction.equals("right")){
                      x = 683+distance;
                      Utility.drawCenteredCircle(g, x, 384, size);
                  }
         }else{
             if(!completed){
                 x = 683-128;
                Utility.drawCenteredCircle(g, x, 384, 16);
             }
         }
        
        jLabel1.setText("Total Number of Trials: " + mainCount);
        jLabel3.setText("Current Trail: " + count);
        
        if(mainCount >= 120){
            completed = true;
        }
        
        //this value should be one greater than previous call where completed true is set
        if(mainCount >= 120){
            jLabel1.setVisible(false);
            jLabel2.setVisible(false);
            jLabel3.setVisible(false);
            jLabel4.setText("You have successfully completed your " + (mainCount - 1) + " trials with " + missHits 
                    + " total miss hits.");
            jLabel4.setVisible(true);
            jButton1.setVisible(true);
        }
      
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}
