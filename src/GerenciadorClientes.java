import java.util.Scanner;
import java.util.ArrayList;

public class GerenciadorClientes {

	private ArrayList<Clientes> listaClientes = new ArrayList<>();
	private Scanner scanner = new Scanner(System.in);
	
	private GerenciadorContas gerenciadorConta;
	
	public GerenciadorClientes(){
		
	}
	
	public void setGerenciadorConta(GerenciadorContas gerenciadorConta) {
		this.gerenciadorConta = gerenciadorConta;	
	}
	
	public void criarCliente(){
			System.out.println("Insira o seu CPF: ");
			String cpf = scanner.nextLine();
			if (buscarCliente(cpf) != null) {
				System.out.println("Erro ao criar cliente! ja existe um cliente com este cpf.");
				return;
			}
			
			System.out.println("Insira o seu nome: ");
			String nome = scanner.nextLine();
			
			System.out.println("Insira a sua data de nascimento: ");
			String dataNascimento = scanner.nextLine();
			
			System.out.println("Insira o seu sexo: ");
			String sexo = scanner.nextLine();
			
			System.out.println("Insira o seu número de telefone: ");
			String telefone = scanner.nextLine();
			
			System.out.println("Insira o seu email: ");
			String email = scanner.nextLine();
			
			Clientes novoCliente = new Clientes();
			novoCliente.setCpf(cpf);
			novoCliente.setNome(nome);
			novoCliente.setDataNascimento(dataNascimento);
			novoCliente.setSexo(sexo);
			novoCliente.setTelefone(telefone);
			novoCliente.setEmail(email);
			
			listaClientes.add(novoCliente);
			
			System.out.println("Cliente adicionado com sucesso!!!");
	}
	
	public Clientes buscarCliente(final String cpf) {
		for (Clientes cliente: listaClientes) {
			if (cliente.getCpf().equals(cpf)) {
				return cliente;
			}
		}
	return null;
	}
	
	public void listarClientes() {
		if (listaClientes.isEmpty()) {
			System.out.println("Nenhum cliente cadastrado até o momento. Deseja cadastrar um novo?\n"
			+"1. Sim\n"
			+"2. Não");
			int menu = scanner.nextInt();
			scanner.nextLine();
			if (menu == 1) {
				criarCliente();
			}
			else {
				System.out.println("Retornando ao menu principal...");
			}
			return;
		}
		
		for (Clientes cliente : listaClientes) {
			cliente.mostrarDados();
		}
	}
		
	public void mostrarCliente() {
		System.out.println("Insira o cpf do cliente para mostrar informações: ");
		scanner.nextLine();
		String cpf = scanner.nextLine();
		buscarCliente(cpf);
		}
	
	public void apagarCliente() {
		System.out.println("Insira o cpf do cliente que deseja apagar: ");
		scanner.nextLine();
		String cpf = scanner.nextLine();
			Clientes clienteEncontrado = buscarCliente(cpf);
			
			if (clienteEncontrado != null) {
				listaClientes.remove(clienteEncontrado);
			}
			else {
				System.out.println("O cliente não foi encontrado, certifique-se que digitou o CPF corretamente.");	
			}
		
	}
	
