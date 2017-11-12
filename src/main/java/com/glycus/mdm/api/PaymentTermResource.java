/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glycus.mdm.api;

import com.glycus.mdm.model.PaymentTerm;
import com.glycus.mdm.dao.PaymentTermDao;
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
public class PaymentTermResource {

    @Autowired
    private PaymentTermDao dao;

    @GetMapping("/paymentterm")
    public List<PaymentTerm> findAll() {
        List<PaymentTerm> paymentTermList = dao.findAll();
        return paymentTermList;
    }

    @GetMapping("/paymentterm/findByCode")
    public PaymentTerm findByCode(@RequestHeader HttpHeaders headers) {
        String code = headers.get("code").get(0);
        PaymentTerm paymentTerm = dao.findByCode(code);
        return paymentTerm;
    }

    @PostMapping("/paymentterm")
    public ResponseEntity add(PaymentTerm paymentTerm) {
        dao.create(paymentTerm);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/paymentterm")
    public ResponseEntity update(PaymentTerm paymentTerm) {
        dao.edit(paymentTerm);
        return ResponseEntity.ok().build();
    }

}