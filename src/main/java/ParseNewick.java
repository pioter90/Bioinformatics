/**
 * Created by ifar on 2014-12-08.
 */


    import java.io.*;
    import java.lang.*;
    import java.util.*;

    import org.biojavax.bio.phylo.io.nexus.*;

    import org.jgrapht.*;
    import org.jgrapht.graph.*;

    public class ParseNewick {

        public static void main(String [] args) throws Exception {

            String label = "sample";
            String st = "((1:2.0, 2:3.0):2.0, 3:5.0)";
            String test = null;
            WeightedGraph<String, DefaultWeightedEdge> jg = new SimpleWeightedGraph<String, DefaultWeightedEdge>(DefaultWeightedEdge.class);

            TreesBlock sample_tree = new TreesBlock();
            TreesBlock.NewickTreeString s = new TreesBlock.NewickTreeString();

            s.setTreeString(st);
            sample_tree.addTree("test", s);

            jg = sample_tree.getTreeAsWeightedJGraphT("test");

            System.out.println(st);
            System.out.println(jg.toString());
        } // end of main

    }

