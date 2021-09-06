package interfaces;

import Model.Disciplina;

public interface Gerenciavel {
    public boolean addDisciplina(Disciplina disc);
    public boolean removerDisciplina(String discNome);
}
