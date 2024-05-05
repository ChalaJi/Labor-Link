package com.microservice.WorkProject.Repository;

import com.microservice.WorkProject.Model.WorkModel;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CustomWorkRepository {
    List<WorkModel> getByCity(String s);
}
