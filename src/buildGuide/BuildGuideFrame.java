package buildGuide;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


/**
 * 
 * @author Gareth Tucker
 * @version 1.0
 * This class generates a frame with an image inside
 * the image is clickable with a mouse and moves to a
 * another frame displaying text
 * there are 2 buttons on the frame to navigate 
 */
public class BuildGuideFrame implements ActionListener, MouseListener {
	//Instance variables
	JFrame buildGuide;
	JFrame buildInsertMobo;
	JFrame previewBuild;
	JFrame buildTextFrame;
	JLabel imgLabel = new JLabel();
	ImageIcon imgIco;
	JPanel upperP = new JPanel();
	JPanel lowerP = new JPanel();
	JPanel buildImage = new JPanel();
	JPanel textPanel = new JPanel();
	JPanel infoPanel = new JPanel();
	JButton btnNext,btnExit,btnPrevious;
	FlowLayout flow = new FlowLayout();
	GridLayout gl11 = new GridLayout(1,1);
	//Text fields
	JTextArea txtArea = new JTextArea();
	JTextArea txtInfo = new JTextArea();
	String tooltip = "Click Image";
	String toolTip1 = "Click text Area";
	//
	/**
	 * Constructor calls the frames from the driver class and assigns them to locally generated frames
	 * It then creates the content pane
	 * @param buildGuide is a Frame 
	 * @param previewBuild
	 * @param insertMoboFrame
	 * @param buildTextFrame
	 */
	//constructor
public BuildGuideFrame(JFrame buildGuide, JFrame previewBuild, JFrame insertMoboFrame, JFrame buildTextFrame) {
		this.buildGuide = buildGuide;
		this.previewBuild = previewBuild;	
		this.buildInsertMobo = insertMoboFrame;
		this.buildTextFrame = buildTextFrame;
		createContentPane();
	}//end of constructor
	//
	/**
	 * This method creates the content on the main frame
	 * The image is called directly and displayed on screen inside the main frame
	 * both the image frame and the text frame are created and populated
	 * The buttons are then added to the bottom panel to allow the user to navigate
	 */
	//method create content pane
private void createContentPane() {
		//
		//generate build Frame
		buildGuide.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);				//sets from to do nothing if X is pressed on frame
		buildGuide.setLocationRelativeTo(null);											//sets location to center of screen
		buildGuide.setVisible(false);													//sets the visibility of the frame
		//
		//generate text frame
		buildTextFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);			//sets from to do nothing if X is pressed on frame
		buildTextFrame.setLocationRelativeTo(null);										//sets location to center of screen
		buildTextFrame.setVisible(false);												//sets the visibility of the frame
		//
		//creates text area with rows and columns
		txtArea = new JTextArea();														//creates text area
		txtArea.setLineWrap(true);														//sets the line wrap of the text
		txtArea.setWrapStyleWord(true);													//sets the wrap style of the area
		txtArea.setEditable(false);														//sets if the text area is editable
		txtArea.setLayout(new BorderLayout());											//applies a border layout to the text area
		txtArea.setBackground(Color.LIGHT_GRAY);										//sets the background colour of the text area
		//
		//txtinfo
		txtInfo = new JTextArea("Shows Image of standoffs that mount the motherboard");
		txtInfo.setEditable(false);
		txtInfo.setForeground(Color.RED);
		//
		//set panel layouts
		infoPanel.setLayout(flow);
		upperP.setLayout(flow);															//sets the layout of the panel
		lowerP.setLayout(flow);															//sets the layout of the panel
		textPanel.setLayout(new BorderLayout());										//sets the layout of the textpanel
		//			
		//image Icon for intro
		imgIco = new ImageIcon(this.getClass().getResource("/standoff.jpg")); 			 //assign jpg image to the img variable
		imgLabel.setIcon((imgIco));														 //sets image to image icon													 //sets image to image icon
		imgLabel.setBounds(10,10, imgIco.getIconWidth(), imgIco.getIconHeight());		 //moves and resizes this component. the location of the image is specificed by x10, y 10			
		//
		//add action listener
		buildImage.addMouseListener(this);												 //adds mouse action listener to the image
		txtArea.addMouseListener(this);													 //adds mouse action listener to the text area
		//jbutton exit
		btnExit = new JButton("Exit ! ");												 //creates new button
		btnExit.addActionListener(this);												 //adds action listener to the button
		//jbutton next
		btnNext = new JButton(" Next ");
		btnNext.addActionListener(this);
		//JButton previous
		btnPrevious = new JButton("Previous");	
		btnPrevious.addActionListener(this);
		//	
		//add elements to panels
		infoPanel.add(txtInfo);
		textPanel.add(txtArea);															 //adds the JTextArea to the panel
		textPanel.setVisible(true);														 //sets the visibility of the text panel										
		buildImage.add(imgLabel);														 //adds the image to the build image panel
		//add elements to main panels
		upperP.add(infoPanel);
		upperP.add(buildImage);															 //adds the build image to upper panel
		lowerP.add(btnPrevious);														 //adds the button to the lower panel
		lowerP.add(btnNext);															 
		lowerP.add(btnExit);
		//
		//build guide 
		buildGuide.setResizable(false);													 //sets the frame resizable by user
		buildGuide.add(upperP,BorderLayout.CENTER);										 //adds the panel and position on the frame
		buildGuide.add(lowerP,BorderLayout.PAGE_END);
		buildGuide.setSize(imgLabel.getWidth(),imgLabel.getHeight()); 					 //sets the size of the frame to the boundaries of the image
		buildGuide.setLocationRelativeTo(null);											 //sets the location of the frame to null(Center of screen)
		buildGuide.setVisible(false);													 //sets visibility
		//
		//text frame
		buildTextFrame.setResizable(false);
		buildTextFrame.setLayout(new BorderLayout());
		buildTextFrame.add(textPanel,BorderLayout.CENTER);
		buildTextFrame.setSize(imgLabel.getHeight() ,imgLabel.getWidth());
		buildTextFrame.setLocationRelativeTo(null);
		buildTextFrame.setVisible(false);
		//
	}//end of create content pane
	//
	/**
	 * This method controls the button interaction events
	 * @param ActionEvent e - sets visibility of frames
	 */
	//button actions
