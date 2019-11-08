package pcbuilder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * 
 * @author Gareth Tucker
 * @version 1.0
 * This Frame creates a single image applies to panel
 * A second panel contains a button to go forward
 */
public class WelcomeFrame implements ActionListener, MouseListener {
	//instance variables
	JFrame welFrame;
	JFrame previewBuild;
	JFrame previewFrame;
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JButton nextBtn, exitBtn; 
	FlowLayout flow = new FlowLayout();
	JLabel imgLabel = new JLabel();
	//
	/**
	 * The Constructor calls the frames from driver class
	 * and takes you from the welcome screen to the preview build
	 * @param welcomeFrame JFrame displaying image and button
	 * @param previewBuild JFrame displaying components
	 * @param insertMoboFrame JFrame displaying components
	 * @param buildGuide JFrame displaying components
	 */
	//constructor
public WelcomeFrame(JFrame welcomeFrame, JFrame previewBuild) {
		this.welFrame = welcomeFrame;
		this.previewBuild = previewBuild;
		createContentpane();
	}//end of constructor
	//
	/**
	 * This method creates the components to be displayed on screen
	 * The image is called directly and displayed to screen 
	 * the buttons are then added to the panel
	 */
	//Method create content pane 
private void createContentpane() {
		//
		//generate Welcome Frame
		welFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);					//sets from to do nothing if X is pressed on frame
		welFrame.setLocationRelativeTo(null);											//sets location to center of screen
		welFrame.setVisible(true);														//sets visibility of the panel
												//sets the frame visibility
		//
		//set layout of panel
		p1.setLayout(flow);																//set layout of panel
		p2.setLayout(flow);
		//
		//Set background
		p2.setBackground(Color.lightGray);												//sets colour of background
		p2.setBackground(Color.lightGray);
		//
		//image Icon for intro
		ImageIcon img1 = new ImageIcon(this.getClass().getResource("/DSC_0071-2.jpg")); 	//assign jpg image to the img variable
		imgLabel.setIcon((img1));													 	//sets image to image icon
		imgLabel.setBounds(10,10, img1.getIconWidth(), img1.getIconHeight());		 	//moves and resizes this component. the location of the image is specificed by x10, y 10
		p2.add(imgLabel);																//add image label to panel
		//
		//create buttons	
		nextBtn = new JButton("Next");													//generate new button
		exitBtn = new JButton("Exit");
		//
		//add action listener
		nextBtn.addActionListener(this);	
		nextBtn.addMouseListener(this);//add action listener
		exitBtn.addActionListener(this);
		exitBtn.addMouseListener(this);
		//
		//add button
		p1.add(nextBtn);																//add button to panel
		p1.add(exitBtn);									
		//
		welFrame.setResizable(false);													//sets if the frame is resizable by the user
		welFrame.add(p2,BorderLayout.CENTER);											//add panel and position
		welFrame.add(p1,BorderLayout.PAGE_END);											//add panel and position
		welFrame.setSize(imgLabel.getWidth(), imgLabel.getHeight());		//sets the size of the frame 
		welFrame.setLocationRelativeTo(null);											//sets location of the frame to null(centre of the screen
		welFrame.setVisible(true);														//sets frame visibility
		//		
	}//end of method create content pane
	//
	/**
	 * This method controls the button interaction events
	 * @param ActionEvent e - Event from user input
	 */
	//method action event
@Override
public void actionPerformed(ActionEvent e) {
		if (e.getSource() == nextBtn) {
			welFrame.setVisible(false);
			previewBuild.setVisible(true);
		}
		if (e.getSource() == exitBtn) {
			System.exit(0);
		}//end if
	}//end method action listener
	/*
	 * Mouse event actions for mouse entered area displaying tooltips
	 * @param MouseEvent e - displays tooltip when mouse enters area.
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == nextBtn) {
			nextBtn.setToolTipText("Go to Start");
			}
			if (e.getSource() == exitBtn) {
				exitBtn.setToolTipText("Exit program");
			}//end if	
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}//end of class welcomeFrame
