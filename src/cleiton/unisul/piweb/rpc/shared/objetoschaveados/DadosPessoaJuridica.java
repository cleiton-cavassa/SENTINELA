package cleiton.unisul.piweb.rpc.shared.objetoschaveados;

import java.util.ArrayList;
import java.util.Collection;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import cleiton.unisul.piweb.rpc.shared.ObjetoChaveado;

@PersistenceCapable(detachable="true")
public class DadosPessoaJuridica implements ObjetoChaveado {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5639742467355654224L;

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
	private String chave;
	
	public DadosPessoaJuridica(){}
	
	@Persistent
	private long cnpj;
	
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


	public long getCnpj() {
		return cnpj;
	}


	public void setCnpj(long cnpj) {
		this.cnpj = cnpj;
	}


	public String getRazaoSocial() {
		return razaoSocial;
	}


	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}


	public Collection<String> getRegioesDeAtuacao() {
		if(regioesDeAtuacao==null){
			setRegioesDeAtuacao(new ArrayList<String>());
		}
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
