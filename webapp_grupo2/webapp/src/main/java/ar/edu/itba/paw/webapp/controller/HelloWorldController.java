package ar.edu.itba.paw.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {

    @RequestMapping("/")
    public ModelAndView helloWorld(){
        final ModelAndView mav = new ModelAndView("helloworld/index");
        mav.addObject("username", "PAW");

        return mav;
    }

    @RequestMapping("/bye")
    public ModelAndView bye(){
        return new ModelAndView("byebye/index");
    }
}
