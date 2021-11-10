package tat.itis.services.validation;


import tat.itis.dto.LabForm;
import tat.itis.dto.UserForm;

import java.util.Optional;

public interface Validator {
    Optional<ErrorEntity> validateRegistration(UserForm form);
    Optional<ErrorEntity> validateRegistration(LabForm form);
}
