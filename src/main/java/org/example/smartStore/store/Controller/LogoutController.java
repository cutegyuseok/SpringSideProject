package org.example.smartStore.store.Controller;

import org.example.smartStore.cookie.CookieMgr;
import org.example.smartStore.session.SessionMgr;
import org.example.smartStore.util.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {
    private SessionMgr sessionMgr;
    private CookieMgr cookieMgr;

    @Autowired
    public LogoutController(SessionMgr sessionMgr,CookieMgr cookieMgr){
        this.sessionMgr =sessionMgr;
        this.cookieMgr = cookieMgr;
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
            session.removeAttribute("USER_ID");
            respStatus = Status.SUCCESS;
        }
        session = request.getSession(); // 새로운 세션 생성 (새로운 세션 만들어 redirect 하기 위함)
        session.setAttribute("logout",respStatus);
        return "redirect:/";
    }
}
