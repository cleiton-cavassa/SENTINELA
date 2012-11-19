package cleiton.unisul.piweb.rpc.shared.objetoschaveados;

import java.util.Date;


import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import cleiton.unisul.piweb.rpc.shared.ObjetoChaveado;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.acessorios.PadraoItemResumo;

@SuppressWarnings("serial")
@PersistenceCapable
public class ConviteRecebido implements ObjetoChaveado {

//	@PrimaryKey
//	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
//	private Object chave;
	
	@Persistent
	private Long cnpj;
	
	@Persistent
	private Date dataConvite;
	
	@Persistent
	private Object frotaRemetente;
	
	@Persistent
	private String razaoSocial;
	
//	public Object getChave() {
//		return chave;
//	}

	public Long getCnpj() {
		return cnpj;
	}

	public Date getDataConvite() {
		return dataConvite;
	}

	public Object getFrotaRemetente() {
		return frotaRemetente;
	}

	public String getRazaoSocial() {
		return razaoSocial;
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

//	public void setChave(Object chave) {
//		this.chave = chave;
//	}

	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}

	public void setDataConvite(Date dataConvite) {
		this.dataConvite = dataConvite;
	}

	public void setFrotaRemetente(Object frotaRemetente) {
		this.frotaRemetente = frotaRemetente;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
}
