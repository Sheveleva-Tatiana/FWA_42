package edu.school.cinema.services;

import edu.school.cinema.model.User;

public interface UsersService {
    boolean signIn(String username, String password);
    boolean signUp(User user);
}
