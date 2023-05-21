package Algo2HW1_2;
//-----------------------------------------------------
//Title: Tour Graph
//Author: Kaan GÜLER
//ID: 1973559069
//Section: 4
//Assignment: 1
//Description: This class adds the islands according to the information it receives from the input.
//-----------------------------------------------------

public class TourGraph {


	private final int V; //number of vertices
	private int E;		//number of edges
	public static Bag<Integer>[] adj; //adjecency list
	
	public TourGraph(int V) {
		this.V=V;
		this.E=0;
		adj=(Bag<Integer>[]) new Bag[V]; //Create array of lists.
	
		for(int v=0;v<V;v++) {			//Initialize all lists
			adj[v]=new Bag<Integer>();	//to empty.
		}
		}
	

	public int V() {
		return V;
	}
	public int E() {
		return E;
	}
	public void addEdge(int v,int w) {
		if(v==w) {
			adj[v].add(w);//add w to v's list
			
		}
		else {
		adj[v].add(w);	//add w to v's list
		adj[w].add(v);		//add v to w's list
		}
		
		E++;
	}
	
	public Iterable<Integer> adj(int v){// it returns adj list
		return adj[v];
	}
	

	
	
	
	
}
