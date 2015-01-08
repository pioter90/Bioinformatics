package pl.pg.eti.biomed.bioinf.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Tree {
	private ArrayList<Edge> edges;
	private boolean isTreeLegit;
	
	public Tree(ArrayList<Edge> edges){
		this.edges = edges;
		EdgeComparator comparator = new EdgeComparator();
		addSingletons();
		Collections.sort(edges, comparator);
		isTreeLegit=isTheTreeBuildable();
	}
	
	private void addSingletons(){
		ArrayList<Leaf> leaves = new ArrayList<Leaf>();
		for(Edge edge:edges)
			for(Leaf leaf:edge.getLeaves())
				if(!leaves.contains(leaf))
					leaves.add(leaf);
		for(Leaf leaf:leaves){
			Edge edge = new Edge(leaf);
			if(!edges.contains(edge))
				edges.add(edge);
		}
	}
	
	public int getNumberOfEdges(){
		return this.edges.size();
	}
	
	public Edge getEdgeAt(int index){
		return this.edges.get(index);
	}
	
	public ArrayList<Edge> getEdges(){
		return this.edges;
	}
	
	public String getTreeVisualisation(){
		if(isTreeLegit){
			String output="";
			for(Edge e:edges){
				output+=e.getLeavesAsString()+"\n";
			}
			output=output.substring(0, output.length()-1);
			return output;
		}else{
			return "Drzewo o zadanych parametrach nie istnieje";
		}
	}
	
	public boolean doesTreeContainsEdge(Edge edge){
		for(Edge locEdge:this.edges){
			if(edge.equals(locEdge))
				return true;
		}
		return false;
	}
	
	private boolean isTheTreeBuildable(){
		for(Edge edge1:edges){
			for(Edge edge2:edges){
				if(!edge1.isCompatible(edge2)){
					return false;
				}
			}
		}
		return true;
	}
	
}

class EdgeComparator implements Comparator<Edge>{

	public int compare(Edge e0, Edge e1) {
		int e0size = e0.getLeaves().size();
		int e1size = e1.getLeaves().size();
		if(e0size==e1size) return 0;
		else{
			if(e0size>e1size) 
				return -1;
			else
				return 1;
		}
	}
}
