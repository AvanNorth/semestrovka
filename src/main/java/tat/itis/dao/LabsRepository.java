package tat.itis.dao;

import tat.itis.dao.base.CrudRepository;
import tat.itis.model.Lab;

import java.util.Optional;

public interface LabsRepository extends CrudRepository<Lab,Long> {
    Optional<Lab> findByEmail(String email);
    void updateAvatarForLab(Long labId, Long fileId);
}
