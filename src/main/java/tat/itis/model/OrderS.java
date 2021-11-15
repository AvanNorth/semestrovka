package tat.itis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import tat.itis.dto.OrderDto;

import java.sql.Timestamp;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class OrderS {
    private Long id;
    private Long userId;
    private Long labId;
    private Long cost;
    private String status;
    private Timestamp date;

    public static OrderS from(Order order){
        return OrderS.builder()
                .id(order.getId())
                .userId(order.getUserId())
                .labId(order.getLabId())
                .cost(order.getCost())
                .date(order.getData()).build();
    }
}
