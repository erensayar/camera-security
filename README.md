# What Repository For

This project provide live video stream, you can turn on light for clear vision with button on home page and you can turn the camera for see on other angles. Everything is in real time. 

# How It Works

Web module provide live video stream and controll the camera and light. To do this need communication java and arduino. I solved this problem with serial communication. I use jSerialComm library for Java. (First i used Firmata but i cant control servo with firmata.Then i choosed serial communication.) 

# Used Technologies

* Java
* Spring Boot
* JSerialComm
* Thymeleaf
* Vanilla JS
* Firmata (Canceled. Firmata codes put in the comment line as a note)
* Arduino
* Servo motor
* Digital Camera
* Led

# Requirements For Start The Project

## BE Requirements 

* Java 8 or higher
* Maven

## Hardware Requirements

* Arduino
* Digital Camera
* Servo Motor
* Led
* Resistance For Led

## Common Requirements

* Arduino port be suitable for connection, i mean port shouldn't used by another program.
* Set Camera Name on code. (You need read the code and need understand relevant place)

# Home Page 

![Home](/doc/home.png)




Firmata
---

! Firmata Removed For This Project, but there is still for as note.

You should upload firmata code to arduino.

Open Arduino IDE > Select Your Arduino Port > Examples >  Firmata > Standart Firmata > Upload Code To Arduino
