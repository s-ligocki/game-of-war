package com.beleco.gameofwar.redis.service;

import com.beleco.gameofwar.domain.domain.User;
import com.beleco.gameofwar.domain.domain.UserID;
import com.beleco.gameofwar.redis.exception.ValueDoesNotExistsException;
import com.beleco.gameofwar.redis.resource.RedisResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Everdark on 20.08.2017.
 */
@Component
public class SimpleLoginService implements LoginService {

    @Autowired
    RedisResource redisResource;

    private final String USERNAME_PREFIX = "USERNAME:";
    private final String USER_ID_PREFIX = "USER_ID:";

    @Override
    public boolean userExists(String username) {
        return redisResource.exists(USERNAME_PREFIX + username);
    }

    @Override
    public boolean userExists(UserID userID) {
        return redisResource.exists(USER_ID_PREFIX + userID.getUserID());
    }

    @Override
    public UserID getUserIdByUsername(String username) throws ValueDoesNotExistsException {
        String userID = redisResource.get(USERNAME_PREFIX + username);
        return encapsulateUserID(userID);
    }

    @Override
    public User getUserById(UserID userId) throws ValueDoesNotExistsException{
        String username = redisResource.get(USER_ID_PREFIX + userId.getUserID());
        return encapsulateUser(userId, username);
    }

    @Override
    public void saveNewUser(String username, UserID userId) {
        redisResource.put(USER_ID_PREFIX + userId.getUserID(), username);
        redisResource.put(USERNAME_PREFIX + username, userId.getUserID());
    }

    @Override
    public void deleteUser(UserID userId) throws ValueDoesNotExistsException{
        if(userExists(userId)){
            String username = getUserById(userId).getUsername();
            redisResource.delete(USER_ID_PREFIX + userId.getUserID());
            redisResource.delete(USERNAME_PREFIX + username);
        }
    }

    private UserID encapsulateUserID(String userID){
        return new UserID(userID);
    }

    private User encapsulateUser(UserID userID, String username){
        User user = new User(userID, username);
        return user;
    }
}
