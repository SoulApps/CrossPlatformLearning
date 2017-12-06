using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HolaMundoCSharp
{
    class Program
    {
        static void Main(string[] args)
        {
            int i, j;
            Boolean salir = false;
            string pregunta;

            do {
                Console.ForegroundColor = ConsoleColor.Cyan;
                /*Console.BackgroundColor = ConsoleColor.Blue*/
                Console.WriteLine("Hello World!");


                for (i = 0; i < 5; i++)
                {
                    Console.Beep(1000, 1000);
                    Console.Beep(2000, 1000);
                    Console.Beep(3000, 1000);

                    for (j = 0; j < 2; j++)
                        Console.Beep(500, 500);
                }

                Console.WriteLine("¿Quieres salir?");
                pregunta = Console.ReadLine();
            
                if (pregunta == "Si" || pregunta == "si")
                    salir = true;
            
            } while (!salir);

            

        }
    }
}
