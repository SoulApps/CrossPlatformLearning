Public Class Form1
    Private Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click

        Button1.Location = New Point(CInt(((Me.Width - Button1.Width) * Rnd()) + 1), CInt(((Me.Height - Button1.Height) * Rnd()) + 1))


        'Punto fijo
        'Button1.Location = New Point(100, 100)

    End Sub

    Private Sub Button1_MouseHover(sender As Object, e As EventArgs) Handles Button1.MouseHover

        'Mover al pasar por encima
        'Button1.Location = New Point(CInt(((Me.Width - Button1.Width) * Rnd()) + 1), CInt(((Me.Height - Button1.Height) * Rnd()) + 1))

    End Sub

    Private Sub Button1_MouseMove(sender As Object, e As MouseEventArgs) Handles Button1.MouseMove

        'Hacer que huya
        If (e.X <= Button1.Width / 2 And Button1.Location.X + 1 < (Me.Width - Button1.Width)) Then
            Button1.Location = New Point(Button1.Location.X + 1, Button1.Location.Y)
        End If

        If (e.Y <= Button1.Height / 2 And Button1.Location.Y + 1 < (Me.Height - Button1.Height)) Then
            Button1.Location = New Point(Button1.Location.X, Button1.Location.Y + 1)
        End If

        If (e.X >= Button1.Width / 2 And Button1.Location.X - 1 > 0) Then
            Button1.Location = New Point(Button1.Location.X - 1, Button1.Location.Y)
        End If

        If (e.Y >= Button1.Height / 2 And Button1.Location.Y - 1 > 0) Then
            Button1.Location = New Point(Button1.Location.X, Button1.Location.Y - 1)
        End If
    End Sub
End Class
