package backend.entidades;

import java.io.Serializable;

public abstract class Utilizador implements Serializable {

    private static final long serialVersionUID = 1L;

    private static int geradorIds = 1;

    private final int id;
    private String nome;
    private String email;
    private String password;

    public Utilizador(String nome, String email, String password) {
        this.id = geradorIds++;
        this.nome = nome;
        this.email = email;
        this.password = password;
    }

    // ==========================
    // GETTERS
    // ==========================
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    // ==========================
    // SETTERS
    // ==========================
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String novaPassword) {
        this.password = novaPassword;
    }

    // ==========================
    // AUTENTICAÇÃO
    // ==========================
    public boolean autenticar(String email, String password) {
        return this.email.equalsIgnoreCase(email) && this.password.equals(password);
    }

    @Override
    public String toString() {
        return "Utilizador {" +
                "ID = " + id +
                ", Nome = '" + nome + '\'' +
                ", Email = '" + email + '\'' +
                " }";
    }
}
