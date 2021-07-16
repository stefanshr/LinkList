package ch.stefanhohl.sh.linklist;

import ch.stefanhohl.sh.linklist.entity.Category;
import ch.stefanhohl.sh.linklist.entity.Link;
import ch.stefanhohl.sh.linklist.entity.LinkList;
import ch.stefanhohl.sh.linklist.entity.User;
import ch.stefanhohl.sh.linklist.entity.manager.DBManager;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class MyRunner implements CommandLineRunner {
    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Autowired
    private DBManager DBMANAGER;


    @Override
    public void run(String... args) throws Exception {
        DBMANAGER.saveUser(new User("Stefan", bcryptEncoder.encode("Password")));
        DBMANAGER.saveUser(new User("Simon", bcryptEncoder.encode("Password")));
        DBMANAGER.saveUser(new User("Patrick", bcryptEncoder.encode("Password")));
        DBMANAGER.saveUser(new User("Ismail", bcryptEncoder.encode("Password")));

        DBMANAGER.saveCategory(new Category("Social Media"));
        DBMANAGER.saveCategory(new Category("Banking"));

        DBMANAGER.saveLink(new Link("https://instagram.com", DBMANAGER.findCategoryByName("Social Media")));
        DBMANAGER.saveLink(new Link("https://facebook.com", DBMANAGER.findCategoryByName("Social Media")));
        DBMANAGER.saveLink(new Link("https://snapchat.com", DBMANAGER.findCategoryByName("Social Media")));
        DBMANAGER.saveLink(new Link("https://whatsapp.com", DBMANAGER.findCategoryByName("Social Media")));
        DBMANAGER.saveLink(new Link("https://UBS.ch", DBMANAGER.findCategoryByName("Banking")));
        DBMANAGER.saveLink(new Link("https://ZKB.ch", DBMANAGER.findCategoryByName("Banking")));

        DBMANAGER.saveLinkList(new LinkList(DBMANAGER.findLink(1), DBMANAGER.findUser(1)));
        DBMANAGER.saveLinkList(new LinkList(DBMANAGER.findLink(1), DBMANAGER.findUser(2)));
        DBMANAGER.saveLinkList(new LinkList(DBMANAGER.findLink(1), DBMANAGER.findUser(3)));
        DBMANAGER.saveLinkList(new LinkList(DBMANAGER.findLink(1), DBMANAGER.findUser(4)));
        DBMANAGER.saveLinkList(new LinkList(DBMANAGER.findLink(2), DBMANAGER.findUser(2)));
        DBMANAGER.saveLinkList(new LinkList(DBMANAGER.findLink(5), DBMANAGER.findUser(1)));
        DBMANAGER.saveLinkList(new LinkList(DBMANAGER.findLink(3), DBMANAGER.findUser(3)));
        DBMANAGER.saveLinkList(new LinkList(DBMANAGER.findLink(2), DBMANAGER.findUser(3)));
        System.out.println("Successfully filled DB");
    }
}
