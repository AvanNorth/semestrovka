package tat.itis.services;

import tat.itis.dto.LabForm;
import tat.itis.dto.UserForm;

public interface SignUpService {
    void signUp(UserForm form);
    void signUp(LabForm form);
}
