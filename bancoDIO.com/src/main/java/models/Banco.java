package models;
import lombok.Data;
import lombok.ToString;
import models.contas.Conta;

import java.util.ArrayList;
import java.util.List;

@Data
public class Banco {

    private String nome;
    private List<Conta> contas;

    public Banco(String nome) {
        this.nome = nome;
        this.contas = new ArrayList<>();
    }

    public void adicionarConta(Conta conta) {
        this.contas.add(conta);
    }

    public void imprimirContas() {
       for (Conta conta : this.contas) {
           System.out.println("======================================");
           System.out.printf("Nome: %s%n", conta.getCliente().getNome());
           System.out.printf("Número da conta: %s%n", conta.getNumeroConta());
           System.out.println("======================================");
       }
    }
}

