package br.com.banco.modelo;

import br.com.banco.util.exception.SaldoInsuficienteException;

public class MovimentoContaCaixa {
	
		public static void main(String[] args) {
		// Cria uma inst�ncia de ContaService onde est� presente as opera��es para Objeto Conta
		ContaService operacoesConta = new ContaService();
		// cria conta caixa
		Conta caixa = new Conta("ContaCaixa", 0);
		caixa.setSaldo(100000);
		Conta correntista1 = new Conta("Hinfe Liz", 1001);
		// faz deposito
		operacoesConta.depositar(correntista1, 1000);
		Conta correntista2 = new Conta("ZILEF D'AVIDA", 1002);
		// faz deposito, transferir para conta caixa
		operacoesConta.depositar(correntista2, 2000);
		// Mostra saldo correntista 1
		System.out.println("correntista1 saldo =" + correntista1.getSaldo());
		// Mostra saldo correntista 2
		System.out.println("correntista2 saldo =" + correntista2.getSaldo());
		try {
			if (operacoesConta.transferir(correntista1, 100.00, correntista2)) {
			System.out.println("transferencia ok");
			} else {
			System.out.println("nao pode transferir !");
			}
		} catch (SaldoInsuficienteException e) {
			e.printStackTrace();
		}
		// Mostra saldo correntista 1
		System.out.println("correntista1 saldo =" + correntista1.getSaldo());
		// Mostra saldo correntista 2
		System.out.println("correntista2 saldo =" + correntista2.getSaldo());
		// faz saque
		operacoesConta.Sacar(correntista2, 120.00);
		System.out.println("saque ok");
		// Mostra saldo correntista 2
		System.out.println("correntista2 saldo =" + correntista2.getSaldo());
		// mostra movimento correntista 1
		System.out.println(correntista1.getMovimento());
		// mostra movimento correntista 2
		System.out.println(correntista2.getMovimento());
		}
		
}
