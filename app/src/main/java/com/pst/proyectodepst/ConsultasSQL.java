package com.pst.proyectodepst;

import android.app.Activity;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConsultasSQL extends Activity{

    public ConsultasSQL() {
    }

    public boolean conectarMySQL(){
        boolean estadoConexion = false;
        Connection conexionMySQL = null;

        String driver = "com.mysql.jdbc.Driver";
        String urlMySQL = "jdbc:mysql://" + "smartqr-server.database.windows.net" + ":" + "4403" + "/";
        try{
            //Cargamos el driver del conector JDBC
            Class.forName(driver).newInstance ();
            //Establecemos la conexión con el Servidor MySQL indicándole como parámetros la url construida,
            //la Base de Datos a la que vamos a conectarnos, y el usuario y contraseña de acceso al servidor
            conexionMySQL = DriverManager.getConnection(urlMySQL + "SmartQR-Database", "administrador", "Smartqr99");
            //Comprobamos que la conexión se ha establecido
            if(!conexionMySQL.isClosed())
            {
                estadoConexion = true;
                Toast.makeText(this,"Conexión Establecida", Toast.LENGTH_LONG).show();
            }
        }catch(Exception ex)
        {
            Toast.makeText(this,"Error en la conexión:" + ex.getMessage(), Toast.LENGTH_LONG).show();
        }
        finally
        {
            try {
                conexionMySQL.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }

        return estadoConexion;
    }
    public void login(String user, String pass){
        try {
            if (user.isEmpty()||pass.isEmpty()){
                Toast.makeText(this,"Error en las credenciales, intente de nuevo",Toast.LENGTH_SHORT).show();
            }else {
                String driver = "com.mysql.jdbc.Driver";
                String urlMySQL = "jdbc:mysql://" + "smartqr-server.database.windows.net" + ":" + "4403" + "/";
                Class.forName(driver).newInstance();
                Connection con = DriverManager.getConnection(urlMySQL + "SmartQR-Database","administrador","Smartqr99");
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("");
                String resultadoSQL = "";
                Integer numColumnas = 0;

                //Variable que almacenará el número de columnas obtenidas de la consulta Transact-SQL
                numColumnas = rs.getMetaData().getColumnCount();

                //Búcle encargado de recorrer y mostrar los resultados a partir de la consulta ejecutada
                while (rs.next())
                {
                    for (int i = 1; i <= numColumnas; i++)
                    {
                        if (rs.getObject(i) != null)
                        {
                            if (resultadoSQL != "")
                                if (i < numColumnas)
                                    resultadoSQL = resultadoSQL + rs.getObject(i).toString() + ";";
                                else
                                    resultadoSQL = resultadoSQL + rs.getObject(i).toString();
                            else
                            if (i < numColumnas)
                                resultadoSQL = rs.getObject(i).toString() + ";";
                            else
                                resultadoSQL = rs.getObject(i).toString();
                        }
                        else
                        {
                            if (resultadoSQL != "")
                                resultadoSQL = resultadoSQL + "null;";
                            else
                                resultadoSQL = "null;";
                        }
                    }
                    resultadoSQL = resultadoSQL + "n";
                }
                st.close();
                rs.close();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
