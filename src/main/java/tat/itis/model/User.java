package tat.itis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private Long phone;
    private String hashPassword;
    private String email;
    private Long avatarId;
}
