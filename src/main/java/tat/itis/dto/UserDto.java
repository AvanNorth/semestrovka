package tat.itis.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import tat.itis.model.User;

@Data
@AllArgsConstructor
@Builder
public class UserDto {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private Long avatarId;
    private String token;

    public static UserDto from(User user) {
        return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .phone(user.getPhone())
                .avatarId(user.getAvatarId())
                .build();
    }
}
