import lombok.Data;
import lombok.NonNull;

@Data
public class Cliente {

	@NonNull
	private String nome;
	@NonNull
	private String cpf;
	@NonNull
	Endereco endereco;

	public Cliente (String nome, String cpf, Endereco endereco ){
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
	}



}
