package liga.medical.personservice.core.controller.serurity;

import liga.medical.personservice.core.annotation.DbLog;
import liga.medical.personservice.core.exception.NoUserRoleException;
import liga.medical.personservice.core.model.security.User;
import liga.medical.personservice.core.service.security.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private final UserService userService;

    private final UserValidator userValidator;

    @Autowired
    public RegistrationController(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }

    @GetMapping
    @DbLog
    public String getPage() {
        return "registration";
    }

    @PostMapping("/registration")
    @DbLog
    public String addUser(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {

        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration.jsp";
        }
        try {
            userService.save(userForm);
        } catch (NoUserRoleException e) {
            throw new RuntimeException(e);
        }
        return "redirect:/";
    }

    @GetMapping("/registration")
    @DbLog
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

}
