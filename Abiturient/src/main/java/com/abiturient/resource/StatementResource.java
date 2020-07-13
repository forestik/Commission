package com.abiturient.resource;



import com.abiturient.entity.Statement;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class StatementResource {
    private static final String BILL_SERVICE_URL = "http://localhost:5050";

    private final RestTemplate restTemplate;

    public StatementResource() {
        this.restTemplate = new RestTemplate();
    }

    public void deleteStatementById(final Long statementId) {
        restTemplate.delete(BILL_SERVICE_URL + "/statement/deletestatement"+"?id=" + statementId, Statement.class);

    }


}
