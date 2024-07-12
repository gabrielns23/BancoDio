package utils;

public class ContaUtil {

    private static int SEQUENCIAL = 1;


    public static String gerarNumeroConta() {
        String numeroConta = String.format("%04d", SEQUENCIAL++);
        String digitoVerificador = calcularDigitoVerificador(numeroConta);
        return numeroConta + "-" + digitoVerificador;
    }

    public static String calcularDigitoVerificador(String numeroConta) {

        int soma = 0;
        int peso = 2;

        for (int i = numeroConta.length() - 1; i >= 0; i--) {
            soma += (numeroConta.charAt(i) - '0') * peso;
            peso++;
            if (peso > 9) {
                peso = 2;
            }
        }

        int digitoVerificadorInt = 11 - (soma % 11);
        if (digitoVerificadorInt >= 10) {
            digitoVerificadorInt = 0;
        }

        return String.valueOf(digitoVerificadorInt);
    }
}
