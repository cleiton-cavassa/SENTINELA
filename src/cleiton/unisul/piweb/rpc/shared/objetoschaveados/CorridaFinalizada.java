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
public class CorridaFinalizada implements ObjetoChaveado {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3038391588553764762L;

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
	private String chave;
	
	@Persistent
	private CorridaSolicitada corridaSolicitada;
	
	@Persistent
	private Date dataHoraDesembarque;
	
	@Persistent
	private String localDesembarque;

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public CorridaSolicitada getCorridaSolicitada() {
		return corridaSolicitada;
	}

	public void setCorridaSolicitada(CorridaSolicitada corridaSolicitada) {
		this.corridaSolicitada = corridaSolicitada;
	}

	public Date getDataHoraDesembarque() {
		return dataHoraDesembarque;
	}

	public void setDataHoraDesembarque(Date dataHoraDesembarque) {
		this.dataHoraDesembarque = dataHoraDesembarque;
	}

	public String getLocalDesembarque() {
		return localDesembarque;
	}

	public void setLocalDesembarque(String localDesembarque) {
		this.localDesembarque = localDesembarque;
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

}
