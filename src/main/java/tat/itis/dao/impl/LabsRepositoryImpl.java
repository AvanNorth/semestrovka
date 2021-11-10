package tat.itis.dao.impl;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import tat.itis.dao.LabsRepository;
import tat.itis.dao.UsersRepository;
import tat.itis.model.Lab;
import tat.itis.model.User;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Types;
import java.util.List;
import java.util.Optional;

public class LabsRepositoryImpl implements LabsRepository {

    private final static String SQL_INSERT = "insert into labs(name, phone, password_hash, email, avatar_id) " +
            "values (?, ?, ?, ?, ?)";
    private final static String SQL_UPDATE = "update labs set name = ?, phone = ?, password_hash = ?, email = ?, avatar_id = ? where id = ?";
    private final static String SQL_UPDATE_AVATAR = "update labs set avatar_id = ? where id = ?";
    private final static String SQL_SELECT_BY_ID = "select * from labs where id = ?";
    private final static String SQL_SELECT_BY_EMAIL = "select * from labs where email = ?";
    private final static String SQL_SELECT_ALL = "select * from labs";

    private final RowMapper<Lab> rowMapper = (row, rowNumber) ->
            Lab.builder()
                    .id(row.getLong("id"))
                    .name(row.getString("name"))
                    .phone(row.getLong("phone"))
                    .hashPassword(row.getString("password_hash"))
                    .email(row.getString("email"))
                    .avatarId(row.getLong("avatar_id") == 0 ? null : row.getLong("avatar_id"))
                    .build();

    private final JdbcTemplate jdbcTemplate;

    public LabsRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Optional<Lab> findByEmail(String email) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(SQL_SELECT_BY_EMAIL,rowMapper,email));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public void updateAvatarForLab(Long userId, Long fileId) {
        jdbcTemplate.update(SQL_UPDATE_AVATAR,
                fileId, userId
        );
    }

    @Override
    public Optional<Lab> findById(Long id) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, rowMapper, id));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Lab> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL, rowMapper);
    }

    @Override
    public Lab save(Lab item) {
        if(item.getId() == null) {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement statement = connection.prepareStatement(SQL_INSERT, new String[]{"id"});
                statement.setString(1, item.getName());
                statement.setLong(2, item.getPhone());
                statement.setString(3, item.getHashPassword());
                statement.setString(4, item.getEmail());
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
                    item.getName(),
                    item.getPhone(),
                    item.getHashPassword(),
                    item.getEmail(),
                    item.getAvatarId(),
                    item.getId()
            );
        }
        return item;
    }

    // TODO: Implement
    @Override
    public void delete(Long id) {}
}