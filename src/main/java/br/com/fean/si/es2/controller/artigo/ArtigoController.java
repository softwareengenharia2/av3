package br.com.fean.si.es2.controller.artigo;

import br.com.fean.si.es2.business.ArtigoService;
import br.com.fean.si.es2.dto.ArtigoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("artigo")
public class ArtigoController {

    @Autowired
    private ArtigoService artigoService;

    private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    @RequestMapping("/todos")
    public ModelAndView listarTodos() {
        ModelAndView view = new ModelAndView("artigo/artigos.jsp");
        view.addObject("artigos", artigoService.artigos());
        return view;
    }

    @RequestMapping("/cadastro")
    public String cadastro(@ModelAttribute("artigo") ArtigoDTO artigoDTO, ModelMap model) {
        Date date = new Date();
        model.addAttribute("data", dateFormat.format(date));
        return "artigo/cadastro.jsp";
    }


    @RequestMapping("/save")
    public String save(@Valid @ModelAttribute("artigo") ArtigoDTO artigoDTO, RedirectAttributes attr) {
        artigoService.add(artigoDTO);
        return "redirect:/artigo/todos";
    }

    @RequestMapping("/update/{id}")
    public ModelAndView preUpdate(@PathVariable("id") Long id, ModelMap model) {
        ArtigoDTO artigoDTO = artigoService.findById(id);
        model.addAttribute("artigo", artigoDTO);
        model.addAttribute("data", dateFormat.format(artigoDTO.getData()));
        return new ModelAndView("/artigo/cadastro.jsp", model);
    }

    @RequestMapping("/update")
    public ModelAndView update(@ModelAttribute("artigo") ArtigoDTO artigoDTO) {
        artigoService.update(artigoDTO);
        return new ModelAndView("redirect:/artigo/todos");
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        artigoService.remove(id);
        return "redirect:/artigo/todos";
    }


}
