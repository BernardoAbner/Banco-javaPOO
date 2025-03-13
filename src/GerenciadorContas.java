import java.util.Scanner;
import java.util.ArrayList;

public class GerenciadorContas {
	Scanner scanner = new Scanner(System.in);
	
	private GerenciadorClientes gerenciadorCliente;
	
	public GerenciadorContas() {
	
	}
	
	public void setGerenciadorClientes(GerenciadorClientes gerenciadorCliente) {
		this.gerenciadorCliente = gerenciadorCliente;
	}
	
	Contas conta = new Contas();
	Clientes cliente = new Clientes();
	
	ArrayList<ContaCorrente> listaContaC = new ArrayList<>();
	ArrayList<ContaPoupanca> listaContaP = new ArrayList<>();
	ArrayList<Contas> listaContas = new ArrayList<>();
	
	private String senha;

	
	public void criarConta() {
		System.out.println("Seja bem vindo! Você ja possui cadastro como cliente?\n"
						 + "Escolha a sua opção entre 1 e 2:\n"
						 + "1. Sim\n"
						 + "2. Não");
		int menuCriarConta = scanner.nextInt();
		scanner.nextLine();
		
		Clientes titular = null;
		
		if (menuCriarConta == 1) {
			System.out.println("Insira o seu cpf: ");
			String cpf = scanner.nextLine();
			titular = gerenciadorCliente.buscarCliente(cpf);
			
			if(titular == null) {
				System.out.println("Cliente não encontrado. Por favor, cadastre o cliente primeiro. ");
				return;
			}
		}
		
		else if (menuCriarConta == 2) {
			System.out.println("Cadastrando um novo cliente...");
			gerenciadorCliente.criarCliente();
			
			System.out.println("Insira o seu cpf: ");
			String cpf = scanner.nextLine();
			titular = gerenciadorCliente.buscarCliente(cpf);
			
			if (titular == null) {
				System.out.println("Erro ao encontrar cliente. Tente novamente.");
				return;
			}
			
			
		}
		else {
			System.out.println("Opção inválida.");
			return;
		}
		
		System.out.println("Insira uma senha para a sua nova conta: ");
		String senha = scanner.nextLine();
			

		System.out.println("Qual tipo de conta você deseja criar? \n"
						 + "Escolha entre 1 e 2:\n"
						 + "1. Conta Poupanca \n"
						 + "2. Conta Corrente");
		int menuEscolhaConta = scanner.nextInt(); 
		scanner.nextLine();
		
		if (menuEscolhaConta == 1) {
			ContaPoupanca novaContaP = new ContaPoupanca();
			novaContaP.setSenha(senha);
			novaContaP.setTitular(titular);
			novaContaP.setNumeroConta(novaContaP.numeroContaP());
			novaContaP.setSaldo(0.0);
			
			listaContaP.add(novaContaP);
			listaContas.add(novaContaP);
			System.out.println("A conta foi criada com sucesso!");
			
		}
		else if (menuEscolhaConta == 2) {
			ContaCorrente novaContaC = new ContaCorrente();
			novaContaC.setSenha(senha);
			novaContaC.setTitular(titular);
			novaContaC.setNumeroConta(novaContaC.numeroContaC());
			novaContaC.setSaldo(0.0);
			
			listaContaC.add(novaContaC);
			listaContas.add(novaContaC);	
			System.out.println("A conta foi criada com sucesso!");
		}
		
		else {
			System.out.println("Opção inválida.");
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
				scanner.nextLine();
				
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
		Contas conta = buscarConta(numeroConta);
		
		
			if(conta != null) {
				System.out.println("Insira a sua senha: ");
				String senha = scanner.nextLine();
				if(conta.getSenha().equals(senha)) {
					System.out.println("Login realizado com sucesso! ");
					atividadesConta(conta);
				}
				else {
					System.out.println("Senha inválida.");
				}
			} else {
				System.out.println("Conta não encontrada. ");
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
	
	
	
	public void atividadesConta(Contas conta) {
		System.out.println("Seja muito bem vindo: "+ conta.getTitular().getNome());
		
		System.out.println("O que deseja executar?\n"
						 + "Escolha entre 1 e 5 ou 0 para sair\n"
						 + "1. Sacar\n"
						 + "2. Depositar\n"
						 + "3. Transferir\n"
						 + "4. Mostrar dados da conta\n"
						 + "5. Apagar conta\n"
						 + "0. Sair");
		int subMenu = scanner.nextInt();
		scanner.nextLine();
		
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
					 + "5. Apagar conta\n"
					 + "0. Sair");
			subMenu = scanner.nextInt();
			scanner.nextLine();
	
		}
		
}
	

	
	
}
