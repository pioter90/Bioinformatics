package pl.pg.eti.biomed.bioinf.dao;

import java.util.ArrayList;

public class Tree {
	private ArrayList<Edge> edges;
	
	public Tree(ArrayList<Edge> edges){
		this.edges = edges;
	}
	
	public int getNumberOfEdges(){
		return this.edges.size();
	}
	
	public Edge getEdgeAt(int index){
		return this.edges.get(index);
	}
	
}
