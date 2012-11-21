package cleiton.unisul.piweb.rpc.shared.objetoschaveados;

import java.util.Date;


import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import org.datanucleus.api.jpa.annotations.Extension;

import cleiton.unisul.piweb.rpc.shared.ObjetoChaveado;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.acessorios.PadraoItemResumo;

@SuppressWarnings("serial")
@PersistenceCapable
public class ConviteRecebido implements ObjetoChaveado {

	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
	private String chave;
	
	@Persistent
	private Long cnpj;
	
	@Persistent
	private Date dataConvite;
	
	@Persistent
	private Object frotaRemetente;
	
	@Persistent
	private String razaoSocial;

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

	public Date getDataConvite() {
		return dataConvite;
	}

	public void setDataConvite(Date dataConvite) {
		this.dataConvite = dataConvite;
	}

	public Object getFrotaRemetente() {
		return frotaRemetente;
	}

	public void setFrotaRemetente(Object frotaRemetente) {
		this.frotaRemetente = frotaRemetente;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	@Override
 	public String getResumo(){
     	StringBuilder b=new StringBuilder();
     	
     	PadraoItemResumo p = PadraoItemResumo.get();
     	p.gerarItem(b, "CNPJ do remetente", cnpj);
     	p.gerarItem(b, "Razao Social do remetente", razaoSocial);
     	p.gerarItem(b, "data do convite", dataConvite);
 		
 		return b.toString();
 	}
}
