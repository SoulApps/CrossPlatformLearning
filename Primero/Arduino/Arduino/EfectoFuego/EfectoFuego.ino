/*
  Efecto fuego
 */
 
int led1=3;
int led2=5;
int led3=6;

void setup() {
  pinMode(led1, OUTPUT);
  pinMode(led2, OUTPUT);
  pinMode(led3, OUTPUT);
}

void loop() {
  analogWrite(led1, 135+random(120));
  analogWrite(led2, 135+random(120));
  analogWrite(led3, 135+random(120));
  
  delay(random(100));
}
