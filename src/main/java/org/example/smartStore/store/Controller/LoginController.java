package org.example.smartStore.store.Controller;

import org.example.smartStore.cookie.CookieMgr;
import org.example.smartStore.session.SessionMgr;
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
    static int  loginCNT =0;

    private SessionMgr sessionMgr;
    private CookieMgr cookieMgr;

    @Autowired
    public LoginController(SessionMgr sessionMgr, CookieMgr cookieMgr){
    this.sessionMgr = sessionMgr;
    this.cookieMgr = cookieMgr;
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
        //tryLogin();
        loginCNT++;
        model.addAttribute("loginAtempt",loginCNT);
        session.setAttribute("login",respStatus);
        return view;

    }

}
