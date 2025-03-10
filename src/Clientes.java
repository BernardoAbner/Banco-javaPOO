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
	public String getNome() {
		return nome;
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
	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setSexo(String novoSexo) {
		this.sexo = novoSexo;
}
	public String getSexo() {
		return sexo;
	}

	public void setTelefone(String novoTelefone) {
		this.telefone = novoTelefone;
}
	public String getTelefone() {
		return telefone;
	}

	public void setEmail(String novoEmail) {
		this.email = novoEmail;
}
	public String getEmail() {
		return email;
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
