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


    public static Tree getOneTreeFromFile(String filePath) {
    	Tree tree = getTreesFromFile(filePath, "##").get(0);
    	return tree;
    }
    
    public static ArrayList<Tree> getTreesFromFile(String filePath, String separator){
    	String fileData = readFileAsString(filePath);
    	if(fileData.length()!=0){
    		ArrayList<Tree> trees = getTreesFromString(fileData, separator);
    		return trees;
    	}else
    		return null;
    }
    
    private static Edge getEdgeFromLine(String line){
    	ArrayList<Leaf> leaves = new ArrayList<Leaf>();
        String[] leavesNames = line.split(",");
        for(int i=0;i<leavesNames.length; i++){
           Leaf leaf = new Leaf(leavesNames[i]);
            leaves.add(leaf);
        }
        return new Edge(leaves);
    }
    
    private static Tree getTreeFromString(String treeData){
    	String[] edgesData=treeData.split("\n");
    	ArrayList<Edge> edges = new ArrayList<Edge>();
		for(int i=0; i<edgesData.length; i++){
			edges.add(getEdgeFromLine(edgesData[i]));
		}
		return new Tree(edges);
    }
    
    private static ArrayList<Tree> getTreesFromString(String data, String separator){
    	ArrayList<Tree> trees = new ArrayList<Tree>();
    	String[] treesData = data.split(separator);
    	for(int i=0; i<treesData.length; i++){
    		trees.add(getTreeFromString(treesData[i]));
    	}
    	return trees;
    }
    
    private static String readFileAsString(String filePath){
    	try {
            File file = new File(filePath);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String readFile="";
            while ((line = bufferedReader.readLine()) != null) {
                line = line.replaceAll("\\s+","");
                readFile+=line+"\n";
            }
            readFile = readFile.substring(0, readFile.length()-1);
            fileReader.close();
            return readFile;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }




}




