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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
                                     Model model, HttpServletRequest request,
                                     HttpServletResponse response){
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
//            model.addAttribute("userStoreName",session.getAttribute("USER_STORE_NAME").toString());
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
                view = customerManagePage(session,customerService,model,request,response);
                respStatus = Status.SUCCESS;
            }
//        }
        session.setAttribute("add",respStatus);
        return view;
    }
}
