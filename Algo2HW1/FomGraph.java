package Algo2HW1;


public class FomGraph {
	public final int V; //number of vertices
	private int E;		//number of edges
	private Bag<Integer>[] adj; //adjecency list
	
	public FomGraph(int V) {
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
	
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
	
	public static int degree(FomGraph G,int v) {
		int degree=0;
		for(int w : G.adj(v)) {
			degree++;
		}
		return degree;
	}
	public static int maxDegree(FomGraph G) {
		int gN=0;
		int degree=0;
		for(int i=0;i<G.V;i++) {
			for(int w: G.adj(i)) {
				degree++;
			}
			if(degree>gN) {
				gN=degree;
			}
			degree=0;
				
		}
		return gN;
		
	}
	
	public static int numberOfselfLoops(FomGraph G) {
		int sl=0;
		for(int i=0;i<G.V;i++) {
			for(int w:G.adj(i)) {
				if(i==w) {
					sl++;
				}
			}
		}
		return sl;
		
		
	}
	
}
