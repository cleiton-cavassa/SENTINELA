package cleiton.unisul.piweb.shared;

import java.io.Serializable;
import java.util.List;

import javax.jdo.annotations.*;

@PersistenceCapable
public class Frota implements Serializable, ObjetoChaveado {
	
	@Persistent
	private Long CNPJ;
	
	@Persistent
	private String razaoSocial;
	
	@Persistent
	private String endereco;
	
	@Persistent
	private List<String> telefones;
	
	@Persistent
	private List<String> Strings;
	
	@Persistent
	private List<String> regioesDeAtuacao;
	
	@Persistent
	private List<Integer> ClientesPJ;
	
	public Long getChave() {
		return CNPJ;
	}

	public void setChave(Long cNPJ) {
		CNPJ = cNPJ;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public List<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<String> telefones) {
		this.telefones = telefones;
	}

	public List<String> getStrings() {
		return Strings;
	}

	public void setStrings(List<String> Strings) {
		this.Strings = Strings;
	}

	public List<String> getRegioesDeAtuacao() {
		return regioesDeAtuacao;
	}

	public void setRegioesDeAtuacao(List<String> regioesDeAtuacao) {
		this.regioesDeAtuacao = regioesDeAtuacao;
	}

	public List<Integer> getClientesPJ() {
		return ClientesPJ;
	}

	public void setClientesPJ(List<Integer> clientesPJ) {
		ClientesPJ = clientesPJ;
	}

	public List<Integer> getClientesPF() {
		return ClientesPF;
	}

	public void setClientesPF(List<Integer> clientesPF) {
		ClientesPF = clientesPF;
	}

	@Persistent
	List<Integer> ClientesPF;
}
