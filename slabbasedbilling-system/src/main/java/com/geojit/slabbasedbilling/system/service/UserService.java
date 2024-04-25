package com.geojit.slabbasedbilling.system.service;

import com.geojit.slabbasedbilling.system.dto.ResponseDto;
import com.geojit.slabbasedbilling.system.dto.SignInDto;
import com.geojit.slabbasedbilling.system.dto.SignInResponseDto;
import com.geojit.slabbasedbilling.system.dto.SignUpDto;
import com.geojit.slabbasedbilling.system.exception.AuthenticationFailsExceptions;
import com.geojit.slabbasedbilling.system.exception.CustomException;
import com.geojit.slabbasedbilling.system.model.AuthenticationToken;
import com.geojit.slabbasedbilling.system.model.User;
import com.geojit.slabbasedbilling.system.repository.UserRepository;
import jakarta.transaction.Transactional;
import jakarta.xml.bind.DatatypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationService authenticationService;

    @Transactional
    public ResponseDto signUp(SignUpDto signUpDto) {
        if (Objects.nonNull(userRepository.findByEmail(signUpDto.getEmail()))) {
            throw new CustomException("user already present");
        }
        String encryptedPassword = signUpDto.getPassword();
        try {
            encryptedPassword = hashPassword(signUpDto.getPassword());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            //throw new CustomException(e.getMessage());
        }
        User user = new User(signUpDto.getFirstName(),
                signUpDto.getLastName(),
                signUpDto.getEmail(),
                encryptedPassword);

        userRepository.save(user);

        final AuthenticationToken authenticationToken = new AuthenticationToken(user);
        authenticationService.saveConfirmationToken(authenticationToken);


        ResponseDto responseDto = new ResponseDto("success", "User Created Sucessfully");
        return responseDto;
    }

    private String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        String hash = DatatypeConverter.printHexBinary(digest).toUpperCase();
        return hash;
    }

    public SignInResponseDto signIn(SignInDto signInDto) {

        User user = userRepository.findByEmail(signInDto.getEmail());
        try {
            String userPassword = user.getPassword();
            if (userPassword == null || !userPassword.equals(hashPassword(signInDto.getPassword()))) {
                throw new AuthenticationFailsExceptions("Wrong Password");
            }
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        AuthenticationToken token = authenticationService.getToken(user);

        if (Objects.isNull(token)) {
            throw new CustomException("Token is not present ");
        }
        return new SignInResponseDto("Success", token.getToken());
    }
}