	public void alterarInformacao() {
		System.out.println("Insira o CPF do cliente que deseja alterar informações: ");
		scanner.nextLine();
		String cpf = scanner.nextLine();
		Clientes cliente = buscarCliente(cpf);
			
		if (cliente == null) {
			return;
		}
			
			
			
			if (cliente.getCpf().equals(cpf)) {
				mostrarCliente();
				System.out.println("Qual informação deseja alterar?\n"
								 + "1. Nome\n"
								 + "2. Data de Nascimento\n"
								 + "3. Sexo\n"
								 + "4. Telefone\n"
								 + "5. Email\n"
								 + "0. Sair");
				int subMenu = scanner.nextInt();
				scanner.nextLine();
				
				while (subMenu != 0) {
				if (subMenu == 1) {
					System.out.println("O nome atual é " + cliente.getNome() + " insira o nome para qual deseja alterar: ");
					cliente.setNome(scanner.nextLine());
				}
				else if (subMenu == 2) {
					System.out.println("A data de nascimento atual é: "+ cliente.getDataNascimento() + " insira a data de nascimento para a qual deseja alterar: ");
					cliente.setDataNascimento(scanner.nextLine());
				}
				else if(subMenu == 3) {
					System.out.println("O sexo atua é: "+ cliente.getSexo() + " insira o sexo para o qual deseja alterar: ");
					cliente.setSexo(scanner.nextLine());
				}
				else if(subMenu == 4) {
					System.out.println("O telefone atual é: "+ cliente.getTelefone() + " insira o telefone para o qual deseja alter: ");
					cliente.setTelefone(scanner.nextLine());
				}
				else if(subMenu == 5) {
					System.out.println("O email atual é: "+ cliente.getEmail() + " insira o email para o qual deseja alterar: ");
					cliente.setEmail(scanner.nextLine());
				}
				
				System.out.println("Qual informação deseja alterar?\n"
						 + "1. Nome\n"
						 + "2. Data de Nascimento\n"
						 + "3. Sexo\n"
						 + "4. Telefone\n"
						 + "5. Email\n"
						 + "0. Sair");
				subMenu = scanner.nextInt();
				scanner.nextLine();
				
				}
				System.out.println("Informações gravadas com sucesso! Segue abaixo os seus dados atuaizados: ");
				cliente.mostrarDados();
			}
			
		}
	
	public void contaGerente() {
		System.out.println("### GERÊNCIA ###\n"
						 + "O que deseja executar?\n"
				  		 + "1. Listar clientes\n"
				  		 + "2. Mostrar dados de um cliente específico\n"
				  		 + "3. Alterar informações\n"
				  		 + "4. Adicionar cliente\n"
				  		 + "5. Apagar cliente\n"
				  		 + "6. Listar contas\n"
				  		 + "7. Mostrar dados de uma conta específicar\n"
				  		 + "8. Adicionar conta\n"
				  		 + "9. Apagar conta\n"
				  		 + "0. Sair");
		int menuGerencia = scanner.nextInt();
		scanner.nextLine();
		
		while (menuGerencia != 0) {
			if (menuGerencia == 1) {
				listarClientes();
			}
			
			else if (menuGerencia == 2) {
				mostrarCliente();
			}
			
			else if (menuGerencia == 3) {
				criarCliente();
			}
			
			else if (menuGerencia == 4) {
				apagarCliente();
			}
			else if (menuGerencia == 5) {
				alterarInformacao();
			}
			else if (menuGerencia == 6 ) {
				gerenciadorConta.listarContas();
			}
			else if (menuGerencia == 7) {
				System.out.println("Insira o numero da sua conta: ");
				String numeroConta = scanner.nextLine();
				Contas conta = gerenciadorConta.buscarConta(numeroConta);
				if(conta != null) {
					conta.mostrarConta();
				} else {
					System.out.println("Conta não encontrada! ");
				}
				
				
			}
			else if (menuGerencia == 8) {
				gerenciadorConta.criarConta();
			}
			else if (menuGerencia == 9) {
				gerenciadorConta.apagarConta();
			}
			
			else {
				System.out.println("Opção inválida! Insira uma opção dentro do intervalo especificado: ");
			}
			
			System.out.println("### GERÊNCIA ###\n"
					 + "O que deseja executar?\n"
			  		 + "1. Listar clientes\n"
			  		 + "2. Mostrar dados de um cliente específico\n"
			  		 + "3. Alterar informações\n"
			  		 + "4. Adicionar cliente\n"
			  		 + "5. Apagar cliente\n"
			  		 + "6. Listar contas\n"
			  		 + "7. Mostrar dados de uma conta específicar\n"
			  		 + "8. Adicionar conta\n"
			  		 + "9. Apagar conta\n"
			  		 + "0. Sair");
		   menuGerencia = scanner.nextInt();
		   scanner.nextLine();
		}

		
	}

		
		
	}
	

