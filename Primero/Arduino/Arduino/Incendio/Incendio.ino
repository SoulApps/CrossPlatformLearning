#define UMBRALSENSOR 10
#define FRECMINIMA 2000
#define AMPLIFICACION 1000

int zumbador=8;
int tono;
float seno;

void setup() {
  Serial.begin(9600);
  pinMode(zumbador, OUTPUT);
}

void loop() {
  int lecturaSensor = analogRead(0);
  Serial.println(lecturaSensor);
  
  if (lecturaSensor>UMBRALSENSOR){
    int i;
    for (i=0;i<180;i++){
      seno = sin(i*3.1415/180);
      tono = FRECMINIMA+int(seno*AMPLIFICACION);
      tone(zumbador, tono);
      delay(2);
    }
  } else{
    noTone(zumbador);
    delay(100);
  }

}
