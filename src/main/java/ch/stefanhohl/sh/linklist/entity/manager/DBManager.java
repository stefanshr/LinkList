package ch.stefanhohl.sh.linklist.entity.manager;


import ch.stefanhohl.sh.linklist.entity.Category;
import ch.stefanhohl.sh.linklist.entity.Link;
import ch.stefanhohl.sh.linklist.entity.LinkList;
import ch.stefanhohl.sh.linklist.entity.User;
import ch.stefanhohl.sh.linklist.entity.manager.repository.CategoryRepository;
import ch.stefanhohl.sh.linklist.entity.manager.repository.LinkListRepository;
import ch.stefanhohl.sh.linklist.entity.manager.repository.LinkRepository;
import ch.stefanhohl.sh.linklist.entity.manager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Locale;
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

    @Autowired
    private LinkListRepository linkListRepository;

    @Autowired
    private CategoryRepository categoryRepository;

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

    public ArrayList<Link> getAllLinks() {
        ArrayList<Link> links = new ArrayList<>();
        for (Link l : linkRepository.findAll()) {
            links.add(l);
        }
        return links;
    }

    public ArrayList<LinkList> getAllLinkLists() {
        ArrayList<LinkList> linkLists = new ArrayList<>();
        for (LinkList l : linkListRepository.findAll()) {
            linkLists.add(l);
        }
        return linkLists;
    }

    public Link findLink(int id) {
        Optional opt = linkRepository.findById(id);
        return opt.isPresent() ? (Link) opt.get() : null;
    }

    public ArrayList<Category> getAllCategorys() {
        ArrayList<Category> categories = new ArrayList<>();
        for (Category c : categoryRepository.findAll()) {
            categories.add(c);
        }
        return categories;
    }

    public void saveLink(Link l) {
        linkRepository.save(l);
    }

    public void saveCategory(Category c) {
        categoryRepository.save(c);
    }

    public void saveLinkList(LinkList l) {
        linkListRepository.save(l);
    }

    public Category findCategoryByName(String name) {
        for (Category c : categoryRepository.findAll()) {
            if (c.getTitle().toLowerCase().equals(name.toLowerCase())) {
                return c;
            }
        }
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

