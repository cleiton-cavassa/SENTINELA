package cleiton.unisul.piweb.shared;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;


@SuppressWarnings("serial")
@PersistenceCapable
public class ClientePJ  implements Serializable {
	
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long CNPJ;
	
	@Persistent
	private String razaoSocial;
	
	@Persistent
	private Boolean status;
	
	/*
	@Persistent
	private ArrayList<ClientePF> pessoasFisicas;

	public ArrayList<ClientePF> getPessoasFisicas() {
		return pessoasFisicas;
	}

	public void setPessoasFisicas(ArrayList<ClientePF> pessoasFisicas) {
		this.pessoasFisicas = pessoasFisicas;
	}
	*/

	@Persistent
	private String enderecoMatriz;

	@Persistent
	private ArrayList<String> regioesDeAtuacao;
	
	@Persistent
	private Boolean vouchersAtivos;

	public Long getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(Long cNPJ) {
		CNPJ = cNPJ;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}


	public ArrayList<String> getRegioesDeAtuacao() {
		return regioesDeAtuacao;
	}
	
	public String getEnderecoMatriz() {
		return enderecoMatriz;
	}

	public void setEnderecoMatriz(String enderecoMatriz) {
		this.enderecoMatriz = enderecoMatriz;
	}

	public void setRegioesDeAtuacao(ArrayList<String> regioesDeAtuacao) {
		this.regioesDeAtuacao = regioesDeAtuacao;
	}

	public Boolean getVouchersAtivos() {
		return vouchersAtivos;
	}

	public void setVouchersAtivos(Boolean vouchersAtivos) {
		this.vouchersAtivos = vouchersAtivos;
	}
}
