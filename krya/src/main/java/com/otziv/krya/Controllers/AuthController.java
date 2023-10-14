package com.otziv.krya.Controllers;

import com.otziv.krya.domain.entity.ApplicationUser;
import com.otziv.krya.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    @GetMapping("/login")
    public String getLoginPage() {

        return "login";
    }

    @GetMapping("/success")
    public String getSuccessPage() {
        return "success";
    }
    private final UserRepository userRepository;
    @GetMapping(path="/all")
    public @ResponseBody Iterable<ApplicationUser> getAllUsers() {
        // This returns a JSON or XML with the users

        return userRepository.findAll();
    }
}
