import jdk.swing.interop.SwingInterOpUtils;

import java.awt.desktop.OpenURIEvent;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);

		System.out.println("Bem vindo ao banco Dio, vamos criar uma nova conta \n primeiramente digite seu nome");

		String nome = leitor.nextLine();

		System.out.println("digite seu cpf");

		String cpf = leitor.nextLine();

		System.out.println("digite seu endereço \n longadouro");
		String longadouro = leitor.nextLine();
		System.out.println("numero");
		String numero = leitor.nextLine();
		System.out.println("bairro");
		String bairro = leitor.nextLine();
		System.out.println("cidade");
		String cidade = leitor.nextLine();
		System.out.println("cep");
		int cep = leitor.nextInt();


		Cliente cliente = new Cliente(nome, cpf, new Endereco(longadouro,cidade, bairro, numero, cep));
		Conta cc = new ContaCorrente(cliente);
		Banco dio = new Banco();
		Conta poupanca = new ContaPoupanca(cliente);

		int opcoes = 0;
		while (opcoes == 0){

			System.out.println("digite 1 para deposito");
			System.out.println("digite 2 para sacar");
			System.out.println("digite 3 para tranferir");
			System.out.println("digite 4 para sair");

			int opcao = leitor.nextInt();

			if (opcao == 1){
				System.out.println("Qual valor deseja deposita?");
				double valor = leitor.nextDouble();
				cc.depositar(valor);
			}else if (opcao == 2){
				System.out.println("saldo atual \n"+ cc.saldo);
				System.out.println("Qual valor deseja sacar?");
				double valor = leitor.nextDouble();
				cc.sacar(valor);
				System.out.println("saldo restante"+ cc.saldo);
			}else if(opcao == 3){
				System.out.println("Qual valor deseja transferir?");
				double valor = leitor.nextDouble();
				cc.transferir(valor, poupanca);
				System.out.println("saldo restante"+ cc.saldo);
			} else if (opcao == 4) {
				opcoes = 1;
			}
		}
		cc.imprimirExtrato();
		poupanca.imprimirExtrato();

	}

}
