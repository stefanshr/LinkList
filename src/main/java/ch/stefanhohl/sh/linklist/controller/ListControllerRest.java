package ch.stefanhohl.sh.linklist.controller;


import ch.stefanhohl.sh.linklist.entity.LinkList;
import ch.stefanhohl.sh.linklist.entity.User;
import ch.stefanhohl.sh.linklist.entity.manager.DBManager;
import ch.stefanhohl.sh.linklist.security.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author stefan.hohl
 * @version 06.01.2021
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api")
public class ListControllerRest {

    @Autowired
    private DBManager DBMANAGER;


    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @GetMapping(value = "/hello", produces = "application/json")
    public ResponseEntity<?> sendHello() {
        return new ResponseEntity<>("Hello", HttpStatus.OK);

    }

    @GetMapping(value = "/getUsers", produces = "application/json")
    public ResponseEntity<ArrayList<User>> getUsers(@RequestHeader("Authorization") String token) {
        return new ResponseEntity<ArrayList<User>>(DBMANAGER.getAllUsers(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteUser/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") int userId, @RequestHeader("Authorization") String token) {
        User dbUser = DBMANAGER.findUser(userId);
        if (dbUser != null) {
            DBMANAGER.deleteUser(userId);
            System.out.println("deleted user");
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/getUser/{id}", produces = "application/json")
    public ResponseEntity<?> getUserFromId(@PathVariable(value = "id") int userId, @RequestHeader("Authorization") String token) {
        System.out.println(userId);
        return new ResponseEntity<>(DBMANAGER.findUser(userId), HttpStatus.OK);

    }

    @PutMapping(value = "/createUser")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        if (user != null) {
            DBMANAGER.saveUser(user);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }


}



