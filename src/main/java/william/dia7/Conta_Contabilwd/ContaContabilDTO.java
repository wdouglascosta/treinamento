package william.dia7.Conta_Contabilwd;

import java.util.UUID;

import lombok.Data;

@Data
public class ContaContabilDTO {
	private UUID id;
	private UUID contaSuperiorId;
	private String nome;
	private String codigo;
}