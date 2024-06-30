package com.example.user_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/massage")
    public String message1(){
        return "User Service works fine";
    }

    @GetMapping("/health")
    public String message(){
        //return "User Service works fine";
//        return restTemplate.getForObject("http://localhost:8082/api/v1/item/health",String.class);
        return restTemplate.getForObject("http://item-service/api/v1/item/health",String.class);
    }

    @PostMapping("/saveItem")
    public Item saveItem(@RequestBody Item item){
        return restTemplate.postForObject("http://user-service/api/v1/item/save",item,Item.class);
    }

}
