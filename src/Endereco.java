import lombok.Data;

@Data
public class Endereco {

    private String longadouro;
    private String cidade;
    private String bairro;
    private String numero;
    private int cep;

    public Endereco(String longadouro, String cidade, String bairro, String numero, int cep){
        this.bairro = bairro;
        this.numero = numero;
        this.cep = cep;
        this.longadouro = longadouro;
        this.cidade = cidade;
    }

    public String resumoEndereco(){
        return "CEP " + cep + " cidade " + cidade + " bairro "
                + bairro + " longadouro " + longadouro + " e numero " + numero;
    }
}
