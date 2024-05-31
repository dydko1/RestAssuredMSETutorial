package udemyapitestingrestassured;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PostModelData {
    private String first_name;
    private String middle_name;
    private String last_name;
    private String date_of_birth;
}
