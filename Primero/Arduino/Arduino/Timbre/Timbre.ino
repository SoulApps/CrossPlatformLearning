int pinSensor = 7;
int pinZumbador = 8;

void setup() {
  pinMode(pinSensor, INPUT);
  pinMode(pinZumbador, OUTPUT);
  
}

void loop() {
  int lecturaSensor = digitalRead(pinSensor);
  
  if (lecturaSensor == LOW) {
    tone(pinZumbador, 1000, 100);
    delay(100);
    }
}
