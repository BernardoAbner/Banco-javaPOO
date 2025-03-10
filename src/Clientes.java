public class Clientes {

	private String nome;
	private String cpf;
	private String dataNascimento;
	private String sexo;
	private String telefone;
	private String email;
	
	public void setNome(String novoNome){
		this.nome = novoNome;
}

	public void setCpf(String novoCpf) {
		this.cpf = novoCpf;
}
	public String getCpf() {
		return cpf;
	}

	public void setDataNascimento(String novaDataNascimento) {
		this.dataNascimento = novaDataNascimento;
}

	public void setSexo(String novoSexo) {
		this.sexo = novoSexo;
}

	public void setTelefone(String novoTelefone) {
		this.telefone = novoTelefone;
}

	public void setEmail(String novoEmail) {
		this.email = novoEmail;
}
	
	public void mostrarDados() {
		System.out.println("Nome: " + nome);
		System.out.println("CPF: " + cpf);
		System.out.println("Data de nascimento: "+ dataNascimento);
		System.out.println("Sexo: "+ sexo);
		System.out.println("Telefone: " + telefone);
		System.out.println("Email:"+ email);
		
	}
	



}
