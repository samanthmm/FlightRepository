package com.sensei.savedesk.web.rest.customer;

import com.sensei.savedesk.service.customer.CustomerService;
import com.sensei.savedesk.service.customer.dto.CustomerDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/api")
public class CustomerResource {
    private static final String ENTITY_NAME = "Customer";

    @Value("${application.name}")
    private String applicationName;

    private final CustomerService customerService;

    @GetMapping("/customers/findAllCustomer")
    public ResponseEntity<List<CustomerDTO>> getAllCustomer() {
        log.debug("Get All Customers");
        List<CustomerDTO> customers = customerService.findCustomers();
        return new ResponseEntity<List<CustomerDTO>>(customers, HttpStatus.OK);
    }
}