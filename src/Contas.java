import java.util.Scanner;

public abstract class Contas {

	Scanner scanner = new Scanner(System.in);
	
	private double valor;
	private double saldo;
	private int contaDestino;
	
	
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
	
	public void setContaDestino(int novaContaDestino) {
		this.contaDestino = novaContaDestino;
	}	

		public void sacar() {
			System.out.println("Insira o valor que deseja movimentar: ");
			setValor(scanner.nextDouble());
			
			if(getValor() > getSaldo()) {
				System.out.println("O valor de movimentação é maior que o saldo. Por favor insira um valor dentro do seu limite.");
				System.out.println("O saldo atual: "+ getSaldo());
			}
			else {
				setSaldo(getSaldo() + getValor());
				System.out.println("Saldo atual após a movimentação: "+ getSaldo());
			}
			
		}
		public void depositar() {
			System.out.println("Insira o número da conta em que deseja depositar o dinheiro: ");
			
			System.out.println("Insira o valor que deseja depositar: ");
			setValor(scanner.nextDouble());
			
			setSaldo(getSaldo() + getValor());
			System.out.println("O valor após o depósito: " + getSaldo());
		}
		
		public void transferir() {
			sacar();
			
		}
		
	}

	
	

