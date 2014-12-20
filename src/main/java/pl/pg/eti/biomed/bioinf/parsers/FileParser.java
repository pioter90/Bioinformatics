package pl.pg.eti.biomed.bioinf.parsers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileParser {
	
    public static String readFileAsString(String filePath){
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
