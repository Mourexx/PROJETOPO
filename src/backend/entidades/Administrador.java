package backend.entidades;

public class Administrador extends Utilizador {

    private static final long serialVersionUID = 1L;

    public Administrador(String nome, String email, String password) {
        super(nome, email, password);
    }

    public int getIdAdministrador() {
        return getId();
    }

    @Override
    public String toString() {
        return "Administrador{" +
                "id=" + getId() +
                ", nome='" + getNome() + '\'' +
                ", email='" + getEmail() + '\'' +
                '}';
    }
}
