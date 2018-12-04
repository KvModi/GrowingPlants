
package edu.neu.csye6200.bg;

import java.util.Observable;

/**
 * @author vaibhavi
 *
 */
public class EventPublisher extends Observable{
	
	private boolean done=false; //set true to stop run method
	private int ctr=0; //count how many times we loop around
	
	//constructor
	public EventPublisher() {
		System.out.println("EventPublisher - we are here");
	}
	
	//An event has occurred, so notify the subscribers
	public void doAction() {
		setChanged(); //Indicate that a change has happened
		notifyObservers(new String("A message " +ctr));
	}
	
	//Do a lot of messaging
	public void run() {
		while(!done) {
			doAction();
			if(ctr++>10)
				done=true;
			
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventPublisher ep=new EventPublisher(); //we have a publisher
		EventSubscriber sub1=new EventSubscriber();
		ep.addObserver(sub1); //make the subscription
		ep.run();

	}

}
