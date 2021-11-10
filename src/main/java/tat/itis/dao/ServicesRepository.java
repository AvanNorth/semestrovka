package tat.itis.dao;

import tat.itis.dao.base.CrudRepository;
import tat.itis.model.Service;

import java.util.List;

public interface ServicesRepository extends CrudRepository<Service,Long> {
    void updateAvatarForService(Long serviceId, Long fileId);
    List<Service> findByLabId(Long labId);
}
