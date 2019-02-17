package app.controllers;

import app.services.UserService;
import app.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.SQLException;
import java.util.List;

@Controller
public class ListServlet{

    private static final Logger logger = LoggerFactory.getLogger(ListServlet.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showAllUsers (Model model) {
        logger.debug("showAllUsers()");

        try {
            List<User> users = userService.findAllUser();
            model.addAttribute("users", users);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "/list";
    }

    @RequestMapping (value = "/list/{id}/delete", method = RequestMethod.POST)
    public String deleteUser (@PathVariable("id") Integer id, RedirectAttributes redirectAttributes){

        User user=null;
        try {
            user = userService.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        redirectAttributes.addFlashAttribute("dlt", "User "+user.getName()+" sucsesfully deleted !");

        logger.debug("Delete user : {}", user);
        return "redirect:/list";
    }

    @RequestMapping (value = "/list/{id}/update", method = RequestMethod.GET)
    public String updateUser (@PathVariable("id")Integer id, Model model){
        User user=null;
        try {
            user=userService.findUserById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        model.addAttribute(user);
        model.addAttribute("frameworksList", AddServlet.frameworksList );
        model.addAttribute("skillsList", AddServlet.skillsList );
        model.addAttribute("countrysList", AddServlet.countrysList );

        logger.debug("Show updateUserForm : {}", user);
        return "/add";
    }

    @RequestMapping (value = "/list/{id}", method = RequestMethod.GET)
    public String showUser (@PathVariable("id") Integer id, Model model){
        User user=null;
        try {
            user = userService.findUserById(id);
            model.addAttribute("user", user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        logger.debug("Show user : {}", user);
        return "show";
    }
}
