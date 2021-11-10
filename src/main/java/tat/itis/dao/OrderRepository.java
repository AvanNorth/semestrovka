package tat.itis.dao;

import tat.itis.dao.base.CrudRepository;
import tat.itis.model.Order;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order,Long> {
    List<Order> findByUserId(Long userId);
}
