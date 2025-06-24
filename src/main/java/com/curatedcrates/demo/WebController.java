package com.curatedcrates.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class WebController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @PostMapping("/send")
    public String sendMessage(@RequestParam String name, @RequestParam String email,
                               @RequestParam String message, RedirectAttributes redirectAttributes) {

        String subject = "New message from: " + name;
        String body = "Sender Email: " + email + "\n\nMessage:\n" + message;

        emailService.sendMail(email, subject, body);
        redirectAttributes.addFlashAttribute("success", "Message sent successfully!");
        return "redirect:/contact";
    }
}
