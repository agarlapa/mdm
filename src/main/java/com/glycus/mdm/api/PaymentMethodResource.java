/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glycus.mdm.api;

import com.glycus.mdm.model.PaymentMethod;
import com.glycus.mdm.dao.PaymentMethodDao;
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
public class PaymentMethodResource {
    @Autowired
    private PaymentMethodDao dao;

    @GetMapping("/paymentmethod")
    public List<PaymentMethod> findAll() {
        List<PaymentMethod> paymentMethodList = dao.findAll();
        return paymentMethodList;
    }

    @GetMapping("/paymentmethod/findByCode")
    public PaymentMethod findByCode(@RequestHeader HttpHeaders headers) {
        String code = headers.get("code").get(0);
        PaymentMethod paymentMethod = dao.findByCode(code);
        return paymentMethod;
    }

    @PostMapping("/paymentmethod")
    public ResponseEntity add(PaymentMethod paymentMethod) {
        dao.create(paymentMethod);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/paymentmethod")
    public ResponseEntity update(PaymentMethod paymentMethod) {
        dao.edit(paymentMethod);
        return ResponseEntity.ok().build();
    }

}
