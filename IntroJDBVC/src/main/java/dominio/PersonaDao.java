/*
 * conjunto de operaciones que voy a poder realizar en una persona
 */
package dominio;

import static datos.Conexion.close;
import static datos.Conexion.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jonat
 */
public class PersonaDao {
    private static final String SQL_SELECT = "SELECT * FROM personas";
    private static final String SQL_INSERT = "INSERT INTO personas (nombre, apellidos, email, telefono) "
                                            + "VALUES (?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE personas SET nombre=?, apellidos=?, email=?, telefono=? WHERE idPersona = ?";
    //Metodo que lista todas las persoans de nuestro sitema
    public List<Persona> selecionar() throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<>();
        
        conn = getConnection();
        stmt = conn.prepareStatement(SQL_SELECT);//Preparo la consulta para sql
        rs = stmt.executeQuery();
        
        while(rs.next()){
            int idPersona = rs.getInt("idPersona");
            String nombre = rs.getString("nombre");
            String apellidos = rs.getString("apellidos");
            String email = rs.getString("email");
            String telefono = rs.getString("telefono");
            
            personas.add(new Persona(idPersona, nombre, apellidos, email, telefono));
        }
        
        close(rs);
        close(stmt);
        close(conn);
        
        return personas;
    }
    
    //Metodo que inserta una persona en mi sistema
    public int insertar(Persona p){
        //Declaro variables
        Connection conex = null;
        PreparedStatement stmt = null;
        int registrar = 0;
        
        try {
            //1. establecesmos la conexion
            conex = getConnection();
            
            //2. preparo mi instruccion para ejecutarla contra la base de datos
            stmt = conex.prepareStatement(SQL_INSERT);
            //Asignar los valores de los interrogantes(?) de la consulta
            //Tiene que estar en orden los atributos
            stmt.setString(1, p.getNombre());
            stmt.setString(2, p.getApellidos());
            stmt.setString(3, p.getEmail());
            stmt.setString(4, p.getTelefono());
            
            //3. Ejecuto la Query
            registrar = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            try {
                close(stmt);
                close(conex);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return registrar;
    }
    
    public int actualizar(Persona p) {
        Connection conex = null;
        PreparedStatement stmt = null;
        int registros = 0;
        
        try {
            conex = getConnection();
            
            stmt= conex.prepareStatement(SQL_UPDATE);
            stmt.setString(1, p.getNombre());
            stmt.setString(2, p.getApellidos());
            stmt.setString(3, p.getEmail());
            stmt.setString(4, p.getTelefono());
            stmt.setInt(5, p.getIdPersona());
            
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            try {
                close(stmt);
                close(conex);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return registros;
    }
    
}
