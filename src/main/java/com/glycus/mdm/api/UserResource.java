/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glycus.mdm.api;

import com.glycus.mdm.model.User;
import com.glycus.mdm.dao.UserDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author agarlapa
 */
@RestController
public class UserResource {

    @Autowired
    private UserDao dao;

    @GetMapping("/user")
    public List<User> findAll() {
        List<User> userList = dao.findAll();
        return userList;
    }

    @GetMapping("/user/findByCode")
    public User findByCode(@RequestHeader HttpHeaders headers) {
        String code = headers.get("code").get(0);
        User user = dao.findByCode(code);
        return user;
    }

    @PostMapping("/user")
    public ResponseEntity add(User user) {
        dao.create(user);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/user")
    public ResponseEntity update(User user) {
        dao.edit(user);
        return ResponseEntity.ok().build();
    }
}
