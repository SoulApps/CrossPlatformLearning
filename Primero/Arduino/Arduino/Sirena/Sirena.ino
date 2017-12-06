#define UMBRAL 1000
#define AMPLIFICA 3000

int zumbador=2;
float seno;
int frecuencia;

void setup() {
  pinMode(zumbador, OUTPUT);
}

void loop() {
  int i;
  for(i=0;i<180;i++){
    seno=sin(i*3.1416/180);
    frecuencia=UMBRAL+int(seno*AMPLIFICA);
    tone(zumbador, frecuencia);
     delay(2);
  }
}
