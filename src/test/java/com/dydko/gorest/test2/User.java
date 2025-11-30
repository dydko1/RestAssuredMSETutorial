package com.dydko.gorest.test2;

import lombok.*;
import lombok.extern.jackson.Jacksonized;

//@Data
@Builder                // daje GoRestUserRequest.builder()...
//@NoArgsConstructor      // potrzebne dla Jacksona
@AllArgsConstructor
@Value
@Jacksonized
//@Getter
public class User {

    private String name;
    private String email;
    private String gender;
    private String status;
}