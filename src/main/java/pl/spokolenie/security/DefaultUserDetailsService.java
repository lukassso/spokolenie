package pl.spokolenie.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.spokolenie.entities.User;
import pl.spokolenie.repositories.UserRepository;

import java.util.Optional;

@Service
public class DefaultUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOpt = userRepository.findByEmailAdress(username);
        return new DefaultUserDetails(
                userOpt.orElseThrow(() -> new RuntimeException("Nie ma takiego użytkownika")));
    }
}
