package ch.stefanhohl.sh.linklist.entity.manager;


import ch.stefanhohl.sh.linklist.entity.Link;
import ch.stefanhohl.sh.linklist.entity.User;
import ch.stefanhohl.sh.linklist.entity.manager.repository.LinkRepository;
import ch.stefanhohl.sh.linklist.entity.manager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

/**
 * @author Stefan Hohl
 * @version 14.11.2020
 */

@Service
public class DBManager {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LinkRepository linkRepository;

    /**
     * searches a user object in the DB
     *
     * @param u is an object of the class User
     * @return a User object or null based on the data in the DB
     */
    public User findUser(User u) {
        Optional opt = userRepository.findById(u.getId());
        return opt.isPresent() ? (User) opt.get() : null;
    }

    /**
     * searches a user object in the DB with the id
     *
     * @param id is the id of a user object
     * @return a user object or null based on the data in the DB
     */
    public User findUser(int id) {
        Optional opt = userRepository.findById(id);
        return opt.isPresent() ? (User) opt.get() : null;
    }

    /**
     * searches a user object in the DB with the username
     *
     * @param username is the username of a user object
     * @return a user object or null based on the data in the DB
     */
    public User findUser(String username) {
        Optional opt = userRepository.findByUsername(username);
        return opt.isPresent() ? (User) opt.get() : null;
    }

    /**
     * searches all the users in the DB
     *
     * @return an ArrayList of User objects user object
     */
    public ArrayList<User> getAllUsers() {
        ArrayList<User> users = new ArrayList<>();
        for (User u : userRepository.findAll()) {
            users.add(u);
        }
        return users;
    }

    public ArrayList<Link> getAllLinks(int id) {
        ArrayList<Link> links = new ArrayList<>();
     return null;
    }

    /**
     * saves or updates a user object in the db
     *
     * @param u is an object of the class user which will be stores
     */
    public void saveUser(User u) {
        userRepository.save(u);
    }

    /**
     * deletes a user object in the db
     *
     * @param u is an object of the class User which will be deleted (with all children)
     */
    public void deleteUser(User u) {
        userRepository.delete(u);
    }

    /**
     * deletes a user object in the db
     *
     * @param id is an id of a user object which will be deleted (with all children)
     */
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

}

