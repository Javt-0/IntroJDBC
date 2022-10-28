
package dominio;

import java.io.IOException;
import java.util.List;
import java.sql.*;

/**
 *
 * @author jonat
 */
public class UsuarioDao {
    private static final String SQL_SELECT = "SELECT * FROM usuario";
    private static final String SQL_INSERT = "INSERT INTO usuario (nomUsuario, clave)"
                                            + "VALUES (?, ?)";
    private static final String SQL_UPDATE = "UPDATE usuario SET nomUsuario=?, clave=? WHERE idUsuario = ?";
    
   
}
