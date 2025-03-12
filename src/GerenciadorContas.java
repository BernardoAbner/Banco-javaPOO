import java.util.Scanner;
import java.util.ArrayList;

public class GerenciadorContas {
	Scanner scanner = new Scanner(System.in);
	
	GerenciadorClientes gerenciadorClientes = new GerenciadorClientes();
	Contas conta = new Contas();
	
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
	
	public void loginConta() {
		System.out.println("Insira o número da sua conta: ");
		String numeroConta = scanner.nextLine();
		for (Contas conta : listaContas) {
			if(conta.getNumeroConta().equals(numeroConta)) {
				System.out.println("Insira a sua senha: ");
				String senha = scanner.nextLine();
				if(conta.getSenha().equals(senha)) {
					System.out.println("Login realizado com sucesso! ");
				}
				else {
					System.out.println("Login inválido.");
				}
			}
		}
	}
	
	
	
	
	
}
