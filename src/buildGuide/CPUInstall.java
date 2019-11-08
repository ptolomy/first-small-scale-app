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
public class CPUInstall implements MouseListener, ActionListener {
	JFrame previewBuild;
	JFrame CPUFrame;
	JFrame memFrame;
	JFrame buildTextFrame3;
	JFrame moboFrame;
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
	JTextArea txtArea1 = new JTextArea();
	JTextArea txtInfo = new JTextArea();
	String tooltip = "Click Image";
	String toolTip1 = "Click text Area";
	//
	/**
	 * Constructor calls the frames from the driver class and assigns them to locally generated frames
	 * It then creates the content pane
	 * @param CPUFrame
	 * @param previewBuild
	 * @param buildTextFrame3
	 * @param MemFrame
	 * @param insertMoboFrame 
	 */
	//constructor
public CPUInstall(JFrame CPUFrame,JFrame previewBuild,JFrame buildTextFrame3, JFrame MemFrame, JFrame insertMoboFrame) {
		this.CPUFrame = CPUFrame;
		this.previewBuild = previewBuild;
		this.memFrame = MemFrame;
		this.buildTextFrame3 = buildTextFrame3;
		this.moboFrame = insertMoboFrame;
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
		//generate cpu Frame
		CPUFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);	//sets from to do nothing if X is pressed on frame
		CPUFrame.setLocationRelativeTo(null);							//sets location to center of screen
		CPUFrame.setVisible(false);	
		//
		//generate text frame
		buildTextFrame3.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		buildTextFrame3.setLocationRelativeTo(null);
		buildTextFrame3.setVisible(false);
		//
		//creates text area with rows and columns
		txtArea1 = new JTextArea();
		txtArea1.setLineWrap(true);
		txtArea1.setWrapStyleWord(true);
		txtArea1.setEditable(false);
		txtArea1.setLayout(new BorderLayout());
		txtArea1.setBackground(Color.LIGHT_GRAY);
		//txtinfo
		txtInfo = new JTextArea("Shows Image of CPU installation");
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
		imgIco = new ImageIcon(this.getClass().getResource("/cpuInstall.jpg")); 
		imgLabel.setIcon((imgIco));													
		imgLabel.setBounds(10,10, imgIco.getIconWidth(), imgIco.getIconHeight());		
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
		lowerP.add(btnPrevious);														 //adds the button to the lower panel
		lowerP.add(btnNext);
		lowerP.add(btnExit);	
		upperP.add(infoPanel);
		upperP.add(buildImage);
		//
		//cpu frame
		CPUFrame.setResizable(false);
		CPUFrame.add(upperP,BorderLayout.CENTER);
		CPUFrame.add(lowerP,BorderLayout.PAGE_END);
		CPUFrame.setSize(imgLabel.getWidth(),imgLabel.getHeight());
		CPUFrame.setLocationRelativeTo(null);
		CPUFrame.setVisible(false);
		//
		//text frame 
		buildTextFrame3.setResizable(false);
		buildTextFrame3.setLayout(new BorderLayout());
		buildTextFrame3.add(textPanel,BorderLayout.CENTER);
		buildTextFrame3.setSize(imgLabel.getHeight() ,imgLabel.getWidth());
		buildTextFrame3.setLocationRelativeTo(null);
		buildTextFrame3.setVisible(false);
		//
	}//end of method create content pane
	//
	/**
	 * This method controls the button interaction events
	 * @param ActionEvent e - sets frame visibility 
	 */
	//method action even button clicked
@Override
public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnExit) {
			CPUFrame.setVisible(false);
			previewBuild.setVisible(true);
			}
			if(e.getSource() == btnNext) {
				CPUFrame.setVisible(false);
				memFrame.setVisible(true);	
				}
				if (e.getSource() == btnPrevious) {
					CPUFrame.setVisible(false);
					moboFrame.setVisible(true);
					}//end if
	}//end method
	//
	/**
	 * This method will set the visibility of frames 
	 * @param MouseEvent e - sets frame visibility and sets text
	 */
	//mouse actions
@Override
public void mouseClicked(MouseEvent e) {
		if (e.getSource() == buildImage) {
			CPUFrame.setVisible(false);
			buildTextFrame3.setVisible(true);
			setText();
		}
		if (e.getSource() == txtArea1) {
			buildTextFrame3.setVisible(false);
			CPUFrame.setVisible(true);		
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
		txtArea1.setText("Stage 3 of building a PC  "
				+ "\n\nCarefully remove the CPU from it's box. "
				+ "\n\nUnlock and lift the CPU locking mechanism "
				+ "\n\nFind the gold triangle on the cpu then  "
				+ "\n\nfind the triangle on the socket."
				+ "\n\nAlign the 2 triangles on the CPU and socket and carefully"
				+ "\n\nplace the cpu inside the socket"
				+ "\n\nClose the cpu locking mechanism");
	}//end of method
	
}//end of class
