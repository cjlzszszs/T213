package com.zking.ssm.controller;

import com.zking.ssm.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RequestMapping(value = "Home")
@Controller
public class HomeController {

    @RequestMapping(value = "toHome")
    public String toHome(Customer c, HttpServletRequest req, Model model){
        System.out.println(c);
        System.out.println(req.getRequestURI());
        //System.out.println(sex);
        model.addAttribute("params",c);
        return "redirect:toHome2";
    }


    @RequestMapping(value = "toHome2")
    public String toHome2(Model model){
        return "welcome";
    }


    @RequestMapping(value = "toHomePage")
    public ModelAndView toHomePage(){
        ModelAndView mv=new ModelAndView();
        mv.addObject("params","过几天下雪了");
        mv.setViewName("homepage");
        return mv;
    }
}
