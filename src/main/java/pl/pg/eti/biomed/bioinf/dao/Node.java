package pl.pg.eti.biomed.bioinf.dao;

import java.util.ArrayList;

public class Node {
	private Node parent;
	private ArrayList<Node> children;
	private ArrayList<Leaf> leaves;
	private boolean checked;
	
	public Node(Node parent){
		this.parent = parent;
		children = new ArrayList<Node>();
		leaves = new ArrayList<Leaf>();
	}
	
	public void addChild(Node child){
		children.add(child);
	}
	
	public ArrayList<Node> getChildren(){
		return this.children;
	}
	
	public ArrayList<Leaf> getLeaves(){
		return this.leaves;
	}
	
	public Node getParent(){
		return this.parent;
	}
	
	public void addLeaf(Leaf leaf){
		leaves.add(leaf);
	}
	
	public boolean check(){
		if(checked)
			return false;
		else{
			checked=true;
			return true;
		}	
	}
	
	public void updateLeaves(){
		for(Node child:this.children){
			child.updateLeaves();
			ArrayList<Leaf> childLeaves = child.getLeaves();
			for(Leaf leaf:childLeaves){
				this.addLeaf(leaf);
			}
		}

	}
}
