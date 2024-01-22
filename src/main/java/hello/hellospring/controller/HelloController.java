package hello.hellospring.controller;

import io.micrometer.observation.transport.Propagator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody                       // http 안에 <body> 안에 이 데이터를 직접 넣겠다는 뜻
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;         // 직접열어보면 html 구조가 하나도 없이 이 리턴값 그대로 나옴
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;                   // JSON 방식으로 나옴
    }
                                        //  String 대신에 Hello 라는 객체 를 넣음
    static class Hello {
        private String name;
                            // Alt + Insert = getter, setter 등 만들기 단축키
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


}
