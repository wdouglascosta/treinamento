package treinamento.dia4.jdbc.repo_generico;

public class Produto extends Entidade {
	private String nome;
	
	public Produto(String nome) {
		super();
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
