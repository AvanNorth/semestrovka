package tat.itis.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ServiceForm {
    private Long lab_id;
    private String name;
    private String description;
    private Long price;
}