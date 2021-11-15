package tat.itis.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import tat.itis.model.Lab;
import tat.itis.model.Service;

@Data
@AllArgsConstructor
@Builder
public class ServiceDto {
    private Long id;
    private Long lab_id;
    private String name;
    private String description;
    private Long avatarId;
    private Long price;

    public static ServiceDto from(Service service) {
        return ServiceDto.builder()
                .id(service.getId())
                .lab_id(service.getLab_id())
                .name(service.getName())
                .description(service.getDescription())
                .avatarId(service.getAvatarId())
                .price(service.getPrice())
                .build();
    }
}