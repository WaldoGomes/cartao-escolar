public class ProgramaPrincipal {
    public static void main(String[] args){
        CartaoEscolar cartao = new CartaoEscolar(30);
        System.out.println(cartao);

        cartao.pagarPassagemComum();

        System.out.println(cartao);

        cartao.carregarCartao(20);

        System.out.println(cartao);

        cartao.exibirHistorico();




    }
}
