package tat.itis.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class LabForm {
    private String email;
    private String name;
    private String password;
    private String phone;
}
