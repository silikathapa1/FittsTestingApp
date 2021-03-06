/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Domain.Triple;
import Repository.FittsRepository;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Robot;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Time;
import java.util.Collections;
import java.util.Date;
import java.util.List;

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
    int Xc = Utility.getCentre().x;     // centre of the screen x-coordinate
    int Yc = Utility.getCentre().y;     // centre of the screen y-coordinate
    List<Triple> triples = Utility.tripleList;

    int missHits = 0;

    int missHitsPerTrial = 0;

    double totalDistance = 0;
    Time totalTimeTaken;

    long startTime;             //start point of time for each trial

    String name;
    int diameter;  //diameter of the circle .. set as global to implement click logic for circle
    int amplitude;   //distance to the object from centre of the screen.

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
//        missHitsPerTrial = 0;
        startTime = new Date().getTime();

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me);
                System.out.println("mouse click ko diameter"+diameter);
                 if((me.getY() >= Yc-(diameter/2) && me.getY() <= Yc+(diameter/2)) && (me.getX() >= x-(diameter/2) && me.getX() <= x+(diameter/2))){
                    performRePaint();
                } else {
                    ++missHitsPerTrial;
                     System.out.println("======"+missHitsPerTrial);
                    jLabel2.setText("Miss Hits: " + ++missHits);
                }
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                int xaxis = e.getX();
                int yaxis = e.getY();

                //Compute the distance to target center.  This is sqrt( dx^2 + dy^2 )
                double distX = Math.abs((double) xaxis - x);
                double distY = Math.abs((double) yaxis - Yc);
                double dist = Math.sqrt(distX * distX + distY * distY);
                totalDistance = totalDistance + dist;
            }
        }
        );
        initComponents();
    }

    public TestScreen(String name) {
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
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        Info = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        InfoPanel = new javax.swing.JPanel();
        TrialsInfoPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        FinishBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 153, 153));

        jPanel2.setBackground(new java.awt.Color(51, 51, 255));

        Info.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Info.setForeground(new java.awt.Color(255, 255, 255));
        Info.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Info.setText("There are total of 120 trials. You need to click inside the circle to complete the trial. After completion of the trial you will continuosly get 120 trials.");
        Info.setAlignmentX(0.5F);
        Info.setLocation(200, 20);
        Info.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Info.setPreferredSize(new java.awt.Dimension(1030, 83));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(Info, javax.swing.GroupLayout.PREFERRED_SIZE, 1160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(490, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(Info, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(1000, 32));
        Cursor te = new Cursor(Cursor.CROSSHAIR_CURSOR);
        jPanel1.setCursor(te);

        try{
            Robot robot = new Robot();
            robot.mouseMove(Xc, Yc);
        }catch(Exception e){

        }
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel4.setVisible(false);
        jLabel4.setBackground(new java.awt.Color(255, 0, 0));
        jLabel4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 204, 51));
        jLabel4.setText("You have Successfully Completed !!");
        jPanel1.add(jLabel4, new java.awt.GridBagConstraints());

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        InfoPanel.setBackground(new java.awt.Color(204, 204, 204));
        InfoPanel.setPreferredSize(new java.awt.Dimension(268, 170));
        InfoPanel.setLayout(new java.awt.GridBagLayout());

        TrialsInfoPanel.setBackground(new java.awt.Color(153, 153, 153));
        TrialsInfoPanel.setPreferredSize(new java.awt.Dimension(300, 130));

        jLabel1.setBackground(new java.awt.Color(0, 51, 204));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText(" Total Number of Trials: 0");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 0, 0));
        jLabel2.setText("Miss Hits: 0");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 0));
        jLabel3.setText("Current Trial: 0");

        javax.swing.GroupLayout TrialsInfoPanelLayout = new javax.swing.GroupLayout(TrialsInfoPanel);
        TrialsInfoPanel.setLayout(TrialsInfoPanelLayout);
        TrialsInfoPanelLayout.setHorizontalGroup(
            TrialsInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TrialsInfoPanelLayout.createSequentialGroup()
                .addGroup(TrialsInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TrialsInfoPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(TrialsInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)))
                    .addGroup(TrialsInfoPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        TrialsInfoPanelLayout.setVerticalGroup(
            TrialsInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TrialsInfoPanelLayout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        InfoPanel.add(TrialsInfoPanel, new java.awt.GridBagConstraints());

        FinishBtn.setBackground(new java.awt.Color(51, 51, 255));
        FinishBtn.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        FinishBtn.setForeground(new java.awt.Color(255, 255, 255));
        FinishBtn.setText("Finish");
        FinishBtn.setPreferredSize(new java.awt.Dimension(95, 33));
        FinishBtn.setVisible(false);
        FinishBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FinishBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        InfoPanel.add(FinishBtn, gridBagConstraints);

        getContentPane().add(InfoPanel, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FinishBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FinishBtnActionPerformed
        // TODO add your handling code here:
        //add to database informations

        this.setVisible(false);
        Main jframe = new Main();
        jframe.setVisible(true);
        jframe.setExtendedState(jframe.MAXIMIZED_BOTH);
    }//GEN-LAST:event_FinishBtnActionPerformed

    public void performRePaint() {
        System.out.println("Total Distance: " + totalDistance);
        long timeNow = new Date().getTime();
        long timeDiff = timeNow - startTime;
        totalTimeTaken = new Time(timeDiff);
        System.out.println("Time Taken: " + totalTimeTaken.getTime());
        System.out.println("Missed hits per trials " + missHitsPerTrial);
        FittsRepository.insertToTrialsTable(name, mainCount, missHitsPerTrial, totalTimeTaken.getTime(), (int) totalDistance, diameter, amplitude);

        missHitsPerTrial = 0;
        totalDistance = 0;
        startTime = new Date().getTime();

        try {
            Robot robot = new Robot();
            robot.mouseMove(Xc, Yc);
        } catch (Exception e) {

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

    public Triple getTriple() {
        if (!called) {
            called = true;
            ++mainCount;
            if (count >= 12) {
                count = 0;
                Collections.shuffle(triples);
                return triples.get(count++);
            } else {
                return triples.get(count++);
            }
        }
        return null;
    }

    @Override
    public void paint(Graphics g) {
        //L ->y-Yc, x-Xc| near=100, far=200 : Xc-100
        super.paint(g);
        g.setColor(Color.RED.brighter());
        Triple triple = getTriple();
//        diameter = triple.getSize();
     
        if (triple != null && !completed) {
            diameter = triple.getSize();
            String direction = triple.getDirection();
            amplitude = triple.getDistance();

            if (direction.equals("left")) {
                x = Xc - amplitude;
                Utility.drawCenteredCircle(g, x, Yc, diameter);
            } else if (direction.equals("right")) {
                x = Xc + amplitude;
                Utility.drawCenteredCircle(g, x, Yc, diameter);
            }
        } else {
            if (!completed) {
                diameter = 16;
                x = Xc - 128;
                Utility.drawCenteredCircle(g, x, Yc, 16);
            }
        }

        jLabel1.setText("Total Number of Trials: " + 120);
        jLabel3.setText("Current Trail: " + mainCount);

        if (mainCount >= 120) {
            completed = true;
        }

        //this value should be one greater than previous call where completed true is set
        if (mainCount >= 121) {
            TrialsInfoPanel.setVisible(false);
            jLabel1.setVisible(false);
            jLabel2.setVisible(false);
            jLabel3.setVisible(false);
            jLabel4.setText("You have successfully completed your " + (mainCount - 1) + " trials with " + missHits
                    + " total miss hits.");
            jLabel4.setVisible(true);
            FinishBtn.setVisible(true);
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton FinishBtn;
    private javax.swing.JLabel Info;
    private javax.swing.JPanel InfoPanel;
    private javax.swing.JPanel TrialsInfoPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

}
