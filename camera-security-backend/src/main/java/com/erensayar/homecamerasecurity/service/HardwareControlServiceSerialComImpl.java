package com.erensayar.homecamerasecurity.service;

import com.erensayar.homecamerasecurity.component.serialCom.SerialCommunicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service("ArduinoServiceSerialComImpl")
public class HardwareControlServiceSerialComImpl implements HardwareControlService {

  // CONSTANTS
  private static final String MOTOR_TURN_LEFT_CODE = "1";
  private static final String MOTOR_TURN_RIGHT_CODE = "2";
  private static final String MOTOR_TURN_ALL_LEFT_CODE = "3";
  private static final String MOTOR_TURN_ALL_RIGHT_CODE = "4";
  private static final String LED_TURN_ON_CODE = "5";
  private static final String LED_TURN_OFF_CODE = "6";

  // DEPENDENCIES
  private final SerialCommunicationService serialCommunicationService;

  @Override
  public void motorTurnLeft() {
    serialCommunicationService.sendDataToFirstAvailableComPorts(MOTOR_TURN_LEFT_CODE);
  }

  @Override
  public void motorTurnRight() {
    serialCommunicationService.sendDataToFirstAvailableComPorts(MOTOR_TURN_RIGHT_CODE);
  }

  @Override
  public void motorTurnAllLeft() {
    serialCommunicationService.sendDataToFirstAvailableComPorts(MOTOR_TURN_ALL_LEFT_CODE);
  }

  @Override
  public void motorTurnAllRight() {
    serialCommunicationService.sendDataToFirstAvailableComPorts(MOTOR_TURN_ALL_RIGHT_CODE);
  }

  @Override
  public void ledOn() {
    serialCommunicationService.sendDataToFirstAvailableComPorts(LED_TURN_ON_CODE);
  }

  @Override
  public void ledOff() {
    serialCommunicationService.sendDataToFirstAvailableComPorts(LED_TURN_OFF_CODE);
  }

}
