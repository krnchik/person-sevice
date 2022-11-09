package liga.medical.personservice.core.controller.serurity;

import liga.medical.personservice.core.annotation.DbLog;
import liga.medical.personservice.core.service.security.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class AdminController {

    private final UserServiceImpl userService;

    @GetMapping("/admin")
    @DbLog
    public String userList(Model model) {
        model.addAttribute("allUsers", userService.getUsers());
        return "admin";
    }

    @PostMapping("/admin")
    @DbLog
    public String deleteUser(@RequestParam(required = true, defaultValue = "") Long userId,
                             @RequestParam(required = true, defaultValue = "") String action,
                             Model model) {
        String str = "delete";
        if (action.equals(str)) {
            userService.deleteUser(userId);
        }
        return "redirect:/admin";
    }

}
