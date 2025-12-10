package Backend.entidades;

public class InvestigadorEnergia extends Investigador {

    private String fonteEnergetica;

    public InvestigadorEnergia(String nome, String email, String password,
                               Laboratorio lab, String fonteEnergetica) {

        super(nome, email, password);
        this.fonteEnergetica = fonteEnergetica;
    }

    @Override
    public String getInfoEspecifica() {
        return "Fonte energética estudada: " + fonteEnergetica;
    }
}
