/**
 * Created by ifar on 2014-12-08.
 */


    import java.io.*;
import java.lang.*;
import java.util.*;

    import org.biojavax.bio.phylo.io.nexus.*;
    import org.jgrapht.*;
import org.jgrapht.graph.*;

import pl.pg.eti.biomed.bioinf.dao.Leaf;
    import pl.pg.eti.biomed.bioinf.dao.Tree;
    import pl.pg.eti.biomed.bioinf.parsers.ClusterParser;

public class ParseNewick {

        public static void main(String [] args) throws Exception {

            Tree tree = ClusterParser.parseFile("cos.xml");
            
        } // end of main

    }

