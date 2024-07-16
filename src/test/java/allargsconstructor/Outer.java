package allargsconstructor;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Outer {
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Middle1 {
        public static final String URL = "www.interia.pl";

        @AllArgsConstructor(access = AccessLevel.PRIVATE)
        public static class Inner1 {
            public static final String INNER_ELE1 = "Element 1 w Middle1->Inner1";
        }

        @AllArgsConstructor(access = AccessLevel.PRIVATE)
        public static class Inner2 {
            public static final String INNER_ELE2 = "Element 2 w Middle1->Inner2";
        }
    }

    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Middle2 {
        public static final String URL = "www.onet.pl";

        @AllArgsConstructor(access = AccessLevel.PRIVATE)
        public static class Inner1 {
            public static final String INNER_ELE1 = "!!!Element 1 w Middle1->Inner1!!!";
        }

        @AllArgsConstructor(access = AccessLevel.PRIVATE)
        public static class Inner3 {
            public static final String INNER_ELE3 = "Element 3 w Middle1->Inner1";
        }

        @AllArgsConstructor(access = AccessLevel.PRIVATE)
        public static class Inner4 {
            public static final String INNER_ELE4 = "Element 4 w Middle1->Inner2";
        }
    }
}
