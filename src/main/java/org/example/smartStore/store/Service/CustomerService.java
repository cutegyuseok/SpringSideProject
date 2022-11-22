package org.example.smartStore.store.Service;

import org.example.smartStore.store.DAO.CustomerDAO;
import org.example.smartStore.store.DTO.CustomerDTO;
import org.example.smartStore.store.DTO.ParameterDTO;
import org.example.smartStore.store.Entity.Customer;
import org.example.smartStore.store.Entity.CustomerWithGrade;
import org.example.smartStore.store.Entity.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class CustomerService implements iCustomerService{


    @Override
     @Transactional(readOnly = true)
     public List<CustomerDTO> getCustomerList(String userID,CustomerDAO customerDAO){
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
         }
         return customerDTOList;
    }

    @Override
    public Customer selectCustomer(String userID, String customerID,CustomerDAO customerDAO) {
        Customer customer = null;
        try {
            customer = customerDAO.select(userID,customerID).toEntity();
        }catch (NullPointerException n){
            n.printStackTrace();
        }
        return customer;
    }

    @Override
    public boolean addCustomer(Customer customer, CustomerDAO customerDAO) {
        return customerDAO.addCustomer(customer)>0;
    }

    public boolean updateCustomer(Customer customer, CustomerDAO customerDAO){
        return customerDAO.updateCustomer(customer)>0;
    }

    public boolean deleteCustomer(Customer customer, CustomerDAO customerDAO){
        return customerDAO.deleteCustomer(customer)>0;
    }
    public boolean deleteAllCustomers(String userID, CustomerDAO customerDAO){
        return customerDAO.deleteAllCustomers(userID)>0;
    }

    public List<CustomerWithGrade> listWithGrade(List<CustomerDTO> customerDTOList,ParameterService parameterService,String userID){
        List<ParameterDTO> parameterList = parameterService.getAllParameter(userID);
        List<CustomerWithGrade> customerWithGradeList = new LinkedList<>();
        ArrayList<CustomerDTO> dtoList = new ArrayList<>();
        for(int i=0;i<customerDTOList.size();i++){
            dtoList.add(customerDTOList.get(i));
        }
        for(int i= (parameterList.size()-1);i>=0;i--){
            for(int j=dtoList.size()-1;j>=0;j--){

                if(parameterList.get(i).getMinimumSpentMoney()<=dtoList.get(j).getCustomerSpentMoney() &&
                   parameterList.get(i).getMinimumPurchaseCount()<=dtoList.get(j).getCustomerPurchaseCount()){
                    customerWithGradeList.add(new CustomerWithGrade(dtoList.get(j),parameterList.get(i).getGrade()));
                    dtoList.remove(j);
                }
            }
        }
        return customerWithGradeList;
    }




}
