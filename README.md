# 🚌💳🤓 Cartão Escolar

Este projeto simula o funcionamento de um cartão escolar utilizado por estudantes para pagar passagens de ônibus com ou sem desconto. O sistema permite realizar pagamentos, carregar saldo e acompanhar o histórico de operações.

---

## ✨ Funcionalidades

- Pagamento de passagem comum
- Pagamento de passagem com desconto
- Recarga de saldo
- Registro de histórico de operações com data e hora
- Exibição do saldo atual

---

## ▶️ Como executar

1. Clone o repositório:
   git clone https://github.com/WaldoGomes/cartao-escolar.git

2. Abra o projeto no IntelliJ IDEA ou outra IDE Java

3. Execute a classe CartaoEscolar.java com um método main para testar as funcionalidades

---

## 📌 Exemplo de uso

CartaoEscolar cartao = new CartaoEscolar(10.00);
cartao.pagarPassagemComDesconto();
cartao.carregarCartao(5.00);
cartao.exibirHistorico();
System.out.println(cartao);

Saída esperada:

Passagem com desconto paga com sucesso!
Cartão recarregado com R$ 5.00
Histórico de operações:
1. 18/11/2025 19:48:12 - Passagem com desconto paga com sucesso!
2. 18/11/2025 19:48:13 - Cartão recarregado com R$ 5.00
   O cartão possui saldo de 12.75 reais.

---

## 🛠️ Tecnologias

- Java 11
- IntelliJ IDEA

---

## 👤 Autor

- Wagner Gomes ([@WaldoGomes](https://github.com/WaldoGomes))