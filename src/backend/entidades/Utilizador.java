package backend.entidades;

import java.io.Serializable;
import java.util.Objects;

public abstract class Utilizador implements Serializable {

    private static final long serialVersionUID = 1L;

    private static int geradorIds = 1;

    private final int id;
    private String nome;
    private String email;
    private String password;

    protected Utilizador(String nome, String email, String password) {
        this.id = geradorIds++;
        this.nome = nome;
        this.email = email;
        this.password = password;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }

    public void setNome(String nome) { this.nome = nome; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String novaPassword) { this.password = novaPassword; }

    public boolean autenticar(String email, String password) {
        return this.email != null
                && this.password != null
                && this.email.equalsIgnoreCase(email)
                && this.password.equals(password);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Utilizador)) return false;
        Utilizador that = (Utilizador) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
