package models.contas;

import Exceptions.SaldoInsuficienteException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import models.Banco;
import models.Cliente;
import utils.ContaUtil;

import java.io.PrintStream;

@Getter
public class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;

    protected int agencia;
    protected String numeroConta;
    protected double saldo;
    protected Cliente cliente;
    protected Banco banco;

    public Conta(Cliente cliente, Banco banco) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numeroConta = ContaUtil.gerarNumeroConta();
        this.cliente = cliente;
        this.saldo = 0;
        this.banco = banco;
        this.banco.adicionarConta(this);
    }

    @Override
    public void sacar(double valor) throws Exception{
        if(valor > this.saldo) throw new SaldoInsuficienteException("Saldo insuficiente");
        this.saldo -= valor;

    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        try{
            this.sacar(valor);
            contaDestino.depositar(valor);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

    }

    protected void imprimirInfosComuns() {
        System.out.printf("Titular: %s%n", this.cliente.getNome());
        System.out.printf("Agencia: %d%n", this.agencia);
        System.out.printf("Numero: %s%n", this.numeroConta);
        System.out.printf("Saldo: %.2f%n", this.saldo);
        System.out.printf("Banco: %s%n", this.banco.getNome());
    }

    @Override
    public void imprimirExtrato(){

    };
}