package pl.pg.eti.biomed.bioinf.algorithms;

import java.util.ArrayList;

import pl.pg.eti.biomed.bioinf.dao.Edge;
import pl.pg.eti.biomed.bioinf.dao.Leaf;
import pl.pg.eti.biomed.bioinf.dao.Tree;

public class TreeCutter {
	public static Tree cutLeaf(Leaf leaf, Tree tree){
		ArrayList<Edge> edges = tree.getEdges();
		ArrayList<Edge> newEdges = new ArrayList<Edge>();
		ArrayList<Leaf> leaves;
		for(Edge edge:edges){
			leaves = new ArrayList<Leaf>();
			for(Leaf l:edge.getLeaves()){
				if(!l.equals(leaf) && !leaves.contains(l))
					leaves.add(l);
			}
			if(leaves.size()>0 && !newEdges.contains(new Edge(leaves)))
				newEdges.add(new Edge(leaves));
		}
		return new Tree(newEdges);
	}
	
//	public static Tree cutLeaves(ArrayList<Leaf> leaves, Tree tree){
//		for(Leaf leaf:leaves){
//			
//		}
//	}
}
