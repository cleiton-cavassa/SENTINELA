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
public class CorridaSolicitada implements ObjetoChaveado {
	
//	@PrimaryKey
//	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
//	private Object chave;
	
//	@Persistent
//	private Object cliente;
	
	@Persistent
	private Date dataHoraEmbarque;
	
	@Persistent
	private String localEmbarque;
	
	@Persistent
	private String localPrevisaoDesembarque;
	
//	@Persistent
//	private Object motorista;
	
	@Persistent
	private String observacao;
	
	
//	public Object getChave() {
//		return chave;
//	}


//	public Object getCliente() {
//		return cliente;
//	}


	public Date getDataHoraEmbarque() {
		return dataHoraEmbarque;
	}


	public String getLocalEmbarque() {
		return localEmbarque;
	}


	public String getLocalPrevisaoDesembarque() {
		return localPrevisaoDesembarque;
	}


//	public Object getMotorista() {
//		return motorista;
//	}


	public String getObservacao() {
		return observacao;
	}


	@Override
 	public String getResumo(){
     	StringBuilder b=new StringBuilder();
     	
     	PadraoItemResumo p = PadraoItemResumo.get();
//     	p.gerarItem(b, "Cliente", cliente);
     	p.gerarItem(b, "Data e hora do embarque", dataHoraEmbarque);
     	p.gerarItem(b, "Local do embarque", localEmbarque);
     	p.gerarItem(b, "Destino previsto", localPrevisaoDesembarque);
     	p.gerarItem(b, "Obs", observacao);
//     	p.gerarItem(b, "Motorista", motorista);
  	
 		return b.toString();
 	}


//	public void setChave(Object chave) {
//		this.chave = chave;
//	}
//
//
//	public void setCliente(Object cliente) {
//		this.cliente = cliente;
//	}


	public void setDataHoraEmbarque(Date dataHoraEmbarque) {
		this.dataHoraEmbarque = dataHoraEmbarque;
	}


	public void setLocalEmbarque(String localEmbarque) {
		this.localEmbarque = localEmbarque;
	}


	public void setLocalPrevisaoDesembarque(String localPrevisaoDesembarque) {
		this.localPrevisaoDesembarque = localPrevisaoDesembarque;
	}


//	public void setMotorista(Object motorista) {
//		this.motorista = motorista;
//	}


	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
}
