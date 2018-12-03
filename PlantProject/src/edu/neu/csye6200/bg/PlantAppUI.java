/**
 * 
 */
package edu.neu.csye6200.bg;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.java.dev.designgridlayout.DesignGridLayout;


/**
 * @author krishnamodi
 *
 */
public class PlantAppUI extends BGApp {

	/**
	 * @params
	 *  log= for logging
	 *  btnpanel = JPanel for the buttons
	 *  mainPanel = JPanel for drawing the tree
	 *  startBtn, stopBtn, resumeBtn, pauseBtn = for start, stop, resume and pausing the tree growth
	 *  pattern1Btn, pattern2Btn = for selecting the pattern of tree growth
	 *  
	 */
	private Logger log = Logger.getLogger(PlantAppUI.class.getName());
	private JPanel btnPanel=null;
	private JPanel mainPanel=null;
	private JButton startBtn=null;
	private JButton stopBtn=null;
	private JButton resumeBtn=null;
	private JButton pauseBtn=null;
	private JButton pattern1Btn=null;
	private JButton pattern2Btn=null;
	private BGCanvas bgPanel = null;
	
	
	private JFrame frame=null;
	private JPanel drawPanel=null;
	private JTextField nameTF= new JTextField();//A name input field
	private JTextField idTF= new JTextField();//A id input field
	
	public PlantAppUI() {
		log.info("App is Starting");
		initGUI();
	}

	/**
	 * m
	 */
	@Override
	public void initGUI() {
		frame =new JFrame();
		frame.setTitle("PlantApp");
		frame.setSize(500,500);//set the size to something reasonable
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//frame.isResizable();
		frame.setLayout(new BorderLayout());
		frame.add(getMainPanel(), BorderLayout.NORTH);//buttons on top
		frame.add(getDrawPanel(), BorderLayout.CENTER);// drawing in the center
		frame.setVisible(true);
	}

	//Create a panel used for drawing
		private JPanel getDrawPanel() {
			drawPanel = BGCanvas.getInstance();
			return drawPanel;
		}
		

		public JPanel getMainPanel() {
			mainPanel=new JPanel();
			DesignGridLayout pLayout = new DesignGridLayout(mainPanel);
			
			//mainPanel.setLayout(new FlowLayout());	// flow from left to right // the whole panel will  come in 1 line
			
			startBtn=new JButton("Start");
			stopBtn=new JButton("Stop");
			
			//startBtn.addActionListener(this);
			startBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					System.out.println("Start");
					drawPanel.repaint();
				}
			});
			stopBtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					System.out.println("Stop");
					drawPanel.repaint();
				}
			});
			
			resumeBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					System.out.println("Resume");
					drawPanel.repaint();
				}
			});
			
			pauseBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					System.out.println("Pause");
					drawPanel.repaint();
				}
			});
			//nameTF.setText("Krey");
			//idTF.setText("10");
			
			pLayout.row().grid(new JLabel("Name")).add(nameTF);
			pLayout.row().grid(new JLabel("ID")).add(idTF);
			pLayout.emptyRow();
			pLayout.row().center().add(startBtn,stopBtn,resumeBtn,pauseBtn);
			mainPanel.setBackground(Color.WHITE);
			//mainPanel.add(startBtn);
			//mainPanel.add(stopBtn);//add the btns to the panel
		//	mainPanel.setBackground(Color.black);
			return mainPanel;
		}
		
	
	@Override
	public void actionPerformed(ActionEvent e) {
		log.info("We recieved  a ActionEvent "+e);
		if(e.getSource()==startBtn) {
			System.out.println("Do start operation");
		}
		else if(e.getSource()==stopBtn) 
			System.out.println("Do stop operation");
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PlantAppUI myApp= new PlantAppUI();
		
		System.out.println("Application is exiting");
		
	}

}
