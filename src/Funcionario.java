import java.time.LocalDate;

public class Funcionario {
    private String nome;
    private String id;
    private String cargo;

    public Funcionario(String nome, String id, String cargo){
        this.nome = nome;
        this.id = id;
        this.cargo = cargo;
    }

    public Aluno cadastrarAluno(String nome, String matricula, String curso, String cpf, LocalDate dataNascimento){
        return new Aluno(nome, matricula, curso, cpf, dataNascimento);
    }

    public CartaoEscolar emitirCartaoEscolar(Aluno aluno){
        return new CartaoEscolar(100.0, aluno);
    }
}
