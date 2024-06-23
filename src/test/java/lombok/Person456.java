package lombok;

@Data
@AllArgsConstructor
public class Person456 {
    static final String firstname = "asd";
    public Person456.Test123 Test123;

    @Data
    @AllArgsConstructor
    public class Test123 {
        private static final String ssn2 = "fdsfdsf";
    }
}
