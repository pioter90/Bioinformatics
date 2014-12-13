package pl.pg.eti.biomed.algorithms;

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
		for(Edge edge:tree1.getEdges()){
			//TO DO!
		}
		
		return 0;
	}
	
	
}
