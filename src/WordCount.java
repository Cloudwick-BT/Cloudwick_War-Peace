/**
 * Created by Bhavin on 07/03/2016.
 */
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCount {
    public static void main(String [] args) {
        int count = 0;
        String word = "the";
        String fileName = "F:/Cloudwick/java_Cloudwick/gutenberg/war&peace.txt";
        FileReader file = null;
        BufferedReader br = null;
        String currentLine = null;
        String[] arrayList = null;

        Pattern p = Pattern.compile("\\b" + word + "\\b", Pattern.CASE_INSENSITIVE);

        try {
            file = new FileReader(fileName);
            br = new BufferedReader(file);

            while ((currentLine = br.readLine()) != null) {
                arrayList = currentLine.split("[^a-zA-Z]");
                for(String str : arrayList){
                    Matcher M = p.matcher(str);
                    if (M.find()){
                        count++;
                    }
                }
            }
            System.out.print("Total Count is : ");
            System.out.print(count);
        }
        catch(Exception e){
            System.out.println("File not found !!");
        }

    }
}
