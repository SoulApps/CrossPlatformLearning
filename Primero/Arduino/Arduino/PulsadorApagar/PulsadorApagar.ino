/*
  Pulsador para apagar
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
    digitalWrite(led, LOW);
    delay(5000);
  } else{
    digitalWrite(led, HIGH);  
  }
}
