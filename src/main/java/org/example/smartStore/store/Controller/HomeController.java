package org.example.smartStore.store.Controller;

import org.example.smartStore.session.SessionMgr;
import org.example.smartStore.util.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Locale;

@Controller
public class HomeController {

    @Autowired
    private SessionMgr sessionMgr;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hompage( Model model, HttpSession session){
        if(session.getAttribute("SESSION_ID") != null){
            model.addAttribute("userID",session.getAttribute("SESSION_ID"));
            model.addAttribute("userName",session.getAttribute("USER_NAME"));
            model.addAttribute("userStoreName",session.getAttribute("USER_STORE_NAME"));
            return"LoginStatus/StoreAdminPage";
        }
        return "smartStore";
    }

    @GetMapping(value = "/LoginStatus/StoreAdminPage")
    public String adminPage(Locale locale,Model model, HttpSession session){
        if(session.getAttribute("SESSION_ID") == null){
            return "redirect:/";
        }else {
            model.addAttribute("userID",session.getAttribute("SESSION_ID"));
            model.addAttribute("userName",session.getAttribute("USER_NAME"));
            model.addAttribute("userStoreName",session.getAttribute("USER_STORE_NAME"));
            return "LoginStatus/StoreAdminPage";
        }
    }
}
