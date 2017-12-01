package br.com.fean.si.es2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/")
@Controller
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String home() {
        return "index.html";
    }

    @ResponseBody
    @RequestMapping(value = "info", method = RequestMethod.GET)
    public String info() {
        return "v0.1";
    }

}