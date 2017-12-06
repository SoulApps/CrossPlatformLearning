/*
  Contador binario
 */

int led0=13;
int led1=12;

// the setup function runs once when you press reset or power the board
void setup() {
  // initialize digital pin 13 as an output.
  pinMode(led0, OUTPUT);
  pinMode(led1, OUTPUT);
}

// the loop function runs over and over again forever
void loop() {
  //0
  digitalWrite(led0, LOW);   // turn the LED on (HIGH is the voltage level)
  digitalWrite(led1, LOW);
  delay(1000);              // wait for a second
  
  //1
  digitalWrite(led0, HIGH);
  digitalWrite(led1, LOW);    // turn the LED off by making the voltage LOW
  delay(1000);              // wait for a second
  
  //2
  digitalWrite(led0, LOW);
  digitalWrite(led1, HIGH);
  delay(1000);
  
  //3
  digitalWrite(led0, HIGH);
  digitalWrite(led1, HIGH);
  delay(1000);
}
