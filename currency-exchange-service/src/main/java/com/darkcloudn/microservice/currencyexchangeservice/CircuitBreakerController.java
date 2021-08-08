package com.darkcloudn.microservice.currencyexchangeservice;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

    private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    //Circuit
    @GetMapping("/sample-api")
//    @Retry(name = "sample-api",fallbackMethod = "hardCodeResponse")
    @CircuitBreaker(name = "sample-api",fallbackMethod = "hardCodeResponse")
    public String sampleApi(){
        logger.info("Sample API call retrieve");
        ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url", String.class);
        return forEntity.getBody();
    }
    public String hardCodeResponse(Exception ex){
        return "fall-back-response";
    }


    @GetMapping("/rate-limit")
//    @RateLimiter(name = "default")
    @Bulkhead(name = "rate-limit")
    public String RateLimit(){
        logger.info("RateLimit");
        return "rate-limit";
    }
}
