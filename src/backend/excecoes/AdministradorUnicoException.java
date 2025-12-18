package backend.excecoes;

public class AdministradorUnicoException extends RuntimeException {

    public AdministradorUnicoException() {
        super("Só pode existir UM administrador no sistema. O poder absoluto não se replica.");
    }
}
