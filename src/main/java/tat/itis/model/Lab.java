package tat.itis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Lab {
    private Long id;
    private String name;
    private String phone;
    private String hashPassword;
    private String email;
    private Long avatarId;
}
