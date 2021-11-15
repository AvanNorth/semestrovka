package tat.itis.dao.impl;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import tat.itis.dao.ServicesRepository;
import tat.itis.model.Lab;
import tat.itis.model.Service;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Types;
import java.util.List;
import java.util.Optional;

public class ServicesRepositoryImpl implements ServicesRepository {
    private final static String SQL_INSERT = "insert into services(lab_id, name, description, price, avatar_id) " +
            "values (?, ?, ?, ?, ?)";
    private final static String SQL_UPDATE = "update services set lab_id = ?, name = ?, description = ?, price = ?, avatar_id = ? where id = ?";
    private final static String SQL_UPDATE_AVATAR = "update services set avatar_id = ? where id = ?";
    private final static String SQL_SELECT_BY_LAB_ID = "select * from services where lab_id = ?";
    private final static String SQL_SELECT_BY_ID = "select * from services where id = ?";
    private final static String SQL_SELECT_ALL = "select * from services";

    private final RowMapper<Service> rowMapper = (row, rowNumber) ->
            Service.builder()
                    .id(row.getLong("id"))
                    .name(row.getString("name"))
                    .description(row.getString("description"))
                    .avatarId(row.getLong("avatar_id") == 0 ? null : row.getLong("avatar_id"))
                    .price(row.getLong("price"))
                    .build();

    private final JdbcTemplate jdbcTemplate;

    public ServicesRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public void updateAvatarForService(Long serviceId, Long fileId) {
        jdbcTemplate.update(SQL_UPDATE_AVATAR,
                fileId, serviceId
        );
    }

    @Override
    public List<Service> findByLabId(Long labId) {
        return jdbcTemplate.query(SQL_SELECT_BY_LAB_ID, rowMapper,labId);
    }

    @Override
    public Optional<Service> findById(Long id) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, rowMapper, id));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Service> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL, rowMapper);
    }

    @Override
    public Service save(Service item) {
        if(item.getId() == null) {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement statement = connection.prepareStatement(SQL_INSERT, new String[]{"id"});
                statement.setLong(1, item.getLab_id());
                statement.setString(2, item.getName());
                statement.setString(3, item.getDescription());
                statement.setLong(4,item.getPrice());
                if(item.getAvatarId() != null) {
                    statement.setLong(5, item.getAvatarId());
                } else {
                    statement.setNull(5, Types.NULL);
                }
                return statement;
            }, keyHolder);
            if (keyHolder.getKey() != null) {
                item.setId(keyHolder.getKey().longValue());
            }
        } else {
            jdbcTemplate.update(SQL_UPDATE,
                    item.getLab_id(),
                    item.getName(),
                    item.getDescription(),
                    item.getPrice(),
                    item.getAvatarId(),
                    item.getId()
            );
        }
        return item;
    }

    @Override
    public void delete(Long id) {

    }
}
