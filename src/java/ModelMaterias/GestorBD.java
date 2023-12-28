package ModelMaterias;

import ModelMaterias.Uea;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import ModelMaterias.ConectaBD;
import java.sql.Statement;

public class GestorBD {

    private Connection conexion = null;
    private ResultSet ueaResultSet;
    private Integer trimestre;
    private String id, nombre, requisito, clave, dias, lugar, hora;
    private Statement stm;

    public ArrayList<Uea> leerUeas() {
        ArrayList<Uea> ueas = new ArrayList<Uea>();
        try {
            ConectaBD conectaBD = new ConectaBD();
            conexion = conectaBD.getConexion();
            PreparedStatement stm = null;
            ResultSet ueaResultSet = null;

            try {
                stm = conexion.prepareStatement("select * from facultaddeingeniería");
                ueaResultSet = stm.executeQuery();

                if (!ueaResultSet.next()) {
                    System.out.println("No se encontraron registros");
                    return null;
                } else {
                    do {
                        id = ueaResultSet.getString("id");
                        clave = ueaResultSet.getString("clave");
                        nombre = ueaResultSet.getString("nombre");
                        trimestre = ueaResultSet.getInt("trimestre");
                        requisito = ueaResultSet.getString("requiere");
                        dias = ueaResultSet.getString("Dias");
                        lugar = ueaResultSet.getString("lugar");
                        hora = ueaResultSet.getString("hora");

                        Uea ueaHallada = new Uea(id, clave, nombre, trimestre, requisito, dias, lugar, hora);
                        ueas.add(ueaHallada);
                    } while (ueaResultSet.next());
                    return ueas;
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

    public boolean guardarUea(Uea ueaNueva) {
        String sql = "INSERT INTO facultaddeingeniería VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conexion = new ConectaBD().getConexion(); PreparedStatement statement = conexion.prepareStatement(sql)) {

            statement.setString(1, ueaNueva.getId());
            statement.setString(2, ueaNueva.getClave());
            statement.setString(3, ueaNueva.getNombre());
            statement.setInt(4, ueaNueva.getTrimestre());
            statement.setString(5, ueaNueva.getRequisito());
            statement.setString(6, ueaNueva.getDias());
            statement.setString(7, ueaNueva.getLugar());
             statement.setString(8, ueaNueva.getHora());

            int resultUpdate = statement.executeUpdate();
            if (resultUpdate != 0) {
                return true;
            } else {
                System.out.println("No se pudo insertar la facultaddeingeniería.");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error en la base de datos.");
            e.printStackTrace();
            return false;
        }
    }
    private int resultUpdate = 0;

    public boolean localizaUEA(String clave, String nombre) {
        try {
            ConectaBD conectaBD = new ConectaBD();
            conexion = conectaBD.getConexion();
            stm = conexion.createStatement();
            ueaResultSet = stm.executeQuery(
                    "SELECT * FROM facultaddeingeniería WHERE(clave = '" + clave + "' AND nombre ='" + nombre + "');"
            );
            if (!ueaResultSet.next()) {
                System.out.println(" No se encontraron registros");
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

    public boolean borrarUea(Uea ueaABorrar) {
        String sql = "DELETE FROM facultaddeingeniería WHERE clave = ? AND nombre = ?";
        try (Connection conexion = new ConectaBD().getConexion(); PreparedStatement statement = conexion.prepareStatement(sql)) {

            statement.setString(1, ueaABorrar.getClave());
            statement.setString(2, ueaABorrar.getNombre());

            int resultUpdate = statement.executeUpdate();
            if (resultUpdate != 0) {
                return true;
            } else {
                System.out.println("No se pudo borrar la facultaddeingeniería.");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error en la base de datos.");
            e.printStackTrace();
            return false;
        }
    }

    public boolean localizaUEA(Integer clave, String nombre) {
        try {
            ConectaBD conectaBD = new ConectaBD();
            conexion = conectaBD.getConexion();
            stm = conexion.createStatement();
            ueaResultSet = stm.executeQuery(
                    "SELECT * FROM facultaddeingeniería WHERE(clave = '" + clave + "' AND nombre ='"
                    + nombre + "');"
            );
            if (!ueaResultSet.next()) {
                System.out.println(" No se encontraron registros");
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

    public boolean modificarUea(Uea ueaACambiar) {
        try {
            ConectaBD conectaBD = new ConectaBD();
            conexion = conectaBD.getConexion();

            String query = "UPDATE facultaddeingeniería SET hora = ?, lugar = ?, id = ?, Dias = ?, nombre = ?, trimestre = ?, requiere = ? WHERE clave = ?";
            PreparedStatement stm = conexion.prepareStatement(query);

            stm.setString(1, ueaACambiar.getHora());
            stm.setString(1, ueaACambiar.getLugar());
            stm.setString(2, ueaACambiar.getId());
            stm.setString(3, ueaACambiar.getDias());
            stm.setString(4, ueaACambiar.getNombre());
            stm.setInt(5, ueaACambiar.getTrimestre());
            stm.setString(6, ueaACambiar.getRequisito());
            stm.setString(7, ueaACambiar.getClave());

            int resultUpdate = stm.executeUpdate();

            if (resultUpdate != 0) {
                conexion.close();
                return true;
            } else {
                conexion.close();
                System.out.println("No se pudo modificar la facultaddeingeniería.");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error en la base de datos.");
            e.printStackTrace();
            return false;
        }
    }

}
