package br.com.banco.modelo;

import br.com.banco.util.UtilData;
import br.com.banco.util.exception.SaldoInsuficienteException;

public class ContaService {

	public void depositar(Conta contaDestino, double valor) {
		contaDestino.setSaldo(contaDestino.getSaldo() + valor);

		this.historicoTransacao(null, contaDestino, valor, "deposito na conta " + contaDestino.getNumero(), EnumTipoTransacao.DEPOSITO);
	}

	public void Sacar(Conta conta, double valor) {
		conta.setSaldo(conta.getSaldo() - valor);

		this.historicoTransacao(null, conta, valor, "saque na conta " + conta.getNumero(), EnumTipoTransacao.DEPOSITO);
	}

	public boolean transferir(Conta contaSaque, double valor, Conta contaDestino) throws SaldoInsuficienteException{
		return Transferir(contaSaque, valor, contaDestino, "transferencia para conta " + contaDestino.getNumero());
	}

	public boolean Transferir(Conta contaSaque, double valor, Conta contaDestino, String descr) throws SaldoInsuficienteException{
		if (contaSaque.getSaldo() - valor >= 0) {
			this.debito(contaSaque, valor);
			this.credito(contaDestino, valor);
			this.historicoTransacao(contaSaque, contaDestino, valor, descr, EnumTipoTransacao.TRANSFERENCIA);
			return true;
		} else {
			throw new SaldoInsuficienteException();
		}
	}

	protected void debito(Conta contaOperacao, double valor) {
		contaOperacao.setSaldo(contaOperacao.getSaldo() - valor);
	}

	protected void credito(Conta contaOperacao, double valor) {
		contaOperacao.setSaldo(contaOperacao.getSaldo() + valor);
	}

	protected void historicoTransacao(Conta contaDebito, Conta contaCredito, double valor, String descr, EnumTipoTransacao tipoTransacao) {
		Transacao transacao = new Transacao(UtilData.data(), contaDebito, contaCredito, valor, descr, tipoTransacao);
		if (contaDebito != null) {
			contaDebito.getMovimento().add(transacao);
		}
		contaCredito.getMovimento().add(transacao);
	}

}
