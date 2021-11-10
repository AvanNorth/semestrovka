package tat.itis.services.impl;

import tat.itis.dao.LabsRepository;
import tat.itis.dao.UsersRepository;
import tat.itis.dto.LabForm;
import tat.itis.dto.UserForm;
import tat.itis.exceptions.ValidationException;
import tat.itis.model.Lab;
import tat.itis.model.User;
import tat.itis.services.PasswordEncoder;
import tat.itis.services.SignUpService;
import tat.itis.services.validation.ErrorEntity;
import tat.itis.services.validation.Validator;

import java.util.Optional;

public class SignUpServiceImpl implements SignUpService {
    private final UsersRepository usersRepository;
    private final LabsRepository labsRepository;
    private final PasswordEncoder passwordEncoder;
    private final Validator validator;

    public SignUpServiceImpl(UsersRepository usersRepository, LabsRepository labsRepository, PasswordEncoder passwordEncoder, Validator validator) {
        this.usersRepository = usersRepository;
        this.labsRepository = labsRepository;
        this.passwordEncoder = passwordEncoder;
        this.validator = validator;
    }

    @Override
    public void signUp(UserForm form) {
        // passwordEncoder.matches("123123", "HASH");
        Optional<ErrorEntity> optionalError = validator.validateRegistration(form);
        if(optionalError.isPresent()) {
            throw new ValidationException(optionalError.get());
        }
        User user = User.builder()
                .email(form.getEmail())
                .firstName(form.getFirstName())
                .lastName(form.getLastName())
                .phone(form.getPhone())
                .hashPassword(passwordEncoder.encode(form.getPassword()))
                .build();
        usersRepository.save(user);
    }

    @Override
    public void signUp(LabForm form) {
        Optional<ErrorEntity> optionalError = validator.validateRegistration(form);
        if(optionalError.isPresent()) {
            throw new ValidationException(optionalError.get());
        }
        Lab lab = Lab.builder()
                .email(form.getEmail())
                .name(form.getName())
                .phone(form.getPhone())
                .hashPassword(passwordEncoder.encode(form.getPassword()))
                .build();
        labsRepository.save(lab);
    }
}