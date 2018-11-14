package edu.neu.csye6200.sim;

import java.util.HashMap;

public class ChildStem {
		int childNo;
		int parentid,parentx,parenty,length;
		Stem2 stem=new Stem2();
		public static HashMap<Integer,Stem2> child = new HashMap<>();
		public ChildStem(int stemid, int x1, int y1, int lenStem) {
			parentid=stemid;
			parentx=x1;
			parenty=y1;
			length=lenStem;
		}
		public void addChild() {
			
			
		}
		public String toString( ChildStem cs) {
			return String.format("%-5d (%4d,%-4d)   %9d %4$5d ",parentid,parentx,parenty,length);
		}

	
}
