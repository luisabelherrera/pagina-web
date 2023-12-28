package ModelUsuarios;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaBD1 {
    private static final String URL = "jdbc:mysql://localhost:3306/materiasingcomp";
    private static final String USUARIO = "root";
    private static final String CONTRASEÑA = "";

    private Connection conexion;

    public ConectaBD1() {
        conectar();
    }

    private void conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
            System.out.println("Conexión exitosa a la base de datos");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error en la conexión: " + e.getMessage());
        }
    }



    public Connection getConexion() {
        return conexion;
    }

    public void cerrarConexion() {
        if (conexion != null) {
            try {
                conexion.close();
                System.out.println("Conexión cerrada");
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }}
    
  