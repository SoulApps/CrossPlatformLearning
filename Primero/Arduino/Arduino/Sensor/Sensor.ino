int sensor=2;
int zumbador=8;

void setup() {
 pinMode(sensor, INPUT);
 pinMode(zumbador, OUTPUT);
 Serial.begin(9600);
}

void loop() {
  int lecturaSensor=digitalRead(sensor);
  if(lecturaSensor==HIGH){
    tone(zumbador, 1000, 100);
    Serial.println("No me toques");
    delay(100);
   } 

}
