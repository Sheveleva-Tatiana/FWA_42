package edu.school.cinema.services;

import edu.school.cinema.model.User;
import edu.school.cinema.repositories.UsersRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UsersServiceImpl implements UsersService {

    private PasswordEncoder passwordEncoder;
    private UsersRepositoryImpl usersRepository;

    @Autowired
    public UsersServiceImpl(PasswordEncoder passwordEncoder, UsersRepositoryImpl usersRepository) {
        this.passwordEncoder = passwordEncoder;
        this.usersRepository = usersRepository;
    }

    @Override
    public boolean signIn(String username, String password) {
        Optional<User> opt = usersRepository.findByUsername(username);

        if (opt.isPresent() && passwordEncoder.matches(password, opt.get().getPassword())) {
            return true;
        }
        return false;
    }

    @Override
    public boolean signUp(User user) {
        if (usersRepository.findByUsername(user.getName()).isPresent()) {
            return false;
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        usersRepository.save(user);
        return true;
    }
}
