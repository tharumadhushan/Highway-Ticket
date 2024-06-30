package com.example.item_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("api/v1/item")
public class ItemController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/massage")
    public String message1(){
        return "Item Service works fine";
    }

    @GetMapping("/health")
    public String message(){
        return "Item Health works fine";
        //return restTemplate.getForObject("http://localhost:8081/api/v1/user/health",String.class);
    }

    @PostMapping("/save")
    public Item saveItem(@RequestBody Item item){
        item.setItemName("Item_Service :"+item.getItemName());
        return item;
    }

}
