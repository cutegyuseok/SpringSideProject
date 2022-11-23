package org.example.smartStore.store.Controller;

import org.example.smartStore.session.SessionMgr;
import org.example.smartStore.store.DTO.ParameterDTO;
import org.example.smartStore.store.Entity.Parameter;
import org.example.smartStore.store.Service.ParameterService;
import org.example.smartStore.util.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/parameter")
public class ParameterController {

    private SessionMgr sessionMgr;
    private ParameterService parameterService;

    @Autowired
    public ParameterController(SessionMgr sessionMgr, ParameterService parameterService) {
        this.sessionMgr = sessionMgr;
        this.parameterService = parameterService;
    }

    @GetMapping("/page")
    public String parameterPage(HttpSession session, Model model){
        List<ParameterDTO> parameterListToPage = parameterService.getAllParameter(session.getAttribute("SESSION_ID").toString());
        model.addAttribute("parameterListToPage",parameterListToPage);
        return "/LoginStatus/parameterPage";
    }

    @PostMapping("/update/{grade}")
    public String parameterUpdate(@PathVariable String grade,
                                  @RequestParam int minimumSpentMoney,
                                  @RequestParam int minimumPurchaseCount,
                                  HttpSession session, Model model) {
        Parameter parameter = new Parameter(session.getAttribute("SESSION_ID").toString(), grade,
                minimumSpentMoney, minimumPurchaseCount);
        Status status = Status.FAIL;
        if (parameter != null) {
            if (parameterService.updateParameter(parameter)){
                 status= Status.SUCCESS;
            }
        }
        session.setAttribute("update",status);
        List<ParameterDTO> parameterListToPage = parameterService.getAllParameter(session.getAttribute("SESSION_ID").toString());
        model.addAttribute("parameterListToPage",parameterListToPage);
        return "/LoginStatus/parameterPage";
    }

    @GetMapping("/delete/{grade}")
    public String deleteParameter(@PathVariable String grade,HttpServletRequest request,
                                  HttpSession session,Model model){
        Status status = Status.FAIL;
        if(parameterService.deleteParameter(grade,session.getAttribute("SESSION_ID").toString())){
            status = Status.SUCCESS;
        }
        session.setAttribute("deleteParameter",status);
        List<ParameterDTO> parameterListToPage = parameterService.getAllParameter(session.getAttribute("SESSION_ID").toString());
        model.addAttribute("parameterListToPage",parameterListToPage);
        return "/LoginStatus/parameterPage";
    }

    @GetMapping("/add")
    public String addParameterPage(HttpSession session,Model model){
        if(session.getAttribute("SESSION_ID")==null){
            return "redirect:/";
        }
        return "/LoginStatus/AddParameter";
    }

    @PostMapping("/add")
    public String addParameter(@RequestParam String grade,
                               @RequestParam int minimumSpentMoney,
                               @RequestParam int minimumPurchaseCount,
                               HttpSession session,Model model){
        if(session.getAttribute("SESSION_ID")==null){
            return "redirect:/";
        }
        Status status = Status.FAIL;
        String view = addParameterPage(session,model);
        Parameter parameter = new Parameter(session.getAttribute("SESSION_ID").toString(),grade,minimumSpentMoney,minimumPurchaseCount);
        if(parameterService.insertParameter(parameter)){
            status = Status.SUCCESS;
            view = parameterPage(session,model);
        }
        session.setAttribute("add parameter",status);
        return view;
    }

}
