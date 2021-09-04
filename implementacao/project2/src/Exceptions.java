class CursoNaoEncontrado extends Exception {
    CursoNaoEncontrado(String nome ){
        super("Curso " + nome + " não encontrado.");
    }
}

class UsuarionaoEncontrado extends Exception {
    UsuarionaoEncontrado(int matricula ){
        super("Usuario com a matricula " + matricula + " não encontrado.");
    }
}

class DataInvalida extends Exception {
    DataInvalida(String data ){
        super(data + " Invalida.");
    }
}

class FalhaNoLogin extends Exception {
    FalhaNoLogin(){
        super("Credenciais invalidas");
    }
}

class DisciplinasExcedidas extends Exception {
    DisciplinasExcedidas() { super("Ops! Número de matrículas nesta modalidade excedido."); }
}