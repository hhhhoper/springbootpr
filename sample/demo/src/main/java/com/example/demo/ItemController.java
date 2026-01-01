package com.example.demo;


import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/items")
@CrossOrigin(origins="http://localhost:8081") //allow cross-origin requests
public class ItemController {
   private final ItemRepository repository;

   public ItemController(ItemRepository repository){
        this.repository=repository;
   }

   @GetMapping
   public List<Item>getAllItems(){
        return repository.findAll();
   }

   @PostMapping
   public Item createItem(@RequestBody Item item){
        return repository.save(item);
   }
}
