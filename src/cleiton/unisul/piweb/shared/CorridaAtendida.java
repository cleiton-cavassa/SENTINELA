package cleiton.unisul.piweb.shared;

import java.io.Serializable;
import java.util.Date;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;


@PersistenceCapable
public class CorridaAtendida  implements Serializable {
	
	@Persistent
	private CorridaMarcada corridaMarcada;

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

	@Persistent
	private String localDesembarque;
	
	@Persistent
	private Date horarioDesembarque;
	
}
