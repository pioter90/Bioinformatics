package pl.pg.eti.biomed.bioinf.algorithms;

import org.junit.*;
import pl.pg.eti.biomed.bioinf.dao.Edge;
import pl.pg.eti.biomed.bioinf.dao.Leaf;
import pl.pg.eti.biomed.bioinf.dao.Tree;
import pl.pg.eti.biomed.bioinf.parsers.ClusterParser;

import java.util.ArrayList;

public class ConsensusTreesTests {
    private ArrayList<Tree> firstTree;
    private Tree firstConsensusTree;

    @Before
    public void setup(){
        firstTree = ClusterParser.getTreesFromFile("Tests/MultipleTreesTests/ConsensusTrees_Sample1.txt", "####");
        firstConsensusTree = ConsensusTreeBuilder.getConsensusTree(firstTree, 100);
    }
    @Test
    public void checkFirstNode(){
        Edge first = firstConsensusTree.getEdgeAt(0);
        ArrayList<Leaf> leaves = first.getLeaves();
        Assert.assertEquals(5,leaves.size());
        Assert.assertEquals("A", leaves.get(0).getId());
        Assert.assertEquals("B", leaves.get(1).getId());
        Assert.assertEquals("C", leaves.get(2).getId());
        Assert.assertEquals("D", leaves.get(3).getId());
        Assert.assertEquals("E", leaves.get(4).getId());
    }
    @Test
    public void checkSecondNode(){
        Edge second = firstConsensusTree.getEdgeAt(1);
        ArrayList<Leaf> leaves = second.getLeaves();
        Assert.assertTrue(leaves.size()==1);
        Assert.assertEquals(leaves.get(0).getId(), "A");

    }
    @Test
    public void checkThirdNode(){
        Edge third = firstConsensusTree.getEdgeAt(2);
        ArrayList<Leaf> leaves = third.getLeaves();
        Assert.assertTrue(leaves.size()==1);
        Assert.assertEquals(leaves.get(0).getId(), "B");

    }
    @Test
    public void displayTrees(){
        ConsensusTreeBuilder.getConsensusTree(firstTree,100);

        //for(int i=0; i<2; i++){
            //System.out.println("Tree number "+i);
            //System.out.println(ConsensusTreeBuilder.getConsensusTree(firstTree, 100).getTreeVisualisation());
        System.out.println(ConsensusTreeBuilder.getConsensusTree(firstTree, 100).getTreeVisualisation());
            System.out.println("======================");
       // }

    }
}
