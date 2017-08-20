package com.beleco.gameofwar.redis.service;

import com.beleco.gameofwar.domain.domain.User;
import com.beleco.gameofwar.domain.domain.UserID;
import com.beleco.gameofwar.redis.exception.ValueDoesNotExistsException;

/**
 * Created by Everdark on 19.08.2017.
 */
public interface LoginService {

    boolean userExists(String username);

    boolean userExists(UserID userID);

    UserID getUserIdByUsername(String username) throws ValueDoesNotExistsException;

    User getUserById(UserID userId) throws ValueDoesNotExistsException;

    void saveNewUser(String username, UserID userId);

    void deleteUser(UserID userID) throws ValueDoesNotExistsException;
}
