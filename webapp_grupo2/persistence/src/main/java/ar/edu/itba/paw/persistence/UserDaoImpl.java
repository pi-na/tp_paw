package ar.edu.itba.paw.persistence;

import ar.edu.itba.paw.models.User;
import org.springframework.stereotype.Repository;

@Repository // extiende de component, para que lo agarre el context y desp se use en webconfig
public class UserDaoImpl implements UserDao {
    @Override
    public User create(String email, String password) {
        return new User(email, password);
    }
}
