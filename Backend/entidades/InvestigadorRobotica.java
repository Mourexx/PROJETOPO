package Backend.entidades;

public class InvestigadorRobotica extends Investigador {

    private String tipoSistema;

    public InvestigadorRobotica(String nome, String email, String password,
                                Laboratorio lab, String tipoSistema) {

        super(nome, email, password);
        this.tipoSistema = tipoSistema;
    }

    @Override
    public String getInfoEspecifica() {
        return "Tipo de sistema trabalhado: " + tipoSistema;
    }
}
