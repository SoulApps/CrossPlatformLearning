/*
  Pulsador parpadear 3 veces
*/

int pulsador=7;
int led=13;
int pulsado;

void setup() {
  pinMode(led, OUTPUT);
  pinMode(pulsador, INPUT);

}

void loop() {
  pulsado=digitalRead(pulsador);
  if (pulsado==HIGH){
    digitalWrite(led, HIGH);
    delay(1000);
    digitalWrite(led, LOW);
    delay(1000);
    digitalWrite(led, HIGH);
    delay(1000);
    digitalWrite(led, LOW);
    delay(1000);
    digitalWrite(led, HIGH);
    delay(1000);
    digitalWrite(led, LOW);
    delay(1000);
  } else{
    digitalWrite(led, LOW);  
  }
}
