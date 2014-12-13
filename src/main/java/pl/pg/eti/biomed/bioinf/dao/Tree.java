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
		Collections.sort(edges, comparator);
		isTreeLegit=isTheTreeBuildable();
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
				output+=e.getLeavesAsString();
			}
			return output;
		}else{
			return "Drzewo o zadanych parametrach nie istnieje";
		}
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
