package org.example.smartStore.store.Controller;

import org.example.smartStore.cookie.CookieMgr;
import org.example.smartStore.session.SessionMgr;
import org.example.smartStore.store.DTO.CustomerDTO;
import org.example.smartStore.store.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/CustomerManage")
public class CustomerManageController {

    SessionMgr sessionMgr;
    CookieMgr cookieMgr;
    CustomerService customerService;

    @Autowired
    public CustomerManageController(SessionMgr sessionMgr, CookieMgr cookieMgr, CustomerService customerService){
        this.sessionMgr =sessionMgr;
        this.cookieMgr =cookieMgr;
        this.customerService =customerService;
    }
    @GetMapping("/list")
    public String customerManagePage(HttpSession session, CustomerService customerService,
                                     Model model, HttpServletRequest request,
                                     HttpServletResponse response){
        if(session.getAttribute("SESSION_ID")==null)return"redirect:/";

        String customerID = (String)session.getAttribute("SESSION_ID");
        List<CustomerDTO> customerDTOList = customerService.getCustomerList(customerID);
        model.addAttribute("customerList",customerDTOList);
        return "LoginStatus/CustomerManage";
    }
}
