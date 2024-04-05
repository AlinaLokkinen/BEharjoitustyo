package hh.sof3.recipebook.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import hh.sof3.recipebook.domain.User;
import hh.sof3.recipebook.domain.UserRepository;


@Service
public class UserDetailServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public UserDetailServiceImpl(UserRepository uRepository) {
        this.userRepository = uRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User currentUser =  userRepository.findByUsername(username);

        UserDetails user = new org.springframework.security.core.userdetails.User(username,
        currentUser.getPasswordHash(),
            AuthorityUtils.createAuthorityList(currentUser.getRole()));

    return user;
    }
}

