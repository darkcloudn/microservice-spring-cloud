package com.darkcloudn.microservice.currencyconversionservice.proxy;


import com.darkcloudn.microservice.currencyconversionservice.CurrencyConversion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "currency-exchange",url = "localhost:8000")
@FeignClient(name = "currency-exchange")
public interface CurrencyExchangeProxy {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversion retrieveExchangeValue(
            @PathVariable(name = "from") String from,
            @PathVariable(name = "to") String to);
}
