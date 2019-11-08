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
public class BuildInsertMobo implements ActionListener, MouseListener {
	//variable declaration
	JFrame MoboFrame;
	JFrame previewBuild;
	JFrame CPUFrame;
	JFrame buildTextFrame1;
	JFrame standFrame;
	JLabel imgLabel = new JLabel();
	ImageIcon imgIco1;
	JPanel upperP = new JPanel();
	JPanel lowerP = new JPanel();
	JPanel buildImage = new JPanel();
	JPanel textPanel = new JPanel();
	JPanel infoPanel = new JPanel();
	JButton btnNext,btnExit,btnPrevious;
	FlowLayout flow = new FlowLayout();
	GridLayout gl11 = new GridLayout(1,1);
	//Text fields
	JTextArea txtArea1 = new JTextArea();
	JTextArea txtInfo = new JTextArea();
	String tooltip = "Click Image";
	String toolTip1 = "Click text Area";
	//
	/**
	 * Constructor calls the frames from the driver class and assigns them to locally generated frames
	 * It then creates the content pane
	 * @param insertMoboFrame
	 * @param previewBuild
	 * @param CPUFrame
	 * @param buildTextFrame1
	 * @param buildGuide 
	 */
	//constructor
public BuildInsertMobo(JFrame insertMoboFrame,JFrame previewBuild, JFrame CPUFrame, JFrame buildTextFrame1, JFrame buildGuide) {
		this.MoboFrame = insertMoboFrame;
		this.previewBuild = previewBuild;
		this.CPUFrame = CPUFrame;
		this.buildTextFrame1 = buildTextFrame1;
		this.standFrame = buildGuide;
	createContentPane();
	}//end of constructor
	//
	/**
	 * This method creates the content on the main frame
	 * The image is called directly and displayed on screen inside the main frame
	 * both the image frame and the text frame are created and populated
	 * The buttons are then added to the bottom panel to allow the user to navigate
	 */
	//Method create content pane
private void createContentPane() {
		//
		//generate mobo Frame
		MoboFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);					//sets from to do nothing if X is pressed on frame
		MoboFrame.setLocationRelativeTo(null);											//sets location to center of screen
		MoboFrame.setVisible(false);													//sets the visibility of the frame
		//
		//generate text frame
		buildTextFrame1.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		buildTextFrame1.setLocationRelativeTo(null);
		buildTextFrame1.setVisible(false);
		//
		//creates text area with rows and columns
		txtArea1 = new JTextArea();
		txtArea1.setLineWrap(true);
		txtArea1.setWrapStyleWord(true);
		txtArea1.setEditable(false);
		txtArea1.setLayout(new BorderLayout());
		txtArea1.setBackground(Color.LIGHT_GRAY);
		//txtinfo
		txtInfo = new JTextArea("Shows Image of where to mount the motherboard");
		txtInfo.setEditable(false);
		txtInfo.setForeground(Color.RED);
		//
		//set layout on panels
		infoPanel.setLayout(flow);
		upperP.setLayout(flow);
		lowerP.setLayout(flow);
		textPanel.setLayout(new BorderLayout());
		//
		//image Icon for intro
		imgIco1 = new ImageIcon(this.getClass().getResource("/Insert_board.jpg")); 
		imgLabel.setIcon((imgIco1));													 
		imgLabel.setBounds(10,10, imgIco1.getIconWidth(), imgIco1.getIconHeight());		 
		//	
		//add action listener
		buildImage.addMouseListener(this);
		txtArea1.addMouseListener(this);
		//
		//create buttons
		btnNext = new JButton("Next");
		btnNext.addActionListener(this);
		btnExit = new JButton("Exit !");
		btnExit.addActionListener(this);
		//JButton previous
		btnPrevious = new JButton("Previous");
		btnPrevious.addActionListener(this);
		//
		//add elements to panels
		infoPanel.add(txtInfo);
		buildImage.add(imgLabel);
		textPanel.add(txtArea1);
		textPanel.setVisible(true);
		upperP.add(infoPanel);
		lowerP.add(btnPrevious);														 //adds the button to the lower panel
		lowerP.add(btnNext);
		lowerP.add(btnExit);	
		upperP.add(buildImage);
		//
		//mobo frame
		MoboFrame.setResizable(false);
		MoboFrame.add(upperP,BorderLayout.CENTER);
		MoboFrame.add(lowerP,BorderLayout.PAGE_END);
		MoboFrame.setSize(imgLabel.getHeight() ,imgLabel.getWidth());
		MoboFrame.setLocationRelativeTo(null);
		MoboFrame.setVisible(false);
		//
		//text frame 
		buildTextFrame1.setResizable(false);
		buildTextFrame1.setLayout(new BorderLayout());
		buildTextFrame1.add(textPanel,BorderLayout.CENTER);
		buildTextFrame1.setSize(imgLabel.getWidth(),imgLabel.getHeight());
		buildTextFrame1.setLocationRelativeTo(null);
		buildTextFrame1.setVisible(false);
		//
	}//end of method create content pane
	//
	/**
	 * This method controls the button interaction events
	 * @param ActionEvent e - Sets frame visibility
	 */
	//method action event
@Override
public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnExit) {
			MoboFrame.setVisible(false);
			previewBuild.setVisible(true);
		}
		if(e.getSource() == btnNext) {
			MoboFrame.setVisible(false);
			CPUFrame.setVisible(true);
		}		
		if (e.getSource() == btnPrevious) {
			MoboFrame.setVisible(false);
			standFrame.setVisible(true);
		}//end if	
	}//end method
	//
	/**
	 * This method will set the visibility of frames 
	 * @param MouseEvent e - sets frame visibility and text
	 */
	//mouse actions
@Override
public void mouseClicked(MouseEvent e) {
		if (e.getSource() == buildImage) {
			MoboFrame.setVisible(false);
			buildTextFrame1.setVisible(true);
			setText();
		}
		if (e.getSource() == txtArea1) {
			buildTextFrame1.setVisible(false);
			MoboFrame.setVisible(true);		
			}//end if	
	}//end of method mouse clicked
	//
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
		if (e.getSource() == buildImage) {
			buildImage.setToolTipText(tooltip);
			}
			if (e.getSource() == txtArea1) {
				txtArea1.setToolTipText(toolTip1);
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
	//method set text
public void setText() {
		txtArea1.setText("Stage 2 of building a PC  "
				+ "\n\nInsert the IO panel in the rear of the case "
				+ "\n\nCarefully place the motherboard into the case aligning the "
				+ "\n\nrear panel to the IO panel and place on top of the post mounts."
				+ "\n\nOnce in position begin screwing in the motherboard to the post mounts"
				+ "\n\nEnsure all screws are tight and nothing is forced into place.");
	}//end method set text
	
}//end of class build guide frame


