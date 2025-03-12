import java.util.Scanner;
import java.util.ArrayList;

public class GerenciadorContas {
	Scanner scanner = new Scanner(System.in);
	
	GerenciadorClientes gerenciadorClientes = new GerenciadorClientes();
	Contas conta = new Contas();
	Clientes cliente = new Clientes();
	
	ArrayList<ContaCorrente> listaContaC = new ArrayList<>();
	ArrayList<ContaPoupanca> listaContaP = new ArrayList<>();
	ArrayList<Contas> listaContas = new ArrayList<>();
	
	private String senha;
	private String cpf;
	
	public void criarConta() {
		System.out.println("Seja bem vindo! Você ja possui cadastro como cliente?\n"
						 + "Escolha a sua opção entre 1 e 2:\n"
						 + "1. Sim\n"
						 + "2. Não");
		int menuCriarConta = scanner.nextInt();
		
		if (menuCriarConta == 1) {
			System.out.println("Insira uma senha para a sua conta: ");
			senha = scanner.nextLine();
			System.out.println("O seu login será a sua senha e o número da sua conta.");
			
			System.out.println("Insira o seu cpf: ");
			cpf = scanner.nextLine();
			
			escolhaConta();
		}
	
	}
	
	public void escolhaConta() {
		System.out.println("Qual tipo de conta você deseja criar? \n"
						 + "Escolha entre 1 e 2:\n"
						 + "1. Conta Poupanca \n"
						 + "2. Conta Corrente");
		
		int menuEscolhaConta = scanner.nextInt(); 
		if (menuEscolhaConta == 1) {
			ContaPoupanca novaContaP = new ContaPoupanca();
			novaContaP.setSenha(senha);
			novaContaP.setTitular(gerenciadorClientes.buscarCliente(cpf));
			conta.setNumeroConta(novaContaP.numeroContaP());
			novaContaP.setSaldo(0.0);
			
			listaContaP.add(novaContaP);
			listaContas.addAll(listaContaP);
			System.out.println("A conta foi criada com sucesso!");
			
		}
		else if (menuEscolhaConta == 2) {
			ContaCorrente novaContaC = new ContaCorrente();
			novaContaC.setSenha(senha);
			novaContaC.setTitular(gerenciadorClientes.buscarCliente(cpf));
			conta.setNumeroConta(novaContaC.numeroContaC());
			novaContaC.setSaldo(0.0);
			
			listaContaC.add(novaContaC);
			listaContas.addAll(listaContaC);
			System.out.println("A conta foi criada com sucesso!");
			
		}
	}
	
	public Contas buscarConta(final String numeroConta){
		for (Contas conta : listaContas) {
			if(conta.getNumeroConta().equals(numeroConta)) {
			return conta;
			}
		}
		return null;
	}
	
	public void listarContas() {
		for (Contas conta : listaContas) {
			if (listaContas.isEmpty()) {
				System.out.println("A lista atualmente está vazia.\n"
								 + "Deseja cadastrar um novo?\n"
								 + "Escolha entre 1 e 2:"
								 + "1. Sim\n"
								 + "2. Não");
				int subMenu = scanner.nextInt();
				
				if(subMenu == 1) {
					criarConta();
				}
				else if(subMenu == 2) {
					System.out.println("Saindo...");
				}
				else {
					System.out.println("Opção inválida. Selecione entre 1 e 2.");
				}
			}
		}
		conta.mostrarConta();
	}
	
	public void loginConta() {
		System.out.println("Insira o número da sua conta: ");
		String numeroConta = scanner.nextLine();
		for (Contas conta : listaContas) {
			if(conta.getNumeroConta().equals(numeroConta)) {
				System.out.println("Insira a sua senha: ");
				String senha = scanner.nextLine();
				if(conta.getSenha().equals(senha)) {
					System.out.println("Login realizado com sucesso! ");
					atividadesConta();
				}
				else {
					System.out.println("Login inválido.");
				}
			}
		}
	}

	public void apagarConta() {
		System.out.println("Insira o número da conta que deseja apagar: ");
		String numeroConta = scanner.nextLine();
		
		for (Contas conta : listaContas) {
			if (conta.getNumeroConta().equals(numeroConta)) {
				listaContas.remove(conta);
				System.out.println("A conta foi removida com sucesso. ");
			}
			
		}
		System.out.println("Segue abaixo a lista de contas atualizada: ");
	}
	
	
	
	public void atividadesConta() {
		System.out.println("Seja muito bem vindo: "+ cliente.getNome());
		
		System.out.println("O que deseja executar?\n"
						 + "Escolha entre 1 e 5 ou 0 para sair\n"
						 + "1. Sacar\n"
						 + "2. Depositar\n"
						 + "3. Transferir\n"
						 + "4. Mostrar dados da conta\n"
						 + "5: Apagar conta"
						 + "0: Sair");
		int subMenu = scanner.nextInt();
		
		while(subMenu != 0) {
			
			if (subMenu == 1) {
				conta.sacar();
			}
			else if (subMenu == 2) {
				conta.depositar();
			}
			else if(subMenu == 3) {
				conta.transferir();
			}
			else if(subMenu == 4) {
				conta.mostrarConta();
			}
			else if (subMenu == 5) {
				apagarConta();
			}
			else {
				System.out.println("Opção inválida! Insira uma opção dentro do intervalo específicado! ");
			}
			System.out.println("O que deseja executar?\n"
					 + "Escolha entre 1 e 5 ou 0 para sair\n"
					 + "1. Sacar\n"
					 + "2. Depositar\n"
					 + "3. Transferir\n"
					 + "4. Mostrar dados da conta\n"
					 + "5: Apagar conta"
					 + "0: Sair");
			subMenu = scanner.nextInt();
	
		}
		
}
	

	
	
}
