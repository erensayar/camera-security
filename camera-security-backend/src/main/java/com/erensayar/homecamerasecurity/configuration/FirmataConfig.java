package com.erensayar.homecamerasecurity.configuration;

import org.springframework.context.annotation.Configuration;

@Configuration
public class FirmataConfig {

  private static final String PORT_NAME = "COM3";

  // Firmata Device Instance
  // @Bean
  // public IODevice deviceInitialize() throws IOException, InterruptedException {
  //     IODevice device = new FirmataDevice(PORT_NAME);
  //     device.start(); // initiate communication to the device
  //     device.ensureInitializationIsDone(); // wait for initialization is done
  //     return device;
  // }

}
