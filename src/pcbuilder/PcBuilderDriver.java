package pcbuilder;

import javax.swing.JFrame;

import buildGuide.BuildGuideFrame;
import buildGuide.BuildInsertMobo;
import buildGuide.CPU2Install;
import buildGuide.CPUInstall;
import buildGuide.GPUInstall;
import buildGuide.MemInstall;
import buildGuide.PSUInstall;
import buildGuide.StorageInstall;
import buildGuide.cableInstall;
import buildGuide.coolerInstall;

/**
 * 
 * @author Gareth Tucker
 * @version 1.0
 * This is the driver class and creates all frames 
 * Image in welcome form is my own
 * Images in Build guide are courtesy of 'PC building simulator' and all rights are theirs.
 */
public class PcBuilderDriver {
/**
 * Main for the program all frames are called in here and passed to each class
 * @param args is the main array of components in the program
 */
	public static void main(String[] args) {
		//sets theme for the application windows
		JFrame.setDefaultLookAndFeelDecorated(false);
		//Frames for each class
		JFrame welcomeFrame = new JFrame("Welcome Frame");
		JFrame previewBuild = new JFrame("Preview Build");
		JFrame displayFrame = new JFrame("Preview");
		JFrame buildGuide = new JFrame("Build Guide");
		JFrame buildTextFrame = new JFrame("Guide post mount");
		JFrame insertMoboFrame = new JFrame("Insert motherboard");
		JFrame buildTextFrame1 = new JFrame("Guide Motherboard");
		JFrame CPUFrame = new JFrame("CPU install");
		JFrame buildTextFrame3 = new JFrame("Guide CPU");
		JFrame MemFrame = new JFrame(" Memory Install");
		JFrame buildTextFrame4 = new JFrame("Guide Memory");
		JFrame StorageFrame = new JFrame("Storage Install");
		JFrame buildTextFrame5 = new JFrame("Guide Storage");
		JFrame GpuFrame = new JFrame("GPU Install");
		JFrame buildTextFrame6 = new JFrame("Guide GPU");
		JFrame CPU2Frame = new JFrame("CPU 2 Install");
		JFrame buildTextFrame7 = new JFrame("Guide CPU");
		JFrame PSUFrame = new JFrame("Install PSU");
		JFrame buildTextFrame2 = new JFrame("Guide PSU");
		JFrame PSU2Frame = new JFrame("Cabling Install");
		JFrame buildTextFrame8 = new JFrame("Guide Cables");
		JFrame coolerFrame = new JFrame("Cooler Install");
		JFrame buildTextFrame9 = new JFrame("Cooler guide");
		//
		WelcomeFrame welFrameGUI = new WelcomeFrame(welcomeFrame,previewBuild);
		PreviewBuildFrame previewGUI = new PreviewBuildFrame(previewBuild,buildGuide,displayFrame);		
		BuildGuideFrame buildGUI = new BuildGuideFrame(buildGuide,previewBuild,insertMoboFrame,buildTextFrame);
		BuildInsertMobo moboGUI= new BuildInsertMobo(insertMoboFrame,previewBuild,CPUFrame,buildTextFrame1,buildGuide);
		CPUInstall cpuGUI = new CPUInstall(CPUFrame,previewBuild,buildTextFrame3,MemFrame,insertMoboFrame);
		MemInstall memGUI = new MemInstall(MemFrame,previewBuild,buildTextFrame4,StorageFrame,CPUFrame);
		StorageInstall stoGUI = new StorageInstall(StorageFrame,previewBuild,buildTextFrame5,GpuFrame,MemFrame);
		GPUInstall gpuGUI = new GPUInstall(GpuFrame,previewBuild,buildTextFrame6,CPU2Frame,StorageFrame);
		CPU2Install cpu2GUI = new CPU2Install(CPU2Frame,previewBuild,buildTextFrame7,PSUFrame,GpuFrame);
		PSUInstall psuGUI = new PSUInstall(PSUFrame,previewBuild,buildTextFrame2,PSU2Frame,CPU2Frame);
		cableInstall cableGUI = new cableInstall(PSU2Frame,previewBuild,buildTextFrame8,coolerFrame,PSUFrame);
		coolerInstall coolerGUI = new coolerInstall(coolerFrame,previewBuild,buildTextFrame9,PSU2Frame);	
	}//end of main

}//end of class driver class


