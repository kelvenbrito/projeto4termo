package com.example.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    
    //método
    @GetMapping("/")
    public ModelAndView abrirIndex() {
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }
    @GetMapping("/home")
    public ModelAndView homeIndex() {
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }
    
    @GetMapping("/cad-usuario")//endereço da pagina no site
    public ModelAndView abrirCadAdm() {
        ModelAndView mv = new ModelAndView("usuario/cad-usuario");
        return mv;
    
    }

}

