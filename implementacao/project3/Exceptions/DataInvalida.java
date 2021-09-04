package Exceptions;

public class DataInvalida extends Exception {
    public DataInvalida(String data) {
        super(data + " Invalida.");
    }
}
