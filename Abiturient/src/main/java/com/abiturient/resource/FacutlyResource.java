package com.abiturient.resource;


import com.abiturient.entity.Faculty;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class FacutlyResource {
    private static final String BILL_SERVICE_URL = "http://localhost:6060";

    private final RestTemplate restTemplate;

    public FacutlyResource() {
        this.restTemplate = new RestTemplate();
    }

    public ResponseEntity<Faculty> findFacultyById(final Long facultyId) {

        ResponseEntity<Faculty> response = restTemplate.getForEntity(BILL_SERVICE_URL + "/faculty/findbyid"+"?id="+facultyId, Faculty.class);
        return response;
    }

    public ResponseEntity<Faculty[]> findFaculty() {

        ResponseEntity<Faculty[]> response = restTemplate.getForEntity(BILL_SERVICE_URL + "/faculty/findall", Faculty[].class);
        return response;
    }

}
