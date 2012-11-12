package cleiton.unisul.piweb.shared;

import java.io.Serializable;
import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;


@PersistenceCapable
public class CorridaAtendida  implements Serializable, ObjetoChaveado {
	
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long chave;
	
	@Persistent
	private CorridaMarcada corridaMarcada;
	
	@Persistent
	private String localDesembarque;
	
	@Persistent
	private Date horarioDesembarque;
	
	public Long getChave() {
		return chave;
	}

	public void setChave(Long chave) {
		this.chave = chave;
	}


	public CorridaMarcada getCorridaMarcada() {
		return corridaMarcada;
	}

	public void setCorridaMarcada(CorridaMarcada corridaMarcada) {
		this.corridaMarcada = corridaMarcada;
	}

	public String getLocalDesembarque() {
		return localDesembarque;
	}

	public void setLocalDesembarque(String localDesembarque) {
		this.localDesembarque = localDesembarque;
	}

	public Date getHorarioDesembarque() {
		return horarioDesembarque;
	}

	public void setHorarioDesembarque(Date horarioDesembarque) {
		this.horarioDesembarque = horarioDesembarque;
	}

	@Override
	public String getResumo() {
		return "";
	}
	
}
