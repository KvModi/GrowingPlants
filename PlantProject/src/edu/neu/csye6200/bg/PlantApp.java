/**
 * 
 */
package edu.neu.csye6200.bg;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JPanel;


/**
 * @author krishnamodi
 *
 */
public class PlantApp extends BGApp{

	private static Logger log = Logger.getLogger(PlantApp.class.getName());

	protected JPanel mainPanel = null;
	protected JPanel northPanel = null;
	protected JButton startBtn = null;
	protected JButton stopBtn = null;
	protected JButton pauseBtn = null;
	protected JButton resumeBtn = null;
    private BGCanvas bgPanel = null;
	public BGGenerationSet bggs;
   
    
    /**
     * Sample app constructor
     */
    public PlantApp() {
    	frame.setSize(500, 400); // initial Frame size
		frame.setTitle("PlantApp");
		menuMgr.createDefaultActions(); // Set up default menu items
		showUI(); // Cause the Swing Dispatch thread to display the JFrame
		
    }
   
    /**
     * Create a main panel that will hold the bulk of our application display
     */
	@Override
	public JPanel getMainPanel() {
	
		mainPanel = new JPanel();
    	mainPanel.setLayout(new BorderLayout());
    	mainPanel.add(BorderLayout.NORTH, getNorthPanel());
    	
    	bgPanel = new BGCanvas();
    	mainPanel.add(BorderLayout.CENTER, bgPanel);
    	
    	return mainPanel;
	}
    
	/**
	 * Create a top panel that will hold control buttons
	 * @return
	 */
    public JPanel getNorthPanel() {
    	northPanel = new JPanel();
    	northPanel.setLayout(new FlowLayout());
    	bggs = new BGGenerationSet();
   	 Thread t= new Thread(bggs);
   	
    	/** 
    	 * Start Button
    	 */
    	
    	try {
    	startBtn = new JButton("Start");
    	startBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Thread status: "+t.getState());
				System.out.println("Start");
				if(t.isAlive()) {
					t.stop();//destroy();
					try {
						t.sleep(300);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("Thread status: "+t.getState());
					
				}
					t.start();
				//drawPanel.repaint();
			}
		}); // Allow the app to hear about button pushes
    	northPanel.add(startBtn);
    	/** 
    	 * Pause Button
    	 */
    	pauseBtn = new JButton("Pause");
    	pauseBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Thread status: "+t.getState());
				System.out.println("Pause");
				if(t.isAlive()) {
					//System.out.println("thread is alive");
					t.suspend(); ;
				}
				else 
				{
					System.out.println("Start the process first");
					}
			
			}
		}); // Allow the app to hear about button pushes
    	northPanel.add(pauseBtn);
    	/** 
    	 * Resume Button
    	 */
    	resumeBtn = new JButton("Resume");
    	resumeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Thread status: "+t.getState());
				System.out.println("Resume");
				if(t.isAlive())
				{
					t.resume(); 
					//System.out.println("Resume");;
					
				}
				else
					System.out.println("Start the process first");
			}
		}); // Allow the app to hear about button pushes
    	northPanel.add(resumeBtn);
    	/** 
    	 * Stop Button
    	 */
    	stopBtn = new JButton("Stop"); // Allow the app to hear about button pushes
    	stopBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Thread status : "+t.getState());
				System.out.println("Stop");
				if(t.isAlive()) {
					t.stop();//destroy(); ;
				}
				else
					System.out.println("Start the process first");
			
			}
		});
    	northPanel.add(stopBtn);

    	}
    	catch (IllegalThreadStateException e) {
			// TODO: handle exception
    		System.out.println("Thread Exception"+e);
		}
    	catch (Exception e) {
			System.out.println("Other except");
		}
    	return northPanel;
    }
   /* 
	@Override
	public void actionPerformed(ActionEvent e) {
		log.info("We received an ActionEvent " );
		if (e.getSource()==startBtn) {
			System.out.println("\n\nStart pressed");
		}
		else if (e.getSource() == stopBtn)
		{
			System.out.println("Stop pressed");
		}
		else
		{
			 System.out.println("Else");
		}
	}
*/
	@Override
	public void windowOpened(WindowEvent e) {
		log.info("Window opened");
	}

	@Override
	public void windowClosing(WindowEvent e) {	
		log.info("Window closing");
	}



	@Override
	public void windowClosed(WindowEvent e) {
		log.info("Window closed");
	}



	@Override
	public void windowIconified(WindowEvent e) {
		log.info("Window iconified");
	}



	@Override
	public void windowDeiconified(WindowEvent e) {	
		log.info("Window deiconified");
	}



	@Override
	public void windowActivated(WindowEvent e) {
		log.info("Window activated");
	}



	@Override
	public void windowDeactivated(WindowEvent e) {	
		log.info("Window deactivated");
	}
	
	/**
	 * Sample Wolf application starting point
	 * @param args
	 */
	public static void main(String[] args) {
		PlantApp papp = new PlantApp();
		
		log.info("PlantApp started");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


}
