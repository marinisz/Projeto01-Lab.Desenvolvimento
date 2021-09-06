package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import Exceptions.DisciplinaNaoEncontradaException;
import Exceptions.DisciplinasExcedidas;
import Exceptions.ForaDaEpocaDeMatriculaException;
import Utils.DisciplinaEnum;
import interfaces.Gerenciavel;
import interfaces.Matriculavel;
import interfaces.Visualizavel;

public class Curriculo implements Matriculavel, Gerenciavel, Visualizavel, Serializable {
    private static final int QTD_DISC_OBRIGATORIA = 4;
    private static final int QTD_DISC_OPCIONAL = 2;
    private ArrayList<Disciplina> disciplinas = new ArrayList<>();
    private Date iniDeMatricula;
    private Date finMatricula;
    private boolean periodoDeMatricula;

    Curriculo(Date iniDeMatricula, Date finMatricula) {
        this.iniDeMatricula = iniDeMatricula;
        this.finMatricula = finMatricula;
        this.periodoDeMatricula = this.ehEpocaDeMatricula();
    }

    public void listar() {
        for (Disciplina disciplina : disciplinas) {
            System.out.println(disciplina);
        }
    }

    public Disciplina buscarPeloNome(String nome) {
        Optional<Disciplina> disciplina = this.disciplinas.stream().filter(disc -> disc.getNome().equals(nome))
                .findAny();

        if (disciplina.isPresent())
            return disciplina.get();
        else
            return null;
    }

    @Override
    public boolean matricular(String nome, Aluno aluno)
            throws ForaDaEpocaDeMatriculaException, DisciplinaNaoEncontradaException, DisciplinasExcedidas {
        boolean matriculado = false;

        if (!this.periodoDeMatricula) {
            this.fecharPeriodoDeMatricula();
            throw new ForaDaEpocaDeMatriculaException();
        }

        Disciplina disciplina = this.buscarPeloNome(nome);
        if (disciplina == null)
            throw new DisciplinaNaoEncontradaException(nome);

        if (this.disciplinasExcedidas(disciplina, aluno))
            throw new DisciplinasExcedidas();

        try {
            matriculado = disciplina.addAluno(aluno);
            if (matriculado)
                if (disciplina.isOpcional())
                    aluno.addOpcional();
                else
                    aluno.addObrigatoria();
        } catch (Exception e) {
            System.out.println(e);
        }

        return matriculado;
    }

    @Override
    public boolean cancelarMatricula(String nome, Aluno aluno)
            throws ForaDaEpocaDeMatriculaException, DisciplinaNaoEncontradaException {
        boolean cancelado = false;
        if (!this.periodoDeMatricula) {
            this.fecharPeriodoDeMatricula();
            throw new ForaDaEpocaDeMatriculaException();
        }

        Disciplina disciplina = this.buscarPeloNome(nome);
        if (disciplina == null)
            throw new DisciplinaNaoEncontradaException(nome);

        try {
            cancelado = disciplina.removerAluno(aluno);
        } catch (Exception e) {
            System.out.println(e);
        }
        return cancelado;
    }

    @Override
    public void listarAlunosPorDisciplina(String nome) throws DisciplinaNaoEncontradaException {
        Disciplina disciplina = this.buscarPeloNome(nome);
        if (disciplina == null)
            throw new DisciplinaNaoEncontradaException(nome);

        disciplina.listar();
    }

    public boolean addDisciplina(Disciplina disc) {
        return this.disciplinas.add(disc);
    }

    public boolean removerDisciplina(String discNome) {
        Disciplina disc = buscarPeloNome(discNome);
        if (disc == null || disc.getSituacao() == DisciplinaEnum.APROVADA) {
            return false;
        } else
            {
                Boolean t = this.disciplinas.remove(disc);
                Sistema.getInstance().atualizarCurso();
                return t;
            }
    }

    public ArrayList<Disciplina> getDisciplinas() {
        return this.disciplinas;
    }

    private boolean ehEpocaDeMatricula() {
        Calendar currentDate = Calendar.getInstance();

        int dataIni = currentDate.getTime().compareTo(this.iniDeMatricula);
        int dataFin = currentDate.getTime().compareTo(this.finMatricula);

        if (dataIni == -1 || dataFin == 1)
            return false;
        else
            return true;
    }

    private void fecharPeriodoDeMatricula() {
        Date currentDate = Calendar.getInstance().getTime();
        if (currentDate.compareTo(this.finMatricula) == 1 && this.periodoDeMatricula) {
            for (Disciplina disciplina : disciplinas) {
                if (disciplina.getAlunos().size() < Disciplina.QTD_MINIMA)
                    disciplina.setSituacao(DisciplinaEnum.CANCELADA);
                else {
                    disciplina.setSituacao(DisciplinaEnum.APROVADA);
                    disciplina.semestreFechado();
                }

            }

            this.periodoDeMatricula = false;
            Sistema.getInstance().atualizarCurso();
        }
    }

    public boolean getEpocaDeMatricula() {
        return this.periodoDeMatricula;
    }

    private boolean disciplinasExcedidas(Disciplina disciplina, Aluno aluno) {
        if (disciplina.isOpcional() && aluno.getDisciplinasOpcionais() >= QTD_DISC_OPCIONAL)
            return true;

        if (aluno.getDisciplinasObrigatorias() >= QTD_DISC_OBRIGATORIA)
            return true;

        return false;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.getClass().getSimpleName() + "= {" + "\n\tData inicial: " + this.iniDeMatricula + "\n\tData Final: "
                + this.finMatricula + "\n\tDisciplinas: " + this.disciplinas + "\n}";
    }
}
