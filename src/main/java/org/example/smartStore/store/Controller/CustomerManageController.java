package org.example.smartStore.store.Controller;

import org.example.smartStore.cookie.CookieMgr;
import org.example.smartStore.session.SessionMgr;
import org.example.smartStore.store.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
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

    @RequestMapping("/CustomerManage")
    public String customerManagePage(HttpSession session, CustomerService customerService){
        if(session.getAttribute("SESSION_ID")==null)return"redirect:/";


        return null;
    }
}
