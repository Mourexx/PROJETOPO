package backend.excecoes;

public class CredenciaisInvalidasException extends RuntimeException {
    public CredenciaisInvalidasException(String msg) { super(msg); }
}
