package com.erensayar.homecamerasecurity.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

  @Value("${camera.port}")
  private int cameraPort;

  @GetMapping(value = "/")
  public String redirectHome() {
    return "redirect:/home";
  }

  @GetMapping(value = "/home")
  public String home(Model model) {
    model.addAttribute("cameraPort", cameraPort);
    return "home";
  }

  @GetMapping(value = "/login")
  public String login() {
    return "login";
  }

}
