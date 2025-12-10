package backend.entidades;

public class InvestigadorBiotecnologia extends Investigador {

    private String areaInvestigacao;

    public InvestigadorBiotecnologia(String nome, String email, String password,
                                     Laboratorio lab, String areaInvestigacao) {

        super(nome, email, password);
        this.areaInvestigacao = areaInvestigacao;
    }

    @Override
    public String getInfoEspecifica() {
        return "Área de investigação: " + areaInvestigacao;
    }
}
