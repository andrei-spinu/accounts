package com.andreis.accounts.controller;

import com.andreis.accounts.config.AccountServiceConfig;
import com.andreis.accounts.model.Account;
import com.andreis.accounts.model.Customer;
import com.andreis.accounts.model.Properties;
import com.andreis.accounts.repository.AccountRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {

    private final AccountRepository repository;
    private final AccountServiceConfig accountServiceConfig;

    @PostMapping("/myAccount")
    public Account getAccountDetails(@RequestBody Customer customer){

        return repository.findByCustomerId(customer.getCustomerId());
    }

    @GetMapping("/properties")
    public String getPropertyDetails() throws JsonProcessingException {
        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        Properties properties = Properties.builder()
                .msg(accountServiceConfig.getMsg())
                .buildVersion(accountServiceConfig.getBuildVersion())
                .mailDetails(accountServiceConfig.getMailDetails())
                .activeBranches(accountServiceConfig.getActiveBranches())
                .build();

        String jsonString = objectWriter.writeValueAsString(properties);

        return jsonString;
    }
}
