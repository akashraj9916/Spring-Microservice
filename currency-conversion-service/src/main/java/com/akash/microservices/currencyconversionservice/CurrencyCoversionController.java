package com.akash.microservices.currencyconversionservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyCoversionController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private CurrencyConversionServiceProxy currencyConversionServiceProxy;

    @GetMapping("currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean currencyConversion(@PathVariable String from, @PathVariable String to,
                                   @PathVariable BigDecimal quantity){
        logger.info(" This is CurrencyCoversionController ");
       /* Map<String,Object> params = new HashMap<>();
        params.put("from",from);
        params.put("to",to);
        CurrencyConversionBean currencyConversionBean = new RestTemplate().
                getForEntity("http://localhost:8001/currency-exchange/from/{from}/to/{to}",CurrencyConversionBean.class,params).getBody();*/
        CurrencyConversionBean currencyConversionBean = currencyConversionServiceProxy.retrieveExchangeService(from,to);
        return currencyConversionBean;
    }
}
