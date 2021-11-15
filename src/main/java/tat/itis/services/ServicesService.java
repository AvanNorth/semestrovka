package tat.itis.services;

import tat.itis.dto.*;
import tat.itis.model.Service;

import java.util.List;

public interface ServicesService {
    List<Service> getLabServices(Long id);
    Service saveLabService(ServiceForm serviceForm);
    Service saveLabServiceById(ServiceForm serviceForm, Long id);
    Service getServiceById(Long id);
}
