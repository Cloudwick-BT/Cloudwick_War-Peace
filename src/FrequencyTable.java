
/**
 * Created by Bhavin on 07/03/2016.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.io.FileWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FrequencyTable {
    public static void main(String [] args) {
        int count = 0;
        String word = null;
        String fileName = "F:/Cloudwick/java_Cloudwick/gutenberg/prac.txt";
        FileReader file = null;
        BufferedReader br = null;
        String currentLine = null;
        String[] arrayList = null;
        HashMap<String, Integer> hmap = new HashMap<String, Integer> ();

        // csv filename to be written
        String outFile = "F:/Cloudwick/java_Cloudwick/gutenberg/tf.csv";

        boolean checkExist = new File(outFile).exists();

        try {
            file = new FileReader(fileName);
            br = new BufferedReader(file);

            while ((currentLine = br.readLine()) != null) {
                arrayList = currentLine.split("[^a-zA-Z]");
                for(String str : arrayList){
                    str = str.toLowerCase();
                    if (str.length()>1 && !str.equals(" ")) {
                        if (hmap.containsKey(str)) {
                            hmap.put(str, hmap.get(str) + 1);
                        } else {
                            hmap.put(str, 1);
                        }
                    }
                }
            }
            System.out.print("Total Count is : ");
            System.out.print(hmap.get("the"));

            // this part of code is to write on file

            FileWriter writer = new FileWriter(outFile);

            for (String key : hmap.keySet()){
                writer.append(key);
                writer.append(",");
                writer.append((hmap.get(key)).toString());
                writer.append("\n");
            }
            writer.flush();
            writer.close();
        }
        catch(Exception e){
            System.out.println("File not found !!");
        }


    }
}
