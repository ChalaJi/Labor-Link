package com.microservice.WorkProject.Controller;

import com.microservice.WorkProject.DTO.WorkDTO;
import com.microservice.WorkProject.Model.WorkModel;
import com.microservice.WorkProject.Service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "work")
public class WorkController {

    @Autowired
    WorkService service;

    @PostMapping("/add")
    public ResponseEntity<WorkModel> addWork(@RequestBody WorkDTO w) {
        return service.addWork(w);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<WorkModel>> getAllWork() {
        return service.getAllWork();
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<WorkModel> getWorkById(@PathVariable String id) {
        return service.getWorkById(id);
    }

    @GetMapping("/getByCity/{city}")
    public ResponseEntity<List<WorkModel>> getByCity(@PathVariable String city) {
        return service.getByCity(city);
    }

    @PatchMapping("/update")
    public ResponseEntity<WorkModel> updateWork(@RequestBody WorkDTO w) {
        return service.updateWork(w);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteWork(@PathVariable String id) {
        return service.deleteWork(id);
    }
}

