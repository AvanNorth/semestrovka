package tat.itis.services.impl;

import tat.itis.dao.ServicesRepository;
import tat.itis.dao.impl.ServicesRepositoryImpl;
import tat.itis.dto.LabDto;
import tat.itis.dto.ServiceDto;
import tat.itis.dto.ServiceForm;
import tat.itis.exceptions.NotFoundException;
import tat.itis.model.FileInfo;
import tat.itis.model.Service;
import tat.itis.services.ServicesService;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class ServicesServiceImpl implements ServicesService {
    private final ServicesRepository servicesRepository;

    public ServicesServiceImpl(ServicesRepository servicesRepository){
        this.servicesRepository = servicesRepository;
    }

    @Override
    public List<Service> getLabServices(Long id) {
        return servicesRepository.findByLabId(id);
    }

    @Override
    public Service saveLabService(ServiceForm form) {
        Service service = Service.builder()
                .lab_id(form.getLab_id())
                .name(form.getName())
                .price(form.getPrice())
                .description(form.getDescription()).build();
       return servicesRepository.save(service);
    }

    @Override
    public Service saveLabServiceById(ServiceForm form, Long id) {
        Service service = Service.builder()
                .id(id)
                .lab_id(form.getLab_id())
                .name(form.getName())
                .price(form.getPrice())
                .description(form.getDescription()).build();
        return servicesRepository.save(service);
    }

    @Override
    public Service getServiceById(Long id) {
        Optional<Service> optionalService = servicesRepository.findById(id);
        return optionalService.orElseThrow(() -> new NotFoundException("Service not found"));
    }
}
