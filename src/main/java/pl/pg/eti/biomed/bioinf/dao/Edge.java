package pl.pg.eti.biomed.bioinf.dao;

import java.util.ArrayList;

public class Edge {
	private ArrayList<Leaf> leaves;
	
	public Edge(ArrayList<Leaf> leaves){
		this.leaves = leaves;
	}
	
	/*
	 * Return true/false whether the edges (clusters) are consistence
	 */
	public boolean isCompatible(Edge edge){
		Edge bigger = edge;
		Edge smaller = this;
		if(this.getNumberOfLeaves()>=edge.getNumberOfLeaves()){
			bigger=this;
			smaller=edge;
		}
		boolean test = bigger.isLeafIncluded(smaller.getFirstLeaf());
		
		for(Leaf leaf:smaller.leaves){
			if(!test==bigger.isLeafIncluded(leaf)){
				return false;
			}
		}
		return true;
		
	}
	
	private boolean isLeafIncluded(Leaf searchedLeaf){
		for(Leaf leaf:leaves){
			if(searchedLeaf.equals(leaf))
				return true;
		}
		return false;
	}
	
	private Leaf getFirstLeaf(){
		return this.leaves.get(0);
	}
	
	private int getNumberOfLeaves(){
		return this.leaves.size();
	}
	
}
