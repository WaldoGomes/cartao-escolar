import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Period;

public class Aluno {
    private String nome;
    private String matricula;
    private String curso;
    private String cpf;
    private LocalDate dataNascimento;

    public Aluno(String nome, String matricula, String curso, String cpf, LocalDate dataNascimento){
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public String getNome(){
        return nome;
    }

    public String getMatricula(){
        return matricula;
    }

    public String getCurso(){
        return curso;
    }

    public String getCpf(){
        return cpf;
    }

    public LocalDate getDataNascimento(){
        return dataNascimento;
    }

    @Override
    public String toString(){
        DateTimeFormatter formatoBr = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String dataFormatada = dataNascimento.format(formatoBr);

        return String.format(
                "Nome: %s\nMatrícula: %s\nCurso: %s\nCPF: %s\nData de Nascimento: %s",
                nome, matricula, curso, cpf, dataFormatada
        );
    }

    public int getIdade(){
        LocalDate dataAtual = LocalDate.now();
        Period periodo = Period.between(dataNascimento, dataAtual);

        return periodo.getYears();
    }

}
