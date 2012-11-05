package cleiton.unisul.piweb.shared;
import java.util.Date;
import java.util.List;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import com.google.appengine.api.datastore.*;

@PersistenceCapable
public class ClientePJ {
	
	@Persistent
	private String CNPJ;
	
	@Persistent
	private String razaoSocial;
	
	@Persistent
	private Boolean status;
	
	@Persistent
	private List<ClientePF> pessoasFisicas;
	
	@Persistent
	private List<PostalAddress> regioesDeAtuacao;
	
	@Persistent
	private Boolean vouchersAtivos;

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

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public List<ClientePF> getPessoasFisicas() {
		return pessoasFisicas;
	}

	public void setPessoasFisicas(List<ClientePF> pessoasFisicas) {
		this.pessoasFisicas = pessoasFisicas;
	}

	public List<PostalAddress> getRegioesDeAtuacao() {
		return regioesDeAtuacao;
	}

	public void setRegioesDeAtuacao(List<PostalAddress> regioesDeAtuacao) {
		this.regioesDeAtuacao = regioesDeAtuacao;
	}

	public Boolean getVouchersAtivos() {
		return vouchersAtivos;
	}

	public void setVouchersAtivos(Boolean vouchersAtivos) {
		this.vouchersAtivos = vouchersAtivos;
	}
}
