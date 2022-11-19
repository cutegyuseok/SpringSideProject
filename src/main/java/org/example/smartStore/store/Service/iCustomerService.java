package org.example.smartStore.store.Service;

import org.example.smartStore.store.DTO.CustomerDTO;

import java.util.List;

public interface iCustomerService {
    List<CustomerDTO> getCustomerList(String userID);
}
