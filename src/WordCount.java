/**
 * Created by Bhavin on 07/03/2016.
 */
import java.util.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCount {
    public static void main(String [] args) {
        int count = 0;
        String str = null;
        String word = "man";
        String fileName = "F:/Cloudwick/java_Cloudwick/gutenberg/war&peace.txt";
        Pattern p = Pattern.compile("\\b" + word + "\\b", Pattern.CASE_INSENSITIVE);
        try {
            Scanner file = new Scanner(new FileReader(fileName));
            while(file.hasNext()){
                str = (file.next());
                Matcher M = p.matcher(str);
                if (M.find()){
                    count = count+1;
                }
            }
            System.out.print(count);
        }
        catch(FileNotFoundException e){
            System.out.println("File not found !!");
        }

    }
}
