package tat.itis.services.impl;

import io.jsonwebtoken.*;
import tat.itis.dao.LabsRepository;
import tat.itis.dao.UsersRepository;
import tat.itis.dto.LabDto;
import tat.itis.dto.LabForm;
import tat.itis.dto.UserDto;
import tat.itis.dto.UserForm;
import tat.itis.exceptions.ValidationException;
import tat.itis.model.Lab;
import tat.itis.model.User;
import tat.itis.services.PasswordEncoder;
import tat.itis.services.SignInService;
import tat.itis.services.validation.ErrorEntity;


public class SignInServiceImpl implements SignInService {
    private final UsersRepository usersRepository;
    private final LabsRepository labsRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtBuilder jwtBuilder;
    private final JwtParser jwtParser;
    private final String jwtSecret;

    public SignInServiceImpl(String jwtSecret, UsersRepository usersRepository,LabsRepository labsRepository, PasswordEncoder passwordEncoder) {
        this.jwtSecret = jwtSecret;
        this.usersRepository = usersRepository;
        this.labsRepository = labsRepository;
        this.passwordEncoder = passwordEncoder;
        jwtBuilder = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, jwtSecret);
        jwtParser = Jwts.parser()
                .setSigningKey(jwtSecret);
    }

    @Override
    public UserDto signInUser(UserForm userForm) {
        User user = usersRepository.findByEmail(userForm.getEmail())
                .orElseThrow(() -> new ValidationException(ErrorEntity.NOT_FOUND));
        if (!passwordEncoder.matches(userForm.getPassword(), user.getHashPassword())) {
            throw new ValidationException(ErrorEntity.INCORRECT_PASSWORD);
        }
        UserDto userDto = UserDto.from(user);
        jwtBuilder.claim("email", userForm.getEmail());
        jwtBuilder.claim("password", userForm.getPassword());
        String token = jwtBuilder.compact();
        userDto.setToken(token);
        return userDto;
    }

    @Override
    public LabDto signInLab(LabForm labForm) {
        Lab lab = labsRepository.findByEmail(labForm.getEmail())
                .orElseThrow(() -> new ValidationException(ErrorEntity.NOT_FOUND));
        if (!passwordEncoder.matches(labForm.getPassword(), lab.getHashPassword())) {
            throw new ValidationException(ErrorEntity.INCORRECT_PASSWORD);
        }
        LabDto labDto = LabDto.from(lab);
        jwtBuilder.claim("email", labForm.getEmail());
        jwtBuilder.claim("password", labForm.getPassword());
        String token = jwtBuilder.compact();
        labDto.setToken(token);
        return labDto;
    }

    @Override
    public UserDto signIn(String token) {
       //Claims claims;
       //try {
       //    claims = jwtParser.parseClaimsJws(token).getBody();
       //} catch (SignatureException e) {
       //    throw new ValidationException(ErrorEntity.FORBIDDEN);
       //}
       //String email = (String) claims.get("email");
       //String password = (String) claims.get("password");
       //return signIn(UserForm.builder().email(email).password(password).build());
        return null;
    }
}
