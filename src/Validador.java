public class Validador {
    private String identificadorOnibus;
    private String linhaOnibus;

    public Validador(String identificadorOnibus, String linhaOnibus){
        this.identificadorOnibus = identificadorOnibus;
        this.linhaOnibus = linhaOnibus;
    }

    public void validarCartao(CartaoEscolar cartao, boolean desconto){
        if(desconto){
            cartao.pagarPassagemComDesconto(linhaOnibus, identificadorOnibus);
        } else {
            cartao.pagarPassagemComum(linhaOnibus, identificadorOnibus);
        }
    }

    public String getOnibus(){
        return identificadorOnibus;
    }

    public String getLinhaOnibus(){
        return linhaOnibus;
    }

}
