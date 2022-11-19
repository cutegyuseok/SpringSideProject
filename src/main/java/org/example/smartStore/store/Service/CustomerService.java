package org.example.smartStore.store.Service;

import org.example.smartStore.store.DAO.CustomerDAO;
import org.example.smartStore.store.DTO.CustomerDTO;
import org.example.smartStore.store.Entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Service
public class CustomerService implements iCustomerService{



    @Override
     @Transactional(readOnly = true)
     public List<CustomerDTO> getCustomerList(String userID,CustomerDAO customerDAO){
         System.out.println(userID);
         System.out.println(customerDAO.toString());
         List<Customer> customerList = null;
         try {
             customerList = customerDAO.selectAll(userID);
         }catch (NullPointerException n){
             System.out.println(n);
             customerList = null;
         }
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
