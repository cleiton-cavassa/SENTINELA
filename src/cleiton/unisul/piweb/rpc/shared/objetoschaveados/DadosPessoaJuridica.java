package cleiton.unisul.piweb.rpc.shared.objetoschaveados;

import java.util.Collection;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import org.datanucleus.api.jpa.annotations.Extension;

import cleiton.unisul.piweb.rpc.shared.ObjetoChaveado;

@SuppressWarnings("serial")
public class DadosPessoaJuridica implements ObjetoChaveado {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
	private String chave;
	
	@Persistent
	private Long cnpj;
	
	@Persistent
	private String razaoSocial;
	
	@Persistent
	private Collection<String> regioesDeAtuacao;
	
	
	public String getChave() {
		return chave;
	}


	public void setChave(String chave) {
		this.chave = chave;
	}


	public Long getCnpj() {
		return cnpj;
	}


	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}


	public String getRazaoSocial() {
		return razaoSocial;
	}


	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}


	public Collection<String> getRegioesDeAtuacao() {
		return regioesDeAtuacao;
	}


	public void setRegioesDeAtuacao(Collection<String> regioesDeAtuacao) {
		this.regioesDeAtuacao = regioesDeAtuacao;
	}


	@Override
	public String getResumo() {
		// TODO Auto-generated method stub
		return null;
	}

}
