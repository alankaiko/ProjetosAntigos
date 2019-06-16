package br.com.banco.util.exception;

public class SaldoInsuficienteException extends Exception {
	public SaldoInsuficienteException() {
		super("Saldo insuficiente para esta operacao");
	}

	public SaldoInsuficienteException(String mensagem) {
		super(mensagem);
	}
}
