// A Java Program to detect cycle in an undirected graph
import java.io.*;
import java.util.*;

// This class represents a directed graph using adjacency list
// representation
class Graph
{
	private int V; // No. of vertices
	private LinkedList<Integer> adj[]; // Adjacency List Represntation

	// Constructor
	Graph(int v) {
		V = v;
		adj = new LinkedList[v];
		for(int i=0; i<v; ++i)
			adj[i] = new LinkedList();
	}

	// Function to add an edge into the graph
	void addEdge(int v,int w) {
		adj[v].add(w);
		adj[w].add(v);
	}
	
	boolean isCyclicUtil(boolean [] visited, int v, int parent){
	    visited[v]= true;
	    int i; 
	    Iterator<Integer> it = adj[v].iterator();
	    while(it.hasNext()){
	        i=it.next();
	        if(!visited[i]){
	            if(isCyclicUtil(visited, i, v)) return true;
	        }
	        else{
	            if( i != parent) return true;
	        }
	    }
	    return false;
	}
	boolean isCyclic(){
	    boolean [] visited = new boolean [V];
	    for ( int i =0; i< visited.length; i++){
	        visited[i]=false;
	    }
	    for ( int i=0; i< adj.length; i++){
	        if(! visited[i]){
	            if( isCyclicUtil(visited, i, -1)) return true;
	        }
	    }
	    return false;
	}




	// Driver method to test above methods
	public static void main(String args[])
	{
		// Create a graph given in the above diagram
		Graph g1 = new Graph(5);
		g1.addEdge(1, 0);
		g1.addEdge(0, 2);
		//g1.addEdge(2, 0);
		g1.addEdge(0, 3);
		g1.addEdge(3, 4);
		g1.addEdge(3,2);
		if (g1.isCyclic())
			System.out.println("Graph contains cycle");
		else
			System.out.println("Graph doesn't contains cycle");

		Graph g2 = new Graph(3);
		g2.addEdge(0, 1);
		g2.addEdge(1, 2);
		if (g2.isCyclic())
			System.out.println("Graph contains cycle");
		else
			System.out.println("Graph doesn't contains cycle");
	}
}
