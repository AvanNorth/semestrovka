package tat.itis.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;


@Data
@AllArgsConstructor
@Builder
public class OrderForm {
    private Long userId;
    private Long labId;
    private Long cost;
    private Timestamp date;
}
