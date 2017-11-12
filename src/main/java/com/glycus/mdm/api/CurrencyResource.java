/**
 *
 */
package com.glycus.mdm.api;


import com.glycus.mdm.model.Currency;
import com.glycus.mdm.dao.CurrencyDao;
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
 * @author agarlapa
 *
 */
@RestController
public class CurrencyResource {

    @Autowired
    private CurrencyDao dao;

    @GetMapping("/currency")
    public List<Currency> findAll() {
        List<Currency> currencyList = dao.findAll();
        return currencyList;
    }

    @GetMapping("/currency/findByCode")
    public Currency findByCode(@RequestHeader HttpHeaders headers) {
        String code = headers.get("code").get(0);
        Currency currency = dao.findByCode(code);
        return currency;
    }

    @PostMapping("/currency")
    public ResponseEntity add(Currency currency) {
        dao.create(currency);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/currency")
    public ResponseEntity update(Currency currency) {
        dao.edit(currency);
        return ResponseEntity.ok().build();
    }
}