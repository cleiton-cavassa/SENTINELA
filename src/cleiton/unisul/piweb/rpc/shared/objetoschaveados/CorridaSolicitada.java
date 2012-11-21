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
public class CorridaSolicitada implements ObjetoChaveado {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
	private String chave;
	
	@Persistent//chave codificada do cliente
	private String cliente;
	
	@Persistent//chave codificada do motorista
	private String motorista;
	
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

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getMotorista() {
		return motorista;
	}

	public void setMotorista(String motorista) {
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
