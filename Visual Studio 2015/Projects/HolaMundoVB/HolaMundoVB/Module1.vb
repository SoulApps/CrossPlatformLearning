Module Module1

    Sub Main()


        Dim salir As Boolean
        Dim pregunta As String

        Do
            Console.ForegroundColor = ConsoleColor.Cyan
            'Console.BackgroundColor = ConsoleColor.Blue
            Console.WriteLine("Hello World!")


            For i As Integer = 0 To 2
                Console.Beep(1000, 1000)
                Console.Beep(2000, 1000)
                Console.Beep(3000, 1000)

                For j As Integer = 0 To 2
                    Console.Beep(500, 500)
                    Beep()
                Next

            Next

            Console.WriteLine("¿Quieres salir?")
            pregunta = Console.ReadLine().ToLower()

            If (pregunta = "si") Then
                salir = True
            End If

        Loop Until salir
    End Sub

End Module
