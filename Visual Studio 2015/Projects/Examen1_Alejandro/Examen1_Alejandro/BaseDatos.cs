using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.SqlClient;

namespace Examen1_Alejandro
{
    class BaseDatos
    {
        private static SqlConnection conexion;
        private static SqlCommand comando;

        public static void abrirConexion()
        {
            conexion = new SqlConnection();
            conexion.ConnectionString = @"Data Source = (LocalDB)\MSSQLLocalDB; AttachDbFilename = C:\Users\ale_z\OneDrive\Documentos\BDDExamen.mdf; Integrated Security = True; Connect Timeout = 30";
            comando = new SqlCommand();

            conexion.Open();
        }

        public static void cerrarConexion()
        {
            conexion.Close();
        }

        public static int contarFilas(string select)
        {
            comando.CommandText = select;
            comando.CommandType = System.Data.CommandType.Text;
            comando.Connection = conexion;
            return (int)comando.ExecuteScalar();
        }

        public static SqlDataReader buscarDatos(string select)
        {
            comando.CommandText = select;
            comando.CommandType = System.Data.CommandType.Text;
            comando.Connection = conexion;
            return comando.ExecuteReader();
        }

        public static void insertar(string insert)
        {
            comando.CommandText = insert;
            comando.CommandType = System.Data.CommandType.Text;
            comando.Connection = conexion;
            comando.ExecuteNonQuery();
        }
    }
}
