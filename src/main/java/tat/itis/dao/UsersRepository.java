package tat.itis.dao;

import tat.itis.dao.base.CrudRepository;
import tat.itis.model.User;

import java.util.Optional;

public interface UsersRepository extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String email);
    void updateAvatarForUser(Long userId, Long fileId);
}
