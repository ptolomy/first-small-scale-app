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
public class StorageInstall implements MouseListener, ActionListener {
	//instance variables
	JFrame previewBuild;
	JFrame storageFrame;
	JFrame buildTextFrame5;
	JFrame gpuFrame;
	JFrame memFrame;
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
	 * @param storageFrame
	 * @param previewBuild
	 * @param buildTextFrame5
	 * @param gpuFrame
	 * @param memFrame 
	 */
	//constructor
public StorageInstall(JFrame storageFrame,JFrame previewBuild,JFrame buildTextFrame5,JFrame gpuFrame, JFrame memFrame ) {
		this.storageFrame = storageFrame;
		this.previewBuild = previewBuild;
		this.buildTextFrame5 = buildTextFrame5;
		this.gpuFrame = gpuFrame;
		this.memFrame = memFrame;
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
		//generate storage Frame
		storageFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);	
		storageFrame.setLocationRelativeTo(null);							
		storageFrame.setVisible(false);	
		//
		//generate text frame
		buildTextFrame5.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		buildTextFrame5.setLocationRelativeTo(null);
		buildTextFrame5.setVisible(false);
		//
		//creates text area with rows and columns
		txtArea1 = new JTextArea();
		txtArea1.setLineWrap(true);
		txtArea1.setWrapStyleWord(true);
		txtArea1.setEditable(false);
		txtArea1.setLayout(new BorderLayout());
		txtArea1.setBackground(Color.LIGHT_GRAY);
		//txtinfo
		txtInfo = new JTextArea("Shows Image of Storage Device Installation");
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
		imgIco = new ImageIcon(this.getClass().getResource("/Storage Installation.jpg"));  
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
		//storage frame
		storageFrame.setResizable(false);
		storageFrame.add(upperP,BorderLayout.CENTER);
		storageFrame.add(lowerP,BorderLayout.PAGE_END);
		storageFrame.setSize(imgLabel.getWidth(),imgLabel.getHeight());
		storageFrame.setLocationRelativeTo(null);
		storageFrame.setVisible(false);
		//
		//text frame 
		buildTextFrame5.setResizable(false);
		buildTextFrame5.setLayout(new BorderLayout());
		buildTextFrame5.add(textPanel,BorderLayout.CENTER);
		buildTextFrame5.setSize(imgLabel.getHeight() ,imgLabel.getWidth());
		buildTextFrame5.setLocationRelativeTo(null);
		buildTextFrame5.setVisible(false);
		//
	}//end of method create content pane
	//
	/**
	 * This method controls the button interaction events
	 * @param ActionEvent e - sets visibility of frames
	 */
	//method action even button click
@Override
public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnExit) {
			storageFrame.setVisible(false);
			previewBuild.setVisible(true);
			}
			if(e.getSource() == btnNext) {
				storageFrame.setVisible(false);
				gpuFrame.setVisible(true);
				}
				if (e.getSource() == btnPrevious) {
					storageFrame.setVisible(false);
					memFrame.setVisible(true);
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
			storageFrame.setVisible(false);
			buildTextFrame5.setVisible(true);
			setText();
		}
		if (e.getSource() == txtArea1) {
			buildTextFrame5.setVisible(false);
			storageFrame.setVisible(true);		
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
		txtArea1.setText("Stage 5 of building a PC  "
				+ "\n\nAdding Storage devices means using either SSD, HDD, or NVME(M.2) drives"
				+ "\n\nWith SSD and HDD use either the toolless install frames or screw into mounting brackets."
				+ "\n\nUsing the appropriate Sata cable, Sata3 spec in most cases and insert into the drive and sata port"
				+ "\n\nWith NVME locate the mounting point on the motherboard and insert matching the notch"
				+ "\n\nthen carefully screw down using the cover if supplied."
				+ "\n\n");
	}//end of method set text
	
}//end of class
