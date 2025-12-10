package backend.entidades;

import java.io.Serializable;

public class Administrador implements Serializable {

    private static final long serialVersionUID = 1L; // Adicionando serialVersionUID para controle de versão

    private final int IdAdministrador;
    private String nome;
    private String email;

    private static int proximoId = 1;

    public Administrador(String nome, String email) {
        this.IdAdministrador = proximoId++;
        this.nome = nome;
        this.email = email;
    }

    public int getIdAdministrador() {
        return IdAdministrador;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static int getProximoId() {
        return proximoId;
    }

    @Override
    public String toString() {
        return "Administrador{" +
                "id=" + IdAdministrador +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
