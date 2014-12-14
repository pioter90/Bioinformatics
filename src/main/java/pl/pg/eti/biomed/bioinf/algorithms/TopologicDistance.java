package pl.pg.eti.biomed.bioinf.algorithms;

import pl.pg.eti.biomed.bioinf.dao.Edge;
import pl.pg.eti.biomed.bioinf.dao.Tree;

public class TopologicDistance {
	/*
	 * Calculate topologic distance between pair of trees
	 * Returns:
	 * -1 when distance  cannot be calculated
	 * >=0 calculated distance
	 */
	public static int calculateTopologicDistanceBetweenTrees(Tree tree1, Tree tree2){
		if(!tree1.getEdgeAt(0).equals(tree2.getEdgeAt(0)))
			return -1;
		int distance=0;
		distance += getNumberOfNotExistingEdges(tree1, tree2);
		distance += getNumberOfNotExistingEdges(tree2, tree1);
		return distance;
	}
	
	private static int getNumberOfNotExistingEdges(Tree tree, Tree refTree){
		int number=0;
		for(Edge edge:tree.getEdges()){
			if(!refTree.doesTreeContainsEdge(edge))
				number++;
		}
		return number;
	}
	
	
}
