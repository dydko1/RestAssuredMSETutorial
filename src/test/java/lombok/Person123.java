package lombok;

@AllArgsConstructor
public class Person123 {

    private String firstname;
    private String lastname;
    private final String ssn;  // Our non initialized 'final' field

    // toString() here

}