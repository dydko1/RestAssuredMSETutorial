package lombok;

@Data
@AllArgsConstructor
public class Person456 {
    static final String firstname = "asd";

    @Data
    @AllArgsConstructor
    public static class Test123 {
        private static final String ssn2 = "fdsfdsf";
    }
}
