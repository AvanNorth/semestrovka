package tat.itis.services.impl;

import tat.itis.services.PasswordEncoder;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;
import java.security.spec.KeySpec;

public class PasswordEncoderImpl implements PasswordEncoder {
    @Override
    public boolean matches(String password, String hashPassword) {
        return password.equals(hashPassword);
    }

    @Override
    public String encode(String password) {
        return password;
    }

    private KeySpec getSpec(String password, byte[] salt){
        return new PBEKeySpec(password.toCharArray(), salt, 6553, 128);
    }
}