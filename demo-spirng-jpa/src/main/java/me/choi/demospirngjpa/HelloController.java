package me.choi.demospirngjpa;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * 010 - 8452 - 0206
 * Project : demo-spirng-jpa
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 11:48 오전
 */
@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!");

        return "hello";
    }
}
