package ch.stefanhohl.sh.linklist;

import ch.stefanhohl.sh.linklist.entity.Category;
import ch.stefanhohl.sh.linklist.entity.Link;
import ch.stefanhohl.sh.linklist.entity.LinkList;
import ch.stefanhohl.sh.linklist.entity.User;
import ch.stefanhohl.sh.linklist.entity.manager.DBManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class LinkListApplication {

    public static void main(String[] args) {
        SpringApplication.run(LinkListApplication.class, args);


    }

}
