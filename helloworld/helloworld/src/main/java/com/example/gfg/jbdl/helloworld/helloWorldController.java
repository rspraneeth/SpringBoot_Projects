package com.example.gfg.jbdl.helloworld;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloWorldController {
    @RequestMapping("/")
    public String hello()
    {
        return "Hello User";
    }
}
