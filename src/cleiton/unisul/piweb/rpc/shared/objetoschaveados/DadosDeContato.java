package cleiton.unisul.piweb.rpc.shared.objetoschaveados;

import java.io.Serializable;
import java.util.Collection;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import cleiton.unisul.piweb.rpc.shared.ObjetoChaveado;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.acessorios.PadraoItemResumo;


@PersistenceCapable(detachable="true")
public class DadosDeContato implements ObjetoChaveado, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8294374056793000729L;

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
	private String chave;
	
	@Persistent(defaultFetchGroup="true")
    private Collection<String> emails;

	@Persistent
    private String endereco;

	@Persistent(defaultFetchGroup="true")
    private Collection<String> telefones;   
	
	public String getChave() {
		return chave;
	}


	public void setChave(String chave) {
		this.chave = chave;
	}

	public Collection<String> getEmails() {
		return emails;
	}


	public void setEmails(Collection<String> emails) {
		this.emails = emails;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public Collection<String> getTelefones() {
		return telefones;
	}


	public void setTelefones(Collection<String> telefones) {
		this.telefones = telefones;
	}


	@Override
 	public String getResumo(){
     	StringBuilder b=new StringBuilder();
     	
     	PadraoItemResumo p = PadraoItemResumo.get();
     	p.gerarItem(b, "Endereco", endereco);
     	p.gerarItem(b, "Telefones", telefones);
     	p.gerarItem(b, "Emails", emails);
 		
 		return b.toString();
 	}
	
	

}
