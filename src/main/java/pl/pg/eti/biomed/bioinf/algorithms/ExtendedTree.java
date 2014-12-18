package pl.pg.eti.biomed.bioinf.algorithms;

import java.util.ArrayList;

import pl.pg.eti.biomed.bioinf.dao.Edge;
import pl.pg.eti.biomed.bioinf.dao.Tree;

public class ExtendedTree {
	public Tree calculateExtendedTree(ArrayList<Tree> trees){
		Tree extendedTree = new Tree(getAllEdgesFromTrees(trees));
		return extendedTree;
	}
	
	private ArrayList<Edge> getAllEdgesFromTrees(ArrayList<Tree> trees){
		ArrayList<Edge> existingEdges = new ArrayList<Edge>();
		for(Tree tree:trees){
			for(Edge edge:tree.getEdges()){
				if(!existingEdges.contains(edge))
					existingEdges.add(edge);
			}
		}
		return existingEdges;
	}
}
