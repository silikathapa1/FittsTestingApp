/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

/**
 * Applet to demonstrate Fitts Law
 * Creation date: (02/15/2002 9:52:13 AM)
 * Modified date: (04/15/2002 2:48:00 PM)
 * @author: Andrew Freed, arf132@psu.edu
 */

/*
Development of this applet was sponsored by the Penn State Fund for 
Excellence in Learning and Teaching (FELT), project "Java-based 
Teaching of Mathematics in Information Sciences and Technology",
supervised by Frank Ritter and David Mudgett.
*/

public class FittsLawApplet extends Applet implements MouseMotionListener, MouseListener {
	private final Label	lblTarget = new Label("TARGET");
	private final Label	lblOutput = new Label("Distance - ?   Time - ?   Target width - ?");
	private final Button	btnResize = new Button("Resize");

/**********************************************************************************
Fitts' law is a robust model of human psychomotor behavior developed in 1954. 
The model is based on time and distance. It enables the prediction of human movement
 and human motion based on rapid, aimed movement, not drawing or writing. 

It seems intuitive that movement time would be affected by the distance moved
 and the precision demanded by the size of the target to which one is moving.
 Fitts discovered that movement time was a logarithmic function of distance when
 target size was held constant, and that movement time was also a logarithmic
 function of target size when distance was held constant. 

Mathematically, Fitts' law is stated as follows: 

MT = a + b log2(2A/W) 

where 

MT = movement time 
a,b = regression coefficients 
A = distance of movement from start to target center 
W = width of the target

Source: http://ei.cs.vt.edu/~cs5724/g1/glance.html

**********************************************************************************/

double a = 150.0;		//Constant reaction time
double b = 100.0;		//Movement proportion

//Information about the target
double centerTargetX;
double centerTargetY;
int targetWidth;
int targetHeight;
int targetX;
int targetY;

//State variables to help us keep track of where the mouse is drug
int newX, newY;
boolean isMoving = false;

        @Override 
        public void mouseMoved(MouseEvent e) 
{
  try
  {
	//If we are inside the target, there is nothing to compute
	if( e.getComponent() == lblTarget )
	{
		lblOutput.setText("In target");
		return;
	}

	int x = e.getX();
	int y = e.getY();

	//Compute the distance to target center.  This is sqrt( dx^2 + dy^2 )
	double distX = Math.abs( (double) x - centerTargetX );
	double distY = Math.abs( (double) y - centerTargetY );
	double dist = Math.sqrt( distX * distX + distY * distY );
	
	//Recalculate width along axis of movement 
	double width = 2.0 *  dist* ( (0.5 * (double) lblTarget.getBounds().width) / Math.max(distX, distY));

	//Use Fitt's Law formula to compute time to target
	double time = a + b * logBaseTwo( 2.0 * dist / width );
	
	String result = "";
	result += " --- DISTANCE (px) " + (int) dist + " ---";
	result += " --- TIME TO TARGET " + (int) time + " (ms) ---";
	result += " --- TARGET WIDTH (px) " + (int) width + " ---";
	
	lblOutput.setText(result);

  }

  catch( Throwable ev)
  {
	lblOutput.setText("Error: " + ev.toString());
  }
}

        @Override
        public void mouseDragged(MouseEvent e)
{
	//We only care about this if we are inside the label, and thus moving it
	if( isMoving )
	{
		if( e.getComponent() == lblTarget )
		{
			newX = e.getX() + targetX;
			newY = e.getY() + targetY;
		}
		//If we try to move out of the applet, this must be captured
		else
		{
			newX = e.getX();
			newY = e.getY();
		}

		//Assuming dimensions of 500x350 for this applet, 
		//with the bottom 50 pixels reserved for the output label
		
		//Make sure center of target is within the applet bounds
		if( newX < (targetWidth/2) )
			newX = targetWidth/2;
		if( newX > 500 - (targetWidth/2))
			newX = 500 - (targetWidth/2);
		if( newY < (targetHeight/2) )
			newY = targetHeight/2;
		if( newY > 300 - (targetHeight/2))
			newY = 300 - targetHeight/2;

		//Update the location of the target
		resizeTarget(new Rectangle( newX - (targetWidth/2),
				 newY - (targetHeight/2),
				 targetWidth,
				 targetHeight ));
	}
}

