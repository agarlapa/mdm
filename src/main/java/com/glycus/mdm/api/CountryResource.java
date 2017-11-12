/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glycus.mdm.api;

import com.glycus.mdm.model.Country;
import com.glycus.mdm.dao.CountryDao;
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
public class CountryResource {

    @Autowired
    private CountryDao dao;

    @GetMapping("/country")
    public List<Country> findAll() {
        List<Country> countryList = dao.findAll();
        return countryList;
    }

    @GetMapping("/country/findByCode")
    public Country findByCode(@RequestHeader HttpHeaders headers) {
        String code = headers.get("code").get(0);
        Country country = dao.findByCode(code);
        return country;
    }

    @PostMapping("/country")
    public ResponseEntity add(Country country) {
        dao.create(country);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/country")
    public ResponseEntity update(Country country) {
        dao.edit(country);
        return ResponseEntity.ok().build();
    }
}
