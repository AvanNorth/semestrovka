package tat.itis.services.impl;

import tat.itis.dao.OrderRepository;
import tat.itis.dto.OrderForm;
import tat.itis.model.Order;
import tat.itis.model.OrderS;
import tat.itis.model.Status;
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

        if (order.isPresent()) {
            Order order1 = order.get();
            OrderS orderS = OrderS.from(order1);
            orderS.setStatus(orderRepository.getOrderStatus(order1.getStatus()));
            return orderS;
        } else
            return null;
    }

    @Override
    public OrderS createOrder(OrderForm orderForm) {
        Long statusId = Long.parseLong("1");
        Order order = Order.builder()
                .userId(orderForm.getUserId())
                .labId(orderForm.getLabId())
                .cost(orderForm.getCost())
                .data(orderForm.getDate())
                .userAddress(orderForm.getUserAddress())
                .serviceId(orderForm.getServiceId())
                .build();

        OrderS orderS = OrderS.from(orderRepository.save(order));

        orderS.setStatus(orderRepository.getOrderStatus(statusId));
        return orderS;
    }

    @Override
    public OrderS changeOrderStatus(OrderS orderS, Long statusId) {
        orderRepository.changeStatus(orderS.getId(), statusId);

        orderS.setStatus(orderRepository.getOrderStatus(statusId));

        return orderS;
    }

    @Override
    public List<Status> getAllStatuses() {
        return orderRepository.getAllStatuses();
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
