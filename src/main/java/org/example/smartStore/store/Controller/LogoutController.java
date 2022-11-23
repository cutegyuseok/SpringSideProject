package org.example.smartStore.store.Controller;

import org.example.smartStore.cookie.CookieMgr;
import org.example.smartStore.session.SessionMgr;
import org.example.smartStore.store.Service.CustomerService;
import org.example.smartStore.store.Service.ParameterService;
import org.example.smartStore.store.Service.UserService;
import org.example.smartStore.util.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {
    private SessionMgr sessionMgr;
    private CookieMgr cookieMgr;
    private UserService userService;
    private CustomerService customerService;
    private ParameterService parameterService;

    @Autowired
    public LogoutController(SessionMgr sessionMgr, CookieMgr cookieMgr,
                            UserService userService, CustomerService customerService,
                            ParameterService parameterService) {
        this.sessionMgr = sessionMgr;
        this.cookieMgr = cookieMgr;
        this.userService = userService;
        this.customerService = customerService;
        this.parameterService = parameterService;
    }


    @GetMapping(value = "/logout")
    public String logout(HttpSession session, HttpServletRequest request, HttpServletResponse response,RedirectAttributes redirectAttributes){
        Status respStatus;
        redirectAttributes.addFlashAttribute("redirect", "value");
        if (session.getAttribute("SESSION_ID")==null){
            respStatus = Status.FAIL;
        }else {
            session.removeAttribute("SESSION_ID");
            session.removeAttribute("USER_NAME");
            session.removeAttribute("USER_STORE_NAME");
            respStatus = Status.SUCCESS;
        }
        session = request.getSession(); // 새로운 세션 생성 (새로운 세션 만들어 redirect 하기 위함)
        session.setAttribute("logout",respStatus);
        return "redirect:/";
    }

    @GetMapping("/unregister")
    public String unregister(HttpSession session, HttpServletRequest request,RedirectAttributes redirectAttributes ){
        String userID = session.getAttribute("SESSION_ID").toString();
        if(customerService.deleteAllCustomers(userID)) System.out.println("customer done");
        if(parameterService.deleteAllParameter(userID)) System.out.println("parameter done");
        if(userService.deleteUser(userID)) System.out.println("user done");
        redirectAttributes.addFlashAttribute("redirect", "value");
        session.removeAttribute("SESSION_ID");
        session.removeAttribute("USER_NAME");
        session.removeAttribute("USER_STORE_NAME");
        Status respStatus = Status.SUCCESS;
        session.setAttribute("logout",respStatus);
        return "redirect:/";
    }

}
