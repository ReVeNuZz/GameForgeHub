package service;

import org.springframework.stereotype.Service;
import model.User;

@Service
public class AuthService {

    private User currentUser;

    public boolean login(String username, String password) {

        if(username.equals("admin") && password.equals("1234")) {
            currentUser = new User(username, password);
            return true;
        }

        return false;
    }

    public String logout() {
        currentUser = null;
        return "User logged out";
    }

}