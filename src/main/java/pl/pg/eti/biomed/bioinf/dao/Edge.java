package pl.pg.eti.biomed.bioinf.dao;

import java.util.ArrayList;
import java.util.Collections;

import pl.pg.eti.biomed.bioinf.comparators.LeafComparer;

public class Edge {
	private ArrayList<Leaf> leaves;
	
	public Edge(ArrayList<Leaf> leaves){
		this.leaves = leaves;
		Collections.sort(leaves, new LeafComparer());
	}
	
	//For Singletons
	public Edge(Leaf leaf){
		leaves = new ArrayList<Leaf>();
		leaves.add(leaf);
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
	
	public ArrayList<Leaf> getLeaves(){
		return this.leaves;
	}
	
	public String getLeavesAsString(){
		String stringLeaves="";
		for(Leaf leaf:leaves){
			stringLeaves+=leaf.getId();
		}
		return stringLeaves;
	}
	
	@Override
	public boolean equals(Object o){
		if(o.getClass().equals(this.getClass())){
			Edge edge = (Edge)o;
			if(this.getNumberOfLeaves()!=edge.getNumberOfLeaves())
				return false;
			for(Leaf leaf:this.leaves){
				if(!edge.doesContainLeaf(leaf))
					return false;
			}
			return true;
		}else{
			return false;
		}
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
	
	private boolean doesContainLeaf(Leaf leaf){
		return this.leaves.contains(leaf);
	}
	
	
	
}
