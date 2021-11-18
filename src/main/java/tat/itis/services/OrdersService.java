package tat.itis.services;

import tat.itis.dto.OrderForm;
import tat.itis.model.Order;
import tat.itis.model.OrderS;
import tat.itis.model.Status;

import java.util.List;

public interface OrdersService {
    List<OrderS> getOrdersByLabId(Long labId);
    List<OrderS> getOrdersByUserId(Long userId);

    OrderS getOrderById(Long id);
    OrderS createOrder(OrderForm order);
    OrderS changeOrderStatus(OrderS orderS,Long statusId);

    List<Status> getAllStatuses();

}
