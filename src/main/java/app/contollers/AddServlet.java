package app.contollers;

import app.services.UserService;
import app.services.UserServiceImpl;
import app.entities.User;
import app.validator.UserFormValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class AddServlet{
    private static final Logger logger = LoggerFactory.getLogger(AddServlet.class);

    @Autowired
    private UserService userService;

    @Autowired
    UserFormValidator userFormValidator;

    @InitBinder
    protected void initBinder (WebDataBinder binder){
        binder.setValidator(userFormValidator);
    }

    @RequestMapping (value = "/", method = RequestMethod.GET)
    public String index (){
        logger.debug("index()");
        return "/index";
    }

    @RequestMapping ( value = "/add", method = RequestMethod.GET)
    public String showAddUserForm(Model model){
        logger.debug("showAddUserForm()");
        model.addAttribute("user", new User());
        model.addAttribute("frameworksList", frameworksList );
        model.addAttribute("skillsList", skillsList );
        model.addAttribute("countrysList", countrysList );
        return "/add";
    }

    @RequestMapping (value = "/checkUser", method = RequestMethod.POST)
    public String addOrUpdateUser (@ModelAttribute("user") User user, Model model, BindingResult result, RedirectAttributes redirect) throws SQLException {
        logger.debug("addOrUpdateUser() : {}", user);
        if (result.hasErrors()){
            model.addAttribute("frameworksList", frameworksList );
            model.addAttribute("skillsList", skillsList );
            model.addAttribute("countrysList", countrysList );
            return "/add";
        }
        else {
            if (user.isNew()) {
                userService.save(user);
                redirect.addFlashAttribute("msg", "User " + user.getName() + " aded sucsesfully!");
            } else {
                userService.update(user);
                redirect.addFlashAttribute("msg", "User " + user.getName() + " updated sucsesfully!");
            }

            return "redirect:/list";
        }
    }
    public static ArrayList<String> frameworksList;
    public   static ArrayList<String> skillsList;
    public static Map<String, String> countrysList;

    static {
        frameworksList = new ArrayList<String>();
        frameworksList.add("Spring");
        frameworksList.add("Struts");
        frameworksList.add("Grails");
        frameworksList.add("JSF");
        frameworksList.add("Bootstrap");
        frameworksList.add("Angular");

        skillsList = new ArrayList<String>();
        skillsList.add("Java EE");
        skillsList.add("Hibernate ORM");
        skillsList.add("Spring data JPA");
        skillsList.add("REST/SOAP");
        skillsList.add("Maven");
        skillsList.add("Gradle");
        skillsList.add("HTML");
        skillsList.add("CSS");
        skillsList.add("React");
        skillsList.add("SQL");

        countrysList = new HashMap<String, String>();
        countrysList.put("RU", "Russian Federation");
        countrysList.put("KA", "Kazakhstan");
        countrysList.put("UA", "Ukraine");
        countrysList.put("US", "United States");
        countrysList.put("CA", "Canada");
    }
}
