package tat.itis.dto;

import lombok.*;
import tat.itis.model.Order;

import java.sql.Timestamp;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Long id;
    private Long userId;
    private Long labId;
    private Long cost;
    private Long status;
    private Long serviceId;
    private String userAddress;
    private Timestamp date;

    public static OrderDto from(Order order){
        return OrderDto.builder()
                .id(order.getId())
                .userId(order.getUserId())
                .labId(order.getLabId())
                .cost(order.getCost())
                .status(order.getStatus())
                .serviceId(order.getServiceId())
                .userAddress(order.getUserAddress())
                .date(order.getData()).build();
    }

}
