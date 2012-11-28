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
public class CorridaSolicitada implements ObjetoChaveado {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3136578762285625374L;

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
	private String chave;
	
	@Persistent//chave codificada do cliente
	private ParChaveDescricao cliente;
	
	@Persistent//chave codificada do motorista
	private ParChaveDescricao motorista;
	
	@Persistent
	private Date dataHoraEmbarque;
	
	@Persistent
	private String localEmbarque;
	
	@Persistent
	private String localPrevisaoDesembarque;
	
	@Persistent
	private String observacao;

	
	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public ParChaveDescricao getCliente() {
		if(cliente==null){
			setCliente(new ParChaveDescricao());
		}
		return cliente;
	}

	public void setCliente(ParChaveDescricao cliente) {
		this.cliente = cliente;
	}

	public ParChaveDescricao getMotorista() {
		if(motorista==null){
			setMotorista(new ParChaveDescricao());
		}
		return motorista;
	}

	public void setMotorista(ParChaveDescricao motorista) {
		this.motorista = motorista;
	}

	public Date getDataHoraEmbarque() {
		return dataHoraEmbarque;
	}

	public void setDataHoraEmbarque(Date dataHoraEmbarque) {
		this.dataHoraEmbarque = dataHoraEmbarque;
	}

	public String getLocalEmbarque() {
		return localEmbarque;
	}

	public void setLocalEmbarque(String localEmbarque) {
		this.localEmbarque = localEmbarque;
	}

	public String getLocalPrevisaoDesembarque() {
		return localPrevisaoDesembarque;
	}

	public void setLocalPrevisaoDesembarque(String localPrevisaoDesembarque) {
		this.localPrevisaoDesembarque = localPrevisaoDesembarque;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Override
 	public String getResumo(){
     	StringBuilder b=new StringBuilder();
     	
     	PadraoItemResumo p = PadraoItemResumo.get();
     	p.gerarItem(b, "Cliente", cliente);
     	p.gerarItem(b, "Data e hora do embarque", dataHoraEmbarque);
     	p.gerarItem(b, "Local do embarque", localEmbarque);
     	p.gerarItem(b, "Destino previsto", localPrevisaoDesembarque);
     	p.gerarItem(b, "Obs", observacao);
     	p.gerarItem(b, "Motorista", motorista);
  	
 		return b.toString();
 	}	
}
