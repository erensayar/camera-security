package com.erensayar.homecamerasecurity.component.serialCom;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import static com.erensayar.homecamerasecurity.component.serialCom.SerialCommunicationService.serialPort;

public class SerialCommunicationListener implements SerialPortDataListener {

    // CONSTANTS
    static int cutoffASCII = 10; // ASCII code of the character used for cut-off between received messages
    static String bufferReadToString = ""; // empty, but not null

    @Override
    public int getListeningEvents() {
        return SerialPort.LISTENING_EVENT_DATA_AVAILABLE;
    }

    @Override
    public void serialEvent(SerialPortEvent event) {
        byte[] buffer = new byte[event.getSerialPort().bytesAvailable()];
        event.getSerialPort().readBytes(buffer, buffer.length);
        parseByteArray(buffer);
    }

    private void parseByteArray(byte[] readBuffer) {
        String s = new String(readBuffer);
        bufferReadToString = bufferReadToString.concat(s);
        if ((bufferReadToString.indexOf(cutoffASCII) + 1) > 0) {
            String outputString = bufferReadToString.substring(0, bufferReadToString.indexOf(cutoffASCII) + 1);
            bufferReadToString = bufferReadToString.substring(bufferReadToString.indexOf(cutoffASCII) + 1); // adjust as needed to accommodate the CRLF convention ("\n\r"), ASCII 10 & 13
            System.out.println(outputString);

            if (outputString.contains("sync")) {
                setTime();
            }
        }
    }

    // Reformat Buffer
    private static void setTime() {
        String timeStamp = "T" + LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
        serialPort.writeBytes(timeStamp.getBytes(), timeStamp.length());
        System.out.println("Time set to: " + timeStamp);
    }


}