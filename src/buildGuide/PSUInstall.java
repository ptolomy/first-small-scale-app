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
public class PSUInstall implements ActionListener, MouseListener {
	//variable declaration
	JFrame previewBuild;
	JFrame PSUFrame;
	JFrame buildTextFrame2;
	JFrame psu2Frame;
	JFrame CPU2Frame;
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
	 * @param PSUFrame
	 * @param previewBuild
	 * @param buildTextFrame2
	 * @param PSU2Frame
	 * @param cPU2Frame 
	 */
	//constructor
public PSUInstall(JFrame PSUFrame, JFrame previewBuild, JFrame buildTextFrame2,JFrame PSU2Frame, JFrame CPU2Frame) {
		this.PSUFrame = PSUFrame;
		this.previewBuild = previewBuild;
		this.buildTextFrame2 = buildTextFrame2;
		this.psu2Frame = PSU2Frame;
		this.CPU2Frame = CPU2Frame;
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
		PSUFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);	
		PSUFrame.setLocationRelativeTo(null);							
		PSUFrame.setVisible(false);	
		//
		//generate text frame
		buildTextFrame2.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		buildTextFrame2.setLocationRelativeTo(null);
		buildTextFrame2.setVisible(false);
		//
		//creates text area with rows and columns
		txtArea1 = new JTextArea();
		txtArea1.setLineWrap(true);
		txtArea1.setWrapStyleWord(true);
		txtArea1.setEditable(false);
		txtArea1.setLayout(new BorderLayout());
		txtArea1.setBackground(Color.LIGHT_GRAY);
		//txtinfo
		txtInfo = new JTextArea("Shows Image of Power Supply Installation");
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
		imgIco = new ImageIcon(this.getClass().getResource("/PSU_install_st1.jpg")); 
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
		lowerP.add(btnNext);
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
		//psu frame
		PSUFrame.setResizable(false);
		PSUFrame.add(upperP,BorderLayout.CENTER);
		PSUFrame.add(lowerP,BorderLayout.PAGE_END);
		PSUFrame.setSize(imgLabel.getWidth() ,imgLabel.getHeight() + 110);
		PSUFrame.setLocationRelativeTo(null);
		PSUFrame.setVisible(false);
		//
		//text frame 
		buildTextFrame2.setResizable(false);
		buildTextFrame2.setLayout(new BorderLayout());
		buildTextFrame2.add(textPanel,BorderLayout.CENTER);
		buildTextFrame2.setSize(imgLabel.getHeight() ,imgLabel.getWidth());
		buildTextFrame2.setLocationRelativeTo(null);
		buildTextFrame2.setVisible(false);
		//
	}//end of method create content pane
	//
	/**
	 * This method controls the button interaction events
	 * @param ActionEvent e - sets frame visibility
	 */
	//action performed method
@Override
public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnExit) {
			PSUFrame.setVisible(false);
			previewBuild.setVisible(true);
			}
			if(e.getSource() == btnNext) {
				PSUFrame.setVisible(false);
				psu2Frame.setVisible(true);
				}
				if (e.getSource() == btnPrevious) {
					PSUFrame.setVisible(false);
					CPU2Frame.setVisible(true);
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
			PSUFrame.setVisible(false);
			buildTextFrame2.setVisible(true);
			setText();
		}
		if (e.getSource() == txtArea1) {
			buildTextFrame2.setVisible(false);
			PSUFrame.setVisible(true);		
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
		txtArea1.setText("Stage 8 of building a PC  "
				+ "\n\nThe PSU fits in a dedicated place in every case"
				+ "\n\nIt requires 4 screws to mount but some cases have a removable plate"
				+ "\n\nand comes in various varieties from fully modular semi modular or fixed cables"
				+ "\n\nCables come in different standards, we have the 24 pin ATX power cable for the motherboard"
				+ "\n\nThen we have the 4+4 pin cpu power cable"
				+ "\n\nWe then have multiple of the following cables"
				+ "\n\nPCI-E for powering graphics cards "
				+ "\n\nWe then have sata power, this is used for hard drives and now used for other internal hardware devices"
				+ "\n\nThe last one is Molex, and older 4 pin power used for some pumps and older devices but now becoming less common");
	}//end of method set text
}//end of class build guide frame
