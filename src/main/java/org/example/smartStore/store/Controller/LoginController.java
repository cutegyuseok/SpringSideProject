package org.example.smartStore.store.Controller;

import org.example.smartStore.cookie.CookieMgr;
import org.example.smartStore.session.SessionMgr;
import org.example.smartStore.store.DTO.UserDTO;
import org.example.smartStore.store.Entity.User;
import org.example.smartStore.store.Service.UserService;
import org.example.smartStore.util.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    private SessionMgr sessionMgr;
    private CookieMgr cookieMgr;

    private UserService userService;

    @Autowired
    public LoginController(SessionMgr sessionMgr, CookieMgr cookieMgr,UserService userService){
    this.sessionMgr = sessionMgr;
    this.cookieMgr = cookieMgr;
    this.userService = userService;
    }
    @GetMapping("/login")
    public String loginPage(HttpServletRequest request, HttpSession session){
        if(session.getAttribute("SESSION_ID") != null){
            return "redirect:/";
        }
        return "nonLoginStatus/login";
    }

    @PostMapping("/login")
    public String tryLogin(@RequestParam String userID,
                            @RequestParam String userPassword,
                            @RequestParam(required = false) String save,
                            HttpServletRequest request,
                           HttpSession session,
                           Model model,
                           HttpServletResponse response){
        String view =loginPage(request,session);
        Status respStatus = Status.FAIL;

        User user = userService.login(userID,userPassword);
        if(user!=null){
            sessionMgr.create(session,userID);
            model.addAttribute("userID",session.getAttribute("SESSION_ID"));
            model.addAttribute("userName",user.getUserName());
            model.addAttribute("userStoreName",user.getUserStoreName());
            System.out.println(user.toString());
            view = "LoginStatus/StoreAdminPage";
            respStatus = Status.SUCCESS;
        }

        session.setAttribute("login",respStatus);
        return view;

    }

}
