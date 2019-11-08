package pcbuilder;

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
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * 
 * @author Gareth Tucker
 * @version 1.0 This class generates a frame with multiple components The
 *          purpose is to get multiple user inputs for a selection process and
 *          display a choice from those selections
 *
 */
public class PreviewBuildFrame implements ActionListener, ChangeListener, MouseListener
{
    //instance variables
    JFrame previewFrame;
    JFrame buildFrame;
    JFrame displayFrame;
    JSlider slider;
    JButton buildBtn, previewBtn, exitBtn;
    JRadioButton gamingBtn, businessBtn;
    JTextArea txtHeader = new JTextArea("PREVIEW BUILD");
    JTextArea txtSlide = new JTextArea("£500");
    int sliVal = 500; //fixed as the minimum value on the slider
    JPanel imagePanel = new JPanel();
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JPanel p3 = new JPanel();
    JPanel p4 = new JPanel();
    JPanel p5 = new JPanel();//spacing panel
    FlowLayout flow = new FlowLayout();
    GridLayout gl31 = new GridLayout(4, 1);
    String sysType = "";
    //variables for displayFrame
    JTextArea txtDisplay = new JTextArea();
    String introText = "No parts to display\n\nPlease return and make a selection";
    JPanel txtArea = new JPanel();
    JPanel lowerP = new JPanel();
    JButton retBtn = new JButton();
    int sysValue = 0;
    String toolTip = "Shows a list of the items";
    String toolTip1 = "Shows A guide on how to build a PC";
    String toolTip2 = "This will exit the program";
    String toolTip3 = "This will select the Gaming system";
    String toolTip4 = "This will select the Business system";
    String toolTip5 = "This will set the value of the system";
    String toolTip6 = "Returns to the selection screen";

    //
    /**
     * The constructor calls the frames from the driver class it will take you
     * to the preview of the build selection and will take you to the build
     * guide
     * 
     * @param previewBuild JFrame displaying the content
     * @param buildGuide JFrame displaying content
     * @param displayFrame JFrame displaying content
     */
    //constructor
    public PreviewBuildFrame(JFrame previewBuild, JFrame buildGuide, JFrame displayFrame)
    {
        this.previewFrame = previewBuild;
        this.displayFrame = displayFrame;
        this.buildFrame = buildGuide;
        createContentPane();
    }//end of constructor
     //
     /*
      * This method creates the content panel on screen, all the components are
      * called directly for the main frame and the display frame. The Frame is
      * composed of 5 panels with components added to each
      */
     //create content pane method

