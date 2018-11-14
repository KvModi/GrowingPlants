package edu.neu.csye6200.sim;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.*;

public class RegistryIO {
	
	private static Logger log = Logger.getLogger(RegistryIO.class.getName());  // logger
	FileHandler fh;  // file handler
	
	public RegistryIO()
	{
		log.log(Level.INFO, "Creating RegistryIO Instance");
		try 
		{
			fh = new FileHandler("src.edu.neu.csye6200.sim.Logger.log");
			fh.setFormatter(new SimpleFormatter());
		} catch (SecurityException | IOException e) {
			e.printStackTrace();
		}
		
		log.addHandler(fh);
	}
	
	public void save(HashMap<Integer, Plant> plants,String s)  //Method to save Plant list to a file 
	{
		
		String base = "src\\edu\\neu\\csye6200\\sim\\";      //base directory
		try
		{
			log.log(Level.INFO, "Saving Plant List");
			PrintWriter file = new PrintWriter(base + s);  
			
			for(int i=0;i<plants.size();i++)
			{
				Plant pt=plants.get(i);
				if(pt==null)
					continue;
				String st=new StringBuffer(" ").append(pt.plantId).append(" : ").append(pt.plantType).append(" : ").append(pt.plantHeight).toString();
				
				file.println(st);
			}
			file.close();
			
		}
		catch(IOException ex)
		{
			log.log(Level.SEVERE, ex.getMessage());
			ex.printStackTrace();
		}
	
	}
	
	private String StringBuffer(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(Plant p1, String s) //for writing a single Plant to an open file
	{
		String base = "src\\edu\\neu\\csye6200\\sim\\";
		try
		{
			String temp = p1.toString();
			FileWriter file = new FileWriter(base +s);
		log.log(Level.INFO, "saving plant");
			file.write(temp);
			file.close();
		}
		catch(IOException ex)
		{
			log.log(Level.SEVERE, ex.getMessage());
			ex.printStackTrace();
		}
	}
	
//Add public methods to load() and save() all Plants to disk- pass plant name and file name
	HashMap<Integer, Plant> plantRead = new HashMap<>(); 
	public void load( String filename) {
		try 
		{
			
			String base = "src\\edu\\neu\\csye6200\\sim\\";
			 FileInputStream fileIn = new FileInputStream(base+filename);
			 ObjectInputStream objectIn = new ObjectInputStream(fileIn);
			 
			 String st= (String) objectIn.readObject();
		     System.out.println(st);
		      //plantRead=sc.nextLine();
		    
			objectIn.close();
			fileIn.close();
			 
			
		}catch (FileNotFoundException e) {

			
			e.printStackTrace();
		}catch (Exception e) {

			
			e.printStackTrace();
		}
	
		
	}
		}

