package ru.smal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class CalculatorController {

    @GetMapping("/calculator")
    public String calculator(HttpServletRequest request, Model model){
        String a = request.getParameter("a");
        String b = request.getParameter("b");
        String action = request.getParameter("action");

        int result = 0;

        if(action != null && action.equals("multiplication")){
            result = Integer.parseInt(a) * Integer.parseInt(b);
        }
        if(action != null && action.equals("addition")){
            result = Integer.parseInt(a) + Integer.parseInt(b);
        }
        if(action != null && action.equals("subtraction")){
            result = Integer.parseInt(a) - Integer.parseInt(b);
        }
        if(action != null && action.equals("division")){
            if(Integer.parseInt(b) != 0){
                result = Integer.parseInt(a) / Integer.parseInt(b);
            } else
                result = 0;
        }

        model.addAttribute("calculator", a + " " + getSignOperation(action) + " " + b + " = " + result);


        return "first/calculator";
    }

    public String getSignOperation(String operation){

        return switch (operation){
            case "multiplication" -> "*";
            case "addition" -> "+";
            case "subtraction" -> "-";
            case "division" -> "/";
            default -> "sign not found";
        };
    }
}
