package br.com.banco.modelo;

import java.util.Scanner;

public class Testacontas {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		
		System.out.print("digite o saldo inicial da conta");
		double saldoConta = ler.nextDouble();
		
		System.out.print("Digite o numero da conta");
		int numeroConta = ler.nextInt();
		
		ContaService service = new ContaService();
		
		Conta conta1 = new Conta();
		conta1.setSaldo(saldoConta);
		conta1.setNumero(numeroConta);
		
		Conta conta2 = new Conta();
		Conta conta3 = new Conta();
		
		System.out.println("Conta1 de numero: "+ conta1.getNumero());
		System.out.println("Conta1 com saldo de: "+ conta1.getSaldo());
		
		System.out.println("Sera depositado mais R$: 200 mangos ");
		
		
		System.out.println("conta1 com saldo total de "+ conta1.getSaldo());
	}

}









