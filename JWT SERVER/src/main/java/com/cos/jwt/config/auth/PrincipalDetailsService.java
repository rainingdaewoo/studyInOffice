package com.cos.jwt.config.auth;

import com.cos.jwt.model.Users;
import com.cos.jwt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// http://localhost:8080/login 일 때 요청
@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("PrincipalDetailsService의 loadUserByUsername");
        Users userEntity = userRepository.findByUsername(username);
        System.out.println("++++++++++++++++++++++++++++++++++++");
        System.out.println("userEntity: " + userEntity);
        return new PrincipalDetails(userEntity);
    }
}
