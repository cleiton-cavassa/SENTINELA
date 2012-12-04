package cleiton.unisul.piweb.rpc.shared.objetoschaveados;

import java.util.ArrayList;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import cleiton.unisul.piweb.rpc.shared.ObjetoChaveado;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.acessorios.PadraoItemResumo;


@PersistenceCapable(detachable="true")
public class DadosDeContato implements ObjetoChaveado {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8294374056793000729L;

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
	private String chave;
	
	@Persistent
	@Extension(vendorName="datanucleus", key="gae.parent-pk", value="true")
	private String chavePai;
	
	public String getChavePai() {
		return chavePai;
	}

	public void setChavePai(String chavePai) {
		this.chavePai = chavePai;
	}

	
	
	
	@Persistent(defaultFetchGroup="true")
    private ArrayList<String> emails;

	@Persistent
    private String endereco;

	@Persistent(defaultFetchGroup="true")
    private ArrayList<String> telefones;   
	
	public String getChave() {
		return chave;
	}


	public void setChave(String chave) {
		this.chave = chave;
	}

	public ArrayList<String> getEmails() {
		if(emails==null){
			setEmails(new ArrayList<String>());
		}
		return emails;
	}


	public void setEmails(ArrayList<String> emails) {
		this.emails = emails;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public ArrayList<String> getTelefones() {
		if(telefones==null){
			setTelefones(new ArrayList<String>());
		}
		return telefones;
	}


	public void setTelefones(ArrayList<String> telefones) {
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
