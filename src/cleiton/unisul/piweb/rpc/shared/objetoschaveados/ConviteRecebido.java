package cleiton.unisul.piweb.rpc.shared.objetoschaveados;

import java.util.Date;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import cleiton.unisul.piweb.rpc.shared.ObjetoChaveado;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.acessorios.PadraoItemResumo;

@PersistenceCapable(detachable="true")
public class ConviteRecebido implements ObjetoChaveado {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6353431444954508293L;

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

	
	@Persistent
	private long cnpj;
	
	@Persistent
	private Date dataConvite;
	
	@Persistent//chave codificada
	private String frotaRemetente;
	
	@Persistent
	private String razaoSocial;

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

	public Date getDataConvite() {
		return dataConvite;
	}

	public void setDataConvite(Date dataConvite) {
		this.dataConvite = dataConvite;
	}

	public String getFrotaRemetente() {
		return frotaRemetente;
	}

	public void setFrotaRemetente(String frotaRemetente) {
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
	
	@Override 
	public String toString(){
		return getResumo();
	}
}
