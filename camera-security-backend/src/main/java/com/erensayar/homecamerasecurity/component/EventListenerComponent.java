package com.erensayar.homecamerasecurity.component;

import com.erensayar.homecamerasecurity.component.serialCom.SerialCommunicationService;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamStreamer;
import java.awt.Dimension;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class EventListenerComponent {

  // Dependencies
  private final SerialCommunicationService serialCommunicationService;

  // Constants
  @Value("${camera.port}")
  private int cameraPort;
  private static final String WEBCAM_SHORT_NAME = "LifeCam";

  @EventListener(ApplicationStartedEvent.class)
  public void initialize() {

    // Open Communication Port
    // <===============================================================>
    serialCommunicationService.openComPort();

    // Listen Arduino Messages
    // <===============================================================>
    //serialCommunicationService.listenFirstAvailableComPorts();

    // Camera
    // <===============================================================>
    String webcamFullName = null;
    List<Webcam> webcams = Webcam.getWebcams();
    for(Webcam ws: webcams){
      System.out.println(ws.getDevice().getName());
      if (ws.getDevice().getName().contains(WEBCAM_SHORT_NAME)) {
        webcamFullName = ws.getDevice().getName();
      }
    }
    if (webcamFullName == null) {
      webcamFullName = webcams.get(0).getDevice().getName();
    }
    //Webcam w = Webcam.getDefault();
    //Webcam w = Webcam.getWebcamByName(webcamFullName); // Linux : USB2.0 PC CAMERA /dev/video2 // Win : USB2.0 PC CAMERA 1
    Webcam w = Webcam.getWebcamByName("Microsoft® LifeCam HD-3000: Mi /dev/video2"); // Linux : USB2.0 PC CAMERA /dev/video2 // Win : USB2.0 PC CAMERA 1
    w.setViewSize(new Dimension(640, 480));
    new WebcamStreamer(cameraPort, w, 30, true);
    do {
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    } while (true);

  }

}
