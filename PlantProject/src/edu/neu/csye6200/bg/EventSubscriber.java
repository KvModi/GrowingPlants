package edu.neu.csye6200.bg;

import java.util.Observable;
import java.util.Observer;

public class EventSubscriber implements Observer{
	
	public EventSubscriber() {
		// TODO Auto-generated constructor stub
		System.out.println("Event subscriber");
	}
	public void update(Observable src,Object msg) {
		//react to the update
		System.out.println("ES received update from:"+src);
		System.out.println("                message:"+msg);
	}

}
