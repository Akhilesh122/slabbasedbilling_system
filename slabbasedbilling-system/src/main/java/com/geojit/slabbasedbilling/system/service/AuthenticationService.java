package com.geojit.slabbasedbilling.system.service;

import com.geojit.slabbasedbilling.system.model.AuthenticationToken;
import com.geojit.slabbasedbilling.system.model.User;
import com.geojit.slabbasedbilling.system.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    private TokenRepository tokenRepository;


    public void saveConfirmationToken(AuthenticationToken authenticationToken) {
        tokenRepository.save(authenticationToken);
    }

    public AuthenticationToken getToken(User user) {
        return tokenRepository.findByUser(user);
    }
}
