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
public class CPU2Install implements ActionListener, MouseListener {
	//variable declaration
	JFrame previewBuild;
	JFrame cpu2Frame;
	JFrame buildTextFrame7;
	JFrame psuFrame;
	JFrame gpuFrame;
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
	 * @param CPU2Frame
	 * @param previewBuild
	 * @param buildTextFrame7
	 * @param PSUFrame
	 * @param gpuFrame 
	 */
	//constructor
public CPU2Install(JFrame CPU2Frame, JFrame previewBuild, JFrame buildTextFrame7,JFrame PSUFrame, JFrame gpuFrame) {
		this.cpu2Frame = CPU2Frame;
		this.previewBuild = previewBuild;
		this.buildTextFrame7 = buildTextFrame7;
		this.psuFrame = PSUFrame;
		this.gpuFrame = gpuFrame;
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
		cpu2Frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);	
		cpu2Frame.setLocationRelativeTo(null);							
		cpu2Frame.setVisible(false);	
		//
		//generate text frame
		buildTextFrame7.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		buildTextFrame7.setLocationRelativeTo(null);
		buildTextFrame7.setVisible(false);
		//
		//creates text area with rows and columns
		txtArea1 = new JTextArea();
		txtArea1.setLineWrap(true);
		txtArea1.setWrapStyleWord(true);
		txtArea1.setEditable(false);
		txtArea1.setLayout(new BorderLayout());
		txtArea1.setBackground(Color.LIGHT_GRAY);
		//txtinfo
		txtInfo = new JTextArea("Shows Image of applying Thermal compound");
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
		imgIco = new ImageIcon(this.getClass().getResource("/cpuInstall_st2.jpg"));  
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
		//cpu2 frame
		cpu2Frame.setResizable(false);
		cpu2Frame.add(upperP,BorderLayout.CENTER);
		cpu2Frame.add(lowerP,BorderLayout.PAGE_END);
		cpu2Frame.setSize(imgLabel.getWidth(),imgLabel.getHeight());
		cpu2Frame.setLocationRelativeTo(null);
		cpu2Frame.setVisible(false);
		//
		//text frame 
		buildTextFrame7.setResizable(false);
		buildTextFrame7.setLayout(new BorderLayout());
		buildTextFrame7.add(textPanel,BorderLayout.CENTER);
		buildTextFrame7.setSize(imgLabel.getHeight() ,imgLabel.getWidth());
		buildTextFrame7.setLocationRelativeTo(null);
		buildTextFrame7.setVisible(false);
		//
	}//end of method create content pane
	/**
	 * This method controls the button interaction events
	 * @param ActionEvent e - sets frame visibility 
	 */
	//method action event
@Override
public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnExit) {
			cpu2Frame.setVisible(false);
			previewBuild.setVisible(true);
			}
			if(e.getSource() == btnNext) {
				cpu2Frame.setVisible(false);
				psuFrame.setVisible(true);
				}
				if (e.getSource() == btnPrevious) {
					cpu2Frame.setVisible(false);
					gpuFrame.setVisible(true);
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
			cpu2Frame.setVisible(false);
			buildTextFrame7.setVisible(true);
			setText();
		}
		if (e.getSource() == txtArea1) {
			buildTextFrame7.setVisible(false);
			cpu2Frame.setVisible(true);		
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
		txtArea1.setText("Stage 7 of building a PC  "
				+ "\n\nApplying Thermal Paste to the CPU"
				+ "\n\nA crucial component that allows better heat transfer from the IHS to the CPU cooler"
				+ "\n\nApplication is done by taking an syringe of paste and applying 3 lines or a cross shape"
				+ "\n\non the IHS, it is recommended to spread it yourself but you can allow the coolers weight to spread it"
				+ "\n\nIt is important not to apply to much, pea sized dots are sufficient"
				+ "\n\nCrucially do not allow it to get under the cpu or have enough excess that it can get there ");
				
	}//end of method

	
}//end of class
