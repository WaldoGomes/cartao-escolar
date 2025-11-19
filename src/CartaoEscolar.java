import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CartaoEscolar {
    private double saldo;
    private ArrayList<String> historico = new ArrayList<>();
    private Aluno aluno;

    public CartaoEscolar(double saldoInicial, Aluno aluno){
        this.saldo = saldoInicial;
        this.aluno = aluno;
    }

    public void pagarPassagemComum(){
        if(this.saldo >= 4.50){
            this.saldo -= 4.50;
            registrarOperacao("Passagem comum paga com sucesso!");
        }else{
            registrarOperacao("Saldo insuficiente!");
        }

    }

    public void pagarPassagemComDesconto(){
        DayOfWeek diaAtual = LocalDate.now().getDayOfWeek();
        if(diaAtual != DayOfWeek.SATURDAY && diaAtual != DayOfWeek.SUNDAY){
            if(this.saldo >= 2.25){
                this.saldo -= 2.25;
                registrarOperacao("Passagem com desconto paga com sucesso!");
            }else{
                registrarOperacao("Saldo insuficiente!");
            }
        }else{
            registrarOperacao("Tentativa de uso em final de semana.");
        }
    }

    public void carregarCartao(double valor){
        if(valor <= 0){
            registrarOperacao("Valor inválido, adicione um valor positivo!");
        }else{
            registrarOperacao(String.format("Cartao recarregado com R$ %.2f", valor));
            this.saldo += valor;
        }


    }

    @Override
    public String toString(){
        return String.format("O cartão possui saldo de %.2f reais.", saldo);
    }

    public void exibirHistorico(){
        System.out.println("------------------------------------------------");
        System.out.println("Histórico de operações:");
        for(int i = 0; i <historico.size(); i++){
            System.out.println((i + 1) + ". " + historico.get(i));
        }
        System.out.println("------------------------------------------------");
    }

    public String gerarTimestamp(){
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return agora.format(formato);
    }

    private void registrarOperacao(String mensagem){
        String entrada = gerarTimestamp() + " - " + mensagem;
        historico.add(entrada);
        System.out.println(mensagem);
    }

    public void registrarOperacaoFuncionario(String mensagem){
        registrarOperacao("Funcionario: " + mensagem);
    }

    public void exibirDadosAluno(){
        System.out.println("------------------------------------------------");
        System.out.println(aluno);
        System.out.println("------------------------------------------------");
    }

    public double getSaldo(){
        return saldo;
    }

    public void setSaldo(double novoSaldo){
        this.saldo = novoSaldo;
    }


}
