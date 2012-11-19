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
public class Turno implements ObjetoChaveado {
	
//	@PrimaryKey
//	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
//	private Object chave;
	
	@Persistent
	private Date fim;


	@Persistent
	private Date inicio;


//	public Object getChave() {
//		return chave;
//	}


	public Date getFim() {
		return fim;
	}


	public Date getInicio() {
		return inicio;
	}


	@Override
 	public String getResumo(){
     	StringBuilder b=new StringBuilder();
     	
     	PadraoItemResumo p = PadraoItemResumo.get();
     	p.gerarItem(b, "in’cio", String.format("R", inicio));
     	p.gerarItem(b, "in’cio", String.format("R", fim));
 		
 		return b.toString();
 	}


//	public void setChave(Object chave) {
//		this.chave = chave;
//	}
	
	public void setFim(Date fim) {
		this.fim = fim;
	}
	
	
	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

}
