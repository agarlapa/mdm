/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glycus.mdm.dto;

import com.glycus.mdm.entity.Currency;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author agarlapa
 */
@XmlRootElement(name="currencies")
public class Currencies {
    
    List<Currency> currency;

    public List<Currency> getCurrency() {
        return currency;
    }

    public void setCurrency(List<Currency> currency) {
        this.currency = currency;
    }
    
}
