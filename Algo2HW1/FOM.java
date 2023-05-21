package Algo2HW1;

import java.util.Scanner;
import java.util.Stack;

public class FOM {

	private boolean[] marked; //Is a shortest path to this vertex known ?
	private int[] edgeTo;	  //Last vertex on known path to this vertex
	private int[] distTo;
	private int[] timeTo; //To store times of paths	
	public int time=0;
	public static int loadingTime;;
	public static int runningTime;
	public static int s;	//Source 
	public static int f;	//final point
	public static int cityNumber;
	public static int biDirect;
	
	
	
	 public FOM(FomGraph G)
	 {
     	
     addFromInput(G);
	 marked = new boolean[G.V()];
	 edgeTo = new int[G.V()];
	 distTo=new int[G.V()];
	 fom(G);
	 
	 }	
	
	
private void fom(FomGraph G) {
		
		
		Queue<Integer> q=new Queue();
		q.enqueue(s);		//And put it on the queue
		marked[s]=true;		//Mark the source
		distTo[s]=0;		
		
		while(!q.isEmpty()) {
			int v=q.dequeue(); //Remove next vertex from queue
			for(int w : G.adj(v)) {
				if(!marked[w]) {		//For every unmarked adjacent vertex
					
					q.enqueue(w);		//And add it to the queue.
					marked[w]=true;		//Mark it because path is known 
					edgeTo[w]=v;		//Save last edge on a shortest path
					
					
					distTo[w]=distTo[v]+1;
				}		
			}	
		}
		
		
		
	
	}
	public int showDistance(int v) {	//it helps for showing the distance between source and point we want to reach
			return distTo[v];	
		}
	
	public int getTime() {
		return time;
	}
	
	public void addTime(int time) {
		this.time+=time;
	}
	public static void input() {					//get information from input about city numbers and running and loading time 
		Scanner input=new Scanner(System.in);
		
		String line1=input.nextLine();
		cityNumber=Integer.parseInt(line1.replaceAll("\\s", "").substring(0,1));
		biDirect=Integer.parseInt(line1.replaceAll("\\s", "").substring(1,2));
		loadingTime=Integer.parseInt(line1.replaceAll("\\s", "").substring(2,3));
		runningTime=Integer.parseInt(line1.replaceAll("\\s", "").substring(3,4));
	
	}
	
	public static void addFromInput(FomGraph G) {	//add two cities thanks to input information
		 
		Scanner input=new Scanner(System.in);
		for(int i=0;i<biDirect;i++) {
			String lines=input.nextLine();
			int c1=Integer.parseInt(lines.replaceAll("\\s", "").substring(0,1));	//First city to add
			int c2=Integer.parseInt(lines.replaceAll("\\s", "").substring(1,2)); //Second city to add
			G.addEdge(c1, c2);										//Create a edge between the cities
			
		}
		String lastLine=input.nextLine();
		s=Integer.parseInt(lastLine.replaceAll("\\s", "").substring(0,1));
		f=Integer.parseInt(lastLine.replaceAll("\\s", "").substring(1,2));
	}
	
	public int calculateTime(int s,int f) {// calculate time between to vertical
		
		if(runningTime>loadingTime) {
			return  (calculateDistance(s,f)-1)*(2*loadingTime)+runningTime;
		}
		else {
			return ((this.distTo[f]-this.distTo[s]-1)*((runningTime+loadingTime)))+runningTime;
		}
		
	}
	public int calculateDistance(int s,int f) {// Calculate distance between to verticals
		return this.distTo[f]-this.distTo[s];
	}
	
	
	public String findPath(int v) //Find a path if there is 
	 {
		Integer [] array=new Integer[FOM.cityNumber*2];
		
		
		 if (!hasPathTo(v)) return null;
		 Stack<Integer> path = new Stack<Integer>();
		 int i=0;
		 for (int x = v; x != s; x = edgeTo[x]) {
			 path.push(x);
			 array[i]=x;
			 i++;
		 }
			 
		 path.push(s);
		 array[i]=s;
		 String h="";
		 for(int p=path.size()-1;p>=0;p--) {
			h+=array[p]+" ";
		 }
		 return h;
	 } 
	
	
	public boolean hasPathTo(int v)
	 { return marked[v]; }	
	
	public  void showEdges() {
		for(int i=this.edgeTo.length-1;i>0;i--) {
			System.out.println(i+" edge To"+this.edgeTo[i]);
		}
	}
	
}
