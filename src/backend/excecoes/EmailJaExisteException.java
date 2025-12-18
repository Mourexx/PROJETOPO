package backend.excecoes;

public class EmailJaExisteException extends RuntimeException {
    public EmailJaExisteException(String msg) { super(msg); }
}
