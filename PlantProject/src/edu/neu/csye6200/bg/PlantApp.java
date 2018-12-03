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
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * @author krishnamodi
 *
 */
public class PlantApp extends BGApp{

	private static Logger log = Logger.getLogger(PlantApp.class.getName());

	protected JPanel mainPanel = null;
	protected JPanel northPanel = null;
	protected JPanel northPanel2 = null;
	protected JPanel eastPanel = null;
	protected JButton startBtn = null;
	protected JButton stopBtn = null;
	protected JButton pauseBtn = null;
	protected JButton resumeBtn = null;
	protected JButton startBtn2 = null;
	protected JButton stopBtn2 = null;
	protected JButton pauseBtn2 = null;
	protected JButton resumeBtn2 = null;
	protected JButton incr = null;
	protected JButton decr = null;
	protected JLabel label;
	static int levelNo=3;
    private BGCanvas bgPanel = null;
	public BGGenerationSet bggs=null;
	Thread t=null;
	Thread t2=null;
    
    /**
     * Sample app constructor
     */
    public PlantApp() {
    	frame.setSize(500, 400); // initial Frame size
		frame.setTitle("PlantApp");
		menuMgr.createDefaultActions(); // Set up default menu items
		showUI(); // Cause the Swing Dispatch thread to display the JFrame
		BGGenerationSet bgg=new BGGenerationSet();
		BGCanvas canvas=new BGCanvas();
		bgg.addObserver(canvas);
		

    }
   
    /**
     * Create a main panel that will hold the bulk of our application display
     */
	@Override
	public JPanel getMainPanel() {
	
		mainPanel = new JPanel();
    	mainPanel.setLayout(new BorderLayout());
    	mainPanel.add(BorderLayout.NORTH, getNorthPanel());
    	mainPanel.add(BorderLayout.SOUTH,getNorthPanel2());
    	mainPanel.add(BorderLayout.EAST,getEastPanel());
    	
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
    	
   	 
   	
   	
    	/** 
    	 * Start Button
    	 */
    	
    	
    	startBtn = new JButton("Start Tree 1");
    	startBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
					bggs = new BGGenerationSet(1,levelNo);
					 t= new Thread(bggs);
					System.out.println("Start");
					t.start();
					System.out.println("Thread status: "+t.getState());
					
				
					
				//drawPanel.repaint();
			}
		}); // Allow the app to hear about button pushes
    	northPanel.add(startBtn);
    	/** 
    	 * Pause Button
    	 */
    	pauseBtn = new JButton("Pause Tree 1");
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
    	resumeBtn = new JButton("Resume Tree 1");
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
    	stopBtn = new JButton("Stop Tree 1"); // Allow the app to hear about button pushes
    	stopBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Thread status : "+t.getState());
				System.out.println("Stop");
				if(t.isAlive()) {
					//destroy(); ;
					
					t.stop();
					northPanel.setVisible(false);
				}
				else
					System.out.println("Start the process first");
			
			}
		});
    	northPanel.add(stopBtn);

    	
    	
    
    	
    	
    	return northPanel;
    	
    }
    
    
    
    public JPanel getNorthPanel2() {
    	/**
    	 * Second tree pattern
    	 * 
    	 */
    	northPanel2 = new JPanel();
    	northPanel2.setLayout(new FlowLayout());
    	bggs = new BGGenerationSet(2,levelNo);
   	//= new Thread(bggs);
    	

    	startBtn2 = new JButton("Start Tree 2");
    	startBtn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Thread status: "+t2.getState());
				
				if(t2.isAlive()) {
					System.out.println("The system is already running. Please click Resume");
					t2.resume(); 
				}
				else 
				{
					System.out.println("Start");
					t2 = new Thread(bggs);
					t2.start();
					
					
				}
					
				//drawPanel.repaint();
			}
		}); // Allow the app to hear about button pushes
    	northPanel2.add(startBtn2);
    	/** 
    	 * Pause Button
    	 */
    	pauseBtn2 = new JButton("Pause Tree 2");
    	pauseBtn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Thread status: "+t2.getState());
				System.out.println("Pause");
				if(t2.isAlive()) {
					//System.out.println("thread is alive");
					t2.suspend(); ;
				}
				else 
				{
					System.out.println("Start the process first");
					}
			
			}
		}); // Allow the app to hear about button pushes
    	northPanel2.add(pauseBtn2);
    	/** 
    	 * Resume Button
    	 */
    	resumeBtn2 = new JButton("Resume Tree 2");
    	resumeBtn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Thread status: "+t2.getState());
				System.out.println("Resume");
				if(t2.isAlive())
				{
					t2.resume(); 
					//System.out.println("Resume");;
					
				}
				else
					System.out.println("Start the process first");
			}
		}); // Allow the app to hear about button pushes
    	northPanel2.add(resumeBtn2);
    	/** 
    	 * Stop Button
    	 */
    	stopBtn2 = new JButton("Stop Tree 2"); // Allow the app to hear about button pushes
    	stopBtn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Thread status : "+t2.getState());
				System.out.println("Stop");
				if(t2.isAlive()) {
					//destroy(); ;
					
					t2.stop();
				}
				else
					System.out.println("Start the process first");
			
			}
		});
    	northPanel2.add(stopBtn2);

    	
    	return northPanel2;
    }
    
    
    public JPanel getEastPanel() {
    	eastPanel = new JPanel();
    	eastPanel.setLayout(new FlowLayout());
    	incr=new JButton("Increment");
    	
    	label = new JLabel("" + levelNo);
    	
        incr.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent event)
        {
            levelNo++;

            label.setText("" + levelNo);


        }});
        decr=new JButton("Decrement");
    	
    	label = new JLabel("" + levelNo);
    	
        decr.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent event)
        {
        		if(levelNo!=0 ) {
            levelNo--;
            label.setText("" + levelNo);

        		}
        }});
        eastPanel.add(incr);
        eastPanel.add(label);
        eastPanel.add(decr);
        

		return eastPanel;
    }

    
    	
    	
    	
    
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Plant application starting point
	 * @param args
	 */
	public static void main(String[] args) {
		PlantApp papp = new PlantApp();
		
		log.info("PlantApp started");
	}

	


}
