package pl.pg.eti.biomed.bioinf.algorithms;

import java.util.ArrayList;

import pl.pg.eti.biomed.bioinf.dao.Edge;
import pl.pg.eti.biomed.bioinf.dao.Tree;

public class ConsensusTreeBuilder {
	public static Tree getConsensusTree(ArrayList<Tree> trees, int percentage){
		if(haveAllTheTreesCommonRoot(trees)){
			ArrayList<Edge> consensusEdges = new ArrayList<Edge>();
			for(Tree tree:trees){
				for(Edge edge:tree.getEdges()){
					if(canEdgeBeAddedToConsensusTree(edge, trees, percentage) && !consensusEdges.contains(edge))
						consensusEdges.add(edge);
				}
			}
			return new Tree(consensusEdges);
		}else{
			return null;
		}
	}
	
	private static boolean haveAllTheTreesCommonRoot(ArrayList<Tree> trees){
		Edge root = trees.get(0).getEdgeAt(0);
		for(Tree tree:trees){
			if(!root.equals(tree.getEdgeAt(0)))
				return false;
		}
		return true;
	}
	
	private static boolean canEdgeBeAddedToConsensusTree(Edge edge, ArrayList<Tree> trees, int percentage){
		int numberOfOccurences=0;
		for(Tree tree:trees){
			if(tree.doesTreeContainsEdge(edge))
				numberOfOccurences++;
		}
		if(numberOfOccurences/trees.size()>=(double)(percentage/100))
			return true;
		else
			return false;
	}
}
