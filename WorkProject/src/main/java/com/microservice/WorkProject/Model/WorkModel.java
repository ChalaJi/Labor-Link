package com.microservice.WorkProject.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection = "Work")
public class WorkModel {

    private String id;
    private String wDate;
    private int cId;
    private String problem;
    private String cCity;
    private String status;
    private int lId;
    private String visitDate;

    public WorkModel( String wId, String wDate, int cId, String problem, String cCity, String status) {
        this.id = wId;
        this.wDate = wDate;
        this.cId = cId;
        this.problem = problem;
        this.cCity = cCity;
        this.status = status;
        this.lId = 0;
        this.visitDate = "Not Declared";
    }
}
