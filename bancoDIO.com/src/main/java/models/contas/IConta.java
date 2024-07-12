package models.contas;

public interface IConta {

    void sacar(double valor) throws Exception;

    void depositar(double valor);

    void transferir(double valor, IConta contaDestino);

    void imprimirExtrato();
}