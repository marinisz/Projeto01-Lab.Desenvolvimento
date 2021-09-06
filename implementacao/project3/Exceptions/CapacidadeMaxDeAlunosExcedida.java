package Exceptions;

public class CapacidadeMaxDeAlunosExcedida extends Exception{
    public CapacidadeMaxDeAlunosExcedida() {
        super("Disciplina nao aceita mais matricula de aluno");
   }
}
