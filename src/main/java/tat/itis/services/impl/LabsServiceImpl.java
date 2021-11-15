package tat.itis.services.impl;


import tat.itis.dao.LabsRepository;
import tat.itis.dao.impl.LabsRepositoryImpl;
import tat.itis.dto.LabDto;
import tat.itis.exceptions.NotFoundException;
import tat.itis.model.Lab;
import tat.itis.model.Service;
import tat.itis.services.LabsService;

import java.util.List;
import java.util.Optional;

public class LabsServiceImpl implements LabsService {
    private final LabsRepository labsRepository;

    public LabsServiceImpl(LabsRepository labsRepository) {
        this.labsRepository = labsRepository;
    }

    @Override
    public List<Lab> getLabs() {
        return labsRepository.findAll();
    }

    @Override
    public LabDto getLabById(Long id) {
        Optional<Lab> labOptional = labsRepository.findById(id);
        Lab lab = labOptional.orElseThrow(() -> new NotFoundException("Lab not found"));
        return LabDto.from(lab);
    }
}
