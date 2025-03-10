import java.util.Scanner;
import java.util.ArrayList;

public class Banco {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		GerenciadorClientes gerenciador = new GerenciadorClientes();
		int menu = 0;
		
		
		System.out.println("### SEJA BEM-VINDO ###\n"
						 + "Qual função deseja realizar?\n"
						 + "1. Criar conta\n"
						 + "2. Entrar na conta\n"
						 + "3. Encerrar conta\n"
						 + "0. Sair");
		menu = scanner.nextInt();
		
		while(menu != 0) {			
			if (menu == 1) {
			gerenciador.adicionarCliente();
			}
			
		}


	}

}
