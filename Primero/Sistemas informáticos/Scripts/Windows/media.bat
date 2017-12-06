 @echo off
 ::Media

 ::Mensaje de error
 if "%1"=="" (
	echo MED m1.m2.m3.m4.m5
	exit /B 1
	)
	
::Declaración de variables
for /F "tokens=1-5 delims=." %%a in ("%1") do ( 
		set m1=%%a
		set m2=%%b
		set m3=%%c
		set m4=%%d
		set m5=%%e
		)
		
::Programa		
set /a result=(m1+m2+m3+m4+m5)/5

echo Media: %result%

exit /B 0