    private void createContentPane()
    {
        //
        //generate display Frame
        displayFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); //sets from to do nothing if X is pressed on frame
        displayFrame.setLocationRelativeTo(null); //sets location to center of screen
        displayFrame.setVisible(false); //sets the frame visibility
        //
        //generate preview Frame
        previewFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); //sets from to do nothing if X is pressed on frame
        previewFrame.setLocationRelativeTo(null); //sets location to center of screen
        previewFrame.setVisible(false); //sets the frame visibility
        //
        //set layout of panels
        p1.setLayout(gl31); //sets the layout of the panel
        p2.setLayout(flow); //sets the layout of the panel
        p3.setLayout(flow); //sets the layout of the panel
        p4.setLayout(flow); //sets the layout of the panel
        p5.setSize(100, 30); //sets the size of the panel
        //
        //set layout of panels
        txtArea.setLayout(new BorderLayout()); //sets the layout of the panel
        lowerP.setLayout(flow); //sets the layout of the panel
        //
        //creates text area with rows and columns
        txtDisplay = new JTextArea(); //create new text area
        txtDisplay.setLineWrap(true);
        txtDisplay.setWrapStyleWord(true);
        txtDisplay.setEditable(false);
        txtDisplay.setText(introText);
        txtDisplay.setBackground(Color.lightGray);
        //
        //set colour of panels
        p1.setBackground(Color.LIGHT_GRAY); //sets the background colour of panel
        p2.setBackground(Color.LIGHT_GRAY);
        p3.setBackground(Color.LIGHT_GRAY);
        p4.setBackground(Color.LIGHT_GRAY);
        p5.setBackground(Color.LIGHT_GRAY);
        //
        //JButtons
        buildBtn = new JButton("Build Guide"); //generate new buttons
        previewBtn = new JButton("Preview build");
        exitBtn = new JButton("Exit !");
        buildBtn.addActionListener(this); //adds action listener to buttons
        previewBtn.addActionListener(this);
        exitBtn.addActionListener(this);
        buildBtn.addMouseListener(this); //add mouse action listener 
        previewBtn.addMouseListener(this);
        exitBtn.addMouseListener(this);
        //
        //JRadio Buttons
        gamingBtn = new JRadioButton("Gaming System"); //generate new radio buttons
        gamingBtn.addActionListener(this); //add action listener to the radio buttons
        gamingBtn.addMouseListener(this);
        businessBtn = new JRadioButton("Business System");
        businessBtn.addActionListener(this);
        businessBtn.addMouseListener(this);
        //
        //adding JSlider
        slider = new JSlider(); //generates new slider
        slider.setMaximum(1500); //sets the maximum value of the slider
        slider.setMinimum(500); //sets the minimum value
        slider.setValue(500); //sets the starting value
        slider.setSnapToTicks(true); //sets the intervals the slider will snap too
        slider.setMinorTickSpacing(500); //sets the value of the increments of the snap nearest value
        slider.addChangeListener(this); //adds action listener to the snap
        txtSlide.setEditable(false); //sets the text area containing the value of the slider to uneditable
        txtSlide.setForeground(Color.blue); //sets the initial colour of the text
        txtHeader.setEditable(false); //sets the text area as uneditable
        txtHeader.setForeground(Color.RED); //sets the colour of the text 
        slider.addMouseListener(this);
        //
        //display panel buttons
        retBtn = new JButton("Return"); //generates new button
        retBtn.addActionListener(this); //adds action listener to the button	
        retBtn.addMouseListener(this);
        lowerP.add(retBtn); //adds the button to the panel
        //
        //add components to panels
        //add txtdisplay to txtarea panel
        txtArea.add(txtDisplay); //adds component to panels
        p2.add(txtHeader);
        p2.add(slider);
        p2.add(txtSlide);
        p3.add(gamingBtn);
        p3.add(businessBtn);
        p4.add(buildBtn);
        p4.add(previewBtn);
        p4.add(exitBtn);
        p5.add(txtHeader);
        p1.add(p5); //spacing panel
        p1.add(p2);
        p1.add(p3);
        p1.add(p4);
        //
        //set up preview frame
        previewFrame.setResizable(false); //sets if the frame can be resized by the user
        previewFrame.setLayout(new BorderLayout()); //adds new layout to the frame
        previewFrame.add(p1, BorderLayout.CENTER); //adds components to the frame with a given position
        previewFrame.setSize(500, 450); //sets the size of the frame
        previewFrame.setLocationRelativeTo(null); //sets the location relative to null(centre of the screen)
        previewFrame.setVisible(false); //sets visibility
        //
        //set up display frame
        displayFrame.setResizable(false);
        displayFrame.setLayout(new BorderLayout());
        displayFrame.add(txtArea);
        displayFrame.add(lowerP, BorderLayout.PAGE_END);
        displayFrame.setSize(500, 450);
        displayFrame.setLocationRelativeTo(null);
        displayFrame.setVisible(false);
        //
    }//end of create content pane

    /**
     * This action method controls all the button interactions, each button also
     * sets the colour of the text of their own button and the other radio
     * button,If one is selected the other is deselected
     * 
     * @param ActionEvent e Action performed by a user input in the program.
     */
    //action listner on button press
    @Override
    public void actionPerformed(ActionEvent e)
    {
        //radio button Business
        if (e.getSource() == businessBtn) {
            sysType = ("Business");
            businessBtn.setForeground(Color.BLUE); //sets the color of the text
            gamingBtn.setForeground(Color.black); //sets the color of the text
            gamingBtn.setSelected(false); //deselects gaming button
        } //radio button gaming
        if (e.getSource() == gamingBtn) {
            sysType = ("Gaming");
            gamingBtn.setForeground(Color.RED); //sets the color of the text 
            businessBtn.setForeground(Color.black); //sets the color of the text
            businessBtn.setSelected(false); //deselects business button
        } //end if radio buttons
          //exit button
        if (e.getSource() == exitBtn) {
            System.exit(0);
        } //preview button
        if (e.getSource() == previewBtn) {
            getPreviewType(); //calls method get preview type
            previewFrame.setVisible(false); //sets frame visibility
            displayFrame.setVisible(true); //sets frame visibility
        } //build button
        if (e.getSource() == buildBtn) {
            previewFrame.setVisible(false); //sets frame visibility
            buildFrame.setVisible(true); //sets frame visibility	
        } //end if
        if (e.getSource() == retBtn) {
            displayFrame.setVisible(false); //sets frame visibility
            previewFrame.setVisible(true); //sets frame visibility
            txtDisplay.setText(""); //sets the text in display area to null
            sysType = "null"; //sets the text in sys type to null
            businessBtn.setSelected(false); //resets business button
            gamingBtn.setSelected(false); //resets gaming button
            slider.setValue(500); //resets slider value
            gamingBtn.setForeground(Color.black);
            businessBtn.setForeground(Color.black);
        } //end if	
    }//end method action listener
     //

    /**
     * This method sets the value of the slider, the colour of the txtSlide is
     * also changed depending on value
     * 
     * @param ChangeEvent e - Sets value changes based on position.
     */
    //change listener for slide bar
    @Override
    public void stateChanged(ChangeEvent e)
    {
        if (e.getSource() == slider) {
            sliVal = slider.getValue(); //gets value from slider and sets sliVal
            txtSlide.setText("£" + sliVal); //sets the text on the text area to match the value of the slider
            if (sliVal < 1000) {
                txtSlide.setForeground(Color.blue); //sets the color of the text
            }
            if (sliVal >= 1000 && sliVal < 1500) {
                txtSlide.setForeground(Color.orange); //sets the color of the text
            }
            if (sliVal == 1500) {
                txtSlide.setForeground(Color.red); //sets the color of the text
            } //end if
        } //end if	
    }//end of method slide bar 
     //

    /**
     * This method gets the value of the slider
     * 
     * @return sliVal
     */
    //getter for slider value
    public int getSliderValue()
    {
        return sliVal;
    }//end of getter system value

    /**
     * this method returns the value stored in sysType
     * 
     * @return sysType
     */
    //getter for system type
    public String getSysType()
    {
        return sysType;
    }//end of getter system type

    /**
     * This method gets the sysType selected from the radio buttons then
     * compares the value and calls the appropriate method
     */
    //get preview type
    public void getPreviewType()
    {
        sysType = getSysType(); //pulls data from preview build frame
        //if gaming system selected
        if (sysType.equals("Gaming")) {
            setTextGaming(sysType); //method call for gaming system
        }
        //if business system selected
        if (sysType.equals("Business")) {
            setTextBusiness(sysType); //method call for business systems
        } //end if	
    }//end method preview system type

    /**
     * This method sets the text in the preview frame It resets the value of the
     * text area before over writing the area then calls the value of the slider
     * it then selects the appropriate choice from the selection
     * 
     * @param sysType
     */
    //gaming system method
    public void setTextGaming(String sysType)
    {
        txtDisplay.setText(null); //sets text in display area to null
        sysValue = getSliderValue(); //pulls system value from preview build frame
        //gaming + 500
        if (sysValue == 500) {
            txtDisplay.append("Case : NZXT H330" + "\nMotherboard : B350" + "\nCPU : AMD Ryzen 2200g"
                    + "\nRAM : 8gb Corsair 2133Mhz DDR4" + "\nHDD : 500 Gb seagate fireCuda" + "\nPSU : Corsair CM350");
        }
        else if (sysValue == 1000) {
            txtDisplay.append("Case : NZXT H440" + "\nMotherboard : X470" + "\nCPU : AMD Ryzen 5 2600x"
                    + "\nRAM : 8gb Corsair 3200Mhz DDR4" + "\nHDD : 1Tb seagate fireCuda"
                    + "\nSSD : 256GB Samsung 850EVO" + "\nGPU : AMD 580 8gb" + "\nPSU : Corsair CM500");
        } //gaming + 1500
        else if (sysValue == 1500) {
            txtDisplay.append("Case : NZXT H700i" + "\nMotherboard : X470" + "\nCPU : AMD Ryzen 7 2700x"
                    + "\nRAM : 16gb Corsair 3200Mhz DDR4" + "\nHDD : 2Tb seagate fireCuda"
                    + "\nSSD : 256GB Samsung 850EVO" + "\nGPU : Nvidia 1080TI 11gb" + "\nPSU : Corsair CM650");
        } //end if			
    }//end of method gaming systems

    /**
     * This method sets the text in the preview frame It resets the value of the
     * text area before over writing the area then calls the value of the slider
     * it then selects the appropriate choice from the selection
     * 
     * @param sysType
     */
    //business system method
    public void setTextBusiness(String sysType)
    {
        txtDisplay.setText(null); //sets text in display area to null
        sysValue = getSliderValue(); //pulls system value from preview build frame
        //business + 500
        if (sysValue == 500) {
            txtDisplay.append("Case : Fractal design S(sound dampened)" + "\nMotherboard : B350"
                    + "\nCPU : AMD Ryzen 2200g" + "\nRAM : 8gb Corsair 2133Mhz DDR4" + "\nHDD : 500Gb seagate fireCuda"
                    + "\nPSU : Corsair CM350");
        }
        else//business + 1000
        if (sysValue == 1000) {
            txtDisplay.append("Case : Fractal design S(sound dampened)" + "\nMotherboard : H370"
                    + "\nCPU : Intel I5 8600" + "\nRAM : 8gb Corsair 2667Mhz DDR4" + "\nHDD : 500Gb seagate fireCuda"
                    + "\nSSD : 256GB Samsung 850EVO" + "\nGPU : Nvidia Quadro P600" + "\nPSU : Corsair CM500");
        } //business + 1500
        else if (sysValue == 1500) {
            txtDisplay.append(
                    "Case : Fractal design S(sound dampened)" + "\nMotherboard : X470" + "\nCPU : AMD Ryzen 7 2700x"
                            + "\nRAM : 16gb Corsair 3200Mhz DDR4 ECC" + "\nHDD : 2Tb seagate fireCuda"
                            + "\nSSD : 256GB Samsung 850EVO" + "\nGPU : Nvidia Quadro K1200" + "\nPSU : Corsair CM650");
        } //end if
    }//end of method business systems
     //

    /**
     * This method sets tool tip text to mouse events inside buttons
     * 
     * @param MouseEvent e - When mouse entered area's tooltip text is displayed
     */
    //
    @Override
    public void mouseClicked(MouseEvent e)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        // TODO Auto-generated method stub

    }

    //Method used to show tool tips
    @Override
    public void mouseEntered(MouseEvent e)
    {
        if (e.getSource() == previewBtn) {
            previewBtn.setToolTipText(toolTip);
        }
        if (e.getSource() == buildBtn) {
            buildBtn.setToolTipText(toolTip1);
        }
        if (e.getSource() == exitBtn) {
            exitBtn.setToolTipText(toolTip2);
        }
        if (e.getSource() == gamingBtn) {
            gamingBtn.setToolTipText(toolTip3);
        }
        if (e.getSource() == businessBtn) {
            businessBtn.setToolTipText(toolTip4);
        }
        if (e.getSource() == slider) {
            slider.setToolTipText(toolTip5);
        }
        if (e.getSource() == retBtn) {
            retBtn.setToolTipText(toolTip6);
        } //end if
    }//end method mouse entered

    @Override
    public void mouseExited(MouseEvent e)
    {
        // TODO Auto-generated method stub

    }

}//end of class preview build frame
