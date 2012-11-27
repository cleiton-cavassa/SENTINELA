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
public class CorridaCancelada implements ObjetoChaveado {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6780450017028023234L;

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
	private String chave;

	@Persistent
	private CorridaSolicitada corridaSolicitada;



	@Persistent
	private Date dataHoraCancelamento;



	@Persistent
	private String motivo;



	public String getChave() {
		return chave;
	}



	public CorridaSolicitada getCorridaSolicitada() {
		return corridaSolicitada;
	}



	public Date getDataHoraCancelamento() {
		return dataHoraCancelamento;
	}



	public String getMotivo() {
		return motivo;
	}



	@Override
 	public String getResumo(){
     	StringBuilder b=new StringBuilder();
     	PadraoItemResumo p = PadraoItemResumo.get();
     	
     	p.gerarItem(b, "Dados da corrida solicitada", corridaSolicitada);
     	p.gerarItem(b, "Motivo do cancelamento", motivo);
     	p.gerarItem(b, "Data e Hora do registro do cancelamento", dataHoraCancelamento);
  	
 		return b.toString();
 	}



	public void setChave(String chave) {
		this.chave = chave;
	}
	
	public void setCorridaSolicitada(CorridaSolicitada corridaSolicitada) {
		this.corridaSolicitada = corridaSolicitada;
	}
	
	public void setDataHoraCancelamento(Date dataHoraCancelamento) {
		this.dataHoraCancelamento = dataHoraCancelamento;
	}
	
	

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}



}
