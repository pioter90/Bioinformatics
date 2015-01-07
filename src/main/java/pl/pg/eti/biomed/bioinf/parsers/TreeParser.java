package pl.pg.eti.biomed.bioinf.parsers;

import java.util.ArrayList;

import pl.pg.eti.biomed.bioinf.dao.Edge;
import pl.pg.eti.biomed.bioinf.dao.Leaf;
import pl.pg.eti.biomed.bioinf.dao.Node;
import pl.pg.eti.biomed.bioinf.dao.Tree;

public class TreeParser {
	public static ArrayList<Tree> getTreesFromFile(String filePath){
		String fileData = FileParser.readFileAsString(filePath);
		ArrayList<Tree> trees = new ArrayList<Tree>();
		String[] lines = fileData.split("\n");
		for(int i=0; i<lines.length; i++){
			Tree tree = getTreeFromLine(lines[i]);
			trees.add(tree);
		}
		return trees;
	}
	
	public static Tree getTreeFromLine(String line){
		Node root = getRootNode(line);
		ArrayList<Edge> edges = getClustersFromRoot(root);
		Tree tree = new Tree(edges);
		return tree;
	}
	
	public static ArrayList<Edge> getClustersFromRoot(Node root){
		ArrayList<Edge> edges = new ArrayList<Edge>();
		boolean allChecked=false;
		Node currentNode = root;
		currentNode.updateLeaves();
		edges.add(new Edge(currentNode.getLeaves()));
		ArrayList<Node> childNodes;
		boolean childPicked;
		while(!allChecked){
			childNodes = currentNode.getChildren();
			childPicked=false;
			for(Node child:childNodes){
				if(child.check()){
					Edge edge = new Edge(child.getLeaves());
					edges.add(edge);
					currentNode = child;
					childPicked=true;
					break;
				}
			}
			if(!childPicked){
				currentNode=currentNode.getParent();
				if(currentNode==null)
					allChecked=true;
			}
			
		}
		return edges;
	}
	
	public static Node getRootNode(String line){
		String leafName = "";
		Node root = new Node(null);
		Node currentNode=root;
		for(int i=0; i<line.length(); i++){
			char c = line.charAt(i);
			if(c=='[' || c==']' || c=='(' || c==')' || c==','){
				switch(c){
				case '(':
					currentNode = new Node(currentNode);
					currentNode.getParent().addChild(currentNode);
					break;
				case ')':
					if(!leafName.equals(""))
						currentNode.addLeaf(new Leaf(leafName));
					currentNode = currentNode.getParent();
					break;
				case ',':
					if(!leafName.equals(""))
						currentNode.addLeaf(new Leaf(leafName));
					break;
				}
				leafName="";
			}else{
				leafName += c;
			}
		}
		return root;
	}
}
