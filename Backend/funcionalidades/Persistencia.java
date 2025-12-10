package backend.funcionalidades;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Persistencia {

    private static final String FICHEIRO = "sistema.dat";

    // =====================================================
    //  GUARDAR ESTADO DO SISTEMA
    // =====================================================
    public static boolean guardarSistema(GestaoSistema sistema) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FICHEIRO))) {
            oos.writeObject(sistema);
            return true;
        }
        catch (Exception e) {
            System.out.println("Erro ao guardar sistema: " + e.getMessage());
            return false;
        }
    }

    // =====================================================
    //  CARREGAR ESTADO DO SISTEMA
    // =====================================================
    public static GestaoSistema carregarSistema() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FICHEIRO))) {
            return (GestaoSistema) ois.readObject();
        }
        catch (Exception e) {
            System.out.println("Nenhum ficheiro encontrado. Sistema novo será criado.");
            return new GestaoSistema();
        }
    }
}
