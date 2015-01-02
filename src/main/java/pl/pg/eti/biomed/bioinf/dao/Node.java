package pl.pg.eti.biomed.bioinf.dao;

import java.util.ArrayList;

public class Node {
	private Node parent;
	private ArrayList<Node> children;
	private ArrayList<Leaf> leaves;
	
	public Node(Node parent){
		this.parent = parent;
		children = new ArrayList<Node>();
		leaves = new ArrayList<Leaf>();
	}
	
	public void addChild(Node child){
		//Dodaæ liœcie dziecka
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
}
