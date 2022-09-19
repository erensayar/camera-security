package com.erensayar.homecamerasecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

  @GetMapping(value = "/")
  public String redirectHome() {
    return "redirect:/home";
  }

  @GetMapping(value = "/home")
  public String home() {
    return "home";
  }

}
