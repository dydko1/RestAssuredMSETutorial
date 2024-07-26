package geeksforgeeks.stringtoken;

public class Join1 {
    public static void main(String[] args) {
        String[] s1 = {"aaa", "cccc", "vvv", "ffff"};

        System.out.println(joinTest(s1));
    }

    private static String joinTest(String[]
                                           s2) {
        String s3 = "";
        for (String ss : s2) {
            s3 +=" : "+ ss;
        }
        return s3;
    }

}
