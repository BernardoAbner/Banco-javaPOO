
public class ContaCorrente extends Contas {
	private static int contadorCorrente = 1000;
	
	public String numeroContaC() {	
		this.numeroConta = contadorCorrente + "-C";
		contadorCorrente++;
		return getNumeroConta();
	}
	
}