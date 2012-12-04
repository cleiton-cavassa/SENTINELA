package cleiton.unisul.piweb.rpc.shared.objetoschaveados;

import java.util.Date;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.FetchGroup;
import javax.jdo.annotations.FetchGroups;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import cleiton.unisul.piweb.rpc.shared.ObjetoChaveado;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.acessorios.PadraoItemResumo;

@FetchGroups({
@FetchGroup(name="grupo", members={@Persistent(name="cliente"),@Persistent(name="motorista")})
,
@FetchGroup(name="corridasCanceladas", members={@Persistent(name="cliente"),@Persistent(name="motorista")})
,
@FetchGroup(name="corridasFinalizadas", members={@Persistent(name="cliente"),@Persistent(name="motorista")})
})

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
	
	@Persistent
	@Extension(vendorName="datanucleus", key="gae.parent-pk", value="true")
	private String chavePai;
	
	
	public enum Status{SOLICITADA,CANCELADA,FINALIZADA}
	
	@Persistent
	private Status status=Status.SOLICITADA;
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getChavePai() {
		return chavePai;
	}

	public void setChavePai(String chavePai) {
		this.chavePai = chavePai;
	}

	
	
	@Persistent//chave codificada do cliente
	private ParChaveDescricao<ClientePF> cliente=null;
	
	@Persistent//chave codificada do motorista
	private ParChaveDescricao<Motorista> motorista=null;
	
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

	public ParChaveDescricao<ClientePF> getCliente() {
		if(cliente==null){
			setCliente(new ParChaveDescricao<ClientePF>());
		}
		return cliente;
	}

	public void setCliente(ParChaveDescricao<ClientePF> cliente) {
		this.cliente = cliente;
	}

	public ParChaveDescricao<Motorista> getMotorista() {
		if(motorista==null){
			setMotorista(new ParChaveDescricao<Motorista>());
		}
		return motorista;
	}

	public void setMotorista(ParChaveDescricao<Motorista> motorista) {
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
     	p.gerarItem(b, "Cliente", cliente.getResumo());
     	p.gerarItem(b, "Data e hora do embarque", dataHoraEmbarque);
     	p.gerarItem(b, "Local do embarque", localEmbarque);
     	p.gerarItem(b, "Destino previsto", localPrevisaoDesembarque);
     	p.gerarItem(b, "Obs", observacao);
     	p.gerarItem(b, "Motorista", motorista.getResumo());
  	
 		return b.toString();
 	}	
}
