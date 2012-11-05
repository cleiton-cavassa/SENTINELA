package cleiton.unisul.piweb.shared;

import java.util.List;

import javax.jdo.annotations.*;

import com.google.appengine.api.datastore.*;

@PersistenceCapable
public class Frota {
	
	@Persistent
	private String CNPJ;
	
	@Persistent
	private String razaoSocial;
	
	@Persistent
	private PostalAddress endereco;
	
	@Persistent
	private List<PhoneNumber> telefones;
	
	@Persistent
	private List<Email> emails;
	
	@Persistent
	private List<PostalAddress> regioesDeAtuacao;
	
	@Persistent
	private List<Integer> ClientesPJ;
	
	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public PostalAddress getEndereco() {
		return endereco;
	}

	public void setEndereco(PostalAddress endereco) {
		this.endereco = endereco;
	}

	public List<PhoneNumber> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<PhoneNumber> telefones) {
		this.telefones = telefones;
	}

	public List<Email> getEmails() {
		return emails;
	}

	public void setEmails(List<Email> emails) {
		this.emails = emails;
	}

	public List<PostalAddress> getRegioesDeAtuacao() {
		return regioesDeAtuacao;
	}

	public void setRegioesDeAtuacao(List<PostalAddress> regioesDeAtuacao) {
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
