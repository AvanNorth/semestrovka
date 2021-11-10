package tat.itis.services;

import tat.itis.dto.LabDto;
import tat.itis.dto.LabForm;
import tat.itis.dto.UserDto;
import tat.itis.dto.UserForm;

public interface SignInService {
    UserDto signInUser(UserForm userForm);
    LabDto signInLab(LabForm labForm);
    UserDto signIn(String token);
}
