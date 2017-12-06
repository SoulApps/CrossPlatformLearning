int zumbador=8;
int ldr=0;
int valorLDR=0;

void setup() {
  Serial.begin(9600);

}

void loop() {
  valorLDR=analogRead(ldr);
  Serial.println(valorLDR);
  tone(zumbador, 1000);
  delay(25);
  noTone(zumbador);
  delay(valorLDR);

}