        @Override
        public void mousePressed(MouseEvent e)
{
            //If we are over the target, this signifies the beginning of a drag
    isMoving = e.getComponent() == lblTarget;
}
        @Override
        public void mouseReleased(MouseEvent e)
{
	//Dragging operation is finished
	if( isMoving )
	{
		isMoving = false;
	}
}

//This must be implemented because this applet is registered as a MouseListener.
//However, a "blank" implementation will do just fine
        @Override
        public void mouseClicked(MouseEvent e){}
        @Override
        public void mouseEntered(MouseEvent e){}
        @Override
        public void mouseExited(MouseEvent e){}

//This function resizes and relocates the target, and also updates the global
//variables related to the target
public void resizeTarget(Rectangle newBounds)
{
	lblTarget.setBounds(newBounds);	

	targetWidth  = lblTarget.getBounds().width;
	targetHeight = lblTarget.getBounds().height;
	targetX 	 = lblTarget.getBounds().x;
	targetY 	 = lblTarget.getBounds().y;

	centerTargetX = targetX  + 0.5 * targetWidth;
	centerTargetY = targetY  + 0.5 * targetHeight;
}

//This resizes the target to a square between 25 and 100 pixels wide
private void doRandomResize()
{
	int myWidth = 25 + (int)( 75 * Math.random() + 1);
	resizeTarget(new Rectangle(targetX, targetY, myWidth, myWidth));

	lblOutput.setText("New target width: " + myWidth);
}

//Java's log function is base e.  Fitt's Law uses logs base 2.
private double logBaseTwo(double myDouble)
{
	return( Math.log(myDouble) / Math.log(2.0) );
}

/**
 * Initializes the applet.
 */
        @Override
        public void init() {
	try {
		setLayout(null);
		setSize(500, 350);

		lblTarget.setBounds(0,0,100,100);
		lblTarget.setBackground(Color.red);
		lblTarget.setAlignment(Label.CENTER);

		lblOutput.setBounds(0,300, 500, 50);
		lblOutput.setBackground(Color.white);

		btnResize.setBounds(450, 0, 50, 30);

		this.setBackground(Color.gray);

		add(lblTarget);
		add(lblOutput);
		add(btnResize);

		lblTarget.addMouseMotionListener(this);
		addMouseMotionListener(this);

		lblTarget.addMouseListener(this);
		addMouseListener(this);

		//This will set some global variables
		resizeTarget(lblTarget.getBounds());

		btnResize.setActionCommand("btnResize");
		btnResize.addActionListener((java.awt.event.ActionEvent e) -> {
                    doRandomResize();
                });

	} catch (java.lang.Throwable Exc) {
		handleException(Exc);
	}
}
    
/**
 * Called whenever the part throws an exception.
 * @param exception java.lang.Throwable
 */
private void handleException(java.lang.Throwable exception) {
	lblOutput.setText("Error: " + exception.toString() );
}


//Main function allows you to run this applet as an application
/**
 * main entrypoint - starts the part when it is run as an application
 * @param args java.lang.String[]
 */
public static void main(java.lang.String[] args) {
	try {
		Frame frame = new java.awt.Frame();
		FittsLawApplet aFittsLawApplet;
		Class iiCls = Class.forName("FittsLawApplet");
		ClassLoader iiClsLoader = iiCls.getClassLoader();
		aFittsLawApplet = (FittsLawApplet)java.beans.Beans.instantiate(iiClsLoader,"FittsLawApplet");
		frame.add("Center", aFittsLawApplet);
		frame.setSize(aFittsLawApplet.getSize());
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
			public void windowClosing(java.awt.event.WindowEvent e) {
				System.exit(0);
			};
		});
		frame.show();
		java.awt.Insets insets = frame.getInsets();
		frame.setSize(frame.getWidth() + insets.left + insets.right, frame.getHeight() + insets.top + insets.bottom);
		frame.setVisible(true);
	} catch (HeadlessException | IOException | ClassNotFoundException exception) {
		System.err.println("Exception occurred in main() of java.applet.Applet");
		exception.printStackTrace(System.out);
	}
}
}