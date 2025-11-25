import java.time.LocalDate;
import java.util.Scanner;

public class ProgramaPrincipal {
    public static void main(String[] args){
        Scanner scanner =new Scanner(System.in);
        Funcionario funcionario = new Funcionario("José da Silva Sauro", "19382289","Agente 01");
        Aluno novoAluno = null;
        CartaoEscolar cartao = null;

        int opcao;

        do {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1. Cadastrar aluno");
            System.out.println("2. Emitir cartão escolar");
            System.out.println("3. Carregar saldo");
            System.out.println("4. Exibir histórico");
            System.out.println("5. Exibir dados do aluno");
            System.out.println("6. Exibir saldo do cartão");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao){
                case 0:
                    System.out.println("Sistema encerrado!");
                    break;
                case 1:
                    System.out.println("===== Cadastro de Aluno =====");
                    System.out.print("Nome completo: ");
                    String nome = scanner.nextLine();

                    System.out.print("Matrícula: ");
                    String matricula = scanner.nextLine();

                    System.out.print("Curso: ");
                    String curso = scanner.nextLine();

                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();

                    LocalDate dataNascimento = null;
                    boolean dataValida = false;

                    do{
                        try {
                            System.out.print("Ano de nascimento (ex: 2000): ");
                            int ano = scanner.nextInt();

                            int mes;
                            do {
                                System.out.print("Mês de nascimento (1 a 12): ");
                                mes = scanner.nextInt();
                                if (mes < 1 || mes > 12) {
                                    System.out.println("Insira um número válido");
                                }
                            } while (mes < 1 || mes > 12);

                            int dia;
                            do {
                                System.out.print("Dia de nascimento: ");
                                dia = scanner.nextInt();
                                scanner.nextLine();
                                if (dia < 1 || dia > 31) {
                                    System.out.println("Insira um número válido");
                                }
                            } while (dia < 1 || dia > 31);

                            dataNascimento = LocalDate.of(ano, mes, dia);
                            novoAluno = funcionario.cadastrarAluno(nome, matricula, curso, cpf, dataNascimento);
                            System.out.println("\nAluno cadastrado com sucesso!");
                            dataValida = true;

                        }catch (Exception e){
                            System.out.println("Data inválida! Verifique dia, mês e ano e tente novamente.");
                        }
                    } while (!dataValida);

                    break;

                case 2:
                    if (novoAluno == null){
                        System.out.println("Cadastre um aluno primeiro.");
                    } else {
                        cartao = funcionario.emitirCartaoEscolar(novoAluno);
                        System.out.println("Cartao emitido com saldo inicial de R$100,00");
                    }
                    break;

                case 3:
                    if (cartao == null){
                        System.out.println("Emita um cartão primeiro.");
                    } else {
                        double valor;
                        do {
                            System.out.print("Valor a carregar: R$ ");
                            valor = scanner.nextDouble();
                            if (valor <= 0) {
                                System.out.println("Insira um valor positivo!");
                            }
                        } while (valor <= 0);

                        cartao.carregarCartao(valor);
                        System.out.println("Recarga realizada com sucesso!");
                    }
                    break;

                case 4:
                    if (cartao == null){
                        System.out.println("Emita um cartão primeiro.");
                    } else {
                        cartao.exibirHistorico();
                    }
                    break;

                case 5:
                    if (cartao == null){
                        System.out.println("Emita um cartão primeiro.");
                    } else {
                        cartao.exibirDadosAluno();
                    }
                    break;

                case 6:
                    if (cartao == null){
                        System.out.println("Emita um cartão primeiro.");
                    } else {
                        cartao.consultarSaldo();
                    }
                    break;

                default:
                    System.out.println("Opção inválida");
            }
        } while (opcao != 0);

        scanner.close();
    }

}
