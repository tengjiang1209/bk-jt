package com.teng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BkController {

    @RequestMapping(value = "index")
    public String index(){
        return "index";
    }


}