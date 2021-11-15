package tat.itis.services;

import tat.itis.dto.LabDto;
import tat.itis.model.Lab;
import java.util.List;

public interface LabsService {
    List<Lab> getLabs();
    LabDto getLabById(Long id);
}
