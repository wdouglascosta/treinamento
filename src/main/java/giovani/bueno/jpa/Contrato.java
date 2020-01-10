package giovani.bueno.jpa;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({
	@NamedQuery(name = "delete_contrato", query = "delete from Contrato")
})
@Entity
public class Contrato {

	@Id
	private UUID id;
	
	@Embedded
	@Column(unique= true)
	@AttributeOverride(name = "valor",column = @Column(name="numero"))
	private InteiroPositivo  numero;
	
	@Column(nullable = false)
	
	private LocalDate emissao;
	
	@Embedded
	@AttributeOverride(name = "cpf",column = @Column(name="cpfDotitular"))
	private CPF cpfDoTitular;
	
	public Contrato() {
	 id = UUID.randomUUID();
	}

	public Contrato(InteiroPositivo numero, LocalDate emiss�o, CPF cpf) {
		this();
		this.numero = numero;
		this.emissao = emiss�o;
		this.cpfDoTitular = cpf;
	}
	
	public LocalDate getEmissao() {
		return emissao;
	}
	
	public UUID getId() {
		return id;
	}
	
	public InteiroPositivo getNumero() {
		return numero;
	}
	
	public void setNumero(InteiroPositivo numero) {
		this.numero = numero;
	}
	
	
	public CPF getCpfDoTitular() {
		return cpfDoTitular;
	}

	public void setCpfDoTitular(CPF cpfDoTitular) {
		this.cpfDoTitular = cpfDoTitular;
	}

	public void setEmissao(LocalDate emissao) {
		this.emissao = emissao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contrato other = (Contrato) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Contrato [id=" + id + ", numero=" + numero + ", emiss�o=" + emissao + "]";
	}
	
	
	
	
}
