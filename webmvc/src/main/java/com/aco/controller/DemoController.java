package com.aco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demoController")
public class DemoController {

    @RequestMapping("/index")
    public String index(){
        return "logo";
    }
}
