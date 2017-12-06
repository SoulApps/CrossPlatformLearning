int zumbador=8;
void setup() {
  pinMode(zumbador, OUTPUT);

  Serial.begin(9600);
}

void loop() {
 tone(zumbador, 1000, 100);
 Serial.println("Pi");
 delay(1000);
}
