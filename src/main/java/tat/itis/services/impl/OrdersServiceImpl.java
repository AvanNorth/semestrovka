package tat.itis.services.impl;

import tat.itis.dao.OrderRepository;
import tat.itis.dto.OrderForm;
import tat.itis.model.Order;
import tat.itis.model.OrderS;
import tat.itis.services.OrdersService;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class OrdersServiceImpl implements OrdersService {

    private final OrderRepository orderRepository;

    public OrdersServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<OrderS> getOrdersByLabId(Long labId) {
        List<Order> orders = orderRepository.findByLabId(labId);

        return stringStatus(orders);
    }

    @Override
    public List<OrderS> getOrdersByUserId(Long userId) {
        List<Order> orders = orderRepository.findByUserId(userId);

        return stringStatus(orders);
    }

    @Override
    public OrderS getOrderById(Long id) {
        Optional<Order> order = orderRepository.findById(id);

        //TODO доделать

        return null;
    }

    @Override
    public OrderS createOrder(OrderForm orderForm) {
        Order order = Order.builder()
                .userId(orderForm.getUserId())
                .labId(orderForm.getLabId())
                .cost(orderForm.getCost())
                .data(orderForm.getDate())
                .build();


        return OrderS.from(orderRepository.save(order));
    }

    @Override
    public OrderS changeOrderStatus(Order order, Long statusId) {
        orderRepository.changeStatus(order.getId(),statusId);

        OrderS orderS = OrderS.from(order);
        orderS.setStatus(orderRepository.getOrderStatus(statusId));

        return orderS;
    }

    private List<OrderS> stringStatus(List<Order> orders) {
        List<OrderS> orderWithStatus = new LinkedList<>();

        for (Order order : orders) {
            OrderS orderS = OrderS.from(order);
            orderS.setStatus(orderRepository.getOrderStatus(order.getStatus()));
            orderWithStatus.add(orderS);
        }
        return orderWithStatus;
    }
}
