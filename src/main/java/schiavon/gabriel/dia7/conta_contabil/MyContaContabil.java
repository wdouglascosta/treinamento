package schiavon.gabriel.dia7.conta_contabil;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import schiavon.gabriel.dia5.jpa.associacoes.BaseEntity;

@Entity
public class MyContaContabil extends BaseEntity {

	private String codigo;
	private String nome;

	@JsonIgnore
	@ManyToOne
	private MyContaContabil contaSuperior;
	
	@JsonIgnore
	@OneToMany(mappedBy = "contaSuperior")
	private List<MyContaContabil> contasFilhas;

	public MyContaContabil() {
		super();
	}
	
	public MyContaContabil(UUID id, String codigo, String nome, MyContaContabil contaSuperior) {
		super(id);
		this.codigo = codigo;
		this.nome = nome;
		this.contaSuperior = contaSuperior;
	}

	public MyContaContabil(String codigo, String nome, MyContaContabil contaSuperior) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.contaSuperior = contaSuperior;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@JsonIgnore
	public MyContaContabil getContaSuperior() {
		return contaSuperior;
	}

	public void setContaSuperior(MyContaContabil contaSuperior) {
		this.contaSuperior = contaSuperior;
	}
	
	@JsonIgnore
	public List<MyContaContabil> getContasFilhas() {
		return contasFilhas;
	}

	public void setContasFilhas(List<MyContaContabil> contasFilhas) {
		this.contasFilhas = contasFilhas;
	}

	public UUID getContaSuperiorId() {
		if (this.contaSuperior != null) {
			return this.contaSuperior.getId();
		}
		return null;
	}
	
	@Override
	public String toString() {
		return "MyContaContabil [codigo=" + codigo + ", nome=" + nome + ", contaSuperior=" + contaSuperior
				+ ", getId()=" + getId() + "]";
	}
}
