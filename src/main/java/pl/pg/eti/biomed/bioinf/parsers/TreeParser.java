package pl.pg.eti.biomed.bioinf.parsers;

import java.util.ArrayList;

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

		return null;
	}
	
	public static Node getRootNode(String line){
		String leafName = "";
		Node currentNode=null;
		Node root = new Node(null);
		for(int i=0; i<line.length(); i++){
			char c = line.charAt(i);
			if(c=='[' || c==']' || c=='(' || c==')' || c==','){
				switch(c){
				case ']':
					break;
				case '[':
					currentNode = root;
					break;
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
