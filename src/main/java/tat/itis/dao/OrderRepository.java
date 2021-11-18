package tat.itis.dao;

import tat.itis.dao.base.CrudRepository;
import tat.itis.dto.OrderDto;
import tat.itis.dto.OrderForm;
import tat.itis.model.Order;
import tat.itis.model.Status;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order,Long> {
    List<Order> findByUserId(Long userId);
    List<Order> findByLabId(Long labId);

    void changeStatus(Long orderId, Long statusId);
    String getOrderStatus(Long statusId);

    List<Status> getAllStatuses();
}
