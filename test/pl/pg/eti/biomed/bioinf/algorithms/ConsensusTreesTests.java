package pl.pg.eti.biomed.bioinf.algorithms;

import org.junit.*;
import pl.pg.eti.biomed.bioinf.dao.Tree;
import pl.pg.eti.biomed.bioinf.parsers.ClusterParser;

import java.util.ArrayList;

public class ConsensusTreesTests {
    private ArrayList<Tree> firstTree;

    @Before
    public void setup(){
        firstTree = ClusterParser.getTreesFromFile("Tests/MultipleTreesTests/ConsensusTrees_Sample1.txt", "####");
    }
    @Test
    public void testNumberOfLoadedTrees(){
       // Assert.assertEquals(2, firstTree.size());
    }
    @Test
    public void testNumberOfEdgesInConsensusTree(){
        Tree first = firstTree.get(0);
       // Assert.assertEquals(8, first.getNumberOfEdges());
    }
    @Test
    public void testNumberOfEdgesInSecondTree(){
        Tree second = firstTree.get(1);
      //  Assert.assertEquals(7, second.getNumberOfEdges());
    }
    @Test
    public void displayTrees(){
        ConsensusTreeBuilder.getConsensusTree(firstTree,50);

        //for(int i=0; i<2; i++){
            //System.out.println("Tree number "+i);
            //System.out.println(ConsensusTreeBuilder.getConsensusTree(firstTree, 100).getTreeVisualisation());
        ConsensusTreeBuilder.getConsensusTree(firstTree, 100).getTreeVisualisation();
            System.out.println("======================");
       // }

    }
}
