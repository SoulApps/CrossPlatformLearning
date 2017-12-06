/*
  Efecto fuego con define
 */

#define BRILLOMINIMO 135 
#define BRILLOVARIALBLE 120
#define ESPERA 100
int led1=3;
int led2=5;
int led3=6;

void setup() {
  pinMode(led1, OUTPUT);
  pinMode(led2, OUTPUT);
  pinMode(led3, OUTPUT);
}

void loop() {
  analogWrite(led1, BRILLOMINIMO+random(BRILLOVARIALBLE));
  analogWrite(led2, BRILLOMINIMO+random(BRILLOVARIALBLE));
  analogWrite(led3, BRILLOMINIMO+random(BRILLOVARIALBLE));
  
  delay(random(ESPERA));
}
