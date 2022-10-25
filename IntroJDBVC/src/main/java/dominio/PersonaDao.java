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

/**
 *
 * @author jonat
 */
public class PersonaDao {
    private static final String SQL_SELECT = "SELECT * FROM persona";
    
    public List<Persona> selecionar() throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<>();
        
        conn = getConnection();
        stmt = conn.prepareStatement(SQL_SELECT);
        rs = stmt.executeQuery();
        
        while(rs.next()){
            int idPersona = rs.getInt("idPersonas");
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
}
