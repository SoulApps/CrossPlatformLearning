int ledR=6;
int ledG=3;
int ledB=5;
int pulsador=8;

// Variables para guardar el color actual.
int valorR;
int valorG;
int valorB;

void setup() {
  pinMode(ledR, OUTPUT);
  pinMode(ledG, OUTPUT);
  pinMode(ledB, OUTPUT);
  pinMode(pulsador, INPUT);
  
}

void loop() {
  int lecturaBoton=digitalRead(pulsador);
  
  if(lecturaBoton==HIGH){
    valorR=random(255);
    valorG=random(255);
    valorB=random(255);  
    
    analogWrite(ledR, valorR);
    analogWrite(ledG, valorG);
    analogWrite(ledB, valorB);
    
    delay(1000);
  }

}
