package tat.itis.dao.impl;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import tat.itis.dao.OrderRepository;
import tat.itis.dto.OrderDto;
import tat.itis.model.Lab;
import tat.itis.model.Order;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Types;
import java.util.List;
import java.util.Optional;

public class OrderRepositoryImpl implements OrderRepository {

    private final static String SQL_INSERT = "insert into orders(user_id, lab_id, cost, status, date) " +
            "values (?, ?, ?, ?,?)";
    private final static String SQL_UPDATE_STATUS = "update orders set status = ? where id = ?";
    private final static String SQL_SELECT_BY_USER_ID = "select * from orders where user_id = ?";
    private final static String SQL_SELECT_BY_LAB_ID = "select * from orders where lab_id = ?";
    private final static String SQL_SELECT_BY_ID = "select * from orders where id = ?";
    private final static String SQL_SELECT_ALL = "select * from orders";
    private final static String SQL_SELECT_STATUS = "select name from statuses where id = ?";

    private final RowMapper<Order> rowMapper = (row, rowNumber) ->
            Order.builder()
                    .id(row.getLong("id"))
                    .userId(row.getLong("user_id"))
                    .labId(row.getLong("lab_id"))
                    .cost(row.getLong("cost"))
                    .status(row.getLong("status"))
                    .data(row.getTimestamp("date"))
                    .build();


    private final RowMapper<String> rowMapperStatus = (row, rowNumber) ->
            row.getString("name");


    private final JdbcTemplate jdbcTemplate;

    public OrderRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public List<Order> findByUserId(Long userId) {
        return jdbcTemplate.query(SQL_SELECT_BY_USER_ID, rowMapper, userId);
    }

    @Override
    public List<Order> findByLabId(Long labId) {
        return jdbcTemplate.query(SQL_SELECT_BY_LAB_ID, rowMapper, labId);
    }

    @Override
    public void changeStatus(Long orderId, Long statusId) {
        jdbcTemplate.update(SQL_UPDATE_STATUS, orderId, statusId);
    }

    @Override
    public String getOrderStatus(Long statusId) {
        return jdbcTemplate.query(SQL_SELECT_STATUS,rowMapperStatus,statusId).get(0);
    }

    @Override
    public Optional<Order> findById(Long id) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, rowMapper, id));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Order> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL, rowMapper);
    }

    @Override
    public Order save(Order item) {
        if(item.getId() == null) {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement statement = connection.prepareStatement(SQL_INSERT, new String[]{"id"});
                statement.setLong(1, item.getUserId());
                statement.setLong(2, item.getLabId());
                statement.setLong(3, item.getCost());
                statement.setLong(4, item.getStatus());
                statement.setTimestamp(5,item.getData());
                return statement;
            }, keyHolder);
            if (keyHolder.getKey() != null) {
                item.setId(keyHolder.getKey().longValue());
            }
        }
        return item;
    }

    @Override
    public void delete(Long id) {

    }
}
