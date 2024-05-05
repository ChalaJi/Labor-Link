package com.microservice.UserProject.Controller;

import com.microservice.UserProject.Model.User;
import com.microservice.UserProject.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "user")
//@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    UserService service;

    @GetMapping("/getcity/{cId}")
    public ResponseEntity<String> getCity(@PathVariable int cId){
        return service.getCity(cId);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addProduct(@RequestBody User u){
        return service.addUser(u);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        return service.getUserById(id);
    }

    @GetMapping("/getByName/{name}")
    public ResponseEntity<List<User>> getUsersByName(@PathVariable String name) {
        return service.getUsersByName(name);
    }

    @GetMapping("/getByCityPrefix/{prefix}")
    public ResponseEntity<List<User>> areCityPrefix(@PathVariable String prefix) {
        return service.areCityPrefix(prefix);
    }

    @PatchMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User u) {
        return service.updateUser(u);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        return service.deleteUser(id);
    }
}

