package backend.entidades;

public class Coordenador extends Utilizador {

    public Coordenador(String nome, String email, String password) {
        super(nome, email, password);
    }

    public int getIdCoordenador() {
        return getId();   // herdado de Utilizador
    }

    public String getNomeCoordenador() {
        return getNome(); // herdado de Utilizador
    }

    public String getEmailCoordenador() {
        return getEmail(); // herdado de Utilizador
    }

    @Override
    public String toString() {
        return "Coordenador { " +
                "ID = " + getId() +
                ", Nome = '" + getNome() + '\'' +
                ", Email = '" + getEmail() + '\'' +
                " }";
    }
}
