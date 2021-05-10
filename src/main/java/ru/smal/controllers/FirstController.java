package ru.smal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(HttpServletRequest request){
        String name = request.getParameter("name");
        String surename = request.getParameter("surename");

        System.out.println(name + " " + surename + " " + "Hello");

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodbyePage(@RequestParam(value = "name", required = false) String name,
                              @RequestParam(value = "surename", required = false) String surename,
                              Model model){

//        System.out.println("Hello, " + name + " " + surename);
        model.addAttribute("message", "Hello, " + name + " " + surename);

        return "first/goodbye";
    }
}
