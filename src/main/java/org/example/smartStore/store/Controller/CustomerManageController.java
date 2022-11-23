package org.example.smartStore.store.Controller;

import org.example.smartStore.session.SessionMgr;
import org.example.smartStore.store.DTO.CustomerDTO;
import org.example.smartStore.store.Entity.Customer;
import org.example.smartStore.store.Entity.CustomerWithGrade;
import org.example.smartStore.store.Service.CustomerService;
import org.example.smartStore.store.Service.ParameterService;
import org.example.smartStore.util.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/customerManage")
public class CustomerManageController {
    @Autowired
    SessionMgr sessionMgr;
    @Autowired
    CustomerService customerService;
    @Autowired
    ParameterService parameterService;

    @GetMapping("/list")
    public String customerManagePage(HttpSession session,Model model){
        if(session.getAttribute("SESSION_ID")==null)return"redirect:/";
        String userID = session.getAttribute("SESSION_ID").toString();
        List<CustomerDTO> customerDTOList = customerService.customerList(userID);
        if(customerDTOList == null)return"redirect:/";
        List<CustomerWithGrade> customerGradeList = customerService.listWithGrade(customerDTOList,parameterService,userID);
        model.addAttribute("customerGradeList",customerGradeList);
        return "/LoginStatus/CustomerManage";
    }

    @GetMapping("/addCustomer")
    public String addCustomerPage(HttpSession session, HttpServletRequest request,Model model){
        if(session.getAttribute("SESSION_ID")==null)return "redirect:/";
        else {
            return "/LoginStatus/AddCustomer";
        }
    }

    @PostMapping("/addCustomer")
    public String addCustomer(@RequestParam String customerID,
                              @RequestParam String customerName,
                              @RequestParam int customerSpentMoney,
                              @RequestParam int customerPurchaseCount,
                              HttpSession session, HttpServletRequest request,
                              Model model,HttpServletResponse response){
        String userID = session.getAttribute("SESSION_ID").toString();
        String view = addCustomerPage(session,request,model);
        Status respStatus = Status.FAIL;
//        if (customerService.selectCustomer(userID,customerID,customerDAO)==null){ //jdbc 연결 X 주석 처리
            Customer customer = new Customer(userID, customerID, customerName, customerSpentMoney, customerPurchaseCount);
            if (customerService.addCustomer(customer)) {
                view = customerManagePage(session, model);
                respStatus = Status.SUCCESS;
            }
//        }
        session.setAttribute("add",respStatus);
        return view;
    }

    @GetMapping("/updateCustomer/{customerID}")
    public String updateCustomerPage(HttpSession session, HttpServletRequest request, Model model
                                 ,@PathVariable String customerID){
        if(session.getAttribute("SESSION_ID")==null){
            return "redirect:/";
        }
        Customer customer = customerService.selectCustomer(session.getAttribute("SESSION_ID").toString(),customerID);
        if(customer == null){
            return customerManagePage(session,model);
        }else {
            model.addAttribute("customer",customer);
            String name = customer.getCustomerName();
            model.addAttribute("customerName",name);
            return "/LoginStatus/updateCustomer";
        }
    }

    @PostMapping("/updateCustomer/{customerID}")
    public String updateCustomer(@RequestParam String customerName,
                                 @RequestParam int customerSpentMoney,
                                 @RequestParam int customerPurchaseCount,
                                 @PathVariable String customerID,
                                 HttpSession session,Model model,HttpServletRequest request) {
        String view = updateCustomerPage(session, request, model, customerID);
        Status respStatus = Status.FAIL;
        Customer customer = new Customer(session.getAttribute("SESSION_ID").toString(),customerID,customerName,customerSpentMoney,customerPurchaseCount);
        if(customerService.updateCustomer(customer)){
            view = customerManagePage(session,model);
            respStatus = Status.SUCCESS;
        }
        session.setAttribute("update",respStatus);
        return view;
    }

    @GetMapping("/deleteCustomer/{customerID}")
    public String deleteCustomer(HttpSession session,Model model,HttpServletRequest request,
                                 @PathVariable String customerID) {
        Status respStatus = Status.FAIL;
        Customer customer = new Customer(session.getAttribute("SESSION_ID").toString(),customerID);
        if(customerService.deleteCustomer(customer)){
            respStatus  = Status.SUCCESS;
        }
        session.setAttribute("delete",respStatus);
        return customerManagePage(session,model);
    }
}
