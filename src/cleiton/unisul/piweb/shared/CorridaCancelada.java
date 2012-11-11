package cleiton.unisul.piweb.shared;

import java.io.Serializable;
import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;


@PersistenceCapable
public class CorridaCancelada  implements Serializable, ObjetoChaveado {
	
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long chave;
	
	@Persistent
	private Corrida corrida;
	
	@Persistent
	private String motivo;
	
	@Persistent	
	private Date horarioCancelamento; 
	
	@Persistent
	private String motoristaId;
	
	public Long getChave() {
		return chave;
	}

	public void setChave(Long chave) {
		this.chave = chave;
	}

	
	
	public String getMotoristaId() {
		return motoristaId;
	}

	public void setMotoristaId(String motoristaId) {
		this.motoristaId = motoristaId;
	}

	public Corrida getCorrida() {
		return corrida;
	}

	public void setCorrida(Corrida corrida) {
		this.corrida = corrida;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public Date getHorarioCancelamento() {
		return horarioCancelamento;
	}

	public void setHorarioCancelamento(Date horarioCancelamento) {
		this.horarioCancelamento = horarioCancelamento;
	}



}
