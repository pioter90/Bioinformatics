package pl.pg.eti.biomed.bioinf.parsers;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pl.pg.eti.biomed.bioinf.dao.Node;

public class TreeParserTest {
	private Node temp;
	
	@Before
	public void setup(){
		String treeString = FileParser.readFileAsString("Tests/TreeFormat/TreeParserTests/SingleTree.txt");
		temp = TreeParser.getRootNode(treeString);
	}
	
	@Test
	public void verifyFirstChildLine(){
		ArrayList<Node> firstChildNodes = temp.getChildren();
		Assert.assertEquals("Nieoczekiwana liczba dzieci roota", 2, firstChildNodes.size());
		for(Node node:firstChildNodes){
			
		}
	}
}
