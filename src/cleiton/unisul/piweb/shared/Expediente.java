package cleiton.unisul.piweb.shared;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;


@PersistenceCapable
public class Expediente  implements Serializable {
	
	@Persistent
	private Date inicio;
	
	@Persistent	
	private Date fim;
	
	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFim() {
		return fim;
	}

	public void setFim(Date fim) {
		this.fim = fim;
	}
	
}
