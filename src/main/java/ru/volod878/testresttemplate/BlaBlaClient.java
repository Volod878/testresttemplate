package ru.volod878.testresttemplate;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class BlaBlaClient {
    private final RestTemplate restTemplate;

    public Customer getEmployee(String id) {
        ResponseEntity<Customer> resp =
                restTemplate.getForEntity("http://www.local.ry/employee/" + id, Customer.class);

        return resp.getStatusCode() == HttpStatus.OK ? resp.getBody() : null;
    }
}
