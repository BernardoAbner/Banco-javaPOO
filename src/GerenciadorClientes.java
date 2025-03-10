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
			listaClientes.add(novoCliente);
			
			System.out.println("Cliente adicionado com sucesso!!!");
	}
	
	public Clientes buscarCliente(String cpf) {
		for (Clientes i : listaClientes) {
			if (i.getCpf().equals(cpf)) {
				return i;
			}
		}
	return null;
	}
	
}
