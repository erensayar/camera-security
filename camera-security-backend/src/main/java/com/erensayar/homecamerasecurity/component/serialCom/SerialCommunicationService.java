package com.erensayar.homecamerasecurity.component.serialCom;

import com.fazecast.jSerialComm.SerialPort;
import java.io.PrintWriter;
import org.springframework.stereotype.Service;

@Service
public class SerialCommunicationService {

  public static SerialPort serialPort;
  //private static final String SERIAL_PORT_NAME = "COM3"; // COM3 - /dev/ttyUSB0

  // LISTEN
  // <=========================================================================>
  public void listenFirstAvailableComPorts() {
    System.out.println("Opened the first available serial port: " + serialPort.getDescriptivePortName());
    SerialCommunicationListener listenerObject = new SerialCommunicationListener();
    serialPort.addDataListener(listenerObject);
  }

  // SEND
  // <=========================================================================>
  public void sendDataToFirstAvailableComPorts(String dataToBeSent) {
    PrintWriter out = new PrintWriter(serialPort.getOutputStream(), true);
    out.println(dataToBeSent);
    out.flush();
  }

  // COMMON
  // <=========================================================================>
  private SerialPort[] getAllAvailableComPorts() {
    SerialPort[] allAvailableComPorts = SerialPort.getCommPorts();
    for (SerialPort eachComPort : allAvailableComPorts)
      System.out.println("List of all available serial ports: " + eachComPort.getDescriptivePortName());
    return allAvailableComPorts;
  }

  public void openComPort() {
    serialPort = getAllAvailableComPorts()[0];
    serialPort.setComPortParameters(9600, 8, 1, 0);  // default connection settings for Arduino
    serialPort.setComPortTimeouts(SerialPort.TIMEOUT_NONBLOCKING, 0, 0);
    //serialPort.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0); // block until bytes can be written

    if (serialPort.openPort()) {
      System.out.println("Port is open :)");
    } else {
      System.out.println("Failed to open port :(");
    }
  }

  public void closeComPort() {
    if (serialPort.closePort()) {
      System.out.println("Port is closed :)");
    } else {
      System.out.println("Failed to close port :(");
    }
  }

}
