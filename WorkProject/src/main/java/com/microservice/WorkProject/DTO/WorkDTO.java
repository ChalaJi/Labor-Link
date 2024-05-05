package com.microservice.WorkProject.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class WorkDTO {
    private String wId;
    private int cId;
    private String problem;
    private String wDate;
}
