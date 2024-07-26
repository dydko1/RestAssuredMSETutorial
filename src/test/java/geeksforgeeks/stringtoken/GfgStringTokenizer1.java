package geeksforgeeks.stringtoken;

import java.util.StringTokenizer;

public class GfgStringTokenizer1 {
    public static void main(String[] args) {
        String mydelim = " : ";
        String mystr = "JAVA : Code : String : Tokenizer : Geeks";

        StringTokenizer geeks = new StringTokenizer(mystr, mydelim);

        int count = geeks.countTokens();
        System.out.println("Number of tokens : " + count);

        while (geeks.hasMoreElements())

            //  Returning the next token
            // using nextElement() method
            System.out.println(geeks.nextElement());
    }
}