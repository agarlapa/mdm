/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glycus.mdm.api;

import com.glycus.mdm.model.UOM;
import com.glycus.mdm.dao.UOMDao;
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
public class UOMResource {
     @Autowired
    private UOMDao dao;

    @GetMapping("/uom")
    public List<UOM> findAll() {
        List<UOM> uomList = dao.findAll();
        return uomList;
    }

    @GetMapping("/uom/findByCode")
    public UOM findByCode(@RequestHeader HttpHeaders headers) {
        String code = headers.get("code").get(0);
        UOM uom = dao.findByCode(code);
        return uom;
    }

    @PostMapping("/uom")
    public ResponseEntity add(UOM uom) {
        dao.create(uom);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/uom")
    public ResponseEntity update(UOM uom) {
        dao.edit(uom);
        return ResponseEntity.ok().build();
    }
}
