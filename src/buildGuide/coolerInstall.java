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
public class coolerInstall implements MouseListener, ActionListener {
	//variable declaration
	JFrame previewBuild;
	JFrame buildTextFrame9;
	JFrame coolerFrame;
	JFrame cableFrame;
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
	 * @param coolerFrame
	 * @param previewBuild
	 * @param buildTextFrame9
	 * @param pSU2Frame 
	 */
	//constructor
public coolerInstall(JFrame coolerFrame, JFrame previewBuild, JFrame buildTextFrame9, JFrame PSU2Frame) {
		this.coolerFrame = coolerFrame;
		this.previewBuild = previewBuild;
		this.buildTextFrame9 = buildTextFrame9;
		this.cableFrame = PSU2Frame;
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
		//generate cooler Frame
		coolerFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);	
		coolerFrame.setLocationRelativeTo(null);							
		coolerFrame.setVisible(false);	
		//
		//generate text frame
		buildTextFrame9.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		buildTextFrame9.setLocationRelativeTo(null);
		buildTextFrame9.setVisible(false);
		//
		//creates text area with rows and columns
		txtArea1 = new JTextArea();
		txtArea1.setLineWrap(true);
		txtArea1.setWrapStyleWord(true);
		txtArea1.setEditable(false);
		txtArea1.setLayout(new BorderLayout());
		txtArea1.setBackground(Color.LIGHT_GRAY);
		//txtinfo
		txtInfo = new JTextArea("Shows Image of standard Air cooler installation");
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
		imgIco = new ImageIcon(this.getClass().getResource("/CPU_cooler_install.jpg")); 
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
		textPanel.add(txtArea1);
		textPanel.setVisible(true);
		lowerP.add(btnPrevious);														 //adds the button to the lower panel
		lowerP.add(btnNext);
		lowerP.add(btnExit);
		buildImage.add(imgLabel);
		upperP.add(infoPanel);
		upperP.add(buildImage);	
		//
		//cooler frame
		coolerFrame.setResizable(false);
		coolerFrame.add(upperP,BorderLayout.CENTER);
		coolerFrame.add(lowerP,BorderLayout.PAGE_END);
		coolerFrame.setSize(imgLabel.getHeight() ,imgLabel.getWidth());
		coolerFrame.setLocationRelativeTo(null);
		coolerFrame.setVisible(false);
		//
		//text frame 
		buildTextFrame9.setResizable(false);
		buildTextFrame9.setLayout(new BorderLayout());
		buildTextFrame9.add(textPanel,BorderLayout.CENTER);
		buildTextFrame9.setSize(imgLabel.getWidth(),imgLabel.getHeight());
		buildTextFrame9.setLocationRelativeTo(null);
		buildTextFrame9.setVisible(false);
		//
		}//end of method create content pane
	//
	/**
	 * This method controls the button interaction events
	 * @param ActionEvent e - sets frame visibility
	 */
	//method call action event 
@Override
public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnExit) {
			coolerFrame.setVisible(false);
			previewBuild.setVisible(true);
			}
			if(e.getSource() == btnNext) {
				coolerFrame.setVisible(false);
				previewBuild.setVisible(true);
				}
				if (e.getSource() == btnPrevious) {
					coolerFrame.setVisible(false);
					cableFrame.setVisible(true);
					}//end if
	}//end of method mouse clicked
	//
	/**
	 * This method will set the visibility of frames 
	 * @param MouseEvent e - sets frame visibility and sets text
	 */
	//mouse actions
@Override
public void mouseClicked(MouseEvent e) {
		if (e.getSource() == buildImage) {
			coolerFrame.setVisible(false);
			buildTextFrame9.setVisible(true);
			setText();
		}
		if (e.getSource() == txtArea1) {
			buildTextFrame9.setVisible(false);
			coolerFrame.setVisible(true);		
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
	//method to set text in txtarea
public void setText() {
		txtArea1.setText("Stage 9 of building a PC  "
				+ "\n\nInstalling the cooler"
				+ "\n\nMany coolers have different mounting methods so you should refer to the manual"
				+ "\n\nIntel rely on 4 fixing points while AMD use 2 points on their stock coolers"
				+ "\n\nAftermarket coolers such as AIO or air coolers use the 4 fixing point method on both Intel and AMD"
				+ "\n\nHEDT coolers will mount to the socket frame or an included frame due to the size"
				+ "\n\nInstalling is simple, as you have already applied thermal paste. Attach the mounting frame"
				+ "\n\nthen place the cooler on top of the cpu and screw in 50% of the way on each screw"
				+ "\n\nonce all are at that state then begin tightening each screw"
				+ "\n\nHand tight only no excess force is required.");
	}//end of method set text

}//end of class
