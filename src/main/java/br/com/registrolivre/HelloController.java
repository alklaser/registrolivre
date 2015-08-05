package br.com.registrolivre;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class HelloController {

    private static final String template = "Olá, %s!";

    @RequestMapping("/")
    public Hello hello(@RequestParam(value="name", defaultValue="Júnior") String name) {
        return new Hello(String.format(template, name));
    }
}
