package tat.itis.services.impl;

import tat.itis.dao.LabsRepository;
import tat.itis.dao.UsersRepository;
import tat.itis.dto.LabForm;
import tat.itis.dto.UserForm;
import tat.itis.services.validation.ErrorEntity;
import tat.itis.services.validation.Validator;

import java.util.Optional;

public class ValidatorImpl implements Validator {
    private final UsersRepository usersRepository;
    private final LabsRepository labsRepository;

    public ValidatorImpl(UsersRepository usersRepository, LabsRepository labsRepository) {
        this.usersRepository = usersRepository;
        this.labsRepository = labsRepository;
    }

    @Override
    public Optional<ErrorEntity> validateRegistration(UserForm form) {
        if(form.getEmail() == null) {
            return Optional.of(ErrorEntity.INVALID_EMAIL);
        } else if(usersRepository.findByEmail(form.getEmail()).isPresent()) {
            return Optional.of(ErrorEntity.EMAIL_ALREADY_TAKEN);
        }
        return Optional.empty();
    }

    @Override
    public Optional<ErrorEntity> validateRegistration(LabForm form) {
        if(form.getEmail() == null) {
            return Optional.of(ErrorEntity.INVALID_EMAIL);
        } else if(labsRepository.findByEmail(form.getEmail()).isPresent()) {
            return Optional.of(ErrorEntity.EMAIL_ALREADY_TAKEN);
        }
        return Optional.empty();
    }
}