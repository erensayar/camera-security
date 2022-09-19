package com.erensayar.homecamerasecurity.service;
/*
import java.io.IOException;

@RequiredArgsConstructor
@Service
public class ArduinoServiceFirmataImpl implements ArduinoService {

    private static final int LED_PIN = 12;
    private static final int MOTOR_PIN = 11;

    private final IODevice device;

    @Override
    public void ledOn() {
        try {
            Pin pin = device.getPin(LED_PIN);
            pin.setMode(Pin.Mode.OUTPUT);
            pin.setValue(1);
            //device.stop();
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    @Override
    public void ledOff() {
        try {
            Pin pin = device.getPin(LED_PIN);
            pin.setMode(Pin.Mode.OUTPUT);
            pin.setValue(0);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    // Doesn't Work
    @Override
    public void motorTurnLeft() {
        try {
            Pin pin = device.getPin(MOTOR_PIN);
            pin.setServoMode(160,20);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    // Doesn't Work
    @Override
    public void motorTurnRight() {
        try {
            Pin pin = device.getPin(MOTOR_PIN);
            pin.setServoMode(20,160);
        } catch (IOException e) {
            System.out.println(e);
        }
    }


}
 */