/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import DatabaseConnection.DatabaseConnection;
import Domain.Triple;
import Main.Utility;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Robot;
import java.awt.Toolkit;
import java.util.Collections;
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

    /**
     * Creates new form TestScreen
     */
    public TestScreen() {
        initComponents();
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

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(291, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(36, 36, 36))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(249, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(28, 28, 28))
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
         try{
            Robot robot = new Robot();
            robot.mouseMove(683, 384);
        }catch(Exception e){

        }
        called = false;
        repaint();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        //TestScreen testScreen = new TestScreen();
        //testScreen.setExtendedState(MAXIMIZED_BOTH);
	//testScreen.setVisible(true);
    }
    
    boolean called = false;
    int count = 0;
    int mainCount = 0;
    
    public Triple getTriple(){
        if(!called){
            called = true;
            ++mainCount;
            if(count >= 12){
                count = 0;
                List<Triple> triples = Utility.tripleList; 
                Collections.shuffle(triples);
                return triples.get(count++);
            }else{
                List<Triple> triples = Utility.tripleList;   
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
        if(triple != null){
                 int size = triple.getSize();
                 String direction = triple.getDirection();
                 int distance = triple.getDistance();

                  if(direction.equals("left")){
                      int x = 683-distance;
                      Utility.drawCenteredCircle(g, x, 384, size);
                  }else if(direction.equals("right")){
                      int x = 683+distance;
                      Utility.drawCenteredCircle(g, x, 384, size);
                  }
         }else{
             int x = 683-128;
             Utility.drawCenteredCircle(g, x, 384, 16);
         }
      
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
