package ch.stefanhohl.sh.linklist.controller;


import ch.stefanhohl.sh.linklist.entity.manager.DBManager;
import ch.stefanhohl.sh.linklist.security.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


}



