package org.example.smartStore.store.Controller;

import org.example.smartStore.cookie.CookieMgr;
import org.example.smartStore.session.SessionMgr;
import org.example.smartStore.store.Entity.User;
import org.example.smartStore.store.Service.UserService;
import org.example.smartStore.store.VO.UserVO;
import org.example.smartStore.util.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private SessionMgr sessionMgr;
    @Autowired
    private CookieMgr cookieMgr;
    @Autowired
    private UserService userService;

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

        UserVO user = userService.login(userID,userPassword);
        if(user!=null){
            sessionMgr.create(session,user.getUserID());
            sessionMgr.create(session,"USER_NAME",user.getUserName());
            sessionMgr.create(session,"USER_STORE_NAME",user.getUserStoreName());
            model.addAttribute("userID",session.getAttribute("SESSION_ID"));
            model.addAttribute("userName",user.getUserName());
            view = "LoginStatus/StoreAdminPage";
            respStatus = Status.SUCCESS;
        }

        session.setAttribute("login",respStatus);
        return view;
    }
    @GetMapping("/login/signUp")
    public String signUpPage(HttpServletRequest request,HttpSession session){
        if (session.getAttribute("SESSION_ID")!=null){
            return "redirect:/";
        }
        return "nonLoginStatus/signUp";
    }

    @PostMapping("/login/signUp")
    public String doSignUP(@RequestParam String userID,
                           @RequestParam String userPassword,
                           @RequestParam String userName,
                           @RequestParam String userEmail,
                           @RequestParam String userStoreName,
                           HttpServletRequest request,
                           HttpSession session,
                           HttpServletResponse response){
        System.out.println(userName+" "+ userStoreName);
        String view = signUpPage(request,session);
        Status respStatus = Status.FAIL;
        if (userService.checkIDExist(userID)){
            if(userService.doSignUp(userID,userPassword,userEmail,userName,userStoreName)){
             view = "nonLoginStatus/login";
             respStatus = Status.SUCCESS;
            }
        }
        session.setAttribute("signup",respStatus);
        return view;
    }

    @GetMapping("/login/update")
    public String userUpdatePage(HttpSession session,Model model){
        if(session.getAttribute("SESSION_ID")==null)return "redirect:/";
        User user =userService.getUserInfo(session.getAttribute("SESSION_ID").toString());
        user.setUserPassword("PASSWORD"); //hiding Password
        model.addAttribute("user",user);
        model.addAttribute("userStoreName",session.getAttribute("USER_STORE_NAME").toString());
        return "/LoginStatus/updateUser";
    }

    @PostMapping("/login/update")
    public String userUpdate(@RequestParam String userName,
                             @RequestParam String userEmail,
                             @RequestParam String userPassword,
                             @RequestParam String userNewPassword,
                             @RequestParam String userStoreName,HttpSession session, Model model) {
        String userID = session.getAttribute("SESSION_ID").toString();
        String view = "/LoginStatus/updateUser";
        Status resp = Status.FAIL;
        System.out.println(userNewPassword);
        User user = new User(userName,userID,userNewPassword,userEmail,userStoreName);

        if (userService.updateUser(user,userPassword)){
            view = "/LoginStatus/StoreAdminPage";
            resp = Status.SUCCESS;
            sessionMgr.set(session,"USER_NAME",user.getUserName());
            sessionMgr.set(session,"USER_STORE_NAME",user.getUserStoreName());
            model.addAttribute("userName",user.getUserName());
        }else {
            User originalUser =userService.getUserInfo(session.getAttribute("SESSION_ID").toString());
            originalUser.setUserPassword("PASSWORD"); //hiding Password
            model.addAttribute("user",originalUser);
        }
        model.addAttribute("userStoreName",session.getAttribute("USER_STORE_NAME").toString());
        session.setAttribute("update",resp);
                return view;
    }

}
