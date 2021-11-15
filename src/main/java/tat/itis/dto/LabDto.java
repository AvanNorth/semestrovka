package tat.itis.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import tat.itis.model.Lab;
import tat.itis.model.User;

@Data
@AllArgsConstructor
@Builder
public class LabDto {
    private Long id;
    private String email;
    private String name;
    private String phone;
    private Long avatarId;
    private String token;

    public static LabDto from(Lab lab) {
        return LabDto.builder()
                .id(lab.getId())
                .email(lab.getEmail())
                .name(lab.getName())
                .phone(lab.getPhone())
                .avatarId(lab.getAvatarId())
                .build();
    }
}
