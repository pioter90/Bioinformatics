package pl.pg.eti.biomed.bioinf.parsers;
import java.util.ArrayList;

import org.junit.*;

import pl.pg.eti.biomed.bioinf.dao.Edge;
import pl.pg.eti.biomed.bioinf.dao.Leaf;
import pl.pg.eti.biomed.bioinf.dao.Tree;


public class MultipleTreesReadTest {
	private ArrayList<Tree> trees;
	
	@Before
	public void setup(){
		trees = ClusterParser.getTreesFromFile("Tests/MultipleTreesTests/MultipleTreesRead_Sample1.txt", "####");
	}
	
	@Test
	public void testNumberOfLoadedTrees(){
		Assert.assertEquals(2, trees.size());
	}
	
	@Test
	public void testNumberOfEdgesInFirstTree(){
		Tree first = trees.get(0);
		Assert.assertEquals(8, first.getNumberOfEdges());
	}
	
	@Test
	public void testNumberOfEdgesInSecondTree(){
		Tree second = trees.get(1);
		Assert.assertEquals(7, second.getNumberOfEdges());
	}
	
	@Test
	public void displayTrees(){
		for(int i=0; i<2; i++){
			System.out.println("Tree number "+i);
			System.out.println(trees.get(i).getTreeVisualisation());
			System.out.println("======================");
		}
		
	}
	
	
}
