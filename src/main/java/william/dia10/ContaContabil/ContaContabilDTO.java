package william.dia10.ContaContabil;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ContaContabilDTO extends BaseDTO<ContaContabil> {
	private Long contaSuperiorId;
	private String nome;
	private String codigo;

	@Override
	public ContaContabil toEntity() {
		return ContaContabil.builder().id(id).version(version).nome(nome).codigo(codigo).build();
	}

	@Override
	public ContaContabil mergeEntity(ContaContabil actual) {
		return actual;

	}
}
