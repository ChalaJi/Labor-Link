package com.microservice.WorkProject.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("USER-SERVICE")
public interface FeignInterface {
    @GetMapping("user/getcity/{cId}")
    public ResponseEntity<String> getCity(@PathVariable int cId);
}
