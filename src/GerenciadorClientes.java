import java.util.Scanner;
import java.util.ArrayList;

public class GerenciadorClientes {

	private ArrayList<Clientes> listaClientes = new ArrayList<>();
	private Scanner scanner = new Scanner(System.in);
	
	public void adicionarCliente(){
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
		for (Clientes i : listaClientes) {
			if (listaClientes.isEmpty()) {
				System.out.println("Nenhum cliente cadastrado até o momento. Deseja cadastrar um novo?\n"
				+"1. Sim\n"
				+"2. Não");
				int menu = scanner.nextInt();
				if (menu == 1) {
					adicionarCliente();
				}
				else {
					System.out.println("Retornando ao menu principal...");
				}
				return;
			}
			i.mostrarDados();
		}
	}
		
	public void mostrarCliente() {
		System.out.println("Insira o cpf do cliente para mostrar informações: ");
		String cpf = scanner.nextLine();
		buscarCliente(cpf);
		}
	
	public void apagarCliente() {
		System.out.println("Insira o cpf do cliente que deseja apagar: ");
		String cpf = scanner.nextLine();
		
		for (Clientes cliente : listaClientes) {
			int cont = 0;
			
			if (cliente.getCpf().equals(cpf)) {
				listaClientes.remove(cliente);
				cont ++;
			}
			if (cont == 0) {
				System.out.println("Nenhum cliente com o cpf " + cpf +" foi encontrado em nosso sistema.");
			}
			else {
				System.out.println("O cliente "+ cliente.getNome() + "foi excluido com sucesso!");
			}
			return;
		}
		System.out.println("Segue abaixo a lista de cliente atualizada: ");
		listarClientes();
		
	}
	
	public void alterarInformacao() {
		System.out.println("Insira o CPF do cliente que deseja alterar informações: ");
		String cpf = scanner.nextLine();
		for (Clientes cliente : listaClientes) {
			if (cliente.getCpf().equals(cpf)) {
				mostrarCliente();
				System.out.println("Qual informação deseja alterar?\n"
								 + "1. Nome\n"
								 + "2. CPF\n"
								 + "3. Data de Nascimento\n"
								 + "4. Sexo\n"
								 + "5. Telefone\n"
								 + "6. Email\n"
								 + "0. Sair");
				int subMenu = scanner.nextInt();
				
				while (subMenu != 0) {
				if (subMenu == 1) {
					System.out.println("O nome atual é " + cliente.getNome() + " insira o nome para qual deseja alterar: ");
					cliente.setNome(scanner.nextLine());
				}
				else if(subMenu == 2) {
					System.out.println("O CPF atual é "+ cliente.getCpf() + " insira o cpf para qual deseja alterar: ");
					cliente.setCpf(scanner.nextLine());
				}
				else if (subMenu == 3) {
					System.out.println("A data de nascimento atual é: "+ cliente.getDataNascimento() + " insira a data de nascimento para a qual deseja alterar: ");
					cliente.setDataNascimento(scanner.nextLine());
				}
				else if(subMenu == 4) {
					System.out.println("O sexo atua é: "+ cliente.getSexo() + " insira o sexo para o qual deseja alterar: ");
					cliente.setSexo(scanner.nextLine());
				}
				else if(subMenu == 5) {
					System.out.println("O telefone atual é: "+ cliente.getTelefone() + " insira o telefone para o qual deseja alter: ");
					cliente.setTelefone(scanner.nextLine());
				}
				else if(subMenu == 6) {
					System.out.println("O email atual é: "+ cliente.getEmail() + " insira o email para o qual deseja alterar: ");
					cliente.setEmail(scanner.nextLine());
				}
				
				System.out.println("Qual informação deseja alterar?\n"
						 + "1. Nome\n"
						 + "2. CPF\n"
						 + "3. Data de Nascimento\n"
						 + "4. Sexo\n"
						 + "5. Telefone\n"
						 + "6. Email\n"
						 + "0. Sair");
				subMenu = scanner.nextInt();
				
				}
				System.out.println("Informações gravadas com sucesso! Segue abaixo os seus dados atuaizados: ");
				cliente.mostrarDados();
			}
			
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
				  		 + "0. Sair");
		int menuGerencia = scanner.nextInt();
		
		while (menuGerencia != 0) {
			if (menuGerencia == 1) {
				listarClientes();
			}
			
			else if(menuGerencia == 2) {
				mostrarCliente();
			}
			
			else if (menuGerencia == 3) {
				adicionarCliente();
			}
			
			else if (menuGerencia == 4) {
				apagarCliente();
			}
			else if (menuGerencia == 5) {
				alterarInformacao();
			}
			System.out.println("### GERÊNCIA ###\n"
					 + "O que deseja executar?\n"
			  		 + "1. Listar clientes\n"
			  		 + "2. Mostrar dados de um cliente específico\n"
			  		 + "3. Adiciionar clientes\n"
			  		 + "4. Apagar cliente\n"
			  		 + "5. Alterar informação do cliente\n"
			  		 + "0. Sair");
		   menuGerencia = scanner.nextInt();
		}

		
	}
		
		
	}
	

