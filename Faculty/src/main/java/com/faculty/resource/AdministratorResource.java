package com.faculty.resource;


import com.faculty.entity.Administrator;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AdministratorResource {
    private static final String BILL_SERVICE_URL = "http://localhost:7070";

    private final RestTemplate restTemplate;

    public AdministratorResource() {
        this.restTemplate = new RestTemplate();
    }

    public Administrator findAdministratorById(final Long administratorId) {
        Administrator administrator = restTemplate.getForObject(BILL_SERVICE_URL + "/administrator/findbyid" + "?id=" + administratorId, Administrator.class);
        return administrator;
    }

    public Administrator saveAdministrator(final Administrator administrator) {
        Administrator administrator1 = restTemplate.postForObject(BILL_SERVICE_URL + "/administrator", administrator, Administrator.class);
        return administrator1;
    }

}
