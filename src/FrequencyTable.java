
/**
 * Created by Bhavin on 07/03/2016.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
import java.io.FileWriter;


public class FrequencyTable {

    //Method for sorting the TreeMap based on values



    public static void main(String [] args) {
        int count = 0;
        String fileName = "F:/Cloudwick/java_Cloudwick/gutenberg/war&peace.txt";
        FileReader file = null;
        BufferedReader br = null;
        String currentLine = null;
        String[] arrayList = null;
        Map<String, Integer> hmap = new HashMap<String, Integer> ();
        //TreeMap<String, Integer> hmap = new TreeMap<String, Integer> ();
        // csv filename to be written
        String outFile = "F:/Cloudwick/java_Cloudwick/gutenberg/tf.csv";
        boolean checkExist = new File(outFile).exists();

        if (checkExist){
            System.out.print(outFile + " file exist !");
            return;
        }

        SortedSet<Map.Entry<String, Integer>> sortedset = new TreeSet<Map.Entry<String, Integer>>(
                new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> e1,
                                       Map.Entry<String, Integer> e2) {
                        return (-1*e1.getValue().compareTo(e2.getValue()));
                    }
                });

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

            // to write top 10 words
            outFile = "F:/Cloudwick/java_Cloudwick/gutenberg/tf10.csv";
            checkExist = new File(outFile).exists();

            if (checkExist){
                System.out.print("top 10 file exist !");
                return;
            }

            sortedset.addAll(hmap.entrySet());

            // Use iterator to display the keys and associated values
            System.out.println("Map Values Before: ");
            Set keys = hmap.keySet();
            for (Iterator i = keys.iterator(); i.hasNext();) {
                String key = (String) i.next();
                Integer value = (Integer) hmap.get(key);
             //   System.out.println(key + " = " + value);
            }
/*
            writer = new FileWriter(outFile);

            for (sortedset){
                writer.append(key);
                writer.append(",");
                writer.append((hmap.get(key)).toString());
                writer.append("\n");
            }
            writer.flush();
            writer.close();
  */

            System.out.println(sortedset);

        }
        catch(Exception e){
            e.printStackTrace();
        }


    }
}
