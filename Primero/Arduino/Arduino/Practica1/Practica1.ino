int sensor=2;
int ledR=8;
int ledG=9;
int ledB=10;

int valorR;
int valorG;
int valorB;

void setup() {
  pinMode(ledR, OUTPUT);
  pinMode(ledG, OUTPUT);
  pinMode(ledB, OUTPUT);
  pinMode(sensor, INPUT);

}

void loop() {
  int lecturaSensor=digitalRead(sensor);
  if(lecturaSensor==LOW){
     valorR=random(255);  
     valorG=random(255);  
     valorB=random(255);  
     
     analogWrite(ledR, valorR);
     analogWrite(ledG, valorG);
     analogWrite(ledB, valorB);
     
     delay(300);
     
  } 

}
