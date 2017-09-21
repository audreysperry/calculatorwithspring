package com.audreysperry.calculatorwithspring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String index(@RequestParam("firstNumber") double firstNumber,
                        @RequestParam("secondNumber") double secondNumber,
                        @RequestParam("operation") String operator,
                        Model model) {

        double result;
        if (operator.equals("+")) {
            result = firstNumber + secondNumber;

        } else if (operator.equals("-")) {
            result = firstNumber - secondNumber;
        } else if (operator.equals("/")) {
            result = firstNumber / secondNumber;
        } else {
            result = firstNumber * secondNumber;
        }
        model.addAttribute("equation", firstNumber + operator + secondNumber);
        model.addAttribute("result", result);
        return "index";

    }
}
