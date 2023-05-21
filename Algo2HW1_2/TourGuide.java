package Algo2HW1_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

//-----------------------------------------------------
//Title: Tour Guide
//Author: Kaan GULER
//ID: 1973559069
//Section: 4
//Assignment: 1
//Description: This class goes to the target island according to the information it receives from the input, deletes every island it goes to from the graph and returns.
//-----------------------------------------------------

public class TourGuide {
	
	private boolean[] marked ; 	//Has dfs() been called for this vertex?
	private int[] edgeTo; //last vertex on known path to this vertex
	private int count; 
	public static int s;	//Source 
	public static int f;	//final point
	public static int cityNumber;
	public static int biDirect;
	private boolean hasCycle;
	public String x="";
	public boolean [] color;

	
	 public TourGuide(TourGraph G)
	 {
     	
     addFromInput(G);
	 marked = new boolean[G.V()];
	 edgeTo = new int[G.V()];
	 int[] distTo = new int[G.V()];
	 
	
		tgui(G);
	 
	 }	
	
	
	 private void tgui(TourGraph G) {
			
		   for(int i=0;i<marked.length;i++) {
			   marked[i]=false;
		   }
		   
		 
			
			Queue<Integer> q=new Queue();
			q.enqueue(s);		//And put it on the queue
			marked[s]=true;		//Mark the source	
			
			while(!q.isEmpty()) {
				int v=q.dequeue(); //Remove next vertex from queue
				for(int w : G.adj(v)) {
					if(!marked[w]) {		//For every unmarked adjacent vertex
						
						q.enqueue(w);		//And add it to the queue.
						marked[w]=true;		//Mark it because path is known 
						edgeTo[w]=v;		//Save last edge on a shortest path
						
						
				
					}		
				}	
			}
			
			
		
		
		}

	
	public void edgeTozero() {
		
		for(int i=0;i<edgeTo.length;i++) {
			edgeTo[i]=-1;
		}
	}
	

	
	
	
	
	 public String pathTo(TourGraph G,int v)
	 {
	ArrayList<Integer> fs=new ArrayList<Integer>();	 
	 if (!hasPathTo(v)) return null;
	 Stack<Integer> path = new Stack<Integer>();
	 for (int x = v; x != s; x = edgeTo[x]) {//finds its pay from destination to source
		if(x!=s && x!=v) {
			for(int i=1;i<TourGraph.adj.length;i++) {
	
				TourGraph.adj[i].remove(x);  // delete the passed vertex
			}
		}
		fs.add(x); 
		path.push(x); 
	 }
		
	 boolean tf=false;
	 if(fs.contains(v) &&  fs.size()==1) {//Check if there is any island between source and destination
		 for(int i=1;i<TourGraph.adj.length;i++) {
			TourGraph.adj[i].remove(v);
			tf=true;
		}
		 
		 }
	 
	 this.tgui(G);		//restart deleted island graph
	 for (int x = v; x != s; x = edgeTo[x]) {
			if(x!=s && x!=v) {
				for(int i=0;i<TourGraph.adj.length;i++) {
					TourGraph.adj[i].remove(x);
				}
			}
			if(tf) {	//if there is an island between source and target
				for(int i=0;i<edgeTo.length;i++) {
					if(edgeTo[i]==edgeTo[v]&& i!=v) {
						x=i;
								
					}
				}
			}
			if(x!=v) 
				path.push(x); 
		 }
	 
	 path.push(s);
	 
	 Integer arr[]=new Integer[path.size()];
	 for(int i=0;i<path.size();i++) {
		 arr[i]=path.elementAt(i);
	 }
	 Arrays.sort(arr);
	 String p="";
	 for(int i=0;i<arr.length;i++) {
		 p+=arr[i]+" ";
	 }
	 return p;
	 }
	
	
	
	public boolean hasPathTo(int v)
	 { return marked[v]; }	
	
	public  void showEdges() {
		for(int i=this.edgeTo.length-1;i>0;i--) {
			System.out.println(i+" edge To"+this.edgeTo[i]);
		}
	}
	
	
	public static void input() {	//get information from input about island numbers and their connections 
		Scanner input=new Scanner(System.in);
		
		String line1=input.nextLine();
		cityNumber=Integer.parseInt(line1.replaceAll("\\s", "").substring(0,1));
		biDirect=Integer.parseInt(line1.replaceAll("\\s", "").substring(1,2));
		
	}
	
	
	public static void addFromInput(TourGraph G) {	//add two islands thanks to input information
		 
		Scanner input=new Scanner(System.in);
		for(int i=0;i<biDirect;i++) {
			String lines=input.nextLine();
			int c1=Integer.parseInt(lines.replaceAll("\\s", "").substring(0,1));	//First island to add
			int c2=Integer.parseInt(lines.replaceAll("\\s", "").substring(1,2)); //Second island to add
			G.addEdge(c1, c2);										//Create a edge between the island
			
		}
		String lastLine=input.nextLine();
		s=Integer.parseInt(lastLine.replaceAll("\\s", "").substring(0,1));
		f=Integer.parseInt(lastLine.replaceAll("\\s", "").substring(1,2));
	}

}
