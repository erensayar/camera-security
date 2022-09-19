#include <Servo.h>

Servo srv;

//PINS
int LED_PIN=12;
int SERVO_PIN=11;

// CONSTANTS
String MOTOR_TURN_LEFT_CODE = "1";
String MOTOR_TURN_RIGHT_CODE = "2";
String MOTOR_TURN_ALL_LEFT_CODE = "3";
String MOTOR_TURN_ALL_RIGHT_CODE = "4";
String LED_TURN_ON_CODE = "5";
String LED_TURN_OFF_CODE = "6";

// COUNTER 
int SERVO_COUNTER=0;


void setup(){
  Serial.begin(9600);
  srv.attach(SERVO_PIN);
  pinMode(LED_PIN, OUTPUT);
}


void loop(){
  Serial.println("Enter data:");
  while (Serial.available() == 0) {}    //wait for data available
  String inpStr = Serial.readString();  //read until timeout
  inpStr.trim();                        // remove any \r \n whitespace at the end of the String
  
  if (inpStr == MOTOR_TURN_LEFT_CODE) {
    Serial.println("Turn Left");
    turnLeft();
  } 
  else if (inpStr == MOTOR_TURN_RIGHT_CODE) {
    Serial.println("Turn Right");
    turnRight();
  }
  else if (inpStr == MOTOR_TURN_ALL_LEFT_CODE) {
    Serial.println("Turn All The Way To The Left");
    SERVO_COUNTER = 0;
    turnLeft();
  }
  else if (inpStr == MOTOR_TURN_ALL_RIGHT_CODE) {
    Serial.println("Turn All The Way To The Right");
    SERVO_COUNTER = 180;
    turnRight();
  }
  else if (inpStr == LED_TURN_ON_CODE){
    digitalWrite(LED_PIN, HIGH);
  } 
  else if (inpStr == LED_TURN_OFF_CODE){
    digitalWrite(LED_PIN, LOW);
  } 
  else {
    Serial.println("You can enter '1 for turnRight' or '2 for turnLeft' ");
    Serial.println("You can enter '3 for ledOn' or '4 for ledOff' ");
  }

  Serial.read();
}

void turnRight(){
  SERVO_COUNTER += 30;
  Serial.println(SERVO_COUNTER);
  if (SERVO_COUNTER > 180){
    SERVO_COUNTER = 180;
  }
  Serial.println(SERVO_COUNTER);
  srv.write(SERVO_COUNTER);
  delay(25);
}

void turnLeft(){
  SERVO_COUNTER -= 30;
  Serial.println(SERVO_COUNTER);
  if (SERVO_COUNTER < 0){
    SERVO_COUNTER = 0;
  }
  Serial.println(SERVO_COUNTER);
  srv.write(SERVO_COUNTER);
  delay(25);
}
