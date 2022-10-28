
package dominio;

/**
 *
 * @author jonat
 */
public class Usuario {
    private int idUsuario;
    private String nomUsuario;
    private String clave;
    
    //Constructores

    public Usuario(int idUsuario, String nomUsuario, String clave) {
        this.idUsuario = idUsuario;
        this.nomUsuario = nomUsuario;
        this.clave = clave;
    }

    public Usuario(String nomUsuario, String clave) {
        this.nomUsuario = nomUsuario;
        this.clave = clave;
    }

    public Usuario() {
    }

    public Usuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    //Set y Get

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.idUsuario;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        return this.idUsuario == other.idUsuario;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Usuario{");
        sb.append("idUsuario=").append(idUsuario);
        sb.append(", nomUsuario=").append(nomUsuario);
        sb.append(", clave=").append(clave);
        sb.append('}');
        return sb.toString();
    }
    
    
}
