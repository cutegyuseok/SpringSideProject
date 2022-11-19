package org.example.smartStore.store.Service;

import org.example.smartStore.store.DAO.CustomerDAO;
import org.example.smartStore.store.DTO.CustomerDTO;
import org.example.smartStore.store.Entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class CustomerService implements iCustomerService{
     CustomerDAO customerDAO;

     @Autowired
     public CustomerService(CustomerDAO customerDAO){
         this.customerDAO = customerDAO;
     }

    public List<CustomerDTO> getCustomerList(String userID){
         List<Customer> customerList = customerDAO.selectAll(userID);
         if(customerList == null){
             return null;
         }
         List<CustomerDTO> customerDTOList = new LinkedList<>();
         for(int i=0;i<customerList.size();i++){
             customerDTOList.add(customerList.get(i).toDTO());
             System.out.println(customerList.get(i).toString());
         }
         return customerDTOList;
    }
}
