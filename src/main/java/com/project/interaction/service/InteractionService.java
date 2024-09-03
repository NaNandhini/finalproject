package com.project.interaction.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.project.interaction.dto.CustomerProfile;
import com.project.interaction.entity.InteractionEntity;
import com.project.interaction.exception.CustomerIdNotException;
import com.project.interaction.repository.InteractionRepository;

@Service
public class InteractionService {

    @Autowired
    private InteractionRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    public List<InteractionEntity> findAll() {
        return repository.findAll();
    }

    public Optional<InteractionEntity> findById(String interactionId) {
        return repository.findById(interactionId);
    }

    public InteractionEntity save(InteractionEntity interactionEntity) {
        return repository.save(interactionEntity);
    } 

    public void deleteById(String interactionId) {
        repository.deleteById(interactionId);
    }

   
     public CustomerProfile getInfoFromCustomerInfo(Long customerId) {
        String customerServiceUrl = "http://localhost:9595/api/customers/" + customerId;
        CustomerProfile info =restTemplate.getForObject(customerServiceUrl, CustomerProfile.class);
         if (info!=null){ 
             return info;
         }
         else{
             throw new CustomerIdNotException("No customer details found for the given customer id");
         }
        // String url = customerProfileServiceUrl + "/" + customerId;
        // try {
        //     CustomerProfile customerProfile = restTemplate.getForObject(url, CustomerProfile.class);
        //     if (customerProfile == null) {
        //         System.out.println("No customer profile found for ID: " + customerId);
        //     }
        //     return customerProfile;
        // } catch (RestClientException e) {
        //     // Handle the exception
        //     throw new RuntimeException("Failed to fetch customer info for ID: " + customerId, e);
        // }
    }
}
