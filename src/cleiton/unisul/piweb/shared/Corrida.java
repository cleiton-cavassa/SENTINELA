package cleiton.unisul.piweb.shared;
import java.io.Serializable;
import java.util.Date;

import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;


@PersistenceCapable
public class Corrida  implements Serializable, ObjetoChaveado {
	
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long chave;
	
	@Persistent
	private String clienteId;
	
	@Persistent
	private Date horarioEmbarque;
	
	@Persistent
	private String localEmbarque;
	
    public Long getChave() {
		return chave;
	}

	public void setChave(Long chave) {
		this.chave = chave;
	}

	public String getClienteId() {
		return clienteId;
	}

	public void setClienteId(String clienteId) {
		this.clienteId = clienteId;
	}

	public Date getHorarioEmbarque() {
		return horarioEmbarque;
	}

	public void setHorarioEmbarque(Date horarioEmbarque) {
		this.horarioEmbarque = horarioEmbarque;
	}

	public String getLocalEmbarque() {
		return localEmbarque;
	}

	public void setLocalEmbarque(String localEmbarque) {
		this.localEmbarque = localEmbarque;
	}


	
}
