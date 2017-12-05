package br.com.fean.si.es2.controller.gestor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/Gestao")
public class GestaoController {

    @RequestMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login/login.jsp");
    }

    @RequestMapping("/inicio")
    public ModelAndView home() {
        return new ModelAndView("inicio/inicio.jsp");
    }

}
