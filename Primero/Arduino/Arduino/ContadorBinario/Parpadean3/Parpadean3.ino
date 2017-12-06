/*
  Parpadear 3
 */

int led0=13;
int led1=12;
int led2=11;

// the setup function runs once when you press reset or power the board
void setup() {
  // initialize digital pin 13 as an output.
  pinMode(led0, OUTPUT);
  pinMode(led1, OUTPUT);
  pinMode(led2, OUTPUT);
}

// the loop function runs over and over again forever
void loop() {
  //paso 1
  digitalWrite(led0, HIGH);   // turn the LED on (HIGH is the voltage level)
  digitalWrite(led1, LOW);
  digitalWrite(led2, LOW);
  delay(1000);              // wait for a second
  
  //paso 2
  digitalWrite(led0, LOW);   // turn the LED on (HIGH is the voltage level)
  digitalWrite(led1, HIGH);
  digitalWrite(led2, LOW);
  delay(1000);              // wait for a second
  
  digitalWrite(led0, LOW);
  digitalWrite(led1, LOW);
  digitalWrite(led2, HIGH);
  delay(1000);
 }
