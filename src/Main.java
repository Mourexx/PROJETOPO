import Frontend.MenuPrincipal;
import backend.funcionalidades.GestaoSistema;
import backend.funcionalidades.Persistencia;

public class Main {

    public static void main(String[] args) {

        GestaoSistema sistema = Persistencia.carregarSistema();

        if (sistema == null) {
            sistema = new GestaoSistema();
        }

        new MenuPrincipal(sistema).iniciar();
    }
}
