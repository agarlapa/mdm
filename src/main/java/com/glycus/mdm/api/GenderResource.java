/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glycus.mdm.api;

import com.glycus.mdm.model.Gender;
import com.glycus.mdm.dao.GenderDao;
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
public class GenderResource {
    
    @Autowired
    private GenderDao dao;

    @GetMapping("/gender")
    public List<Gender> findAll() {
        List<Gender> listOfGenders = dao.findAll();
        return listOfGenders;
    }

    @GetMapping("/gender/findByName")
    public Gender findByCode(@RequestHeader HttpHeaders headers) {
        String name = headers.get("name").get(0);
        Gender gender = dao.findByName(name);
        return gender;
    }

    @PostMapping("/gender")
    public ResponseEntity add(Gender gender) {
        dao.create(gender);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/gender")
    public ResponseEntity update(Gender gender) {
        dao.edit(gender);
        return ResponseEntity.ok().build();
    }
}
