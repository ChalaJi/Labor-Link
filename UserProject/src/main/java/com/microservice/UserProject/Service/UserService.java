package com.microservice.UserProject.Service;

import com.microservice.UserProject.Model.User;
import com.microservice.UserProject.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository repo;

    public ResponseEntity<String> addUser(User u){
        try {
            repo.save(u);
            return new ResponseEntity("Success", HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity("Failed", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> getCity(int cId){
        try {
            Optional<User> u = repo.findById(cId);
            return new ResponseEntity(u.get().getCCity(),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity("Failed",HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<User>> getAllUsers() {
        try {
            return new ResponseEntity(repo.findAll(),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<User> getUserById(int id) {
        try {
            return new ResponseEntity(repo.findById(id),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity(new User(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<User>> getUsersByName(String name) {
        try {
            return new ResponseEntity(repo.findBycName(name),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<User>> areCityPrefix(String prefix) {
        try {
            return new ResponseEntity(repo.areCityPrefix(prefix),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<User> updateUser(User u) {
        try {
            return new ResponseEntity(repo.save(u),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity(new User(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> deleteUser(int id) {
        try {
            repo.deleteById(id);
            return new ResponseEntity("Deletion Successful",HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity("Deletion Failed",HttpStatus.BAD_REQUEST);
    }
}

