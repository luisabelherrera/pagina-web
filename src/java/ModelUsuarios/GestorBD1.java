package ModelUsuarios;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import ModelUsuarios.ConectaBD1;
import java.sql.Statement;
import ModelUsuarios.Uea1;


public class GestorBD1 {

 private Connection conexion = null;
    private ResultSet ueaResultSet;
    private String id,username, password, rol;
    private Statement stm;

    public ArrayList<Uea1> leerUeas1() {
        ArrayList<Uea1> ueas1 = new ArrayList<Uea1>();
        try {
            ConectaBD1 conectaBD = new ConectaBD1();
            conexion = conectaBD.getConexion();
            PreparedStatement stm = null;
            ResultSet ueaResultSet = null;

            try {
                stm = conexion.prepareStatement("select * from usuarios");
                ueaResultSet = stm.executeQuery();

                if (!ueaResultSet.next()) {
                    System.out.println("No se encontraron registros");
                    return null;
                } else {
                    do {
                        id = ueaResultSet.getString("id");
                        username = ueaResultSet.getString("username");
                        password = ueaResultSet.getString("password");
                        rol = ueaResultSet.getString("rol");
                        
                        Uea1 ueaHallada = new Uea1(id,username, password, rol);
                        ueas1.add(ueaHallada);
                    } while (ueaResultSet.next());
                    return ueas1;
                }
            } finally {
                if (ueaResultSet != null) {
                    ueaResultSet.close();
                }
                if (stm != null) {
                    stm.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            }
        } catch (SQLException e) {
            System.out.println("Error en la base de datos.");
            e.printStackTrace();
            return null;
        }
    }



   public boolean localizaUEA1(String id,String username, String password,String rol) {
    try {
        ConectaBD1 conectaBD = new ConectaBD1();
        conexion = conectaBD.getConexion();
        
        // Usar PreparedStatement para prevenir la inyección SQL
        PreparedStatement stm = conexion.prepareStatement(
                "SELECT * FROM usuarios WHERE id = ? AND username = ? AND password = ? AND rol = ?");
        
        // Establecer los valores de los parámetros
          stm.setString(1, id);
        stm.setString(2, username);
        stm.setString(3, password);
         stm.setString(3, rol);
        
        
        ueaResultSet = stm.executeQuery();
        
        if (!ueaResultSet.next()) {
            System.out.println("No se encontraron registros");
            conexion.close();
            return false;
        } else {
            conexion.close();
            return true;
        }
    } catch (Exception e) {
        System.out.println("Error en la base de datos.");
        e.printStackTrace();
        return false;
    }
}



}
