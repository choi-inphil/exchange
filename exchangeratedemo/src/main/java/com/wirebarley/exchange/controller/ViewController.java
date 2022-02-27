package com.wirebarley.exchange.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * View controller
 * @author ipchoi
 *
 */
@Controller
public class ViewController {

    @RequestMapping("/")
    public String main(){
        return "index";
    }
}
