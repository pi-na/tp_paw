package ar.edu.itba.paw.webapp.controller;

import ar.edu.itba.paw.models.User;
import ar.edu.itba.paw.persistence.UserDao;
import ar.edu.itba.paw.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HelloWorldController {

//    @Autowired        // Inyeccion de parametros por atributo
    private final UserService us;

    private UserDao userDao;

//    Inyeccion de parametros por constructor (recomendada por Sotuyo)
    @Autowired
    public HelloWorldController(final UserService us){
        this.us = us;
    }

    @RequestMapping("/")
    public ModelAndView helloWorld(){
        final ModelAndView mav = new ModelAndView("helloworld/index");
        mav.addObject("user", us.createUser("pina@itba.edu.ar", "1234"));

        return mav;
    }

    // Regex despues de los dos puntos, hace que solo matchee numeros enteros
    // Si ponemos un negativo o una string, el path proporcionado NO MATCHEA CON EL METODO,
    // devuelve 404!!!
    @RequestMapping("/user/{id:\\d+}")
    public ModelAndView profile(@PathVariable("id") final long userId){
        final ModelAndView mav = new ModelAndView("helloworld/profile");

        mav.addObject("userid", userId);
        return mav;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(@RequestParam(value = "email", required = true) final String email,
                                 @RequestParam(value = "password", required = true) final String password){
        final User user = us.createUser(email, password);

        final ModelAndView mav = new ModelAndView("helloworld/index");
        mav.addObject("user", user);
        return mav;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView registerForm(){
        return new ModelAndView("helloworld/register");
    }
}
