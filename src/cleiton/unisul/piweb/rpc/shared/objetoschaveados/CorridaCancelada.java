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
public class CorridaCancelada implements ObjetoChaveado {
	
//	@PrimaryKey
//	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
//	private Object chave;
	
//	public Object getChave() {
//		return chave;
//	}



//	public void setChave(Object chave) {
//		this.chave = chave;
//	}



	public CorridaSolicitada getCorridaSolicitada() {
		return corridaSolicitada;
	}



	public void setCorridaSolicitada(CorridaSolicitada corridaSolicitada) {
		this.corridaSolicitada = corridaSolicitada;
	}



	public String getMotivo() {
		return motivo;
	}



	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}



	public Date getDataHoraCancelamento() {
		return dataHoraCancelamento;
	}



	public void setDataHoraCancelamento(Date dataHoraCancelamento) {
		this.dataHoraCancelamento = dataHoraCancelamento;
	}



	@Persistent
	private CorridaSolicitada corridaSolicitada;
	
	@Persistent
	private String motivo;
	
	@Persistent
	private Date dataHoraCancelamento;
	
	

	@Override
 	public String getResumo(){
     	StringBuilder b=new StringBuilder();
     	PadraoItemResumo p = PadraoItemResumo.get();
     	
     	p.gerarItem(b, "Dados da corrida solicitada", corridaSolicitada);
     	p.gerarItem(b, "Motivo do cancelamento", motivo);
     	p.gerarItem(b, "Data e Hora do registro do cancelamento", dataHoraCancelamento);
  	
 		return b.toString();
 	}



}
