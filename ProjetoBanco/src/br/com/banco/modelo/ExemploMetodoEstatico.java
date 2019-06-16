package br.com.banco.modelo;

import br.com.banco.util.exception.SaldoInsuficienteException;


public class ExemploMetodoEstatico {
	public static void main(String[] args){
		ContaService service = new ContaService();
		
		Conta conta1 = new Conta();
		conta1.setNumero(448845616);
		conta1.setSaldo(950.00);
		
		Conta conta2 = new Conta();
		conta2.setNumero(777777884);
		conta2.setSaldo(50.00);
		
		Conta conta3 = new Conta();
		
		
		
		
		System.out.println("conta1 tem total "+conta1.getSaldo());
		System.out.println("conta2 tem total "+conta2.getSaldo());
		
		System.out.println("Tranferir 400 da conta 1 para a conta 2");
		
		try {
			service.Transferir(conta1, 400, conta2, null);
		} catch (SaldoInsuficienteException e) {
			e.printStackTrace();
		}
		System.out.println("conta1 agora tem"+conta1.getSaldo());
		System.out.println("conta2 agora tem"+conta2.getSaldo());
		System.out.println("conta3 agora tem"+conta3.getSaldo());
		
		System.out.println("");
		System.out.println("");
		System.out.println("transferir 200 da conta 1 para a conta2");
		
		
		try {
			service.Transferir(conta1, 200, conta2,null);
		} catch (SaldoInsuficienteException e) {
			e.printStackTrace();
		}
		System.out.println("Saldo da Conta 1:" + conta1.getSaldo());
		System.out.println("Saldo da Conta 2:" + conta2.getSaldo());
		System.out.println("Saldo da Conta 3:" + conta3.getSaldo());		
	}
}
