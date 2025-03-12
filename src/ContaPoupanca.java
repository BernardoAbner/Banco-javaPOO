
public class ContaPoupanca extends Contas {
	private static  int contadorPoupanca = 1000;
	
	public String numeroContaP(){
		setNumeroConta(contadorPoupanca + "-P");
		contadorPoupanca++;
		return getNumeroConta();
	}
	
	


}
