package pl.pg.eti.biomed.bioinf.algorithms;
import pl.pg.eti.biomed.algorithms.TopologicDistance;


import org.junit.*;
import pl.pg.eti.biomed.bioinf.dao.Tree;
import pl.pg.eti.biomed.bioinf.parsers.ClusterParser;

public class TopologicalDistanceTest {

    @Test
    public void trees_RF_4(){
        Tree tree = ClusterParser.parseFile("TopologicalDistanceTests/Tree_1_RF_4.txt");
        Tree tree2 = ClusterParser.parseFile("TopologicalDistanceTests/Tree_2_RF_4.txt");
        Assert.assertTrue(TopologicDistance.calculateTopologicDistanceBetweenTrees(tree, tree2) == 4);
    }
    @Test
    public void trees_RF_0(){
        Tree tree = ClusterParser.parseFile("TopologicalDistanceTests/Tree_1_RF_0.txt");
        Tree tree2 = ClusterParser.parseFile("TopologicalDistanceTests/Tree_2_RF_0.txt");
        Assert.assertTrue(TopologicDistance.calculateTopologicDistanceBetweenTrees(tree, tree2) == 0);
    }
    @Test
    public void trees_RF_null(){
        Tree tree = ClusterParser.parseFile("TopologicalDistanceTests/Tree_1_RF_null.txt");
        Tree tree2 = ClusterParser.parseFile("TopologicalDistanceTests/Tree_2_RF_null.txt");
    }



}
