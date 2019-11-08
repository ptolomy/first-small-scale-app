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
public class cableInstall implements MouseListener, ActionListener {
	//variable declaration
	JFrame previewBuild;
	JFrame buildTextFrame8;
	JFrame psu2Frame;
	JFrame coolerFrame;
	JFrame PSUFrame;
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
	 * @param PSU2Frame
	 * @param previewBuild
	 * @param buildTextFrame8
	 * @param coolerFrame
	 * @param pSUFrame 
	 */
	//constructor
public cableInstall(JFrame PSU2Frame, JFrame previewBuild, JFrame buildTextFrame8, JFrame coolerFrame, JFrame PSUFrame) {
		this.psu2Frame = PSU2Frame;
		this.previewBuild = previewBuild;
		this.buildTextFrame8 = buildTextFrame8;
		this.coolerFrame = coolerFrame;
		this.PSUFrame = PSUFrame;
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
		//generate psu Frame
		psu2Frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);	
		psu2Frame.setLocationRelativeTo(null);						
		psu2Frame.setVisible(false);	
		//
		//generate text frame
		buildTextFrame8.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		buildTextFrame8.setLocationRelativeTo(null);
		buildTextFrame8.setVisible(false);
		//
		//creates text area with rows and columns
		txtArea1 = new JTextArea();
		txtArea1.setLineWrap(true);
		txtArea1.setWrapStyleWord(true);
		txtArea1.setEditable(false);
		txtArea1.setLayout(new BorderLayout());
		txtArea1.setBackground(Color.LIGHT_GRAY);
		//txtinfo
		txtInfo = new JTextArea("Shows Image of cable management");
		txtInfo.setEditable(false);
		txtInfo.setForeground(Color.RED);
		//
		//set layout on panels
		infoPanel.setLayout(flow);
		upperP.setLayout(flow);
		lowerP.setLayout(flow);
		textPanel.setLayout(new BorderLayout());
		textPanel.setVisible(true);
		//
		//image Icon for intro
		imgIco = new ImageIcon(this.getClass().getResource("/PSU_install_st2.jpg"));
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
		lowerP.add(btnPrevious);														 //adds the button to the lower panel
		lowerP.add(btnNext);
		lowerP.add(btnExit);
		buildImage.add(imgLabel);
		upperP.add(infoPanel);
		upperP.add(buildImage);	
		//
		//psu frame
		psu2Frame.setResizable(false);
		psu2Frame.add(upperP,BorderLayout.CENTER);
		psu2Frame.add(lowerP,BorderLayout.PAGE_END);
		psu2Frame.setSize(imgLabel.getWidth(), imgLabel.getHeight() +100);
		psu2Frame.setLocationRelativeTo(null);
		psu2Frame.setVisible(false);
		//
		//text frame 
		buildTextFrame8.setResizable(false);
		buildTextFrame8.setLayout(new BorderLayout());
		buildTextFrame8.add(textPanel,BorderLayout.CENTER);
		buildTextFrame8.setSize(imgLabel.getHeight() ,imgLabel.getWidth());
		buildTextFrame8.setLocationRelativeTo(null);
		buildTextFrame8.setVisible(false);
		//
	}//end of method create content pane
	//
	/**
	 * This method controls the button interaction events
	 * @param ActionEvent e - sets frame visibility
	 */
	//method action performed
@Override
public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnExit) {
			psu2Frame.setVisible(false);
			previewBuild.setVisible(true);
		}
		if(e.getSource() == btnNext) {
			psu2Frame.setVisible(false);
			coolerFrame.setVisible(true);
		}
		if (e.getSource() == btnPrevious) {
			psu2Frame.setVisible(false);
			PSUFrame.setVisible(true);
		}//end if
	}//end of method mouse clicked
	//
	/**
	 * This method will set the visibility of frames 
	 * @param Mouse Event e - sets frame visibility and text
	 */
	//mouse actions
@Override
public void mouseClicked(MouseEvent e) {
		if (e.getSource() == buildImage) {
			psu2Frame.setVisible(false);
			buildTextFrame8.setVisible(true);
			setText();
		}
		if (e.getSource() == txtArea1) {
			buildTextFrame8.setVisible(false);
			psu2Frame.setVisible(true);		
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
	//method to set text in 
public void setText() {
		txtArea1.setText("Stage 9 of building a PC  "
				+ "\n\nCabling inside your case"
				+ "\n\nThere is a myth that cabling affects airflow, while done badly it can have an effect even then it is minimal"
				+ "\n\nStart from the main 24pin cable to the motherboard, it is the largest and least flexible,"
				+ "\n\nthere will usually be a slot to route from the base around the back."
				+ "\n\nThen attach the 4+4 pin cpu power cable to the top of the motherboard, it is best to route this from the base around the back."
				+ "\n\nThen attach the Sata power cables, route around the rear panel and to the devices you wish to power."
				+ "\n\nThe last cables are the PCI-E power, Often these will be routed directly from the PSU to the GPU"
				+ "\n\nTake care when routing the cables, and while it is not important for performance, astheically it will"
				+ "\n\nlook better and be easier to work with.");
	}//end of method set text

}//end of class
