import java.util.Scanner;
import java.util.ArrayList;

public class Banco {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		GerenciadorClientes gerenciadorClientes = new GerenciadorClientes();	
		GerenciadorContas gerenciadorContas = new GerenciadorContas();
		
		gerenciadorContas.setGerenciadorClientes(gerenciadorClientes);
		gerenciadorClientes.setGerenciadorConta(gerenciadorContas);
																						
		ContaCorrente corrente = new ContaCorrente();
		ContaPoupanca poupanca = new ContaPoupanca();
		
		System.out.println("### SEJA BEM-VINDO ###\n"
						 + "Qual função deseja realizar?\n"
						 + "1. Criar conta\n"
						 + "2. Entrar na conta\n"
						 + "3. Entrar como gerente\n"
						 + "0. Sair");
		int menu = scanner.nextInt();
		scanner.nextLine();
		
		while(menu != 0) {			
			if (menu == 1) {
				gerenciadorContas.criarConta();
				
			}
			else if (menu == 2) {
				gerenciadorContas.loginConta();
				
			}
			else if (menu == 3) {
				gerenciadorClientes.contaGerente();

			}
			else {
				System.out.println("Opção inválida! insira uma opção dentro do intervalo solicitado.");
			}
			
			System.out.println("### SEJA BEM-VINDO ###\n"
					 + "Qual função deseja realizar?\n"
					 + "1. Criar conta\n"
					 + "2. Entrar na conta\n"
					 + "3. Entrar como gerente\n"
					 + "4. Encerrar conta\n"
					 + "0. Sair");
			menu = scanner.nextInt();
			scanner.nextLine();
			
		}


	}

}
