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
public class GPUInstall implements MouseListener, ActionListener {
	//Instance variables
	JFrame previewBuild;
	JFrame gpuFrame;
	JFrame buildTextFrame6;
	JFrame cpu2Frame;
	JFrame storageFrame;
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
	 * @param gpuFrame
	 * @param previewBuild
	 * @param buildTextFrame6
	 * @param CPU2Frame
	 * @param storageFrame 
	 */
	//constructor
public GPUInstall(JFrame gpuFrame, JFrame previewBuild, JFrame buildTextFrame6,JFrame CPU2Frame, JFrame storageFrame) {
		this.gpuFrame = gpuFrame;
		this.previewBuild = previewBuild;
		this.buildTextFrame6 = buildTextFrame6;
		this.cpu2Frame = CPU2Frame;
		this.storageFrame = storageFrame;
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
		//generate gpu Frame
		gpuFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);	
		gpuFrame.setLocationRelativeTo(null);							
		gpuFrame.setVisible(false);	
		//
		//generate text frame
		buildTextFrame6.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		buildTextFrame6.setLocationRelativeTo(null);
		buildTextFrame6.setVisible(false);
		//
		//creates text area with rows and columns
		txtArea1 = new JTextArea();
		txtArea1.setLineWrap(true);
		txtArea1.setWrapStyleWord(true);
		txtArea1.setEditable(false);
		txtArea1.setLayout(new BorderLayout());
		txtArea1.setBackground(Color.LIGHT_GRAY);
		//txtinfo
		txtInfo = new JTextArea("Shows Image of Graphics card installation");
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
		imgIco = new ImageIcon(this.getClass().getResource("/gpuInstall.jpg")); 
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
		//gpu frame
		gpuFrame.setResizable(false);
		gpuFrame.add(upperP,BorderLayout.CENTER);
		gpuFrame.add(lowerP,BorderLayout.PAGE_END);
		gpuFrame.setSize(imgLabel.getWidth(),imgLabel.getHeight());
		gpuFrame.setLocationRelativeTo(null);
		gpuFrame.setVisible(false);
		//
		//text frame 
		buildTextFrame6.setResizable(false);
		buildTextFrame6.setLayout(new BorderLayout());
		buildTextFrame6.add(textPanel,BorderLayout.CENTER);
		buildTextFrame6.setSize(imgLabel.getHeight() ,imgLabel.getWidth());
		buildTextFrame6.setLocationRelativeTo(null);
		buildTextFrame6.setVisible(false);
		//
	}//end of method create content pane
	//
	/**
	 * This method controls the button interaction events
	 * @param ActionEvent e - sets frame visibility 
	 */
	//method action event button clicked
@Override
public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnExit) {
			gpuFrame.setVisible(false);
			previewBuild.setVisible(true);
			}
			if(e.getSource() == btnNext) {
				gpuFrame.setVisible(false);
				cpu2Frame.setVisible(true);
				}
				if (e.getSource() == btnPrevious) {
					gpuFrame.setVisible(false);
					storageFrame.setVisible(true);
					}//end if
	}//end of method 
	//
	/**
	 * This method will set the visibility of frames 
	 * @param MouseEvent e - sets frame visibility and sets text
	 */
	//mouse actions
@Override
public void mouseClicked(MouseEvent e) {
		if (e.getSource() == buildImage) {
			gpuFrame.setVisible(false);
			buildTextFrame6.setVisible(true);
			setText();
		}
		if (e.getSource() == txtArea1) {
			buildTextFrame6.setVisible(false);
			gpuFrame.setVisible(true);		
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
		txtArea1.setText("Stage 6 of building a PC  "
				+ "\n\nInstalling the GPU"
				+ "\n\nRemove any PCI panel covers required, 1,2 or 3 depending on the card size"
				+ "\n\nYou may need to remove a retention plate depending on case"
				+ "\n\nGently press the latch at the end of the PCI-E slot"
				+ "\n\nTake the GPU and carefully align the rear panel to the slots you just opened "
				+ "\n\nthen gently push into the PCI-E slot on the motherboard"
				+ "\n\nthe latch will lock in place with a click"
				+ "\n\nThen using any screws from the PCI-Covers screw in place, while holding the GPU horizontal"
				+ "\n\nIf you had a retention plate hold the GPU horizontally then attach the retention plate"
				+ "\n\nWe hold it up to reduce long term strain on the PCI-E port");
	}//end of method

}//end of class
