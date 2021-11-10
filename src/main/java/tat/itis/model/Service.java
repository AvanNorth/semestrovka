package tat.itis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Service {
    private Long id;
    private String name;
    private String description;
    private Long avatarId;
}
