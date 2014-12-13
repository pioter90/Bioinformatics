package pl.pg.eti.biomed.bioinf.parsers;
import pl.pg.eti.biomed.bioinf.dao.Edge;
import pl.pg.eti.biomed.bioinf.dao.Leaf;
import pl.pg.eti.biomed.bioinf.dao.Tree;

import java.io.*;
import java.nio.file.Path;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;

public class ClusterParser {


    public static Tree parseFile(String filePath) {
        ArrayList<Edge> edges = new ArrayList<Edge>();

        try {
            File file = new File(filePath);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                line = line.replaceAll("\\s+","");
                ArrayList<Leaf> leaves = new ArrayList<Leaf>();
                String[] leavesNames = line.split(",");
                for(int i=0;i<leavesNames.length; i++){
                   Leaf leaf = new Leaf(leavesNames[i]);
                    leaves.add(leaf);
                }
                Edge edge = new Edge(leaves);
                edges.add(edge);
            }
            fileReader.close();


        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        Tree tree = new Tree(edges);
        return tree;
    }




}




