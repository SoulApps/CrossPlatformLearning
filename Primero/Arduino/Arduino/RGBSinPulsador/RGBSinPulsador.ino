int ledR=4;
int ledG=3;
int ledB=2;


void setup() {
  pinMode(ledR,OUTPUT);
  pinMode(ledR,OUTPUT);
  pinMode(ledR,OUTPUT);
  
}

void loop() {
  int i;
  for(i=1;i<256;i++){
     analogWrite(ledR, i);
     delay(10);
  }
  
  for(i=255;i>0;i--){
     analogWrite(ledR, i);
     delay(10);
  }
  
  for(i=1;i<256;i++){
     analogWrite(ledG, i);
     delay(10);
  }
  
  for(i=255;i>0;i--){
     analogWrite(ledG, i);
     delay(10);
  }
  
  for(i=1;i<256;i++){
     analogWrite(ledB, i);
     delay(10);
  }
  
  for(i=255;i>0;i--){
     analogWrite(ledB, i);
     delay(10);
  }
}
