import lombok.Data;

@Data
public abstract class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}
	//condicionando saque com saldo positivo
	@Override
	public void sacar(double valor) {
		if (saldo >0){
			saldo -= valor;
		}else {
			throw  new RuntimeException("saldo insuficiente");
		}

	}
     //condicionando o limite de deposito  500,00 por deposito
	@Override
	public void depositar(double valor) {
		if (valor <= 500){
			saldo += valor;
		}else {
			throw  new RuntimeException("valor superior ao limite de deposito");
		}

	}

	//condicionando um limite de tranferências a 200,00 por transferência
	@Override
	public void transferir(double valor, IConta contaDestino) {

		if (saldo > 0 ){
			this.sacar(valor);
		}
		else{
			throw new RuntimeException("saldo insuficiente");
		}

		if(valor < 200){
			contaDestino.depositar(valor);

		}else{
			throw new RuntimeException("valor supeior ao limite");
		}
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}


}
