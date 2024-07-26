package geeksforgeeks.stringtoken;

import java.util.StringTokenizer;

public class GfgStringTokenizer {

    public static void main(String[] args) {
        String myDelim = " : ";
        String myStr = "JAVA : Code : String : Tokenizer : Geeks";

        StringTokenizer geek3 = new StringTokenizer(myStr, myDelim);

        int count = geek3.countTokens();
        System.out.println("Numbers of tokens: " + count);

        for (int i = 0; i < count; i++) {
            System.out.println("Token at: [" + i + "] : "
                    +geek3.nextToken());
        }

        while (geek3.hasMoreTokens())
            System.out.println(geek3.nextToken());
    }
}
