package org.samiuelnegash.modernprocure.security;

import org.samiuelnegash.modernprocure.entities.WebUser;
import org.samiuelnegash.modernprocure.repository.WebUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Transactional(readOnly = true)
public class UserAuthenticationService implements UserDetailsService {

    @Autowired
    private WebUserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmailIgnoreCaseAndStatus(username, WebUser.STATUS_ACTIVE)
                .map(webUser -> {
                    if (webUser.isActive()) {
                        return new AuthUserInfo(webUser, Collections.emptyList(), true);
                    } else {
                        throw new UsernameNotFoundException("User with username: " + username + " is inactive. Please contact administrator.");
                    }

                })
                .orElseThrow(() -> new UsernameNotFoundException("No user present with username: " + username));
    }
}
