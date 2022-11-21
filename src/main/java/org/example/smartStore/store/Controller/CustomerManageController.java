package org.example.smartStore.store.Controller;

import org.example.smartStore.cookie.CookieMgr;
import org.example.smartStore.session.SessionMgr;
import org.example.smartStore.store.DAO.CustomerDAO;
import org.example.smartStore.store.DTO.CustomerDTO;
import org.example.smartStore.store.Entity.Customer;
import org.example.smartStore.store.Service.CustomerService;
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

    SessionMgr sessionMgr;
    CustomerService customerService;
    CustomerDAO customerDAO;

    @Autowired
    public CustomerManageController(SessionMgr sessionMgr, CustomerService customerService,CustomerDAO customerDAO){
        this.sessionMgr =sessionMgr;
        this.customerService =customerService;
        this.customerDAO = customerDAO;
    }
    @GetMapping("/list")
    public String customerManagePage(HttpSession session, CustomerService customerService,
                                     Model model){
        if(session.getAttribute("SESSION_ID")==null)return"redirect:/";
        String userID = session.getAttribute("SESSION_ID").toString();
        List<CustomerDTO> customerDTOList = customerService.getCustomerList(userID,customerDAO);
        if(customerDTOList == null)return"redirect:/";
        model.addAttribute("userStoreName",session.getAttribute("USER_STORE_NAME").toString());
        model.addAttribute("customerList",customerDTOList);
        return "/LoginStatus/CustomerManage";
    }

    @GetMapping("/addCustomer")
    public String addCustomerPage(HttpSession session, HttpServletRequest request,Model model){
        if(session.getAttribute("SESSION_ID")==null)return "redirect:/";

        else {
            model.addAttribute("userStoreName",session.getAttribute("USER_STORE_NAME").toString());
            return "/LoginStatus/AddCustomer";
        }
    }

    @PostMapping("/addCustomer")
    public String addCustomer(@RequestParam String customerID,
                              @RequestParam String customerName,
                              @RequestParam int customerSpentMoney,
                              @RequestParam int customerPurchaseCount,
                              HttpSession session, HttpServletRequest request,
                              CustomerService customerService,Model model,HttpServletResponse response){
        String userID = session.getAttribute("SESSION_ID").toString();
        String view = addCustomerPage(session,request,model);
        Status respStatus = Status.FAIL;
//        if (customerService.selectCustomer(userID,customerID,customerDAO)==null){ //jdbc 연결 X 주석 처리
            Customer customer = new Customer(userID,customerID,customerName,customerSpentMoney,customerPurchaseCount);
            if(customerService.addCustomer(customer,customerDAO)){
                view = customerManagePage(session,customerService,model);
                respStatus = Status.SUCCESS;
            }
//        }
        model.addAttribute("userStoreName",session.getAttribute("USER_STORE_NAME").toString());
        session.setAttribute("add",respStatus);
        return view;
    }

    @GetMapping("/updateCustomer/{customerID}")
    public String updateCustomerPage(HttpSession session, HttpServletRequest request, Model model,
                                 CustomerService customerService,@PathVariable String customerID){
        if(session.getAttribute("SESSION_ID")==null){
            return "redirect:/";
        }
        Customer customer = customerService.selectCustomer(session.getAttribute("SESSION_ID").toString(),customerID,customerDAO);
        if(customer == null){
            return customerManagePage(session,customerService,model);
        }else {
            model.addAttribute("userStoreName",session.getAttribute("USER_STORE_NAME").toString());
            model.addAttribute("customer",customer);
            String name = customer.getCustomerName();
            System.out.println(name);
            model.addAttribute("customerName",name);
            return "redirect:/LoginStatus/updateCustomer";
        }
    }

    @PostMapping("/updateCustomer/{customerID}")
    public String updateCustomer(@RequestParam String customerName,
                                 @RequestParam int customerSpentMoney,
                                 @RequestParam int customerPurchaseCount,
                                 @PathVariable String customerID,
                                 HttpSession session,Model model,HttpServletRequest request) {
        String view = updateCustomerPage(session, request, model, customerService, customerID);
        Status respStatus = Status.FAIL;
        Customer customer = new Customer(session.getAttribute("SESSION_ID").toString(),customerID,customerName,customerSpentMoney,customerPurchaseCount);
        if(customerService.updateCustomer(customer,customerDAO)){
            view = customerManagePage(session,customerService,model);
            respStatus = Status.SUCCESS;
        }
        model.addAttribute("userStoreName",session.getAttribute("USER_STORE_NAME").toString());
        session.setAttribute("update",respStatus);
        return view;
    }

    @GetMapping("/deleteCustomer/{customerID}")
    public String deleteCustomer(HttpSession session,Model model,HttpServletRequest request,
                                 @PathVariable String customerID) {
        Status respStatus = Status.FAIL;
        Customer customer = new Customer(session.getAttribute("SESSION_ID").toString(),customerID);
        if(customerService.deleteCustomer(customer,customerDAO)){
            respStatus  = Status.SUCCESS;
        }
        session.setAttribute("delete",respStatus);
        return customerManagePage(session,customerService,model);
    }

//    @GetMapping("/deleteAllCustomer")
//    public String deleteAllCustomer(HttpSession session, Model model,HttpServletRequest request){
//        Status respStatus = Status.FAIL;
//        String next = "/";
//        if(customerService.deleteAllCustomers(session.getAttribute("SESSION_ID").toString(),customerDAO)){
//            respStatus = Status.SUCCESS;
//            next = "/login/unregister";//parameter 삭제로 추후에 변경
//        }
//        session.setAttribute("delete_all_customer",respStatus);
//        return next;
//    }
}
