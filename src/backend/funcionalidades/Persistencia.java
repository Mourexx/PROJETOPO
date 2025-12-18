package backend.funcionalidades;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class Persistencia {

    private static final String FICHEIRO = "sistema.dat";

    /**
     * Guarda o estado do sistema em ficheiro
     */
    public static boolean guardarSistema(GestaoSistema sistema) {
        if (sistema == null) return false;

        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(FICHEIRO))) {

            oos.writeObject(sistema);
            return true;

        } catch (IOException e) {
            System.out.println("Erro ao guardar sistema: " + e.getMessage());
            return false;
        }
    }

    /**
     * Carrega o estado do sistema a partir de ficheiro.
     * Se não existir ficheiro, cria um sistema novo.
     */
    public static GestaoSistema carregarSistema() {

        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(FICHEIRO))) {

            return (GestaoSistema) ois.readObject();

        } catch (FileNotFoundException e) {
            System.out.println("Nenhum ficheiro encontrado. Sistema novo será criado.");
            return new GestaoSistema();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar sistema. Sistema novo será criado.");
            return new GestaoSistema();
        }
    }
}
