package Exceptions;

public class FalhaNoLogin extends Exception {
    public FalhaNoLogin() {
        super("Credenciais invalidas");
    }
}
