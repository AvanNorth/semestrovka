package tat.itis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Order {
    private Long id;
    private Long userId;
    private Long labId;
    private Long cost;
    private Timestamp data;
}