@Override
public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnExit) {
			buildGuide.setVisible(false);												//sets frame visibility current frame
			previewBuild.setVisible(true);												//sets frame visibility preview build
			}
			if(e.getSource() == btnNext) {
				buildGuide.setVisible(false);
				buildInsertMobo.setVisible(true);
				}
				if (e.getSource() == btnPrevious) {
					buildGuide.setVisible(false);
					previewBuild.setVisible(true);
					}//end if
	}//end of method action button
	//
	/**
	 * This method will set the visibility of frames 
	 * @param MouseEvent e - sets visibility and text of frame
	 */
	//mouse actions
@Override
public void mouseClicked(MouseEvent e) {
		if (e.getSource() == buildImage) {
			buildGuide.setVisible(false);                            					//sets frame visibility of current frame on mouse click
			buildTextFrame.setVisible(true);											//sets frame visibility of text area on mouse click
			setText();
		}
		if (e.getSource() == txtArea) {
			buildTextFrame.setVisible(false);
			buildGuide.setVisible(true);		
			}//end if
	}//end of method mouse clicked
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	//
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub	
	}
	//
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == buildImage) {												//if mouse enters build image
			buildImage.setToolTipText(tooltip);											//display tool tip
			}
			if (e.getSource() == txtArea) {
				txtArea.setToolTipText(toolTip1);
			}//end if
	}//end of method mouse entered
	//
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	//
	/**
	 * This method will set the text in the JTextField
	 * @param txtArea will be changed 
	 */
	//method for setting the text in text area
public void setText() {
		txtArea.setText("Stage 1 of building a PC  "
				+ "\n\nLocate the correct position of the standoff mount points "
				+ "\n\nby matching the holes on the motherboard "
				+ "\n\nscrew in the post mounts "
				+ "\n\nIt is crucial to not leave in post mounts that are not in use"
				+ "\n\nas they can cause an electrical short");
	}//end of method

}//end of class build guide frame
