package com.erensayar.homecamerasecurity.controller;

import com.erensayar.homecamerasecurity.service.HardwareControlServiceSerialComImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ApiController {

  private final HardwareControlServiceSerialComImpl arduinoService;

  @GetMapping(value = "/led/on")
  public ResponseEntity<String> ledOn() {
    System.out.println("LED-ON");
    arduinoService.ledOn();
    return new ResponseEntity<>("OK", HttpStatus.OK);
  }

  @GetMapping(value = "/led/off")
  public ResponseEntity<String> ledOff() {
    System.out.println("LED-OFF");
    arduinoService.ledOff();
    return new ResponseEntity<>("OK", HttpStatus.OK);
  }

  @GetMapping(value = "/motor/left")
  public ResponseEntity<String> motorTurnLeft() {
    System.out.println("MOTOR-LEFT");
    arduinoService.motorTurnLeft();
    return new ResponseEntity<>("OK", HttpStatus.OK);
  }

  @GetMapping(value = "/motor/right")
  public ResponseEntity<String> motorTurnRight() {
    System.out.println("MOTOR-RIGHT");
    arduinoService.motorTurnRight();
    return new ResponseEntity<>("OK", HttpStatus.OK);
  }

  @GetMapping(value = "/motor/all/left")
  public ResponseEntity<String> motorTurnAllLeft() {
    System.out.println("MOTOR-ALL-LEFT");
    arduinoService.motorTurnAllLeft();
    return new ResponseEntity<>("OK", HttpStatus.OK);
  }

  @GetMapping(value = "/motor/all/right")
  public ResponseEntity<String> motorTurnAllRight() {
    System.out.println("MOTOR-ALL-RIGHT");
    arduinoService.motorTurnAllRight();
    return new ResponseEntity<>("OK", HttpStatus.OK);
  }

}
