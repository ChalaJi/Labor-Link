package com.microservice.WorkProject.Service;

import com.microservice.WorkProject.DTO.WorkDTO;
import com.microservice.WorkProject.Feign.FeignInterface;
import com.microservice.WorkProject.Model.WorkModel;
import com.microservice.WorkProject.Repository.CustomWorkRepositoryImpl;
import com.microservice.WorkProject.Repository.WorkRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WorkService {

    @Autowired
    WorkRepository repo;

    @Autowired
    CustomWorkRepositoryImpl custRepo;

    @Autowired
    FeignInterface feignInterface;

    public ResponseEntity<WorkModel> addWork(WorkDTO w){
        try {
            String city;
            String status = "Pending";

            //GetCity
            city = feignInterface.getCity(w.getCId()).getBody();

            WorkModel m = new WorkModel(w.getWId(),w.getWDate(), w.getCId(), w.getProblem(), city, status);

            return new ResponseEntity<>(repo.save(m), HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new WorkModel(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<WorkModel>> getAllWork() {
        try {
            return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<WorkModel> getWorkById(String id) {
        try {
            return new ResponseEntity<>(repo.findById(id).get(), HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new WorkModel(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<WorkModel>> getByCity(String city) {
        try {
            return new ResponseEntity<>(custRepo.getByCity(city), HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<WorkModel> updateWork(WorkDTO w) {
        try {

            Optional<WorkModel> m = repo.findById(w.getWId());
            m.get().setCId(w.getCId());
            m.get().setCCity(feignInterface.getCity(w.getCId()).getBody());
            m.get().setProblem(w.getProblem());
            m.get().setWDate(w.getWDate());

            return new ResponseEntity<>(repo.save(m.get()), HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new WorkModel(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> deleteWork(String id) {
        try {
            repo.deleteById(id);
            return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Deletion Failed", HttpStatus.BAD_REQUEST);
    }
}

