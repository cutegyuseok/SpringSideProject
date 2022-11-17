package org.example.smartStore.store.Controller;

import org.example.smartStore.session.SessionMgr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Locale;

@Controller
public class HomeController {
    private SessionMgr sessionMgr;

    @Autowired
    public HomeController(SessionMgr sessionMgr) {
        this.sessionMgr = sessionMgr;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hompage(Locale locale, Model model, HttpServletRequest request, HttpSession session){
        return "smartStore";
    }
}
