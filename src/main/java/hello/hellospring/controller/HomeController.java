package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")                // "/" 는 로컬 8080 들어오면 바로 호출됨
    public String home() {
        return "home";
    }
}
