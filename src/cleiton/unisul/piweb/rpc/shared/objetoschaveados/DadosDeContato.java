package cleiton.unisul.piweb.rpc.shared.objetoschaveados;

import java.util.Collection;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import org.datanucleus.api.jpa.annotations.Extension;

import cleiton.unisul.piweb.rpc.shared.ObjetoChaveado;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.acessorios.PadraoItemResumo;

@SuppressWarnings("serial")
@PersistenceCapable
public class DadosDeContato implements ObjetoChaveado{

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
	private String chave;
	
	@Persistent
    private Collection<String> emails;

	@Persistent
    private String endereco;

	@Persistent
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
