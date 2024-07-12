package org.example;

import models.Banco;
import models.Cliente;
import models.contas.Conta;
import models.contas.ContaCorrente;
import models.contas.ContaPoupanca;


public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Gabriel", "00000000000", "email@email.com", "61999999999", "teste1234");
        Cliente cliente2 = new Cliente("Jhúlia", "11111111111", "email@email.com", "61999999999", "teste1234");

        Banco banco = new Banco("Santander");
        Conta contaCorrente = new ContaCorrente(cliente1, banco);
        Conta contaPoupanca = new ContaPoupanca(cliente2, banco);

        contaPoupanca.depositar(1000);
        contaCorrente.depositar(1500);

        try{
            contaPoupanca.sacar(500);
            contaCorrente.sacar(2000);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


        try{
            contaCorrente.transferir(1500, contaPoupanca);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        contaCorrente.imprimirExtrato();
        contaPoupanca.imprimirExtrato();
        banco.imprimirContas();
    }
}
