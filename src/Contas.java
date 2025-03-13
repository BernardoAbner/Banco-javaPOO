import java.util.Scanner;

public class Contas {

	Scanner scanner = new Scanner(System.in);
	GerenciadorClientes gerenciadorCliente = new GerenciadorClientes();
	Clientes cliente = new Clientes();
	
	
	protected double valor;
	protected double saldo;
	protected String contaDestino;
	protected String senha;
	protected String numeroConta;
	protected Clientes titular;	
		
	
	public void setValor(double novoValor) {
		this.valor = novoValor;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setSaldo(double novoSaldo) {
		this.saldo = novoSaldo;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public void setContaDestino(String novaContaDestino) {
		this.contaDestino = novaContaDestino;
	}	
	
	public String getContaDestino() {
		return contaDestino;
	}

	public void setSenha(String novaSenha) {
		this.senha = novaSenha;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setNumeroConta(String novoNumeroConta) {
		this.numeroConta = novoNumeroConta;
	}
	
	public String getNumeroConta() {
		return numeroConta;
	}
	
	public void setTitular(Clientes nome) {
		this.titular = nome;
	}
	public Clientes getTitular() {
		return titular;
	}
	
	public void sacar() {
			System.out.println("Insira o valor que deseja movimentar: ");
			setValor(scanner.nextDouble());
			
			if(getValor() > getSaldo() || getValor() <= 0){
				System.out.println("O valor de movimentação é maior que o saldo ou o valor é inválido.");
				System.out.println("O saldo atual: "+ getSaldo());
			}
			else {
				setSaldo(getSaldo() - getValor());
				System.out.println("Saldo atual após a movimentação: "+ getSaldo());
			}
			
		}
	public void depositar() {
			System.out.println("Insira o número da conta em que deseja depositar o dinheiro: ");
			setContaDestino(scanner.nextLine());
			
			System.out.println("Insira o valor que deseja depositar: ");
			setValor(scanner.nextDouble());	
			scanner.nextLine();
			
			if(valor > 0) {
			
			setSaldo(getSaldo() + getValor());
			System.out.println("O valor após o depósito: " + getSaldo());
			}
			else {
				System.out.println("Valor inválido.");
			}
		}
		
	public void transferir() {
			sacar();
			depositar();
		}
	
	public void mostrarConta() { 
		System.out.println("Saldo da conta: "+ saldo + "R$");
		System.out.println("Numero da conta é: "+ numeroConta);
		if(titular != null) {
		System.out.println("O Titular da conta é: "+ titular.getNome());
		}
		else {
			System.out.println("Sem titular");
		}
	}
	
		
}
	

