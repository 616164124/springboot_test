package com.example.demo.controle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

  @RequestMapping("/View")
  public String ViewTest1() {
    System.out.println("111");

    return "test1";
  }
}
