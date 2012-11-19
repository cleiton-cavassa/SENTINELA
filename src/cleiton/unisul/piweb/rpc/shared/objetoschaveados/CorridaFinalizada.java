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
public class CorridaFinalizada implements ObjetoChaveado {
	
//	@PrimaryKey
//	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
//	private Object chave;
	
	@Persistent
	private CorridaSolicitada corridaSolicitada;
	
	@Persistent
	private Date dataHoraDesembarque;
	
	@Persistent
	private String localDesembarque;
	
	
//	public Object getChave() {
//		return chave;
//	}


	public CorridaSolicitada getCorridaSolicitada() {
		return corridaSolicitada;
	}


	public Date getDataHoraDesembarque() {
		return dataHoraDesembarque;
	}


	public String getLocalDesembarque() {
		return localDesembarque;
	}


	@Override
 	public String getResumo(){
     	StringBuilder b=new StringBuilder();
     	PadraoItemResumo p = PadraoItemResumo.get();
     	
     	p.gerarItem(b, "Dados da corrida solicitada", corridaSolicitada);
     	p.gerarItem(b, "Local do desembarque", localDesembarque);
     	p.gerarItem(b, "Data e Hora do desembarque", dataHoraDesembarque);
  	
 		return b.toString();
 	}


//	public void setChave(Object chave) {
//		this.chave = chave;
//	}


	public void setCorridaSolicitada(CorridaSolicitada corridaSolicitada) {
		this.corridaSolicitada = corridaSolicitada;
	}


	public void setDataHoraDesembarque(Date dataHoraDesembarque) {
		this.dataHoraDesembarque = dataHoraDesembarque;
	}


	public void setLocalDesembarque(String localDesembarque) {
		this.localDesembarque = localDesembarque;
	}


}
