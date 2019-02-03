package pl.sdacademy.register;

import javax.ejb.Singleton;
import javax.inject.Inject;

@Singleton
public class UserService {

    @Inject
    private UserDAO userDAO;
}
